package baseExercise;

import java.util.Scanner;
/*
 *       题目描述
小明的花店新开张，为了吸引顾客，他想在花店的门口摆上一排花，共 m 盆。通过调查顾客的喜好，
小明列出了顾客最喜欢的 n 种花，从 1 到 n 标号。为了在门口展出更多种花，规定第 i 种花不能
超过 ai​ 盆，摆花时同一种花放在一起，且不同种类的花需按标号的从小到大的顺序依次摆列。
试编程计算，一共有多少种不同的摆花方案。
	输入描述
第一行包含两个正整数 n 和 m，中间用一个空格隔开。
第二行有 n 个整数，每两个整数之间用一个空格隔开，依次表示a1、a2、an。
其中，0<n≤100, 0<m≤100, 0≤ai​≤100。
	输出描述
输出只有一行，一个整数，表示有几种方案。注：方案数可能很多，请输出方案数对 106+7 取模的结果。
 */
public class DPTwo389 {
	public static void main(String[] args) {
		long mod = (long)1e6+7;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		//前i种花摆了j盆的方法数
		int[][] dp = new int[n+1][m+1];
		
		//第i种花摆0盆的方法是1种，即什么也不摆
		for(int i=0;i<=n;i++) {
			dp[i][0] = 1;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				//设k为第i种花要摆的盆数
				for(int k=0;k<=a[i] && k<=j;k++) {
					dp[i][j] += dp[i-1][j-k];
					dp[i][j] %= mod;
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
