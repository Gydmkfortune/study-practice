package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一块黑色的瓷砖上，
只能向相邻（上下左右四个方向）的黑色瓷砖移动。写一个程序计算总共能够到达多少块黑色的瓷砖。
	输入描述
第一行是两个整数 n 和 m，分别代表房间的行数和列数。
接下来 n 行，每行包含 m 个字符，每个字符代表一块瓷砖的颜色，规则如下：
.：黑色的瓷砖；
#：红色的瓷砖；
@：黑色的瓷砖，并且是你站立的起点，该字符在每个数据集合中唯一出现一次。
输出描述
对于每组输入，输出从起点 @ 出发，总共能够到达的黑色瓷砖的数量（包含起点本身）。
如果无法到达更多瓷砖，仅统计起点数量。
 */
public class DFSbase {
	static int ans;
	static boolean[][] vis;
	static char[][] map ;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		vis = new boolean[N][M];
		for(int i=0;i<N;i++) {
			map[i] = sc.next().toCharArray();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='@') {
					dfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}
	static void dfs(int i,int j) {
		//（i，j）不能走的情况下
		if(i>=N||i<0||j>=M||j<0) return;
		if(map[i][j]=='#') return;
		if(vis[i][j]) return;
		
		//（i，j）能走的情况下
		ans++;
		vis[i][j] = true;
		dfs(i+1,j);
		dfs(i-1,j);
		dfs(i,j+1);
		dfs(i,j-1);
	}
}
