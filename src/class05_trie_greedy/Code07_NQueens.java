package class05_trie_greedy;

public class Code07_NQueens {

	// N皇后问题  不能同行同列 共斜线
	public static int nQueens(int n) {
		if(n<1) {
			return 0;
		}
		int res = 0;
		int []record  =new int[n]; //record[i] -> 第i行放在了record[i]位置上
		return process(0,record,n);
	}
	private static int process(int i, int[] record, int n) {
		// TODO Auto-generated method stub
		/*
		 * 放从i~n行 放的位置 记录在record中 
		 * 已经排除了同行
		 */
		if(i==n) {
			// 放好了  全都放好了 
			return 1;
		}
		int res = 0;
		for(int j=0;j<n;j++) {
			// 尝试放所有位置 第i行放在了j位置上
			if(isValid(record,i,j)) {
				record[i] = j;
				res+=process(i+1,record,n);
			}
		}
		return res;
	}
	private static boolean isValid(int[] record, int i, int j) {
		// TODO Auto-generated method stub
		
		// 假如 第i行放在了j位置上  
		for(int k=0;k<i;k++) {
			// 检查 违规 同列 和共斜线
			if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k)) {
				return false;
			}
		}
		return true;
	}
	
	// 进阶版本 就别看了 看不懂
	public static int nQueensPlus(int n ) {
		if(n<1||n>32) {
			return 0;
		}
		int limit = n==32?-1:(1<<n)-1;
		return processPlus(limit,0,0,0);
	}
	private static int processPlus(int limit, int column, int left, int right) {
		// TODO Auto-generated method stub
		if(column==limit) {
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos = limit&(~(column|left|right));
		int res  = 0;
		while(pos!=0) {
			mostRightOne = pos&(~pos+1);
			pos = pos - mostRightOne;
			res+=processPlus(limit,column|mostRightOne,
					(left|mostRightOne)<<1,
					(right|mostRightOne)>>>1);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = nQueens(9);
		System.out.print(res);
	}

}
