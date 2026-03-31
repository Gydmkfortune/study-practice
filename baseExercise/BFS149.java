package baseExercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *       题目描述
小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右
四小块空地扩展，这四小块空地都将变为有草的小块。请告诉小明，k 个月后空地上哪些地方有草。
	输入描述
输入的第一行包含两个整数 n,m。
接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点（.），
表示为空地；如果字母为 g，表示种了草。
接下来包含一个整数 k。其中约束：2≤n,m≤1000，1≤k≤1000。
	输出描述
输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点（.），表示为空地；
如果字母为 g，表示长了草。
 */
public class BFS149 {
	public static void main(String[] args) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] chr = new char[n][m];
		int[][] vis = new int[n][m];
		
		for(int i=0;i<n;i++) {
			chr[i] = sc.next().toCharArray();
		}
		int k = sc.nextInt();
		sc.close();
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(chr[i][j]=='g') {
					q.add(new int[]{i,j});
					vis[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cao = q.poll();
			int x = cao[0];
			int y = cao[1];
			
			if(vis[x][y]>=k) continue;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && chr[nx][ny]=='.') {
					chr[nx][ny] = 'g';
					vis[nx][ny] = vis[x][y]+1;
					q.add(new int[]{nx,ny}); 
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
            System.out.println(new String(chr[i]));
        }
	}
}
