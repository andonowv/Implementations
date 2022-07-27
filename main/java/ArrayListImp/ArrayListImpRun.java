package ArrayListImp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ArrayListImpRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayListImplementation <Integer> arrayListImplementation = new ArrayListImplementation();
        arrayListImplementation.add(0);
        arrayListImplementation.add(1);
        arrayListImplementation.add(2);
        arrayListImplementation.add(3);


        ArrayListImplementation <Integer> secondArray = new ArrayListImplementation<>();

        secondArray.add(0);
        secondArray.add(1);
        secondArray.add(5);
        secondArray.add(3);

        ArrayList <Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(nums.remove(2));


        ArrayList <Integer> secNum = new ArrayList<>();

        secNum.add(1);
        secNum.add(2);
        secNum.add(3);
        secNum.add(6);
        secNum.add(5);

        ListIterator<Integer> litr = null;
        litr = secNum.listIterator();

    }
}
