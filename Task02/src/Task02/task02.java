/*
    Пусть дан произвольный список целых чисел, удалить из него четные числа.

    Коичество элементов в списке запросим у пользователя, список заполним
    случайными значениями.

 */

package Task02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class task02 {
    // максимальная граница генерируемых значений
    private static final int MAX_NUM = 100;


    public static void main(String[] args) {
        clearScreen();

        Random random = new Random();
        Logger logger = Logger.getAnonymousLogger();

        int arraySize = readIntConsole("Размерность списка: ");
        ArrayList<Integer> arrayList = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            arrayList.add(random.nextInt(MAX_NUM));
        }

        logger.info(arrayList.toString());
        logger.info(deleteEven(arrayList).toString());
    }

    // удаление четных элементов
    private static ArrayList<Integer> deleteEven(ArrayList<Integer> array) {
        for (int i = array.size() - 1; i >=0 ; i--) {
            if((array.get(i) % 2) == 0){
                array.remove(i);
            }
        }
        return array;
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
