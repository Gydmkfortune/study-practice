package baseExercise;

import java.util.Scanner;

public class Fibonacci {
	//斐波那契数列的定义为：F(n)=F(n−1)+F(n−2)其中 F(1)=1，F(2)=1。
	//请你输出数列的第 n 个数对 1e9+7 取模后的值
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		long result = (digui(n)) % (long)(1e9+7);
		System.out.println(result);
	}
	public static long digui(int n) {
		if(n==1 || n==2) {
			return 1;
		}else {
			return digui(n-1)+digui(n-2);
		}
	}
}
