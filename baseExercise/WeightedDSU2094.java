package baseExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *       问题描述
对于一个长度为 N 的整数数列 A1​,A2​,…,AN​，小蓝想知道下标 l 到 r 的部分和
 ∑i=lr​=Al​+Al+1​+⋯+Ar​ 是多少？
然而，小蓝并不知道数列中每个数的值是多少，他只知道它的 M 个部分和的值。
其中第 i 个部分和是下标 li​ 到 ri​ 的部分和 ∑j=li​ri​​=Ali​​+Ali​+1​+⋯+Ari​​，值是 Si​。
	输入格式
第一行包含 3 个整数 N、M 和 Q。分别代表数组长度、已知的部分和数量和询问的部分和数量。
接下来 M 行，每行包含 3 个整数 li​,ri​,Si​。
接下来 Q 行，每行包含 2 个整数 l 和 r，代表一个小蓝想知道的部分和。
	输出格式
对于每个询问，输出一行包含一个整数表示答案。如果答案无法确定，输出 UNKNOWN
 */
public class WeightedDSU2094 {
	static int[] parent;
	static long[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//数组
		int N = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		dist = new long[N+1];
		for(int i=0;i<=N;i++) {
			parent[i] = i;
		}
		
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		//把已知的存进去
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long S = Integer.parseInt(st.nextToken());
			union(l-1,r,S);
		}
		
		//查询结果
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(find(l-1)==find(r)) {
				long res = dist[l-1]-dist[r];
				sb.append(res).append("\n");	
			}else {
				sb.append("UNKNOWN\n");
			}
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(x != parent[x]) {
			int root = find(parent[x]);
			dist[x] += dist[parent[x]];
			parent[x] = root;
		}
		return parent[x];
	}
	
	static void union(int a,int b,long w) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			parent[pa] = pb;
			dist[pa] = dist[b] -dist[a] + w;
		}
	}
}
