package BST;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-10-05.
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays_Om_n(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0) {
            return computeMedian(nums2);
        }
        if (nums2.length == 0) {
            return computeMedian(nums1);
        }
        int[] merged = new int[nums1.length + nums2.length];

        //src - the source array.
//srcPos - starting position in the source array.
//dest - the destination array.
//destPos - starting position in the destination data.
//length - the number of array elements to be copied.
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        System.out.println(Arrays.toString(merged));
        quicksort(merged, 0, merged.length - 1);
        // Arrays.sort(merged);
        System.out.println(Arrays.toString(merged));
        return computeMedian(merged);
    }
    private void quicksort(int[] array, int start, int end) {
        if (array.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }

            while (left <= right && array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        quicksort(array, start, right);
        quicksort(array, left, end);
    }
    private double computeMedian(int[] arr) {
        int len = arr.length;
        if (len % 2 == 0) {
            int mid1 = len / 2;
            int mid2 = mid1 - 1;
            double res = (arr[mid1] + arr[mid2]) / 2.0;
            return res;
        } else {
            return arr[len / 2];
        }
    }

    private double findMedianViaBST(int[] n1, int[] n2) {
        if (n1.length > n2.length) {
            return findMedianViaBST(n2, n1);
        }
        int len1 = n1.length;
        int len2 = n2.length;

        int start = 0;
        int end = len1;


        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = (len1 + len2 + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : n1[partitionX - 1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : n1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : n2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : n2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // len1 + len2 is even number
                if ((len1 + len2) % 2 == 0) {
                    // easy way to remember it is max two on the left side
                    int max = Math.max(maxLeftX, maxLeftY);
                    // min two on the right side
                    int min = Math.min(minRightY, minRightX);
                    double avg = (max + min) / 2.0;
                    return avg;
                    // len1 + len2 is odd number
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
        int[] n1 = {1,3,8,9,15};
        int[] n2 = {7,11,19,21,18,25};
        double res = m.findMedianViaBST(n1, n2);
        System.out.println(res);
    }


}
