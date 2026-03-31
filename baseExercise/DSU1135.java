package baseExercise;

import java.util.Scanner;
/*
 *       问题描述
蓝桥幼儿园的学生是如此的天真无邪，以至于对他们来说，朋友的朋友就是自己的朋友。
小明是蓝桥幼儿园的老师，这天他决定为学生们举办一个交友活动，活动规则如下：
小明会用红绳连接两名学生，被连中的两个学生将成为朋友。
小明想让所有学生都互相成为朋友，但是蓝桥幼儿园的学生实在太多了，他无法用肉眼判断某两个学生是否为朋友。于是他想起了作为编程大师的你，请你帮忙写程序判断某两个学生是否为朋友（默认自己和自己也是朋友）。
	输入描述
第 1 行包含两个正整数 N,M，其中 N 表示蓝桥幼儿园的学生数量，学生的编号分别为 1∼N。
之后的第 2∼M+1 行每行输入三个整数，op,x,y：
如果 op=1，表示小明用红绳连接了学生 x 和学生 y。
如果 op=2，请你回答小明学生 x 和学生 y 是否为朋友。
	数据范围：1≤N,M≤2×105，1≤x,y≤N。
	输出描述
对于每个 op=2 的输入，如果 x 和 y 是朋友，则输出一行 YES，否则输出一行 NO。
 */
public class DSU1135 {
	static int[] parent = new int[200005];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//初始化
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<M;i++) {
			int op = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(op==2) {
				if(find(x)==find(y)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
			if(op==1) {
				union(x,y);
			}
		}
		sc.close();
	}
	
	//查询根
	static int find(int x) {
		return parent[x] = (x==parent[x]?x:find(parent[x]));
	}
	
	//结合
	static void union(int a,int b) {
		if(find(a)!=find(b)) {
			parent[find(a)] = find(b);
		}
	}
}
