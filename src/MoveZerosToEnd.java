public class MoveZerosToEnd {
    public static void main(String[] args) {

        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();
        int[] a = {1, 0, 0, 2};
        // int[] a = {1, 2, 3, 6, 0, 0, 0};

        // int[] a = {23, 45, 0, 0, 0, 0, 1, 3, 0};
        //  int a[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        //int b[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int[] b = {1, 0, 0, 2};
        //int[] b = {1, 2, 3, 6, 0, 0, 0};

        //  int[] b = {23, 45, 0, 0, 0, 0, 1, 3, 0};

        //int[] a ={23, 45, 0, 0, 0, 0, 1, 3, 0};
        //int[] b = {0, 1, 0, 3, 12};
        moveZerosToEnd.compute1(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        moveZerosToEnd.compute3(b);

        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

    private void compute(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                count++;
            }
        }

        int countOfNonZeroElements = a.length - count;
        int right = 0;
        int left = a.length - countOfNonZeroElements;
        int nonMatching = 0;
        while (left + nonMatching < a.length) {
            if (a[right] != 0) {
                swap(a, right, left + nonMatching);
                nonMatching++;
            } else {
                right++;
                left++;
                nonMatching = 0;
            }

            if (right == count + 1) {
                break;
            }
        }
    }

    private void swap(int[] a, int right, int left) {
        int temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    private void compute1(int[] a) {

        int lastNonZero = 0;
        for (int idx = 0; idx < a.length; idx++) { //n
            if (idx > lastNonZero) {
                lastNonZero = idx;
            }
            if (a[idx] == 0) {
                boolean finished = false;
                for (int j = lastNonZero + 1; j < a.length; j++) {  //1
                    if (a[j] != 0) {
                        a[idx] = a[j];
                        a[j] = 0;
                        if (j == a.length - 1) {
                            finished = true;
                        }
                        lastNonZero = j;
                        break;
                    }
                    if (j == a.length - 1) {
                        finished = true;
                    }
                }
                if (finished) {
                    break;
                }
            }

        }
    }

    private void compute3(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                swap(a, count, i);
                count = count + 1;
            }
        }
    }
}
