package baseExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
 *       题目描述
小明是蓝桥王国的勇士，他晋升为蓝桥骑士，于是他决定不断突破自我。
这天蓝桥首席骑士长给他安排了 N 个对手，他们的战力值分别为 a1​,a2​,…,an​，且按顺序阻挡在小明的前方。对于这些对手小明可以选择挑战，也可以选择避战。
作为热血豪放的勇士，小明从不走回头路，且只愿意挑战战力值越来越高的对手。
请你算算小明最多会挑战多少名对手。
	输入描述
输入第一行包含一个整数 N，表示对手的个数。
第二行包含 N 个整数 a1​,a2​,…,an​，分别表示对手的战力值。
约束：1≤N≤103，1≤ai​≤109。
	输出描述
输出一行整数表示答案
 */
public class DPLIS2049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		int res = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(a[i]>a[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}
