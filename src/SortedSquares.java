public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares qs = new SortedSquares();
        qs.sortedSquares(new int[]{-3, -2, -1, 4, 5, 6});
    }
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;
        for (int i = result.length-1; i >=0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[i] = nums[right] * nums[right];
                right--;
            }else{
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
