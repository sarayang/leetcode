package BST;

/**
 * Created by YANGSONG on 2018-10-05.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid - 1] < nums[mid]) {
                start = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int[] arr = {-1,1,2,3,1,2};
        System.out.println(f.findPeakElement(arr));
    }
}
