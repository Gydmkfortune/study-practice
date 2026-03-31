package baseExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
 *       问题描述
黄开的银行最近又发行了一种新面额的钞票，面值为 4，所以现在黄有 5 种面额的钞票，分别是 20、
10、5、4、1。但是不变的是他小气，现在又有很多人来取钱，黄又不开心了，请你算出每个来取
钱的人黄应该给他至少多少张钞票。
	输入格式
每个评测数据含有不超过 10 组输入，每组给出一个 n (1≤n≤10000)，n 为要取出的金额。
	输出格式
每组样例输出一个答案（钞票数）。
 */
public class DPLine3297 {
	public static void main(String[] args) {
		int[] dp = new int[(int)1e5+1];
		int[] arr = {1,4,5,10,20};
		Arrays.fill(dp, (int)1e9);
		
		//dp[i]表示凑到i元钱最少要几张钞票
		dp[0] = 0;
		for(int i=1;i<dp.length;i++) {
			for(int j:arr) {
				if(i>=j) {
					dp[i] = Math.min(dp[i], dp[i-j]+1);
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
