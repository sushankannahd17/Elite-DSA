import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int flag = 0;

        for (int ch : str.toCharArray()) {
            flag |= (1 << ((int)ch - 'a'));
        }

        System.out.println((((1 << 26) - 1) == flag) ? "Yes" : "No");
    }
}