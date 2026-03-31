package baseExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Erfen172 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] A = method(n);
		int[] B = method(n);
		int[] C = method(n);
		int sum = 0;
		
		for(int i=1;i<=n;i++) {
			int res1 = erfen(A[i],B,n);
			for(int j=res1;j<=n;j++) {
				sum += n-erfen(B[j],C,n)+1;
			}
		}
		System.out.println(sum);
	}
	public static int[] method(int n) {
		int[] X = new int[n+1];
		for(int i=1;i<=n;i++) {
			X[i] = sc.nextInt();
		}
		Arrays.sort(X);
		return X;
	}
	public static int erfen(int x,int[] X,int n) {
		int l=0,r=n,mid;
		while(l<r) {
			mid = (l+r+1)/2;
			if(X[mid]>x) {
				r = mid-1;
			}else {
				l = mid;
			}
		}
		return l+1;
	}
}
