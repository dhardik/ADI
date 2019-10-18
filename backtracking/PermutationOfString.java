import java.util.Scanner;
public class PermutationOfString {
    public static void printPermutations(String str,String temp) {
        if(temp.length() == str.length()) {
            System.out.println(temp);
            return;
        }
        else {
            for(int i=0;i<str.length();i++) {
                printPermutations(str,temp+String.valueOf(str.charAt(i)));
                // System.out.println(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPermutations(str,"");
    }
}