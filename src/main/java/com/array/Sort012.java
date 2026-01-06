package com.array;

public class Sort012 {

    public static void main(String[] args) {

        Sort012 obj = new Sort012();
        int[] arr = {0,1,2,0,1,2,1,0,2,0,1};
        obj.sort012(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public void sort012(int[] arr) {



        find2(arr);
    }


    void find2(int[] arr){

        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while(mid <= high){
            if(arr[mid] ==0){
                swap(arr, mid, low);
                low = low+1;
                mid = mid+1;
            }else if(arr[mid] ==1){
                mid = mid+1;
            }else{
                swap(arr, mid, high);
                high = high-1;
                //dont increase mid here
            }
        }
    }

    void swap(int[] arr, int ind1, int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}
