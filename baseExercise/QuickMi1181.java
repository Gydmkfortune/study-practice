package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
给定三个正整数 N,M,P，求 NMmodP。
	输入描述
第 1 行为一个整数 T，表示测试数据数量。
接下来的 T 行每行包含三个正整数 N,M,P。
1≤T≤105，1≤N,M,P≤109。
	输出描述
输出共 T 行，每行包含一个整数，表示答案。
 */
public class QuickMi1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			long N = sc.nextLong();
			long M = sc.nextLong();
			long P = sc.nextLong();
			long res = 1;
			while(M>0) {
				if((M&1)==1) {
					res = res*N%P;
				}
				N = N*N%P;
				M = M>>1;
			}
			System.out.println(res);
		}
		sc.close();
	}
}
