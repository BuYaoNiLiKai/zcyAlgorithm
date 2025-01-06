package class03_tree;

public class Code11_PrintAllFolds {
	// 折纸
	public static void printAllFolds(int n) {
		printAllFolds(n,true);
	}
	public static void printAllFolds(int n,boolean isDown) {
		if(n == 0 ) {
			return ;
		}
		printAllFolds(n-1,true);
		String s =isDown?"凹":"凸";
		System.out.print(s);
		printAllFolds(n-1,false);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllFolds(3);
	}

}
