import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Code bawaan java yang berfungsi untuk scanner nilai dari apa yang kita masukan
        Scanner sc = new Scanner(System.in);

        // Code bawaan java yang berfungsi untuk menampilkan output dari apa yang kita ingin tampilkan
        System.out.println("Masukan nilai string: ");

        // Code bawaan java nextLine () untuk membaca input termasuk spasi di antara kata-kata (yaitu, ia membaca hingga akhir baris\n).
        String str = sc.nextLine();

        // Code logic untuk proses sorting berdasarkan urutan huruf a-z
        char charArray[] = str.toCharArray();
        Arrays.sort(charArray);

        // Perintah untuk menampilkan output hasil dari code program
        System.out.println(new String(charArray));
    }
}