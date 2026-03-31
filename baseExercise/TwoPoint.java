package baseExercise;

import java.util.Scanner;
/*
 * 题目描述
给定一个长度为 n的序列 a1,a2,⋯,an和一个常数 S
对于一个连续区间如果它的区间和大于或等于 S，则称它为美丽的区间。
对于一个美丽的区间，如果其区间长度越短，它就越美丽.请你从序列中找出最美丽的区间​。
 * 输入描述
第一行包含两个整数 n,S，其含义如题所述。
接下来一行包含 n 个整数，分别表示 a1​,a2​,⋯,an​。
10≤N≤105，1×ai​≤104，1≤S≤108。
   输出描述
输出共一行，包含一个整数，表示最美丽的区间的长度。
若不存在任何美丽的区间，则输出 0。
 */
public class TwoPoint {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int S = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = scan.nextInt();
        }
        int l = 0,r=0,min=n+1,sum=0;
        while(r<n) {
        	sum += arr[r];
        	while(sum>=S) {
        		min = Math.min(min,r-l+1);
        		sum -= arr[l];
        		l++;
        	}
        	r++;
        }
        if(min==n+1) {
        	System.out.println(0);
        }else {
        	System.out.println(min);
        }
        scan.close();
	}
}
