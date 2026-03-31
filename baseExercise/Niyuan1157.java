package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
给定一个正整数 N，求它在模 109+7 下的乘法逆元。
	输入描述
第 1 行为一个整数 T，表示测试数据数量。
接下来的 T 行每行包含一个正整数 N。
1≤T≤105，1≤N≤109。
	输出描述
输出共 T 行，每行包含一个整数，表示答案。
 */
public class Niyuan1157 {
	static long mod = 1000000007L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			long n = sc.nextLong();
			long x = faster(n,mod-2);
			System.out.println(x);
		}
		sc.close();
	}
	static long faster(long a,long b) {
		long res = 1L;
		a = a%mod;
		while(b>0) {
			if((b&1)==1) res = res*a%mod;	
			a = a*a%mod;
			b /=2;
		}
		return res;
	}
}
