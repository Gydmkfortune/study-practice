package MiniExercise;

public class Insert {
    public static void main(String[] args) {
        charu();
    }
    public static void charu() {
        int[] arr = {5,8,1,7,6,4,3,9,2};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
