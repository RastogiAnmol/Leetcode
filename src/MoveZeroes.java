public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[]{3,1,2,4});
    }

    public void moveZeroes(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] % 2 != 0) {
                f++;
                continue;
            }
            swap(nums, s, f);
            s++;
            f++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
