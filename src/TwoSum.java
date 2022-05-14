import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0){
            return new int[2];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[2];
    }
}
