import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr3 = null;
        int index = 4;
        int value = 0;
        int[] arr4 = new int[]{3, 6, 2, 8, 0, 5, 10, 5};
        bubble_sort(arr4);
        int[] arr2 = insert(arr1, index, value);
//        System.out.println(arrays_equal(arr1, arr2));
//        fill(arr1, 6);
//        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr4));

    }
//    static boolean arrays_equal(int[] arr1, int[] arr2){
//        int len1 = arr1.length;
//        int len2 = arr2.length;
//        if (len1 != len2) return false;
//        for (int i = 0; i < len1; i++){
//            if (arr1[i] != arr2[i]){
//                return false;
//            }
//        }
//
//        return true;
//    }
//    static void fill(int[] arr, int value){
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = value;
//        }
//    }

    static int[] insert(int[] arr, int index, int value){
        if (arr == null) return null;
        int len = arr.length;

        if (index > len || index < 0) return null;

        int[] new_arr = new int[len + 1];

        for (int i = 0; i < index; i++){
            new_arr[i] = arr[i];
        }
        new_arr[index] = value;

        for (int i = index + 1; i <= len; i++){
            new_arr[i] = arr[i - 1];
        }

        return new_arr;
    }

    static int[] bubble_sort(int[] arr){
        if (arr == null) return null;
        int len = arr.length;
        for (int i = 0; i < len; i++){
            for (int j = len - 1; j > i; j--){
                if (arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;

    }



}
//Дз первый блок: 1.1 и 1.2 (по возможности)