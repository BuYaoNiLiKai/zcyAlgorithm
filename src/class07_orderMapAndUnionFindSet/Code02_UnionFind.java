package class07_orderMapAndUnionFindSet;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code02_UnionFind {
	// 并查集数据结构
	// 先包上一层 
	public static class Element<V>{
		public V value;
		public Element(V val) {
			value = val;
		}
	}
	public static class UnionFindSet<V>{
		
		public HashMap<V,Element<V>> elementMap;
		
		// 该元素的 父节点
		public HashMap<Element<V>,Element<V>> fatherMap;
		
		// 该元素所在集合的大小
		public HashMap<Element<V>,Integer> sizeMap;
		
		public UnionFindSet(List<V> list) {
			
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			
			for(V value : list) {
				Element<V> ele = new Element<V>(value);
				elementMap.put(value,ele);
				fatherMap.put(ele, ele);
				sizeMap.put(ele, 1);
			}
		}	
		
		// 给定一个ele，往上一直找，把代表元素返回
		public Element<V> findHead(Element<V> element){
			Stack<Element<V>> path = new Stack<>();
			while(element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while(!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;	
		}
		// 元素a 和 b 是否在同一个集合
		public boolean isSameSet(V a,V b) {
			if( elementMap.containsKey(a)&&elementMap.containsKey(b)) {
				return findHead(elementMap.get(a))==findHead(elementMap.get(b));
			}
			return false;
		}
		// 合并 元素a所在的集合和元素b所在的集合
		public void union(V a,V b ) {
			if(elementMap.containsKey(a)&&elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if(aF != bF) {
					Element<V> big = sizeMap.get(aF)>= sizeMap.get(bF)?aF:bF;
					Element<V> small = big == aF ? bF : aF;
					fatherMap.put(small, big);
					sizeMap.put(big, sizeMap.get(aF)+sizeMap.get(bF));
					sizeMap.remove(small);	
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
