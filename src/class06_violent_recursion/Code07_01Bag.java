package class06_violent_recursion;

public class Code07_01Bag {

	/*
	 * 01背包问题
	 * 给定两个长度都为M的效组weights和values，weights［i］和values［i］分别代表
	 * i号物品的重量和价值。给定一个正数bag，表示一个载重bag的袋子，你装的物
	 * 品不能起过这个重量。返回你能装下最多的价值是多少？
	 */
	public static int maxVal(int []weights,int []values,int bag) {
		return process(weights,values,0,0,bag);
	}
	private static int process(int[] weights, int[] values, int i,int alreadyWeight,int bag ) {
		// 来到 i位置 要么背 要么不背
		if(alreadyWeight>bag) {
			return 0;
		}
		if( i == weights.length) {
			return 0;
		}
		return Math.max(process(weights,values,i+1,alreadyWeight,bag), 
				process(weights,values,i+1,alreadyWeight+weights[i],bag));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
