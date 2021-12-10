package text1;
//冒泡排序的演示
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args){
        int[] array;
        array = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入5个元素");
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int T = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = T;
                }
            }
        }

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "\t");
        }


    }
}
