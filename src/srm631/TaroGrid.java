package srm631;

public class TaroGrid {

	public static int getNumber(String[] grid){
		char[][] GRID = new char[grid.length][grid.length];
		for(int j=0; j<grid.length; j++){
			String str = grid[j];
			for(int i=0; i<str.length(); i++){
				GRID[j][i] = str.charAt(i);
			}
		}
//		printCharArrs(GRID);
		int max = 0;
		for(int i=0; i<GRID.length; i++){			
			int count = 0;
			int tmpMax = 0;
			for(int j=1; j<GRID.length; j++){
				if(GRID[j][i] == GRID[j-1][i]){
					count ++;
				}
				else{
					if(count >= tmpMax) tmpMax = count;
					count = 0;
				}
			}
			if(count >= max){
				max = count;
			}
		}
		
		return max+1;
	}

	public static void main(String[] args) {
		print(TaroGrid.getNumber(new String[]{"W"}));
		print(TaroGrid.getNumber(new String[]{"WB", "BW"}));
		print(TaroGrid.getNumber(new String[]{"BWW", "BBB", "BWB"}));
		print(TaroGrid.getNumber(new String[]{"BWBW", "BBWB", "WWWB", "BWWW"}));
		print(TaroGrid.getNumber(new String[]{"BWB", "BBW", "BWB"}));
		print(TaroGrid.getNumber(new String[]{"BBWWBBWW", "BBWWBBWW", "WWBBWWBB", "WWBBWWBB", "BBWWBBWW", "BBWWBBWW", "WWBBWWBB", "WWBBWWBB"}));
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void printCharArrs(char[][] arrs){
		for(int j=0; j<arrs.length; j++){
			char[] arr = arrs[j];
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}
