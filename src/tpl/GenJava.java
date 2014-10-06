package tpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * Google TopCoder SRM problem template generator Java
 * @author Edward.Wu
 *
 */
public class GenJava {
	
	public static String problemFile = "problem";
	
	public static Map<String, String> paramMap = new HashMap<String, String>();
	static{
		paramMap.put("boolean","");
		paramMap.put("int","");
		paramMap.put("float","");
		paramMap.put("double","");
		paramMap.put("String","");
		paramMap.put("int[]","new int[]");
		paramMap.put("float[]","new float[]");
		paramMap.put("double[]","new double[]");
		paramMap.put("String[]","new String[]");
	}
	public static Map<String, String> retMap = new HashMap<String, String>();
	static{
		retMap.put("boolean","true");
		retMap.put("int","0");
		retMap.put("float","0f");
		retMap.put("double","0.0");
		retMap.put("String","null");
		retMap.put("int[]","null");
		retMap.put("float[]","null");
		retMap.put("double[]","null");
		retMap.put("String[]","null");
		
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		GenClazz gen = new GenClazz();
		File file = new File(problemFile);
		System.out.println(file.getAbsolutePath());
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), "UTF-8");// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			List<String> prevTxt = new ArrayList<String>();
			while ((lineTxt = bufferedReader.readLine()) != null) {
				if (lineTxt.equals("Definition")){
					System.out.println(lineTxt);
				}
				if (lineTxt.equals("Class:")) {
					 gen.name = bufferedReader.readLine();
				}
				if (lineTxt.equals("Method:")) {
					 gen.method = bufferedReader.readLine();
				}
				if (lineTxt.equals("Parameters:")) {
					String paramLine = bufferedReader.readLine();
					 gen.params = paramLine.split(", ");
//					 for(int i=0; i<gen.params.length; i++)
//						 System.out.print(gen.params[i] + " ");
				}
				if (lineTxt.equals("Returns:")) {
					 gen.ret = bufferedReader.readLine();
				}
				if (lineTxt.equals("Method signature:")) {
					 gen.signature = bufferedReader.readLine();
				}
				
				if(lineTxt.startsWith("Returns: ")){
					String ret = lineTxt.substring(lineTxt.indexOf(" "));
					int size = prevTxt.size();
					List<String> egParam = new ArrayList<String>();
					for(int i=size-gen.params.length; i<size; i++){
						egParam.add(prevTxt.get(i));
					}
					gen.example.put(ret, egParam);
				}
				prevTxt.add(lineTxt);
			}
			read.close();
		} else {
			System.out.println("找不到指定的文件");
		}

		writeTxtFile(gen.sourceCode(), new File("src/" + gen.name + ".java"));
		copyFile(new File(problemFile), new File(gen.name));
	}
	
	public static boolean writeTxtFile(String content, File file)
			throws Exception {
		if(file.exists()){
			System.out.println(file.getAbsolutePath() + " existed.");
			return false;
		}
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(file);
			o.write(content.getBytes("UTF-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}

	public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
	

}

class GenClazz {
	public String name = "GenClazz";
	public String method = "solve";
	public String[] params = {"String"};
	public String ret = "String";
	public String signature = "String solve(int a)";
	public Map<String, List<String>> example = new LinkedHashMap<String, List<String>>();
	
	public String sourceCode(){
		String testSrc = "";
		for(String key : example.keySet()){
			String testParam = "";
			List<String> exampleParams = example.get(key);
			for(int i=0; i<params.length; i++){
				String comma = (params.length-1 == i) ? "" : ",";
				testParam += 
						GenJava.paramMap.get(params[i]) + exampleParams.get(i) + comma;
			}
			 
			testSrc += " print(" + this.name + "." + this.method + "("+ 
					testParam +")); " + "  //" + key + "\n";
		}
		
		String src = "public class " + this.name + "{" + 
				"public static " + this.signature + "{\n" +
					"return " + GenJava.retMap.get(ret) + ";\n" +
				"}\n" +   
				"public static void main(String[] args) {\n" + 
					testSrc +  
				"}\n" + 
				"public static void print(Object obj){\n" + 
					"System.out.println(obj);\n" + 
				"}\n}";
		System.out.println(src);
		return src;
	}
}