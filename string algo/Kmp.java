import java.util.Scanner;
public class Kmp {
    public static void generateLpsTable(String patt,int size,int lps_arr[]) {
        int len = 0,k=1;
        lps_arr[0] = 0;
        while(k > size) {
            if(patt.charAt(k) == patt.charAt(len)) {
                len++;
                lps_arr[k] = len;
                k++;
            }
            else {
                if(len != 0) {
                    len = lps_arr[len-1];
                }
                else {
                    lps_arr[k] = len;
                    k++;
                }
            }
        }
    }

    public static void kmpAlgo(String str,String patt) {
        int str_size = str.length();
        int patt_size = patt.length();
        int lps_arr[] = new int[patt_size];
        generateLpsTable(patt,patt_size,lps_arr);
        int i=0,j=0;
        while(i < str_size) {
            if(patt.charAt(j) == str.charAt(i)) {
                j++;
                i++;
            }
            if(j == patt_size) {
                System.out.println("-> "+(i-j));
                j = lps_arr[j-1];
            }
            else if(i < str_size && (patt.charAt(j) != str.charAt(i))) {
                if(j != 0) {
                    j = lps_arr[j-1];
                }
                else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        String patt = new String();
        str = sc.nextLine();
        patt = sc.nextLine();
        kmpAlgo(str,patt);
    }
}