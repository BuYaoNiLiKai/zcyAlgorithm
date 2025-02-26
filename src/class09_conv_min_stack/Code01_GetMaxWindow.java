package class09_conv_min_stack;

import java.util.LinkedList;

public class Code01_GetMaxWindow {

	// 获取窗口内数组最大值
	/*
	 * 由一个代表麵目，引出一种结构【题月】
	 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次 向右边清一个位置。
	 * 例如，数组为[4.3.5.4.3.3.6.7]，窗口大小为3时
	 * [435]43367
	 * 4[354]3367
	 * 43[543]367
	 * 435[433]67
	 * 4354[336]7
	 * 43543[367]
	 * 窗口中最大值为5 窗口中最大值为5 窗口中最大值为5 窗口中最大值为4 窗口中最大值为6
	 * 窗口中最大体为7如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值
	 * 请实现一个适数输入:整型数组arr，窗口大小为w，输出:一个长度为n-w+1的数组res，
	 * res[i]表示每一种窗口状态下的 以本题为例，结果应该近回5.5.5.4.6.7，
	 */
	public static int []getMaxWindow(int []arr,int w){
		if(arr == null || w<1 ||arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<>(); //双端队列
		int []res = new int[arr.length -w +1];
		int index = 0;
		for(int i = 0;i<arr.length;i++){
			while(!qmax.isEmpty()&&qmax.peekLast()<=arr[i]) {
				qmax.pollLast();
			}
			qmax.add(i); //放的是下标
			if(qmax.peekFirst()==i-w) { //过期下标 
				qmax.pollFirst();
			}
			if(i>=w-1) { //形成窗口
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
