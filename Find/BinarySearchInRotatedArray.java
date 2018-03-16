
/**
 * LeetCode 33;
 * 剑指Offer 11题【变式】
 * 在一个数组中，分两组递增(旋转数组)，在此数组中找到指定的值，返回其下标；若不存在，返回-1；
 * 
 * 思路：递归使用二分查找
 */
public class BinarySearchInRotatedArray {
    public static int find(int[] a, int x) {
        if(a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length;
        while(low <= high) {
            int mid = ((high - low) >> 1) + low;
            if(a[mid] == x) {
                return mid;
            }
            if(a[low] <= a[mid]) {
                if(x >= a[low] && x< a[mid]) {
                    high = mid -1;
                }else {
                    low = mid + 1;
                }
            }else {
                if(x > a[mid] && x <= a[high]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int result = find(a, 3);
        System.out.println(result);
    }
}