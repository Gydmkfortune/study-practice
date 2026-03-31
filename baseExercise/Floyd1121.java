package baseExercise;

import java.util.Arrays;
import java.util.Scanner;

/*
 *       题目描述
小明喜欢观景，于是今天他来到了蓝桥公园。
已知公园有 N 个景点，景点和景点之间一共有 M 条道路。小明有 Q 个观景计划，每个计划包含一个
起点 st 和一个终点 ed，表示他想从 st 去到 ed。但是小明的体力有限，对于每个计划他想走最少
的路完成，你可以帮帮他吗？
	输入描述
输入第一行包含三个正整数 N,M,Q
第 2 到 M+1 行每行包含三个正整数 u,v,w，表示 u↔v 之间存在一条距离为 w 的路。
第 M+2 到 M+Q−1 行每行包含两个正整数 st,ed，其含义如题所述。
数据范围：1≤N≤400，1≤M≤2N×(N−1)​，Q≤103，1≤u,v,st,ed≤N，1≤w≤109
	输出描述
输出共 Q 行，对应输入数据中的查询。
若无法从 st 到达 ed 则输出 −1。
 */
public class Floyd1121 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        long[][] dist = new long[N+1][N+1];
        long INF = Long.MAX_VALUE;
        for(int i=1;i<=N;i++) {
        	Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i=0;i<M;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        
        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(dist[i][k]<INF && dist[k][j]<INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        
        for(int i=0;i<Q;i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            if(dist[st][ed]==INF)  dist[st][ed] = -1;
            System.out.println(dist[st][ed]);
        }
    }
}
