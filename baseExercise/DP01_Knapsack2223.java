package baseExercise;

import java.util.Scanner;

/*
 *       问题描述
小蓝面前有 N 件物品，其中第 i 件重量是 Wi​，价值是 Vi​。她还有一个背包，最大承重是 M。
小蓝想知道在背包称重范围内，她最多能装总价值多少的物品？
特别值得一提的是，小蓝可以使用一个魔法（总共使用一次），将一件物品的重量增加 K，同时价值
翻倍（当然小蓝也可以不使用魔法）。
	输入格式
第一行包含 3 个整数 N、M 和 K。
以下 N 行，每行两个整数 Wi​ 和 Vi​。
	输出格式
一个整数代表答案。
 */
public class DP01_Knapsack2223 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for(int i=1;i<=N;i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		sc.close();
		
		//[0][j]表示当前物品不用魔法的最大价值；[1][j]当前物品用魔法
		int[][] dp = new int[2][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=M;j>=W[i];j--) {
				int temp = Math.max(dp[0][j], dp[0][j-W[i]]+V[i]);
				dp[0][j] = Math.max(temp,dp[1][j-W[i]]+V[i]);
				if(j-K>=W[i]) {
					dp[1][j] = Math.max(dp[1][j],dp[0][j-W[i]-K]+2*V[i]);
				}
			}
		}
		System.out.println(Math.max(dp[0][M], dp[1][M]));
	}
}
