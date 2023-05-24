import java.util.Random;
public class quickSort {
    String pivotType; 
    int[] arr;
    Random r = new Random();
    public quickSort(int[] arr,String pivotType){
        this.arr = arr;
        this.pivotType = pivotType;
    }
    public void sort(){
        if(pivotType.equals("FirstElement")){// control which type of pivot
            firstElementSort(arr, 0, arr.length-1);
        }
        else if(pivotType.equals("RandomElement")){
            randomElementSort(arr, 0, arr.length-1);
        }
        else if(pivotType.equals("MidOfFirstMidLastElement")){
            midOfFirstMidLastElement(arr, 0, arr.length-1);
        }
        else{
            System.out.println("Please give an valid pivot type.");
        }
    }
    // first element pivot method
    private void firstElementSort(int[] arr, int low, int high){
        if(low<high){ // if the low part is higher than high part finish
            int pivot = arr[low]; // first pivot selection
            int i = low + 1;
            int j = high;
            while (i <= j) {
                while (i <= j && arr[i] < pivot) {// go until a lower element than pivot
                    i++;
                }
                while (i <= j && arr[j] > pivot) {// go until a higher element than pivot
                    j--;
                }
                if (i <= j) {
                    swap(i,j);      // swap them each other
                    i++;
                    j--;
                }
            }
            swap(low,j); // place the pivot right place     
            firstElementSort(arr, low, j - 1);// call recursive
            firstElementSort(arr, j + 1, high);
        } 
    }
    //Random pivot method
    private void randomElementSort(int[] arr, int low, int high){
        if(low<high){
            int pivotIndex = r.nextInt(high - low + 1)+low;//get random index for pivot 
            int pivot = arr[pivotIndex]; // get pivot
            int i = low;
            int j = high;
            while (i <= j) {           // go until i lower than j 
                while (arr[i] < pivot) {// find next element that lower than pivot from the left
                    i++;
                }
                while (arr[j] > pivot) {// find next element that higher than pivot from the right
                    j--;
                }
                if (i <= j) {
                    swap(i,j); // swap lower and higher element each other 
                    i++;
                    j--;
                }
            }
            if (low < j) {
                randomElementSort(arr, low, j); // call recursive
            }
            if (i < high) {
                randomElementSort(arr, i, high);
            }
        } 
    }
    //Median of three pivot method
    private void midOfFirstMidLastElement(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = 0;
            int first = arr[low]; // gets first element
            int middle = arr[(low + high) / 2]; // gets middle element
            int last = arr[high]; // gets last element
            if ((first <= middle && middle <= last) || (last <= middle && middle <= first)) {// give the middle of three of them
                pivot = middle;
            } 
            else if ((middle <= first && first <= last) || (last <= first && first <= middle)) {
                pivot = first;
            } 
            else {
                pivot = last;
            } 
            int i = low;
            int j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(i,j);
                    i++;
                    j--;
                }
            }
            if (low < j) {
                midOfFirstMidLastElement(arr, low, j); // call recursive
            }
            if (i < high) {
                midOfFirstMidLastElement(arr, i, high);
            }
        }
    }
    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}