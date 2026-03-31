package baseExercise;

import java.util.Scanner;

public class StringHandle {
	/*
	 * 在实际的开发工作中，对字符串的处理是最常见的编程任务。本题目即是要求程序对用户
	 * 输入的串进行处理。具体规则如下：
	   1.把每个单词的首字母变为大写。
	   2.把数字与字母之间用下划线字符（_）分开，使得更清晰
	   3.把单词中间有多个空格的调整为 1 个空格。
	输入描述
  	       用户输入的串中只有小写字母，空格和数字，不含其它的字母或符号。
  	       每个单词间由 1 个或多个空格分隔。假设用户输入的串长度不超过 200 个字符。
 	输出描述
	       输出处理好的字符串。
	 */

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		char[] c = str.toCharArray();
		char flag = ' ';
		
		for(int i = 0;i < c.length;i++) {
			if(flag==' ' && c[i]==' ');
			else if(flag==' ' && c[i]>='a' && c[i]<='z')
				System.out.print((char)(c[i]-32));
			else if((flag<='9' && flag>='0' && c[i]>='a' && c[i]<='z')
					||(flag<='z' && flag>='a' && c[i]<='9' && c[i]>='0'))
				System.out.print("_" + c[i]);
			else
				System.out.print(c[i]);
			flag = c[i];
		}
		
	}
}
