package baseExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 题目描述
	小明拥有 N 个彩灯，第 i 个彩灯的初始亮度为 ai​。
	小明将进行 Q 次操作，每次操作可选择一段区间，并使区间内彩灯的亮度 +x（x可为负数）
	求 Q 次操作后每个彩灯的亮度（若彩灯亮度为负数则输出 0）。
   输入描述
	第一行包含两个正整数 N，Q，分别表示彩灯的数量和操作的次数。
	第二行包含 N 个整数，表示彩灯的初始亮度。
	接下来 Q 行每行包含一个操作，格式如下：l r x，表示将区间 l∼r 的彩灯的亮度 +x。
	1≤N,Q≤5×105，0≤ai​≤109，1≤l≤r≤N，−109≤x≤109
   输出描述
	输出共 1 行，包含 N个整数，表示每个彩灯的亮度
 */
public class CaiDeng {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		
		long[] arr = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
	
		//差分
		long[] diff = new long[N+2];
		diff[1] = arr[1];
		for(int i=2;i<=N;i++) {
			diff[i] = arr[i]-arr[i-1];
		}
		
		for(int i = 0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long x = Integer.parseInt(st.nextToken());
			
			diff[l] += x;
			diff[r+1] -= x;
		}
		
		//前缀和
		StringBuilder sb = new StringBuilder();
		long res = 0;
		for(int i=1;i<=N;i++) {
			res += diff[i];
			sb.append(res<0?0:res).append(" ");
		}
		
		//输出
		System.out.println(sb.toString().trim());
		br.close();
	}
}
