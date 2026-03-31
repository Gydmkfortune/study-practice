package baseExercise;

import java.util.Scanner;
/*
 *       问题描述
输入一个正整数 n，求小于等于 n 的所有正整数中 “疑似素数” 的个数。“疑似素数” 
指的是十进制下每位数字之和等于素数的正整数。例如，102、818、23 都是 “疑似素数”。
	输入格式
第一行包含一个整数 n，表示要求解的范围，满足 (1≤n≤106)。
	输出格式
输出仅一行，输出小于等于 n 的所有正整数中 “疑似素数” 的个数。
 */
public class Prime3334 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		int count = 0;
		for(int i=2;i<=n;i++) {
			int k=i;
			int sum=0;
			while(k>0) {
				sum += (k%10);
				k = k/10;
			}
			if(isPrime(sum)) {
				count++;
			}
		}
		System.out.println(count);
	}
	static Boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
