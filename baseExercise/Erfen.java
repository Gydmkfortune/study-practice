package baseExercise;

import java.util.Scanner;

/*
 * 给定一个数组，其采用如下代码定义：
 *  int data[200];
	for(i = 0 ; i < 200 ; i ++）data[i] = 4 * i + 6;
	现给定某个数，请你求出它在 data 数组中的位置（下标）
	输入描述
输入一个待查找的整数（该整数一定在数组 data 中）。
	输出描述
输出该整数在数组中的指标
 */
public class Erfen {
	public static void main(String[] args) {
		int[] data = new int[200];
		for(int i = 0 ; i < 200 ; i++){
			data[i] = 4 * i + 6;
		}
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		scan.close();
		int l=0,r=199;
		while(l<r) {
			int mid = (l+r+1)/2;
			if(data[mid]>x) {
				r = mid - 1;
			}else {
				l = mid;
			}
		}
		System.out.println(l);
	}
}
