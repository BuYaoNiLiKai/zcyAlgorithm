package class12_bit_operation;

public class Code01_GetMax {
	// 参数不是0 就是1 反转符号
	// 1-> 0 0->1
	public static int flip(int n) {
		return n^1; 
	}
	// 获取n的符号位
	public static int sign(int n ) {
		// 负数返回1 正数返回0 反转 
		return flip((n>>31)&1);
	}
	// 获取a和b的最大值 不使用比较
	public static int getMax1(int a,int b) {
		int c = a-b; // 返回c的符号 c>0 a大
		int scA = sign(c);  // A的控制位
		int scB = flip(scA); // B的控制位
		return a*scA + b*scB;		
	}
	// getMax1 存在问题 可能会溢出 当a b 符号位置不相同的时候
	public static int getMax2(int a,int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int isDiff = sa^sb; // 相同为0 不同是1
		int isSame = flip(isDiff);// 相同为1 不同是0
		int returnA = isDiff * sa + isSame * sc; // a b 符号位不同返回a的符号位置  （原始做法 相同返回c的符号位）
		int returnB = flip(returnA);
		return a*returnA + b * returnB;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMax2(199,-200000));

	}

}
