package LinkedListImp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListImplementationRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedListImplementationn <Integer> myLinkedList = new LinkedListImplementationn<>();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);


        LinkedListImplementationn <Integer> second = new LinkedListImplementationn<>();
        second.add(0);
        second.add(1);
        second.add(3);
        second.add(3);

        myLinkedList.removeAll(second);

        LinkedList <Integer> num1 = new LinkedList<>();
        num1.add(0);
        num1.add(1);
        num1.add(2);
        num1.add(3);

        LinkedList <Integer> num2 = new LinkedList<>();

        num2.add(0);
        num2.add(4);
        num2.add(2);
        num2.add(3);


        Integer [] array = myLinkedList.toArray(new Integer[myLinkedList.size]);
        Arrays.stream(array).forEach(e-> System.out.println(e));
    }
}
