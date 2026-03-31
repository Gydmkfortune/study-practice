package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
小明有一个容量为 V 的背包。
这天他去商场购物，商场一共有 N 件物品，第 i 件物品的体积为 wi​，价值为 vi​。
小明想知道在购买的物品总体积不超过 V 的情况下所能获得的最大价值为多少，请你帮他算算。
	输入描述
输入第 1 行包含两个正整数 N,V，表示商场物品的数量和小明的背包容量。
第 2∼N+1 行包含 2 个正整数 w,v，表示物品的体积和价值。
其中，1≤N≤102，1≤V≤103，1≤wi​,vi​≤103。
	输出描述
输出一行整数，表示小明所能获得的最大价值
 */
public class DP01_Knapsack1174 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int V = sc.nextInt();
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		for(int i=1;i<=N;i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][V+1];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=V;j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=weight[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		System.out.println(dp[N][V]);
	}
}
