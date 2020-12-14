public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1,5,6,8,7,5};
        array = sortArray(0, array.length-1, array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    //sort array @array[@begin, @end], return the sorted result. The original array will not be changed.
    public static int[] sortArray(int start, int end, int[] array) {
        if (start < end) {
            int split = (start + end)/2;
            return merge(sortArray(start, split, array), sortArray(split + 1, end, array));
        }
        return new int[] {array[start]};
    }

    public static int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] array = new int [arrayOne.length + arrayTwo.length];
        int onePos = 0;
        int twoPos = 0;
        int pos = 0;
        while (onePos < arrayOne.length && twoPos < arrayTwo.length) {
            if (arrayOne[onePos] < arrayTwo[twoPos]) {
                array[pos] = arrayOne[onePos];
                onePos++;
                pos++;
            } else {
                array[pos] = arrayTwo[twoPos];
                twoPos++;
                pos++;
            }
        }
        while (onePos < arrayOne.length) {
            array[pos] = arrayOne[onePos];
            onePos++;
            pos++;
        }
        while (twoPos < arrayTwo.length) {
            array[pos] = arrayTwo[twoPos];
            twoPos++;
            pos++;
        }
        return array;
    }
}
