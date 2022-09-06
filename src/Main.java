import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //task 1
        checkLeapYear(2016);
        //task 2
        clientDevice(1, 2022);
        //task 3
        System.out.printf("Время доставки - %d дней\n", countDeliveryTime(95));
        //task 4
        int[] digits = {3, 2, 1, 6, 5};
        reverseArray(digits);
        System.out.println(Arrays.toString(digits));
        //task 5
        repeatedChars("abcddefghijkk");
        //task 6
        System.out.printf("Средняя выплата - %.2f рублей\n", averageSpend(randomArray(30)));
    }

    public static void checkLeapYear(int year){
        System.out.println((year % 100 != 0 && year % 4 == 0) || year % 400 == 0 ? year + " високосный" : year + " не високосный");
    }

    public static void clientDevice(int clientOS, int clientDeviceYear){
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 1) {
            if (clientDeviceYear == currentYear) {
                System.out.println("Установите версию приложения для Android по ссылке");
            } else {
                System.out.println("Установите lite версию приложения для Android по ссылке");
            }
        } else if (clientOS == 0) {
            if (clientDeviceYear == currentYear) {
                System.out.println("Установите версию приложения для iOS по ссылке");
            } else {
                System.out.println("Установите lite версию приложения для iOS по ссылке");
            }
        } else {
            System.out.println("Ваша ОС не поддерживается");
        }
    }

    public static int countDeliveryTime(int deliveryDistance){
        int deliveryTime;
        if(deliveryDistance > 100 || deliveryDistance < 0){
            throw new RuntimeException("Вне зоны доставки");
        }
        if (deliveryDistance <= 20){
            deliveryTime = 1;
        } else if (deliveryDistance <= 60){
            deliveryTime = 2;
        } else {
            deliveryTime = 3;
        }
        return deliveryTime;
    }

    public static void reverseArray(int[] array){
        int buff;
        for (int i = 0; i < array.length / 2; i++) {
            buff = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buff;
        }
    }

    public static void repeatedChars(String text){
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; i ++) {
            if(chars[i] == chars[i+1]){
                System.out.printf("В строке дублируется символ [%s]\n", chars[i]);
                return;
            }
        }
        System.out.println("В строке нет дублирующихся символов");
    }

    public static int summarySpend(int[] spends){
        int sum = 0;
        for (int spend : spends) {
           sum += spend;
        }
        return sum;
    }

    public static double averageSpend(int[] spends){
        return (double) summarySpend(spends) / spends.length;
    }

    public static int[] randomArray(int length){
        int[] randomArr = new int[length];
        Random random = new Random();
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = random.nextInt(100000) + 100000;
        }
        return randomArr;
    }
}