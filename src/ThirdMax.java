import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 8, 9, 12, 12, 7, 8, 12, 4, 3, 8, 1};
        ThirdMax tm = new ThirdMax();
        int max = tm.thirdMax(nums);

        int max1 = tm.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        Set<Integer> maximums = new HashSet<>();
        for (int i:nums
        ) {
            maximums.add(i);
            if(maximums.size() > k){
                maximums.remove(Collections.min(maximums));
            }
        }
        return Collections.min(maximums);
    }
    public int thirdMax(int[] nums) {
        Set<Integer> maximums = new HashSet<>();
        for (int i:nums
             ) {
            maximums.add(i);
            if(maximums.size() > 3){
                maximums.remove(Collections.min(maximums));
            }
        }
        if(maximums.size() == 3){
            return Collections.min(maximums);
        }
        return Collections.max(maximums);
    }
}
