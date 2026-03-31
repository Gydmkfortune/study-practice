package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
给定一个长度为 N 数组 a 和一个长度为 M 的数组 b。请你求出它们的最长公共子序列长度为多少。
	输入描述
输入第一行包含两个整数 N,M，分别表示数组 a 和 b 的长度。第二行包含 N 个整数 a1​,a2​,…,aN​。
第三行包含 M 个整数 b1​,b2​,…,bM​。
数据范围：1≤N,M≤103，1≤ai​,bi​≤109。
	输出描述
输出一行整数，表示答案。
 */
public class DPLCS1189 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N+1];
		int[] B = new int[M+1];
		for(int i=1;i<=N;i++) {
			A[i] = sc.nextInt();
		}
		for(int i=1;i<=M;i++) {
			B[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(A[i]==B[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
