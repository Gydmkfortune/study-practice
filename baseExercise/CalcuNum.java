package baseExercise;

import java.util.Scanner;

public class CalcuNum {
	//输入一个自然数 n(n≤1000)，我们对此自然数按照如下方法进行处理:
	//1.不作任何处理;
	//2.在它的左边加上一个自然数,但该自然数不能超过原数的一半;
	//3.继续按照规则2添加，但是添加的数不能超过上一次添加数的一半，直到不能添加为止。
	//问总共可以产生多少个数。
	
	static int result = 1;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		digui(n);
		System.out.println(result);
	}
	public static void digui(int n) {
		if(n / 2 <= 0) {
			return;
		}
		for(int i = 1;i <= n/2;i++) {
			digui(i);
			result++;
		}
	}
}
