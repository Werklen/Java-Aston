import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign(int a, int b) {
        String result = a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(result);
    }

    public static void printColor(int value) {
        if (value < 1) {
            System.out.println("Красный");
        } else if (value < 101) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(int a, int b) {
        String result = (a >= b) ? "a >= b" : "a < b";
        System.out.println(result);
    }

    public static boolean sumOfTwo(int a, int b) {
        return a + b > 9 & a + b < 21;
    }

    public static void positiveOrNotPrint(int a) {
        String result = (a >= 0) ? "Положительное" : "Отрицательное";
        System.out.println(result);
    }

    public static boolean positiveOrNot(int a) {
        return a >= 0;
    }

    public static void printStringN(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static boolean yearOrNot(int year) {
        return (year % 4 == 0 & year % 100 != 0) || (year % 4 == 0 & year % 400 == 0) ? true : false;
    }

    public static int[] changeArray01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
        return array;
    }

    public static int[] fillArray100() {
        int[] a = IntStream.rangeClosed(1, 100).toArray();
        return a;
    }

    public static int[] multiplyTo2Array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
        return array;
    }

    public static int[][] fillDiagonalArray(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][i] = 1;
            a[i][n - i - 1] = 1;
        }
        return a;
    }

    public static int[] createArray(int len, int initialValue) {
        int[] a = new int[len];
        Arrays.fill(a, initialValue);
        return a;
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(8, 9);
        printColor(1);
        compareNumbers(2, 1);
        System.out.println(sumOfTwo(-1, 10));
        positiveOrNotPrint(-8);
        System.out.println(positiveOrNot(-8));
        printStringN("aaa", 3);
        System.out.println(Arrays.toString(createArray(5, 1)));
        int[] a = {1, 2, 3, 4, 7};
        System.out.println(Arrays.toString(multiplyTo2Array(a)));
        System.out.println(Arrays.toString(fillArray100()));
        System.out.println(yearOrNot(1975));
        int[] a1 = {0, 1, 0, 1, 0};
        System.out.println(Arrays.toString(changeArray01(a1)));
        System.out.println();
        for (int[] i : fillDiagonalArray(5)) {
            System.out.println(Arrays.toString(i));
        }

    }
}
