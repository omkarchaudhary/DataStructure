package datastructure;



/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int nums3[] = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            } else {
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<n) {
            nums3[k] =nums1[i];
            i++;
            k++;
        }
        while(j<m) {
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        if((n+m)%2!=0) {
            int mid = (n+m)/2;
            return nums3[mid];
        } else {
            int x = (n+m)/2;
            double p = nums3[x];
            double q = nums3[x-1];
            return (p+q)/2;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3};
        int arr2[] = {2, 7};

        double median = findMedianSortedArrays(arr1, arr2);
        System.out.println(median);

        int n = arr1.length;
        int m = arr2.length;
        System.out.println(getMedian(arr1, arr2, n, m));
    }

    static double getMedian(int A[], int B[],
                            int n, int m) {
        int i = 0;
        int j = 0;
        int count;
        double m1 = -1, m2 = -1;

        if ((m + n) % 2 == 1) {
            for (count = 0; count <= (n + m) / 2; count++) {
                if (i != n && j != m) {
                    m1 = (A[i] > B[j]) ? B[j++] : A[i++];
                } else if (i < n) {
                    m1 = A[i++];
                } else {
                    m1 = B[j++];
                }
            }
            return m1;
        } else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (A[i] > B[j]) ? B[j++] : A[i++];
                } else if (i < n) {
                    m1 = A[i++];
                } else {
                    m1 = B[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
