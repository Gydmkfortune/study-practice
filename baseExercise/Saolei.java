package baseExercise;

import java.util.Scanner;

public class Saolei {
	public static void main(String[] args) {
		/*
		 * 在一个 n 行 m 列的方格图上有一些位置有地雷，另外一些位置为空。
		请为每个空位置标一个整数，表示周围八个相邻的方格中有多少个地雷。
		*/
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		
		int[][] result = new int[n][m];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(arr[i][j] == 1) {
					result[i][j] = 9;
				}else {
					for(int a = i-1;a <= i+1;a++) {
						for(int b = j-1;b <= j+1;b++) {
							if(a<0 || a>=n || b<0 || b>=m || ((a==i)&&(b==j))) {
								continue;
							}else if(arr[a][b] == 1) {
								++result[i][j];
							}
						}
					}
				}
			}
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
