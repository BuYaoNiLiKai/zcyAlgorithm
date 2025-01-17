package class06_violent_recursion;

public class Code02_PrintAllSubString {
	// 打印字符串所有子序列
	public static void printAllSubString(String words) {
		char[] chs = words.toCharArray();
		printAllSubString(chs,0);
		System.out.println(String.valueOf(chs));
	}

	private static void printAllSubString(char[] chs, int i) {
		// TODO Auto-generated method stub
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return ;
		}
		printAllSubString(chs,i+1);
		char tmp = chs[i];
		chs[i] = 'z';
		printAllSubString(chs,i+1);
		chs[i]= tmp;
		
	}
	public static void myPrintAllSubString(String words) {
		char[] chs = words.toCharArray();
		String res ="";
		myPrintAllSubString(chs,0,res);
		
	}
	private static void myPrintAllSubString(char[] chs, int i, String res) {
		if(i==chs.length) {
			System.out.println(res);
			return ;
		}
		
		myPrintAllSubString(chs,i+1,res);
		myPrintAllSubString(chs,i+1,res+chs[i]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllSubString("abc");
		myPrintAllSubString("abc");
	}

}
