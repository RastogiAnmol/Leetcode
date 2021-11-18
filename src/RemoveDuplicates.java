public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 1};
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.validMountainArray(nums);
    }
    public boolean validMountainArray(int[] arr) {
        int length = arr.length, valleyCount=0;
        if(length < 3){
            return false;
        }
        for(int i=1; i<length-1; i++){
            if(arr[i] <= arr[i-1] || arr[i] <= arr[i+1]){
                return false;
            }
            valleyCount+=1;
        }
        return true;
    }
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[prev]) {
                nums[++prev] = nums[i];
            }
        }
        return ++prev;
    }
}
