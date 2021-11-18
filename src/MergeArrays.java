public class MergeArrays {
    public static void main(String[] args) {
        MergeArrays ma = new MergeArrays();
        int[] nums1 = new int[]{};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        ma.merge(nums1, m, nums2, n);
    }

    public void merge(int nums1[], int m, int nums2[], int n) {
        int insertIndex = m + n - 1;
        int indexA = m - 1, indexB = n - 1;

        while (indexB >= 0) {
            if (indexA < 0) {
                nums1[insertIndex--] = nums2[indexB--];
            } else {
                if (nums2[indexB] >= nums1[indexA]) {
                    nums1[insertIndex--] = nums2[indexB--];
                } else {
                    nums1[insertIndex--] = nums1[indexA--];
                }
            }
        }
    }
}
