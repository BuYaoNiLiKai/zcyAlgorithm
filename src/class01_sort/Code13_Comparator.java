package class01_sort;

import java.util.Arrays;
import java.util.Comparator;


public class Code13_Comparator {
    // 比较器 其实就是C++中的重载运算符 改写> <
    public static class Student {
        String name;
        int id;
        int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        //返回负数的时候，第一个参数排在前面
        //返回正数的时候，第二个参数排在前面
        //返回0的时候，谁在前面无所谓

        public int compare(Student s1, Student s2) {
            if (s1.id < s2.id) {
                return -1;
            }
            if (s1.id > s2.id) {
                return 1;
            }
            return 0;
//            return s1.id - s2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s2.id - s1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.age - s2.age;
        }
    }

    public static class AgeDescendingComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s2.age - s1.age;
        }
    }

    public static class AComp implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

    public static void printStudent(Student[] students) {
        for (Student student : students) {
            System.out.println(student.name + " " + student.id + " " + student.age);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 7, 9, 8, 1, 0};

        Arrays.sort(arr, new AComp());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("==============================");
        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);
        Student[] students = new Student[]{student1, student2, student3};
        printStudent(students);
        System.out.println("==============================");
        Arrays.sort(students, new IdAscendingComparator());
        printStudent(students);
        System.out.println("==============================");
        Arrays.sort(students, new IdDescendingComparator());
        printStudent(students);
        System.out.println("==============================");
        Arrays.sort(students, new AgeAscendingComparator());
        printStudent(students);
        System.out.println("==============================");
        Arrays.sort(students, new AgeDescendingComparator());
        printStudent(students);
    }
}
