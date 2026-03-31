package baseExercise;

import java.util.Arrays;
import java.util.Scanner;
/*
 *       问题描述
小蓝来到了一座高耸的楼梯前，楼梯共有 N 级台阶，从第 0 级台阶出发。小蓝每次可以迈上 1 级或
 2 级台阶。但是，楼梯上的第 a1​ 级、第 a2​ 级、第 a3​ 级，以此类推，共 M 级台阶的台阶面已经坏
 了，不能踩上去。
现在，小蓝想要到达楼梯的顶端，也就是第 N 级台阶，但他不能踩到坏了的台阶上。请问他有多少种
不踩坏了的台阶到达顶端的方案数？
由于方案数很大，请输出其对 109+7 取模的结果。
	输入格式
第一行包含两个正整数 N（1≤N≤105）和 M（0≤M≤N），表示楼梯的总级数和坏了的台阶数。
接下来一行，包含 M 个正整数 a1​,a2​,…,aM​（1≤a1​<a2​<a3​<⋯<aM​≤N），表示坏掉的台阶的编号。
	输出格式
输出一个整数，表示小蓝到达楼梯顶端的方案数，对 109+7 取模。
 */
public class DPLine3367 {
	public static void main(String[] args) {
		long mod = (long)1e9+7;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] dp = new long[N+1];
		Arrays.fill(dp, 1);
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			dp[x] = 0; 
		}
		for(int i=2;i<=N;i++) {
			if(dp[i]==0) continue;
			dp[i] = dp[i-1]%mod + dp[i-2]%mod;
		}
		System.out.println(dp[N]);
	}
}
