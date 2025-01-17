package class06_violent_recursion;

public class Code04_WinScore {
	// 获胜者分数
	/*
	 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
	 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B
	 * 都绝顶聪明。请返回最后获胜者的分数。【举例】arr=[1.2.100.4]。开始时，玩家A只能
	 * 拿走1或4，如果开始时玩家A拿走1，则排列变为[2,100.4]，接下来玩家 B可以章走2或4，
	 * 然后继续轮到玩家A...如果开始时玩家A拿走4，则排列变为[1.2.100]，接下来玩家B可以
	 * 拿走1或100，然后继续轮到玩家A.玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B
	 * 将拿走100。所以玩家A会先拿1让排列变为[2.100.4]，接下来玩家B不管怎么选，100都会
	 * 被玩家 A拿走。玩家A会获胜，分数为101。所以返回101。arr=[1.100.2].开始时，玩家
	 * A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜分数为100。所以
	 * 返回100。
	 */
	public static int winScore(int []arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		return Math.max(first(arr,0,arr.length-1), second(arr,0,arr.length-1));
	}
	private static int first(int[] arr, int i, int j) {
		// 先手
		if(i==j) {
			return arr[i];
		}
		// 要么拿 最左侧 要么拿最右侧 然后作为后手
		return Math.max(arr[i]+ second(arr,i+1,j),arr[j]+second(arr,i,j-1));
	}
	private static int second(int[] arr, int i, int j) {
		// 后手 
		if(i==j) {
			// 我没能拿的了
			return 0;
		}
		// 我作为后手，最左侧 或者最右侧已经被拿走了 然后我作为拿走之后的先手
		// 因为是别人决定的  别人要赢 所以返回最小值
		return Math.min(first(arr,i+1,j),first(arr,i,j-1));
	}

	public static void main(String[] args) {
		int []arr= {1,100,2};
		int val = winScore(arr);
		System.out.println(val);

	}

}
