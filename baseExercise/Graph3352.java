package baseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 *       问题描述
在一个有 n 个城市的王国中，小蓝和小桥分别生活在城市 1 和城市 n。这些城市间有 m 条双向路径，
第 i 条路径连接城市 ai​ 和城市 bi​，通行时间为 1 小时。小蓝想要尽快到达小桥的城市，请问他有
多少种可行路径。由于答案可能非常大，因此将答案对 109+7 取模。
	输入格式
第一行包含两个整数 n 和 m。
接下来 m 行，每行包含两个整数 ai​ 和 bi​，表示存在一条连接城市 ai​ 和城市 bi​ 的双向路径。
数据范围保证：2≤n≤2×105，0≤m≤2×105，1≤ai​<bi​≤n。
	输出格式
输出一个整数，表示小蓝最快到达小桥的城市的方案数，答案对 109+7 取模。
 */
public class Graph3352 {
	public static void main(String[] args) {
		long mod = 1000000007;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int[] dist = new int[n+1];//从1到i的距离
		long[] cnt = new long[n+1];//从1到i的最短路径方案数
		Arrays.fill(dist, -1);
		dist[1] = 0;
		cnt[1] = 1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : graph[u]) {
				if(dist[v]==-1) {
					dist[v] = dist[u] + 1;
					cnt[v] = cnt[u];
					q.add(v);
				}else if(dist[v]==dist[u]+1){
					cnt[v] = (cnt[v]+cnt[u])%mod;
				}
			}
		}
		System.out.println(cnt[n]);
	}
}
