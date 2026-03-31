package MiniExercise;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {5,8,1,7,6,4,3,9,2};

        guibing(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void guibing(int[] arr) {
        int[] tempArr = new int[arr.length];
        divide(arr,tempArr,0, arr.length - 1);
    }

    public static void divide(int[] arr,int[] tempArr,int begin,int end) {
        if (begin < end) {
            int mid = begin + ((end - begin)>>1);
            divide(arr,tempArr,begin,mid);
            divide(arr,tempArr,mid + 1,end);
            merge(arr,tempArr,begin,mid,end);
        }
    }

    public static void merge(int[] arr,int[] tempArr,int begin,int mid,int end) {
        int leftPos = begin;
        int rightPos = mid + 1;
        int tempArrpos = begin;
        while (leftPos <= mid && rightPos <= end) {
            if (arr[leftPos] < arr[rightPos]) {
                tempArr[tempArrpos++] = arr[leftPos++];
            }else {
                tempArr[tempArrpos++] = arr[rightPos++];
            }
        }
        while (leftPos <= mid) {
            tempArr[tempArrpos++] = arr[leftPos++];
        }
        while (rightPos <= end) {
            tempArr[tempArrpos++] = arr[rightPos++];
        }
        System.arraycopy(tempArr,begin,arr,begin,end - begin + 1);
    }
}
