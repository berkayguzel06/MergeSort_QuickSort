public class mergeSort {
    int numberOfPartitions;// type pf partition
    int[] arr; // data
    public mergeSort(int[] arr,int numberOfPartitions){
        this.arr = arr;
        this.numberOfPartitions = numberOfPartitions;
        if(numberOfPartitions!=1 && numberOfPartitions!=2){ // if the parititon choice is invalid
            System.out.println("Sort algorithm won't work, you have to choose '1' or '2' for 'numberOfPartitions'.");
        }
    }
    public int[] sort(){
        return sort(arr,numberOfPartitions); // run main sort algorithm
    }
    private int[] sort(int[] arr, int numberOfPartitions){
        if(numberOfPartitions==1){// control which number of partition
            if(arr.length==1){  // if array size is 1 return it
                return arr;
            }
            int mid = arr.length/2; // find mid point
            int[] left_half = new int[mid]; // chop array two parts
            int[] right_half = new int[arr.length-mid];
            for (int i = 0; i < arr.length; i++) {
                if(i<mid){
                    left_half[i] = arr[i];       // create left half and right half
                }
                else{
                    right_half[i-mid] = arr[i];
                }
            }
            left_half = sort(left_half,numberOfPartitions); //call recursive function until the array lenght equal 1
            right_half = sort(right_half,numberOfPartitions);
            return merge(left_half,right_half); //after recursive function gather the array together
        }
        else if(numberOfPartitions==2){
            int mid1,mid2;
            if (arr.length <= 2){
                if(arr.length==2){
                    if(arr[1]<arr[0]){ // if length equal to 2 compare two element each other
                        int temp = arr[1];
                        arr[1] = arr[0];
                        arr[0] = temp;
                    }
                }
                return arr;
            }   
            else{
                mid1 = arr.length / 3;     // find mid points
                mid2 = 2 * (arr.length / 3);
            } 
                
            int[] left_arr = new int[mid1];      // divide array three part 
            int[] mid_arr = new int[mid2-mid1];
            int[] right_arr = new int[arr.length-mid2];
            for (int i = 0; i < arr.length; i++) {
                if(i<mid1){
                    left_arr[i] = arr[i];
                }
                else if(i<mid2){
                    mid_arr[i-mid1] = arr[i];
                }
                else{
                    right_arr[i-mid2] = arr[i];
                }
            }
            left_arr = sort(left_arr,numberOfPartitions); // call recursive
            mid_arr = sort(mid_arr,numberOfPartitions);
            right_arr = sort(right_arr,numberOfPartitions);
            return merge(left_arr,right_arr,mid_arr); // gather arrays
        }
        return arr;
    }
    
    //For 1 partition merge
    private int[] merge(int[] left_half, int[] right_half){
        int left = 0;
        int right = 0;
        int[] result = new int[left_half.length+right_half.length];// set the result array the sum of sub arrays
        for(int i = 0;left<left_half.length && right<right_half.length;i++){
            if(left_half[left]<=right_half[right]){ // compare two array each other and gather until one of them finish
                result[i] = left_half[left];
                left++;
            }
            else if(left_half[left]>right_half[right]){
                result[i] = right_half[right];
                right++;
            }
        }
        if(left!=left_half.length){  // add the other array that not finished
            for(int i = right + left;left<left_half.length;i++){
                result[i] = left_half[left];
                left++;
            }
        }
        else if(right!=right_half.length){
            for(int i = right + left;right<right_half.length;i++){
                result[i] = right_half[right];
                right++;
            }
        }
        return result;
    }
    
    //For 2 partition merge
    private int[] merge(int[] left_arr, int[] right_arr, int[] mid_arr){
        int left = 0;
        int right = 0;
        int mid = 0;
        int[] result = new int[left_arr.length+right_arr.length+mid_arr.length];
        for(int i = 0;left!=left_arr.length&&mid!=mid_arr.length&&right!=right_arr.length;i++){   
            if(left_arr[left]<=right_arr[right]){ // compare three array each other and gather until one of them finish
                if(left_arr[left]<=mid_arr[mid]){
                    result[i] = left_arr[left];
                    left++;
                }else{
                    result[i] = mid_arr[mid];
                    mid++; 
                }    
            }else{
                if(right_arr[right]<=mid_arr[mid]){
                    result[i] = right_arr[right];
                    right++;
                }else{
                    result[i] = mid_arr[mid];
                    mid++; 
                }   
            } 
        }
        for(int i = left + mid + right;left!=left_arr.length&&mid!=mid_arr.length;i++){   
            if(left_arr[left]<=mid_arr[mid]){// compare two array each other and gather until one of them finish
                result[i] = left_arr[left];
                left++;
            }else{
                result[i] = mid_arr[mid];
                mid++;
            }
        }
        for(int i = left + mid + right;right!=right_arr.length&&mid!=mid_arr.length;i++){   
            if(mid_arr[mid]<=right_arr[right]){
                result[i] = mid_arr[mid];
                mid++;
            }else{
                result[i] = right_arr[right];
                right++;
            }
        }
        for(int i = left + mid + right;right!=right_arr.length&&left!=left_arr.length;i++){   
            if(left_arr[left]<=right_arr[right]){
                result[i] = left_arr[left];
                left++;
            }else{
                result[i] = right_arr[right];
                right++;
            }
        }
        if(left!=left_arr.length){// add the other array that not finished
            for(int i = right + left + mid;left<left_arr.length;i++){
                result[i] = left_arr[left];
                left++;
            }
        }
        else if(right!=right_arr.length){
            for(int i = right + left + mid;right<right_arr.length;i++){
                result[i] = right_arr[right];
                right++;
            }
        }
        else if(mid!=mid_arr.length){
            for(int i = right + left + mid;mid<mid_arr.length;i++){
                result[i] = mid_arr[mid];
                mid++;
            }
        }
        return result;
    }
}