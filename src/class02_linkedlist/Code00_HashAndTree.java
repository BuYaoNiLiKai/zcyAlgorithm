package class02_linkedlist;

import java.util.*;

import static class02_linkedlist.Code00_LinkedListCommon.*;

public class Code00_HashAndTree {
    /* 哈希表 和 有序表
     * 1)哈希表在使用层面上可以理解为一种集合结构
     * 2)如果只有key,没有伴随数据value，可以使用HashSet结构(C++中叫Un0rderedSet)
     * 3) 如果既有key，又有伴随数据value，可以使用HashMap结构(C++中叫Un0rderedMap)
     * 4)有无伴随数据，是HashMap和HashSet唯一的区别，底层的实际结构是一回事
     * 5)使用哈希表增(put)、删(remove)、改(put)和查(get)的操作，可以认为时间复杂度为0(1)，但是常数时间比较大
     *6)放入哈希表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小7)放入哈希表的东西，如果不是基础类型，内部按引用传递，
     *内存占用是这个东西内存地址的大小
     *
     *
     * 1)有序表在使用层面上可以理解为一种集合结构
     * 2)如果只有key，没有伴随数据value，可以使用TreeSet结构(C++中叫0rderedSet)
     * 3)如果既有key，又有伴随数据value，可以使用TreeMap结构(C++中叫0rderedMap)
     * 4)有无伴随数据，是TreeSet和TreeMap唯一的区别，底层的实际结构是一回事
     * 5)有序表和哈希表的区别是，有序表把key按照顺序组织起来，而哈希表完全不组织
     * 6)红黑树、AVL树、size-balance-tree和跳表等都属于有序表结构，只是底层具体实现不同
     * 7)放入有序表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
     * 8)放入有序表的东西，如果不是基础类型，必须提供比较器，内部按引用传递，内存占用是这个东西内存地址的大小
     *9)不管是什么底层具体实现，只要是有序表，都有以下固定的基本功能和固定的时间复杂度
     */
    public static class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }

    public static void main(String[] args) {
        ListNode nodeA = null;
        ListNode nodeB = null;
        ListNode nodeC = null;

        // hashSet1的key是基础类型->int类型
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(3);
        hashSet1.add(3);
        System.out.println(hashSet1.size());
        System.out.println(hashSet1.contains(3));
        hashSet1.remove(3);
        System.out.println(hashSet1.contains(3));


        HashMap<Integer, String> mapTest = new HashMap<>();
        mapTest.put(1, "zong");
        mapTest.put(2, "pei");
        mapTest.put(3, "chao");
        mapTest.put(3, "potato"); //更新
        System.out.println(mapTest.containsKey(1));
        System.out.println(mapTest.get(3));
        System.out.println(mapTest.get(4));

        mapTest.remove(2);
        System.out.println(mapTest.get(2));

        System.out.println("============1==============");

        // hashSet2的key是非基础类型
        nodeA = new ListNode(1);
        nodeB = new ListNode(2);
        HashSet<ListNode> hashSet2 = new HashSet<>();
        hashSet2.add(nodeA);
        System.out.println(hashSet2.contains(nodeA));
        System.out.println(hashSet2.contains(nodeB));
        hashSet2.remove(nodeA);
        System.out.println(hashSet2.contains(nodeA));
        System.out.println("============2==============");

        // treeSet的key为非基础类型->Node类型
        nodeA = new ListNode(5);
        nodeB = new ListNode(6);
        nodeC = new ListNode(7);
        TreeSet<ListNode> treeSet = new TreeSet<>(); // 红黑树
        // 以下代码会报错 ，因为没有提供Node类型的比较器
        try {
            treeSet.add(nodeA);
            treeSet.add(nodeB);
            treeSet.add(nodeC);
        } catch (Exception e) {
            System.out.println("错误信息:" + e.getMessage());
        }
        treeSet = new TreeSet<>(new ListNodeComparator());
        // 以下代码没问题 因为提供了Node类型的比较器
        try {
            treeSet.add(nodeA);
            treeSet.add(nodeB);
            treeSet.add(nodeC);
        } catch (Exception e) {
            System.out.println("错误信息:" + e.getMessage());
        }
        System.out.println("============3==============");

        // 展示有序表的常用操作
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(7, "我是7");
        treeMap1.put(5, "我是5");
        treeMap1.put(4, "我是4");
        treeMap1.put(3, "我是3");
        treeMap1.put(9, "我是9");
        treeMap1.put(2, "我是2");
        System.out.println(treeMap1.containsKey(5));
        System.out.println(treeMap1.get(5));
        System.out.println(treeMap1.firstKey() + "，我最小");
        System.out.println(treeMap1.lastKey() + "，我最大");
        System.out.println(treeMap1.floorKey(8) + "在表中所有<=8的数中，我离8最近");
        System.out.println(treeMap1.ceilingKey(8) + "在表中所有>=8的数中，我离8最近");
        System.out.println(treeMap1.floorKey(7) + ",，在表中所有<=7的数中，我离7最近");
        System.out.println(treeMap1.ceilingKey(7) + "，在表中所有>=7的数中，我离7最近");
        treeMap1.remove(5);
        System.out.println(treeMap1.get(5) + "，删了就没有了哦");


    }

}
