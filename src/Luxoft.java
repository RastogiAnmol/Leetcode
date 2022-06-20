import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Luxoft {

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Dog","Cat","Camel","Camel","Dog");

        HashMap<String, Integer> map = new HashMap<>();

        Map<String, Long> result
                = lst.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        System.out.println(result);
    }
}
