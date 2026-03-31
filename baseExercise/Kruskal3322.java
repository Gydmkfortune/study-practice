package baseExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 *       问题描述
蓝桥公司招聘了一个推销员，他大部分时间都在不同的城市之间旅行。他决定买一辆新车来帮助他的
工作，但他必须决定新车油箱的容量。假设这辆新车每公里耗油一升。
每个城市至少有一个加油站，推销员可以在那里给油箱加油，但城市之间的道路上没有加油站。给出
城市及其之间道路的描述，找出所需油箱的最小容量，以便推销员能够至少以一种方式在任何一对城市
之间旅行。
	输入格式
输入的第一行包含表示测试用例数的 T。
每个测试用例的第一行包含两个整数：N 和 M，其中 N 为城市数量，M 为道路数量。
以下 M 行都包含三个整数：X,Y,C，其中 C 是城市 X 和城市 Y 之间的长度，单位为公里。道路可以
双向使用。
题目保证每对城市之间最多有一条道路相连，并且可以使用给定的道路在任意一对城市之间旅行。
	输出格式
对于每个测试用例，打印一行整数表示油箱所需的最小容量。
 */
public class Kruskal3322 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			List<int[]> list = new ArrayList<>();
			
			parent = new int[n+1];
			for(int o=1;o<=n;o++) {
				parent[o] = o;
			}
			for(int j =0;j<m;j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				list.add(new int[] {x,y,z});
			}
			
			Collections.sort(list,(a,b)->a[2]-b[2]);
			int max = 0;
			for(int k=0;k<m;k++) {
				int u = find(list.get(k)[0]);
				int v = find(list.get(k)[1]);
				if(u!=v) {
					union(u,v);
					max = Math.max(max, list.get(k)[2]);
				}
			}
			System.out.println(max);
		}
		sc.close();
	}
	static int find(int x) {
		return x==parent[x]?x:find(parent[x]);
	}
	
	static void union(int a,int b) {
		if(find(a)!=find(b)) {
			parent[find(a)] = find(b);
		}
	}
}
