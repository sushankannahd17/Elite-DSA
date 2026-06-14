import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int flag = 0;
        for (char ch : str.toCharArray()) {
            flag ^= (1 << (int)(ch - 'a'));
        }

        System.out.println(((flag == 0) || ((flag & (flag - 1)) == 0)) ? "Yes" : "No");
    }    
}