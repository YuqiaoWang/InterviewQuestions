
/**
 * 在一个数组中，分两组递增，在此数组中找到指定的值，返回其下标；若不存在，返回-1；
 * 
 * 思路：递归使用二分查找
 */

public class FindIndexInDoubleIncreaseArray {
    public static int find(int[] a, int x) {
        if(a == null || a.length == 0) {
            return -1;
        }
        return findCore(a, 0, a.length - 1, x);
    }

    public static int findCore(int[] a, int start, int end, int x) {
        if(a == null || a.length == 0) {
            return -1;
        }
        if(start > end) {
            return -1;
        }
        int mid = ((end - start) >> 1) + start;
        if(a[mid] == x) {
            return mid;
        }
        if(a[mid] < x && x < a[end]) {
            return binarySearch(a, mid + 1, end, x);
        }else if(a[start] < x && x < a[mid]) {
            return binarySearch(a, start, mid - 1, x);
        }else {
            int right = findCore(a, mid + 1, end ,x);
            int left = findCore(a, start, mid -1, x);
            if(right == -1) {
                return left;
            }
            if(left == -1) {
                return right;
            }
        }
        return -1;

    }

    public static int binarySearch(int[] a, int start, int end, int x) {
        int mid = ((end - start) >> 1) + start;
        if(start > end) {
            return -1;
        }

        if(a[mid] == x) {
            return mid;
        }
        if(a[mid] > x) {
            return binarySearch(a, start, mid - 1, x);
        }
        if(a[mid] < x) {
            return binarySearch(a, mid + 1, end, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,6,8,9,3,4,7};
        int result = find(a, 3);
        System.out.println(result);
    }
}