package baseExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 题目描述
	在很久很久以前，有 n 个部落居住在平原上，依次编号为 1 到 n。第 i个部落的人数为 ti​。
	有一年发生了灾荒。小蓝想说服所有部落一同应对灾荒，他能通过谈判来说服部落进行联合。
	每次谈判，小蓝只能邀请两个部落参加，花费的金币数量为两个部落的人数之和，
	谈判的效果是两个部落联合成一个部落（人数为原来两个部落的人数之和）。
   输入描述
	输入的第一行包含一个整数 n，表示部落的数量。
	第二行包含 n 个正整数，依次表示每个部落的人数。
	其中，1≤n≤1000，1≤ti​≤104。
   输出描述
	输出一个整数，表示最小花费。
 */
public class Negotiate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<n+1;i++) {
			list.add(sc.nextInt());
		}
		sc.close();
		int cost = 0;
		Collections.sort(list);
		while(list.size() != 1) {
			int k = list.get(0)+list.get(1);
			list.add(k);
			cost += k;
			list.remove(0);
			list.remove(0);
			Collections.sort(list);
		}
		System.out.println(cost);
	}
}
