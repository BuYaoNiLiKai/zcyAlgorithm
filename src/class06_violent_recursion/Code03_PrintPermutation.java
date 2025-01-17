package class06_violent_recursion;

import java.util.ArrayList;

public class Code03_PrintPermutation {
	public static ArrayList<String> printPermutation(String words) {
		ArrayList<String> res = new ArrayList<>();
		char [] chs = words.toCharArray();
		process(chs,0,res);
		return res;
	}
	private static void process(char[] chs, int i, ArrayList<String> res) {
		if(i==chs.length) {
			res.add(String.valueOf(chs));
			return ;
		}
		boolean [] visit = new boolean[26];
		for(int j=i;j<chs.length;j++) {
			if(!visit[chs[j]-'a']) {
				visit[chs[j]-'a'] = true;
				swap(chs,i,j);
				process(chs,i+1,res);
				swap(chs,i,j);
			}
		}
		
	}
	private static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i]=chs[j];
		chs[j] = tmp;
		
	}
	
	// 我写的
	public static void perm(String words) {
		char [] chs = words.toCharArray();
		perm(chs,0);
		
	}
	private static void perm(char[] chs, int i) {
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return ;
		}
		for(int j =i;j<chs.length;j++) {
			perm(chs,i+1);
			swap(chs,i,j);
			perm(chs,i+1);
			swap(chs,i,j);
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>  res =  printPermutation("aba");
		System.out.println(res);
		System.out.println(res.size());
		perm("ab");
		
	}

}
