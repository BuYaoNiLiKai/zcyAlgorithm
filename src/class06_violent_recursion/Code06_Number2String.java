package class06_violent_recursion;

public class Code06_Number2String {

	
	/*
	 * 数字转字符串
	 * 1->A
	 * 2->B
	 * ...
	 * 数字111 转换为AAA KA和AK
	 * 给定数字str 返回共有多少种结果
	 */
	public static int number2String(String words) {
		char [] chars = words.toCharArray();
		return number2String(chars,0);
	}
	private static int number2String(char[] chars, int i) {
		if(i == chars.length) {
			return 1;
		}
		if(chars[i] == '0') {
			return 0;
		}
		if(chars[i] == '1') {
			int res  = number2String(chars,i+1);
			if(i+1<chars.length) {
				res += number2String(chars,i+2);
			}
			return res;
			
		}
		if(chars[i] == '2') {
			int res  = number2String(chars,i+1);
			if(i+1<chars.length&&(chars[i+1]>='0'&&chars[i]<='6')) {
				res += number2String(chars,i+2);	
			}
			
		}
		return number2String(chars,i+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(number2String("111"));

	}

}
