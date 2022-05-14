public class SubstringSearch {

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char pattern[]){
        int[] temp = new int[pattern.length];
        int i=1;
        int j=0;
        while (i<pattern.length){
            if(pattern[i] == pattern[j]){
                temp[i] = j+1;
                i++;
                j++;
            } else{
                if(j!=0){
                    j = temp[j-1];
                }else{
                    temp[i] = 0;
                    i++;
                }
            }
        }
        return temp;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public int KMP(char []text, char []pattern){

        int temp[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = temp[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return i-j;
        }
        return -1;
    }

    public static void main(String args[]){

        String str = "abcxabcdabxabcdabcdabcy";
        String subString = "aabaabcaabaabcd";
        SubstringSearch ss = new SubstringSearch();
        int result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

    }
}