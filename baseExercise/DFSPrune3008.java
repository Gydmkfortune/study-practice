package baseExercise;

import java.util.Scanner;

/*
 *       问题描述
假设一个三角形三条边为 a、b、c，定义该三角形的值 v=a×b×c。
现在有 t 个询问，每个询问给定一个区间 [l,r]，问有多少个三条边都不相等的三角形的值 v 在该区间范围内。
	输入格式
第一行包含一个正整数 t，表示有 t 个询问。
接下来 t 行，每行有两个空格隔开的正整数 l、r，表示询问区间 [l,r]。
	输出格式
输出共 t 行，第 i 行对应第 i 个查询的三角形个数。
 */
public class DFSPrune3008 {
	public static void main(String[] args) {
		long[] v = new long[1000000];
		
		/*枚举出所有可能的值存入数组
		b最小为a+1，c为a+2，此时a*(a+1)*(a+2)<10e6 -> a<10e2
		a最小为1，c为b+1，此时b*(b+1)<10e6 -> b<10e3
		c<a+b
		*/
		for(int a=1;a<100;a++) {
			for(int b=a+1;b<1000;b++) {
				for(int c=b+1;c<a+b;c++) {
					if(a*b*c<v.length) {
						v[a*b*c]++;
					}
				}
			}
		}
		//给数组求前缀和
		for(int i=1;i<v.length;i++) {
			v[i]+=v[i-1];
		}
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(v[r]-v[l-1]);
		}
	}
}
