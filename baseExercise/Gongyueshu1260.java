package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
给定两个正整数 A,B，求它们的最大公约数。
	输入描述
第 1 行为一个整数 T，表示测试数据数量。
接下来的 T 行每行包含两个正整数 A,B。
1≤T≤105，1≤A,B≤109。
	输出描述
输出共 T 行，每行包含一个整数，表示答案。
 */
public class Gongyueshu1260 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(Gys(a,b));
		}
		scan.close();
	}
	static int Gys(int a,int b) {
		return b==0?a:Gys(b,a%b);
	}
}
