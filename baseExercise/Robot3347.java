package baseExercise;

import java.util.Scanner;

/*
 *       问题描述
小蓝买了 n 种机器人，每种机器人各一个。
他要选择一个或多个机器人来组成机甲战队。然而，他讨厌两个数字 a 和 b，因此机甲战队中的机器人数量不能为 a 或 b。
请问他可以组成多少不同组合的机甲战队，当两个机甲战队中存在一个机器人在一个机甲战队中被使用而在另一个机甲战队
中没有被使用时，这两个机甲战队被认为是不同的。答案可能很大，需要对 109+7 取模。
	输入格式
输入一行 3 个整数 n,a,b。
数据范围保证：2≤n≤109，1≤a<b≤min(n,2×105)。
	输出格式
输出一个整数表示答案，答案需要对 109+7 取模。
 */
public class Robot3347 {
	static long mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long a = sc.nextLong(),b = sc.nextLong();
		sc.close();
		long total = ksm(2,n)-1;
		long res = (total-C(n,a)-C(n,b)+mod+mod)%mod;
		System.out.println(res);
	}
	
	//计算2^n-1
	static long ksm(long x,long n) {
		long res = 1;
		while(n>0) {
			if((n&1)==1) {
				res = res*x%mod;
			}
			x = x*x%mod;
			n = n>>1;
		}
		return res;
	}
	
	//计算C（n，m）
	static long C(long n,long m) {
		long res = 1;
		for(long i=n;i>=(n-m+1);i--) {
			res = res*i%mod;
		}
		for(long i=1;i<=m;i++) {
			res = res*ksm(i,(mod-2))%mod;
		}
		return res;
	}
}
