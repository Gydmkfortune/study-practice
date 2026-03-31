package MiniExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bucket {
	public static void main(String[] args) {
		int[] arr = {5,8,1,7,6,4,3,9,2};
		
		tong(arr,4);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
	}
	
	public static void tong(int[] arr,int bucketNum) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		
		List<List<Integer>> bucketList= new ArrayList<List<Integer>>();
		for (int i : arr) {
			bucketList.add(new ArrayList<Integer>());
		}
		
		for (int i : arr) {
			int bucketIndex = (i - min) * (bucketNum - 1) / (max - min);
			List<Integer> list = bucketList.get(bucketIndex);
			list.add(i);
		}
		
		for(int i = 0;i < bucketNum;i++) {
			int arrIndex = 0;
			List<Integer> bucket = bucketList.get(i);
			Collections.sort(bucket);
			arr[arrIndex++] = bucket.get(i);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
