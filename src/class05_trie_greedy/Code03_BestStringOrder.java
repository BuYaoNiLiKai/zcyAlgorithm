package class05_trie_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Code03_BestStringOrder {
	public static class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	public String bestStringOrder(String[] words) {
		if(words==null||words.length==0) {
			return "";
		}
		String res = "";
		Arrays.sort(words,new StringComparator());
		for(int i=0;i<words.length;i++) {
			res+=words[i];
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []words = {
				"bcde",
				"a",
				"fuck",
				"abc",
				"good",
				"ab"		
			
		};
		for(int i=0;i<words.length;i++) {
			System.out.print(words[i]+"  ");
		}
		System.out.println();
		Arrays.sort(words,new StringComparator());
		for(int i=0;i<words.length;i++) {
			System.out.print(words[i]+"  ");
		}

	}

}
