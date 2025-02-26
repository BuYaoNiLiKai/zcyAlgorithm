package class10_treedp;

import java.util.List;

public class Code02_MaxHappyValue {
	// 派对最大欢乐值
	/*
	 * 公司的每个员工都符合Employee类的描述，整个公司的人员结构可以看作是一操标准的、
	 * 没有坏的多叉例。树的头节点出公司唯一的去板，除者板之外的每个员工都有唯一的直接上址。
	 * 叶节点旱没有任何下闻的基层员工(subordinates列表为空)，除基层员工外，每个员工都有
	 * 一个或多个百接下级，这个公同现在要办pa内y，你可以决定嘭些员工来，零些员工不来，但
	 * 是要遵如下规则，
	 * 1.如果某个员工来了，那么这个员工的所有直接下属都不能来
	 * 2.派对的整体快乐值是所有到场员工快乐值的累加
	 * 3.你的目标是让派对的整体快乐值尽量大
	 * 给定一棵多叉树的头节点b055，请返回派对的最大快乐慎
	 */
	public static class Employee{
		public int happy;
		public List<Employee> subordinates;
	}
	public static class Info{
		int yes;//来
		int no;//不来
		public Info(int y,int n ) {
			yes = y;
			no = n;
		}
	}
	public static int partyMaxHappy(Employee boss) {
		Info bossInfo = process(boss);
		return Math.max(bossInfo.yes, bossInfo.no);
	}
	public static Info process(Employee boss) {
		if(boss.subordinates.isEmpty()) {
			return new Info(0,0);
		}
		// 参加
		int yes = boss.happy;
		//不参加
		int no = 0;
		for(Employee e:boss.subordinates) {
			Info next = process(e);
			yes += next.no;
			no+= Math.max(next.yes, next.no);
		}
		return new Info(yes, no);
		//返回最大值
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
