import java.util.Scanner;

/**
 * Программа, которая запрашивает у пользователя два целых числа, а затем умножает их друг на друга без использования оператора умножения.
 *
 * @author Малякин Кирилл
 */
class CustomMLT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число для умножения: ");
        int firstMultiplier = scanner.nextInt();
        System.out.print("Введите второе число для умножения: ");
        int secondMultiplier = scanner.nextInt();
        int result; // Для точности измерения времени, создаём переменную раньше

        long resultOfCustom = System.nanoTime();
        result = multipleWithoutOperator(firstMultiplier, secondMultiplier);
        resultOfCustom = System.nanoTime() - resultOfCustom;

        System.out.println("Результаты: ");
        System.out.println("Результат умножения: " + result);
        System.out.println("Затраченное время: " + roundTo(resultOfCustom / 1000., 3) + " микросекунд");
    }


    /**
     * Умножает  два числа без использования оператора умножения
     *
     * @param a Первое число
     * @param b Второе число
     * @return Произведение числа a и числа b
     */
    private static int multipleWithoutOperator(int a, int b) {
        //Не теряем время, если у нас один из операндов == 0
        if (a == 0 || b == 0) {
            return 0;
        }
        int result = 0;
        boolean resultWillBeNegative = (a < 0) ^ (b < 0);
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i < a; i++) {
            result += b;
        }
        return resultWillBeNegative ? -result : result;
    }

    /**
     * Округляет число с плавающей точной до определённого знака после запятой
     *
     * @param input            Число, с которым необходимо провести операцию
     * @param digitsAfterPoint Количество символов после запятой
     * @return Округлённое дробное число с определённым количеством знаков после запятой
     */
    @SuppressWarnings("SameParameterValue")
    private static double roundTo(double input, int digitsAfterPoint) {
        long decimalMLT = (long) Math.pow(10, digitsAfterPoint);
        long multipliedResult = Math.round((decimalMLT * input));
        return multipliedResult / (double) decimalMLT;
    }

}
