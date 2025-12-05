import java.util.regex.*;
public class Regex {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ca");
        Matcher m = p.matcher("rca");
        boolean res = m.matches();
        boolean resu = m.find();
        boolean result = Pattern.compile("ca").matcher("rca").matches();
        System.out.println(res);
        System.out.println(resu);
        System.out.println(p.matches("ca", "rca"));
        System.out.println(result);

    }
}
