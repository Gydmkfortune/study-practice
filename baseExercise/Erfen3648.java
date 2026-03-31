package baseExercise;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 *       问题描述
给定 n 个数形成的一个序列 a，现定义如果一个连续子序列包含序列 a 中所有不同元素，则该连续
子序列便为蓝桥序列，现在问你，该蓝桥序列长度最短为多少？
例如 1 2 2 3 2 2 1，包含 3 个不同的数 1, 2, 3，而 3 2 2 1 符合题目要求，因此答案为 4。
连续子序列：从序列 a 中选取若干个连续的数形成一个序列叫连续子序列。
	输入格式
第一行输入一个整数 n，表示序列长度。
第二行输入 n 个元素。
	输出格式
输出一个整数，表示最短的蓝桥序列长度。
 */
public class Erfen3648 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
			set.add(arr[i]);
		}
		scan.close();
		int l=0,r=0,min=n+1,count=0;
		int need = set.size();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(r=0;r<n;r++) {
			map.put(arr[r],map.getOrDefault(arr[r], 0)+1);
			if(map.get(arr[r])==1) {
				count++;
			}
			while(count==need) {
				min = Math.min(min, (r-l+1));
				map.put(arr[l],map.get(arr[l])-1);
				if(map.get(arr[l])==0) {
					count--;
					map.remove(arr[l]);
				}
				l++;
			}
		}
		System.out.println(min);
		
	}
}
