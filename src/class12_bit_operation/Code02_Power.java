package class12_bit_operation;

public class Code02_Power {

	// 判断一个数 是不是2的次幂
	public static boolean is2Power(int n ) {
		// 只有一个1  找出最右侧的1
		return (n&(n-1)) == 0;
	}
	public static boolean is4Power( int n) {
		return (n&(n-1)) == 0 &&(n & 0x55555555) != 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(is2Power(1023));
	}

}
