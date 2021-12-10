package test2;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 2;//循环数字
        int i;
        int sum = 0;
        while (num <= 100) {//数字范围为2-100
            for (i = 2; i < num; i++) {
                if (num % i == 0) {//当从2开始，一个数能被除尽，便不是质数
                    break;
                }

            }
            if (num == i) {//如果这个数为质数，那么i==他本身。
                System.out.print(num+ " ");
                sum += num;
            }
            num++;
        }
        System.out.println("总和为：" + sum);
    }
}
