package baseExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
 *       问题描述
给定一个正整数 n，请你计算 1∼n 中有多少对不同的素数，满足它们的差也是素数。
	输入格式
共一行，包含一个正整数 n（2≤n≤105）。
	输出格式
共一行，包含一个正整数，表示答案。
 */
public class Prime3205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		boolean[] arr = sieve(n);
		for(int i=0;i<=n;i++) {
			if(arr[i]) {
				for(int j=0;j<i;j++) {
					if(arr[j]) {
						int k = i-j;
						if((k>1)&&arr[k]) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
	
	//找1~n中的素数
	static boolean[] sieve(int num) {
		boolean[] arr = new boolean[num+1];
		Arrays.fill(arr, true);
		arr[0]=arr[1]=false;
		for(int i=2;i*i<=num;i++) {
			if(arr[i]) {
				for(int j=i*i;j<=num;j+=i) {
					arr[j]=false;
				}
			}
		}
		return arr;
	}
}
