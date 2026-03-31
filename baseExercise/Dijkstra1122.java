package baseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 *       问题描述
小明是蓝桥王国的王子，今天是他登基之日。
在即将成为国王之前，老国王给他出了道题，他想要考验小明是否有能力管理国家。
题目的内容如下：
蓝桥王国一共有 N 个建筑和 M 条单向道路，每条道路都连接着两个建筑，每个建筑都有自己编号，
分别为 1∼N。（其中皇宫的编号为 1）
国王想让小明回答从皇宫到每个建筑的最短路径是多少，但紧张的小明此时已经无法思考，请你编写程
序帮助小明回答国王的考核。
	输入描述
输入第一行包含两个正整数 N,M。
第 2 到 M+1 行每行包含三个正整数 u,v,w，表示 u→v 之间存在一条距离为 w 的路。
数据范围：1≤N≤3×105，1≤M≤106，1≤ui​,vi​≤N，0≤wi​≤109。
	输出描述
输出仅一行，共 N 个数，分别表示从皇宫到编号为 1∼N 建筑的最短距离，两两之间用空格隔开。
（如果无法到达则输出 −1）
 */
public class Dijkstra1122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<long[]>[] graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=1;i<=m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			long w = sc.nextInt();
			graph[u].add(new long[] {v,w});
		}
		sc.close();
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<long[]> pq = new PriorityQueue<>(
				(a,b) -> Long.compare(a[1],b[1]));
		pq.add(new long[] {1,0});
		
		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			int u = (int)cur[0];
			long d = cur[1];
			if(d>dist[u]) continue;
			for(long[] e: graph[u]) {
				int v = (int)e[0];
				long w = e[1];
				if(dist[v]>dist[u]+w) {
					dist[v] = dist[u]+w;
					pq.add(new long[] {v,dist[u]+w});
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(dist[i]==Long.MAX_VALUE)  dist[i] = -1;
			if(i<n) {
				System.out.print(dist[i]+" ");
			}else {
				System.out.print(dist[i]);
			}
		}	
	}
}
