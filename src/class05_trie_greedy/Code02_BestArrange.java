package class05_trie_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Code02_BestArrange {
	// 会议室最佳安排 安排最多的会议室
	/*
	 * 开始时间和结束时间 怎么安排 最多
	 */
	public static class Meeting{
		int start;
		int end;
		public Meeting(int s,int e) {
			start = s;
			end = e;
		}
	}
	public static class MeetingComparator implements Comparator<Meeting>{


		@Override
		public int compare(Meeting o1, Meeting o2) {
			// TODO Auto-generated method stub
			return o1.end - o2.end;
		}
		
	}
	public static int BestArrange(int startTime,int endTime,int[]startTimes,int[]endTimes) {
		int length = startTimes.length;
	
		Meeting [] meetings = new Meeting[length];
		for(int i=0;i<length;i++) {
			meetings[i]=new Meeting(startTimes[i],endTimes[i]);
		}
		Arrays.sort(meetings,new MeetingComparator() );
		int res = 1;
		int nowTime = meetings[0].end;
		for(int i=1;i<length;i++) {
			if(meetings[i].start>nowTime&&meetings[i].end<endTime) {
				res++;
				nowTime = meetings[i].end; 
			}
		}
		return res;
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
