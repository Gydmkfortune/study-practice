package baseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 *       问题描述
小明在游戏中参加了一个帮派，这一天他突然想知道自己在帮派中是什么地位，但是帮派的查询系统
突然坏了，目前只能知道每个人的附属关系，请问你能帮帮他重建关系网并找出他的地位吗？
给定一个正整数 n，代表该帮派的总人数，并且小明的序号是 m，给出这 n 个人中每个人的附属关系，
确保给出的关系网为一棵树。帮派地位的定义是按照自己手下有多少帮众决定的，注意手下的手下也算
是自己的手下。如果手下的帮众相同则按序号较小的在前面。你能帮助小明找到自己的帮派地位吗？
	输入格式
第一行，两个正整数 n (1≤n≤105) 和 m (1≤m≤n)，代表该帮派的总人数以及小明的序号。
接下来 n−1 行，每行两个正整数，格式如下：
l r（1≤l,r≤n），代表序号为 l 的人附属于序号为 r 的人。
	输出格式
一行，包含 1 个正整数，输出按手下人数多少排序后小明的排名。
 */
public class Graph3891 {
	static List<Integer>[] graph;
	static int n;
	static int[] size;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		size = new int[n+1];
		graph = new ArrayList[n+1];
		
		for (int i = 1; i < n+1; i++) {
		    graph[i] = new ArrayList<>();
		}
		
		int[] parent = new int[n+1];
		for(int i=1;i<n;i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			graph[r].add(l);
			parent[l] = 1;
		}
		
		//找根节点
		int root = 1;
		for(int i=1;i<=n;i++) {
			if(parent[i]==0) {
				root = i;
			}
		}
		
		dfs(root);
		Integer[] rank = new Integer[n];
		for(int i=0;i<n;i++) {
			rank[i] = i+1;
		}
		Arrays.sort(rank,(a,b) -> {
			if(size[a]!=size[b]) {
				return size[b]-size[a];
			}
			return a-b;
		});
		for(int i=0;i<n;i++) {
			if(rank[i]==m) {
				System.out.println(i);
			}
		}
	}
	static void dfs(int a) {
		size[a] = 1;
		for(int s : graph[a]) {
			dfs(s);
			size[a] += size[s];
		}
	}
}
