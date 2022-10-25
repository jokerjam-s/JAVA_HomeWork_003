/*
    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

    Коичество элементов в списке запросим у пользователя, список заполним
    случайными значениями.
 */

package Task03;

import java.util.*;
import java.util.logging.Logger;

public class task03 {
    // максимальная граница генерируемых значений
    private static final int MAX_NUM = 100;

    public static void main(String[] args) {
        clearScreen();

        Random random = new Random();

        // генерация, заполнение
        int arraySize = readIntConsole("Размерность списка: ");
        ArrayList<Integer> arrayList = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            arrayList.add(random.nextInt(MAX_NUM));
        }

        // расчеты
        int minVal = Collections.min(arrayList);
        int maxVal = Collections.max(arrayList);
        float avgVal = (float) (arrayList.stream().mapToDouble(Integer::floatValue).sum() / arrayList.size());

        // вывод, логирование
        Logger logger = Logger.getAnonymousLogger();
        logger.info(arrayList.toString());

        logger.info("Макс. значение  : " + maxVal);
        logger.info("Мин. значение   : " + minVal);
        logger.info("Среднее значение: " + avgVal);
    }


    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение целочисленного значения с консоли
    public static int readIntConsole(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

}
