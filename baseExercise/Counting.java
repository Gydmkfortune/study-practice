package baseExercise;

import java.util.Scanner;

public class Counting {

	public static void main(String[] args) {
		/*377
		 * 计算在区间1到n的所有整数中，数字x（0<=x<=9）出现了多少次
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.close();
		int num = 0;
		
		for(int i = 1;i <= n;i++) {
			String s = i + "";
			for(int j = 0;j < s.length();j++) {
				int c = s.charAt(j) - '0';
				if(c==x)
					num++;
			}
		}
		System.out.println(num);
	}

}
