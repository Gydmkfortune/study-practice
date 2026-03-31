package baseExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *       问题描述
小蓝有一天误入了一个混境之地。
好消息是：他误打误撞拿到了一张地图，并从中获取到以下信息：
混境之地是一个 n⋅m 大小的矩阵，其中第 i 行第 j 列的点 hij​ 表示第 i 行第 j 列的高度。
他现在所在位置的坐标为 (A,B)，而这个混境之地出口的坐标为 (C,D)，当站在出口时即表示
可以逃离混境之地。
小蓝有一个喷气背包，使用时，可以原地升高 k 个单位高度。
坏消息是：
由于小蓝的体力透支，所以只可以往低于当前高度的方向走。
喷漆背包燃料不足，只可以最后使用一次。
小蓝可以往上下左右四个方向行走，不消耗能量。
小蓝想知道他能否逃离这个混境之地，如果可以逃离这里，输入 Yes，反之输出 No。
	输入格式
第 1 行输入三个正整数 n,m 和 k，n,m 表示混境之地的大小，k 表示使用一次喷气背包可以升
高的高度。
第 2 行输入四个正整数 A,B,C,D，表示小蓝当前所在位置的坐标，以及混境之地出口的坐标。
第 3 行至第 n+2 行，每行 m 个整数，表示混境之地不同位置的高度。
	输出格式
输出数据共一行一个字符串：
若小蓝可以逃离混境之地，则输出 Yes。
若小蓝无法逃离混境之地，则输出 No。
 */
public class DFSMemory3820 {
	static int n,m,k,A,B,C,D;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] mem;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mem =  new boolean[n+1][m+1];
		dfs(A,B,k);
		System.out.println("No");
	}
	static void dfs(int x,int y,int flag) {	
		//满足的情况
		if((x==C) && (y==D)) {
			System.out.println("Yes");
			System.exit(0);
		}
		
		mem[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>0 && nx<n+1 && ny>0 && ny<m+1 && !mem[nx][ny]) {
				if(arr[x][y]>arr[nx][ny]) {
					dfs(nx,ny,flag);
				}else if(arr[x][y]<arr[nx][ny] && flag>0 && (arr[nx][ny]-arr[x][y])<=flag){
					dfs(nx,ny,0);
				}
			}
		}
	}
}
