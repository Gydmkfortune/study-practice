package MiniExercise;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {5,8,1,7,6,4,3,9,2};

        kuaisu(arr,0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void kuaisu(int[] arr,int left,int right) {
        if (left < right) {
            int poivt = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && arr[j] > poivt) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < poivt) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = poivt;
            kuaisu(arr,left,i - 1);
            kuaisu(arr,i + 1,right);
        }
    }
}
