package class12_bit_operation;

public class Code03_AddMinMultiDivid {

	public static int add( int a ,int b) {
		int sum = 0;
		while(b!=0) {
			sum = a^b; //sum
			b = (a&b)<<1; //进位信息
			a = sum;
		}
		return sum;
	}
	public static int negNum( int n ) {
		// 反转符号位
		return add(~n,1);
	}
	public static int minus(int a,int b) {
		return add(a,negNum(b));
	}
	public static int multi(int a,int b ) {
		int res = 0;
		while(b != 0) {
			if((b & 1 )!= 0) {
				res = add(res,a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multi(1023,2));
		System.out.println(negNum(1023));
	}

}
