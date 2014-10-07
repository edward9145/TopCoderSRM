package alg;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * http://www.java3z.com/cwbwebhome/article/article5/5829.html?id=1547
 */

public class LCString {

    public static List<String> getLCString(char[] str1, char[] str2)
    {
        int i,j;
        int len1,len2;
        len1 = str1.length;
        len2 = str2.length;
        int maxLen = len1 > len2?len1:len2;
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];
        
        for (i = 0; i < len2 ; i++)
        {
            for (j = len1 -1; j >= 0; j--)
            {
                if (str2[i] == str1[j]) 
                {
                    if ( ( i == 0) || (j == 0) )
                        c[j] = 1;
                    else
                        c[j] = c[j-1] + 1;
                }
                else
                {
                    c[j] = 0;
                }
                
                if (c[j] > max[0])
                {   //如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                    max[0] = c[j];
                    maxIndex[0] = j;
                    
                    for (int k = 1; k < maxLen; k++)
                    {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                }
                else if (c[j] == max[0])
                {   //有多个是相同长度的子串
                    for (int k = 1; k < maxLen; k++)
                    {
                        if (max[k] == 0)
                        {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break;  //在后面加一个就要退出循环了
                        }
                
                    }
                }
            }
        }
        
        List<String> listLCS = new ArrayList<String>(); 
        for (j = 0; j < maxLen; j++)
        {
        	StringBuffer lcs = new StringBuffer(maxLen);
            if (max[j] > 0)
            {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++){
                    System.out.print(str1[i]);
                    lcs.append(str1[i]);
                }
                System.out.println();
                listLCS.add(lcs.toString());
            }
        }
        
        return listLCS;
    }

    public static void main(String[] args) {
        String str1 = new String("adbba1234bdsasa");
        String str2 = new String("adbbf1234sasaa");
        List<String> listLCS = LCString.getLCString(str1.toCharArray(),str2.toCharArray());
        System.out.println(new Gson().toJson(listLCS));
    }
}