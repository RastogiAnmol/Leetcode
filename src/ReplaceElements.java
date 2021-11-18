public class ReplaceElements {
    public static void main(String[] args) {
        int[] nums = new int[]{17, 18, 5, 4, 6, 1};
        ReplaceElements re = new ReplaceElements();
        re.replaceElements(nums);
    }

    public int[] replaceElements(int[] arr) {
        int n = arr.length, temp = 0;
        int max = arr[n-1];
        arr[n-1] = -1;
        for(int i = n-2; i>=0; i--){
            temp = arr[i];
            arr[i] = max;
            if(max < temp){
                max = temp;
            }
        }
        return arr;
    }
}
