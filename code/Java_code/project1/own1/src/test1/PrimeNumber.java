package text1;
//输入元数找出素数
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int[] num;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要筛选的元素的个数");
        n = sc.nextInt();
        num = new int [n];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < num.length; i++) {
            int j;
            for (j = 2; j < num[i]; j++) {
                if (num[i] % j == 0){
                    break;

                }
                System.out.print(num[i] + "\t");
                break;
            }

        }

    }
}
