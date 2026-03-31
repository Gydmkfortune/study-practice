package baseExercise;

import java.util.Scanner;

/*
 * 最小正整数
 *       题目描述
给定两个整数 a,b，请求出最小的 ax+by 使得 ax+by>0。x,y 的取值随意。	
	输入描述
第 1 行为一个整数 T，表示测试数据数量。
接下来的 T 行每行包含两个整数，表示 a,b。
1≤T≤105，−109≤a,b≤109。
保证 a,b 不全为 0。
	输出描述
输出共 T 行，每行包含一个整数，表示每组数据答案。
 */
public class Minzzs1297 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long res = gcd(a,b);
			while(res<=0) {
				int j = -1;
				res *= j;
				j--;
			}
			System.out.println(res);
		}
		sc.close();
	}
	static long gcd(long a,long b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
