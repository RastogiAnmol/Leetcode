import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static int slotWheels(List<String> history) {
        int currentIndex;
        int sum=0;
        int[][] historyCollection = new int[history.size()][];
        for(int i=0; i< history.size(); i++){
            StringBuilder str = new StringBuilder(history.get(i));
            int[] sortedArray = new int[str.length()];
            for(int j=0; j<history.get(i).length(); j++){
                sortedArray[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            Arrays.sort(sortedArray);
            historyCollection[i] = sortedArray;
        }
        currentIndex = historyCollection[0].length-1;
        for(int i=0; i< historyCollection.length; i++){
            int currentMax = historyCollection[0][currentIndex];
            for(int j=0; j<historyCollection[0].length; j++){
                if(currentMax < historyCollection[j][currentIndex]){
                    currentMax = historyCollection[j][currentIndex];
                }
            }
            sum+= currentMax;
            currentIndex--;
        }
        return sum;
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] abc = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] abc = new int[]{1, 1, 4, 5, 5, 2};
        solution.nextPermutation(abc);
        System.out.println(abc);
    }
}