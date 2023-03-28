package com.summary.hml.viper.search;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-28 18:26
 * @Description : 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {

        // 有序的数组
        int[] arr = {-100, -12, 30, 50, 55, 69, 90, 100};
        int target = -12;
        int i = binarySearch1(arr, target);
        System.out.println("i = " + i);

        int i1 = binarySearch2(arr, 0, arr.length - 1, -12);
        System.out.println("i1 = " + i1);

    }

    // 迭代的方法实现二分查找
    public static int binarySearch1(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < arr[mid]) {
                right = mid - 1;
            }else if (target > arr[mid]) {
                left = mid + 1;
            }else if (target == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }

    // 递归的方法实现二分查找
    public static int binarySearch2(int[] arr,int left, int right, int target) {
        int mid = (left + right) / 2;
        if (left <= right) {
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                 return binarySearch2(arr,mid + 1, right, target);
            }else {
                 return binarySearch2(arr, left, mid-1, target);
            }
        }
        return -1;
    }


}
