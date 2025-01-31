package utils;

public class Array {

    public int arrayLength(Object[] arr){
        int length = 0;
        for(int i = 0; i<arr.length && arr[i] != null;i++){
           length++;
        }
       return length;
    }
}
