package baseExercise;

import java.util.Scanner;

/*
 *       问题描述
一个机器人位于一个 m×n 网格的左上角（起始点为 (0,0)）。机器人每次只能向下或者向右移动一步。
机器人试图达到网格的右下角 (n-1, m-1)。问总共有多少条不同的路径？由于数值很大，输出结果对 10^9+7 取模。
	数据范围
n <= 1e5, m <= 1e5
	输入输出实例
实例：n=3, m=7
输出：28

 */
public class RobotPath {
	static long mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		int total = n+m-2;
		System.out.println(C(total,Math.min(m-1, n-1))%mod);
	}
	
	static long ksm(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) {
				res = res*a%mod;
			}
			a = a*a%mod;
			b = b>>1;
		}
		return res;
	}
	
	static long C(int a,int b) {
		long res = 1;
		for(int i=a;i>=(a-b+1);i--) {
			res = res*i%mod;
		}
		for(long i=1;i<=b;i++) {
			res = res*ksm(i,mod-2)%mod;
		}
		return res;
	}
}
