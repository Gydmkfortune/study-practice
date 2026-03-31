package baseExercise;

import java.util.Scanner;

/*
 *       问题描述
小蓝研究了一种特殊的数组操作，称之为 “异或消除”。
对一个整数数组 arr 执行一次 “异或消除” 操作，可以拆解成以下四个步骤：
找到数组中的最大值 a 和次大值 b，若有多个相同的最大值或次大值，取最左边的那个。
将 a 和 b 两个元素同时从数组中移除。
计算 a 和 b 的异或值 c = a ⊕ b。
将 c 放入数组的最左边。
小蓝想知道，对于给定的数组 arr，经过不断的 “异或消除” 操作后，数组中最后留下的元素。
他请你编写一个程序来帮助他解决这个问题。
	输入格式
输入包含两行。
输入的第一行，包含一个整数 n (1 ≤ n ≤ 10^5)，表示数组 arr 的长度。
输入的第二行，包含 n 个整数，表示数组 arr 中的元素。
	输出格式
输出仅一行，包含一个整数，表示数组中最后留下的元素。
 */
public class BitOperation3302 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];
			int res = 0;
			for(int i=0;i<n;i++) {
				res ^= sc.nextInt();
			}
			sc.close();
			System.out.println(res);
		}
}
