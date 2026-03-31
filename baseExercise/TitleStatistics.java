package baseExercise;

import java.util.Scanner;

public class TitleStatistics {
	public static void main(String[] args) {
		/*325
		 【问题描述】
		  输入一行字符串，计算这个字符串中有多少个字符？
	           注意：字符串中可能包含大、小写英文字母、数字字符、
	         空格和换行符。统计标题字符数时，空格和换行符不计算在内。
		 */
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int res = 0;
		for(int i = 0;i < str.length();i++) {
			char c = str.charAt(i);
			if(c != ' ' && c != '\n')
				res++;
		}
		System.out.println(res);
		sc.close();
	}

}
