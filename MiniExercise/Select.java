package MiniExercise;

import java.util.Scanner;

public class Select {
    public static void main(String[] args) {
        /*
         * 输入描述：输入第一行包括1个数字n，表示宝藏有n个
         *         第二行包括n个数字，第i个数字a[i]表示第i个宝藏的珍贵程度
         * 输出描述：输出n个数字，对宝藏珍贵程度从小到大的排序后的数组
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        xuanze(arr,n);
    }
    public static void xuanze(int[] arr,int n) {
        //int[] arr = {5,8,1,7,6,4,3,9,2};
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
