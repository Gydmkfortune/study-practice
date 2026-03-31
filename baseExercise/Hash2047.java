package baseExercise;

import java.util.Scanner;

public class Hash2047 {
	static long[] h = new long[1000005];
	static long[] p = new long[1000005];
	static int P = 131;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S1 = sc.nextLine();
		String S2 = sc.nextLine();
		sc.close();
		init(S2);
		
		long Sha1 = 0;
		//得到S1的哈希值
		for(int i=0;i<S1.length();i++) {
			Sha1 = Sha1*P + S1.charAt(i);
		}
		
		int count = 0;
		//对比s1和s2
		for(int i=1;(i+S1.length()-1)<=S2.length();i++){
			if(get(i,i+S1.length()-1) == Sha1) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	//初始化
	static void init(String s) {
		p[0] = 1;
		for(int i=1;i<=s.length();i++) {
			h[i] = h[i-1]*P + s.charAt(i-1);
			p[i] = p[i-1]*P;
		}
	}
	
	static long get(int l,int r) {
		return h[r]-h[l-1]*p[r-l+1];
	}
}
