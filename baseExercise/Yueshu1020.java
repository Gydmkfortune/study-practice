package baseExercise;
/*
 * 定义阶乘 n!=1×2×3×⋅⋅⋅×n。问 100! 有多少个正约数
 */
public class Yueshu1020 {
	public static void main(String[] args) {
		int[] arr = new int[101];
		for(int i=1;i<=100;i++) {
			int k=i;
			for(int j=2;j<=k/j;j++) {
				if(k%j==0) {
					while(k%j==0) {
						k /= j;
						arr[j]++;
					}
				}
			}
			if(k>1) {
				arr[k]++;
			}
		}
		long res = 1;
		for(int i=1;i<101;i++) {
			if(arr[i]!=0) {
				res = res*(arr[i]+1);
			}
		}
		System.out.println(res);
	}
}
