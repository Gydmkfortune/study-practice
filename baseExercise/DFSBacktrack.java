package baseExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * DFS回溯
 * 输入一个数组n，求1-n的全排列
 */
public class DFSBacktrack {
	static List<Integer> path = new ArrayList<Integer>();
	static boolean[] vis;
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		vis = new boolean[n+1];
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		dfs();
	}
	static void dfs() {
		if(path.size() == n) {
			System.out.println(path);
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!vis[i]) {
				path.add(arr[i]);
				vis[i]=true;
				dfs();
				path.remove(path.size()-1);
				vis[i]=false;
			}
		}
	}
}
