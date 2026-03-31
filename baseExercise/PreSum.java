package baseExercise;

import java.util.Scanner;

public class PreSum {
	/*
	 * 给定一个长度为 n的整数数组 a以及 m 个查询。
	   每个查询包含三个整数 l,r,k 表示询问 l∼r之间所有元素的 k次方和。
	   请对每个查询输出一个答案，答案对 10e9+7取模。
	   输入格式
		第一行输入两个整数 n,m其含义如上所述。
		第二行输入 n个整数 a[1],a[2],...,a[n]
		接下来 m 行，每行输入三个整数 l,r,k 表示一个查询。
	  输出格式
		输出 m 行，每行一个整数，表示查询的答案对 10e9+7 取模的结果。
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] a = new int[n+1];
		for(int i = 1;i <= n;i++) {
			a[i] = scan.nextInt();
		}
		scan.close();
		
		long mod = (long)1e9+7;
		long[][] sum = new long[n+1][6];
		for(int i = 1;i < n+1;i++) {
			for(int j = 1;j<6;j++) {
				sum[i][j]=sum[i-1][j]+(long)Math.pow(a[i], j);
				sum[i][j]%=mod;
			}
		}
		
		for(int i = 0;i<m;i++) {
			int l = scan.nextInt();
			int r = scan.nextInt();
			int k = scan.nextInt();
			long res = (sum[r][k]-sum[l-1][k])%mod;
			System.out.println(res);
		}
	}
}
