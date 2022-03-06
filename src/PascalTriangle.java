import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair
{
    int first, second;

    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (!(obj instanceof Pair))
            return false;
        if (obj == this)
            return true;

        return (this.first == ((Pair)obj).first) &&
                (this.second == ((Pair)obj).second);
    }

    @Override
    public int hashCode()
    {
        return this.first + this.second;
    }
}
public class PascalTriangle {
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Pair, Integer> map = new HashMap<>();
    private int getNumber(int row, int col){
        if(map.containsKey(new Pair(row,col))){
            return map.get(new Pair(row,col));
        }
        if(row==0 || col==0 || row==col){
            return 1;
        }
        return getNumber(row-1, col-1) + getNumber(row-1, col);
    }
    public List<List<Integer>> generate(int numRows) {
        for(int row=0; row<numRows; row++){
            List<Integer> temp = new ArrayList<>();
            for(int col=0; col<=row; col++){
                int value = getNumber(row, col);
                temp.add(value);
                map.put(new Pair(row, col), value);
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        var result = pt.generate(5);
    }
}