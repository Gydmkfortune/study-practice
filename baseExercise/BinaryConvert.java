package baseExercise;

public class BinaryConvert {
	
	public static void main(String[] args) {
		/*
		 * 小明要用二进制来表示 1到 10000 的所有整数，要求不同的整数用不同的二进制数表示，
		 * 请问，为了表示 1 到10000 的所有整数，至少需要多少个二进制位？
		 */
		StringBuilder sb = new StringBuilder();
		int n = 10000;
		while(n>0) {
			sb.append(n%2);
			n/=2;
		}
		System.out.println(sb.length());
		
		
		//请问十六进制数 2021ABCD 对应的十进制是多少
		String str = "2021ABCD";
		int k = 0;
		long res = 0;
		for(int i = str.length()-1;i>=0;i--) {
			if(str.charAt(i)>='A' && str.charAt(i)<='D') {
				res += (long)(str.charAt(i)-'A'+10) * (long)Math.pow(16, k);
			}else
				res += (long)(str.charAt(i)-'0') * (long)Math.pow(16, k);
			k++;
		}
		System.out.println(res);
		//进阶方法：
		System.out.println(Integer.parseInt("2021ABCD",16));
	}
}
