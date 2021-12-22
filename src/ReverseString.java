public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.reverse("Anmol Rastogi");
    }

    private String reverse(String str) {
        if (str.isEmpty())
            return str;
        else
        {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
