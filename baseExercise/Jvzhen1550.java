package baseExercise;

import java.util.Scanner;

/*
 *       题目描述
小明最近刚刚学习了矩阵乘法，但是他计算的速度太慢，
于是他希望你能帮他写一个矩阵乘法的运算器。
	输入描述
输入的第一行包含三个正整数 N,M,K，表示一个 N×M 的矩阵乘以一个 M×K 的矩阵。
接下来 N 行，每行 M 个整数，表示第一个矩阵。再接下来的 M 行，每行 K 个整数，
表示第二个矩阵。
0<N,M,K≤100，0≤ 矩阵中的每个数 ≤1000。
	输出描述
输出有 N 行，每行 K 个整数，表示矩阵乘法的结果
 */
public class Jvzhen1550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),M = sc.nextInt(),K = sc.nextInt();
		int[][] one = new int[N][M];
		int[][] two = new int[M][K];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				one[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<K;j++) {
				two[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int[][] three = new int[N][K];
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				int sum = 0;
				for(int g=0;g<M;g++) {
					sum += one[i][g] * two[g][j];
				}
				three[i][j] = sum;
				System.out.print(three[i][j]);
				if(j != K-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
