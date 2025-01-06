package class05_trie_greedy;

public class Code01_Trie {

	// 树节点 字符串挂在边上
	public static class TrieNode{
		public int pass;
		public int end;
		public TrieNode []nexts;
		public TrieNode() {
			pass = 0; 
			end = 0; 
			// nexts[0] 存储字符a
			// nexts[25] 存储字符z
			nexts = new TrieNode[26];
		}
	}
	// 前缀树
	public static class  Trie{
		public TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		// 插入字符串word
		public void insert(String word) {
			if(word == null) {
				return ;
			}
			char [] chars = word.toCharArray();
			TrieNode cur = root;
			int index = 0;
			cur.pass++; 
			for(int i=0;i<chars.length;i++) {
				index = chars[i]-'a';

				if(cur.nexts[index] == null) {
					cur.nexts[index] = new TrieNode();
				}
				cur = cur.nexts[index] ;
				cur.pass++;
			}
			cur.end++;
		}
		// 查找有几个word字符串
		public int search(String word) {
			if(word ==null) {
				return 0;
			}
			TrieNode cur = root;
			char [] chars = word.toCharArray();
			int index;
			for(int i=0;i<chars.length;i++) {
				index = chars[i]-'a';
				if(cur.nexts[index] == null) {
					return 0;
				}
				cur = cur.nexts[index] ;
			}
			return cur.end;
		}
		// 删除字符串word
		public void delete(String word) {
			if(search(word)>0) {
				TrieNode cur = root;
				char [] chars = word.toCharArray();
				int index;
				cur.pass --;
				for(int i=0;i<chars.length;i++) {
					index = chars[i]-'a';
					if(--cur.nexts[index].pass == 0) {
						cur = null;
						return ;
					}
					cur = cur.nexts[index];
				}
				cur.end --;
			}
		}
		// 以字符串word开头的字符串有几个
		public  int prefixNum(String word) {
			if(word ==null) {
				return 0;
			}
			TrieNode cur = root;
			char [] chars = word.toCharArray();
			int index;
			for(int i=0;i<chars.length;i++) {
				index = chars[i]-'a';
				if(cur.nexts[index] == null) {
					return 0;
				}
				cur = cur.nexts[index] ;
			}
			return cur.pass;
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		System.out.print(s);
		char [] arr = s.toCharArray();
		System.out.print(arr.length);
	}

}
