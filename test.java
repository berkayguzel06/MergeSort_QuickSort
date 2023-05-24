import java.util.*;
public class test {
    public static void main(String[] args) throws Exception {
        
        int[] arr;
        Random r = new Random();
        int size = 100000; // controls size of data
        arr = new int[size];
        for (int i = 1; i < size; i++) {                
            arr[i]=r.nextInt(size);    // changes from here type of data
        }
        getTime(arr, "FirstElement");
        getTime(arr, "RandomElement");
        getTime(arr, "MidOfFirstMidLastElement");
        getTime(arr, 1);
        getTime(arr, 2);
    }
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print("-");
        }
    }
    public static void getTime(int[] arr, String pivotType){
        long start,finish; // to measure time
        quickSort q = new quickSort(arr, pivotType); // getting wanted sort algorithm
        start = System.currentTimeMillis(); // start time
        q.sort();   // sort
        finish = System.currentTimeMillis(); // finish time
        String out = String.format("Quick sort-->\nPivot Type: %s\nTime: %o", pivotType,(finish-start));
        System.out.println(out);
        System.out.println();
    }
    public static void getTime(int[] arr, int numberOfPartitions){
        long start,finish; // to measure time
        mergeSort m = new mergeSort(arr, numberOfPartitions); // getting wanted sort algorithm
        start = System.currentTimeMillis(); // start time
        m.sort();   // sort
        finish = System.currentTimeMillis(); // finish time
        String out = String.format("Merge sort-->\nNumberOfPartitions: %s\nTime: %o", numberOfPartitions,(finish-start));
        System.out.println(out);
        System.out.println();
    }
}
