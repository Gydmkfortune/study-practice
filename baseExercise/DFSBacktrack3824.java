package baseExercise;

import java.util.Scanner;
/*
 *       问题描述
人类的开心程度有高低之分，数字也一样。给定一个正整数 n，在 n 的数位之间插入 k 个加号，
使其变成一个表达式，计算得出的结果就是 n 的一个 k 级开心程度。例如 n=1234，k=1 时，
我们可以往 2 和 3 之间插入一个 + 号，使其变为 12+34，计算出结果为 46。那么 46 就是 1234 的
一个 k 级开心程度。给定 n,k，请你计算出 n 的 k 级开心程度的最大值与最小值之差。
	输入格式
一行输入两个正整数 n,k，含义见题面。
	输出格式
一行一个整数，表示 n 的 k 级开心程度的最大值与最小值之差。
 */
public class DFSBacktrack3824 {
	static String n;
	static long k;
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.next();
		k = sc.nextLong();
		dfs(k,1,0,n.charAt(0)-'0');
		System.out.println(max-min);
	}
	
	//k加号数目  pos当前位置  sum当前和  cur当前数字
	static void dfs(long k,int pos,long sum,long cur) {
		if(pos==n.length()) {
			if(k==0) {
				long total = sum + cur;
				max = Math.max(max, total);
				min = Math.min(min, total);
			}
			return;
		}
		//no+
		dfs(k,pos+1,sum,cur*10+n.charAt(pos)-'0');
		//+
		if(k>0) {
			dfs(k-1,pos+1,sum+cur,n.charAt(pos)-'0');
		}
	}
}
