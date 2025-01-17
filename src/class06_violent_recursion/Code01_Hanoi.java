package class06_violent_recursion;

public class Code01_Hanoi {

	// 汉诺塔 
	public static void Hanoi(int n) {
		Hanoi(n,"左","中","右");
	}
	public static void Hanoi(int n,String left,String mid,String right) {
		// n个目标借助mid从left挪到right
		if( n == 1) {
			System.out.println(left+"---------->"+right);
			return ;
		}
		Hanoi(n-1,left,right,mid); // 吧n-1个目标先借助right柱子从left挪到mid
		System.out.println(left+"---------->"+right); // 直接挪
		Hanoi(n-1,mid,left,right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hanoi(3);
	}

}
