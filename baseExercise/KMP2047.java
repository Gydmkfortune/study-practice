package baseExercise;

import java.util.Scanner;

/*
 * 题目描述
小 Z 同学每天都喜欢斤斤计较，今天他又跟字符串杠起来了。他看到了两个字符串 S1、S2，
他想知道 S1 在 S2 中出现了多少次。
现在给出两个串 S1、S2（只有大写字母），求 S1 在 S2 中出现了多少次。
输入描述
共输入两行，第一行为 S1，第二行为 S2。
数据范围：1<len(S1)<len(S2)<106，字符只为大写字母或小写字母。
输出描述
输出一个整数，表示 S1 在 S2 中出现了多少次。
 */
public class KMP2047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S1 = sc.nextLine();
		String S2 = sc.nextLine();
		sc.close();
		int count = KMP(S2, S1);
		System.out.println(count);
	}
	
	//构造next数组
	static int[] buildNext(String p) {
		int j = 0;
		int[] next = new int[p.length()];
		
		for(int i=1;i<p.length();i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) {
				j = next[j-1];
			}
			if(p.charAt(i)==p.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	
	//KMP
	static int KMP(String T,String P) {
		int j = 0;
		int[] next = buildNext(P);
		int count = 0;
		for(int i=0;i<T.length();i++) {
			while(j>0 && P.charAt(j)!=T.charAt(i)) {
				j = next[j-1];
			}
			if(P.charAt(j)==T.charAt(i)) {
				j++;
			}
			if(j==P.length()) {
				count++;
				j = 0;
			}
		}
		return count;
	}
}
