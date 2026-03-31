package baseExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 问题描述
给定一个数组 A 和一些查询 Li​,Ri​，求数组中第 Li​ 至第 Ri​ 个元素之和。
小蓝觉得这个问题很无聊，于是他想重新排列一下数组，使得最终每个查询结果的和尽可能地大。
小蓝想知道相比原数组，所有查询结果的总和最多可以增加多少？
   输入格式
输入第一行包含一个整数 n。
第二行包含 n 个整数 A1​,A2​,⋯,An​，相邻两个整数之间用一个空格分隔。
第三行包含一个整数 m 表示查询的数目。
接下来 m 行，每行包含两个整数 Li​、Ri​，相邻两个整数之间用一个空格分隔。
 */
public class ReSort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		long m = Integer.parseInt(br.readLine());
		long sum1 = 0;
		long sum2 = 0;
		long[] diff = new long[n+2];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			diff[L]++;
			diff[R+1]--;
		}
		long[] count = new long[n+1];
		for(int i=1;i<=n;i++) {
			count[i] = count[i-1]+diff[i];
		}
		for(int i=1;i<=n;i++) {
			sum1 += arr[i]*count[i];
		}
		Arrays.sort(arr);
		Arrays.sort(count);
		for(int i=1;i<=n;i++) {
			sum2 += arr[i]*count[i];
		}
		System.out.println(sum2-sum1);
	}
}
