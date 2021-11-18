import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 8, 9, 12, 12, 7, 8, 12, 4, 3, 8, 1};
        DisappearedNumbers dn = new DisappearedNumbers();
        dn.findDisappearedNumbers(new int[]{3,2,3,1,2,4,5,5,6});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num:
             nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
