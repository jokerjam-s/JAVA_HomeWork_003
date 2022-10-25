/*
    Реализовать алгоритм сортировки слиянием

    Основная идея — разделение неотсортированного массива на две части и сортировка
    отдельных половинок по рекурсивному принципу.

    Исходный массив заздадим при помощи генерации, количесво элементов
    запрашиваем у пользователя.
 */

package task01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task01 {
    // максимальная граница генерируемых значений
    private static final int MAX_NUM = 100;
    private static int arraySize;

    public static void main(String[] args) {
        clearScreen();

        arraySize = readIntConsole("Размерноость массива: ");
        ArrayList<Integer> array = new ArrayList<>(arraySize);
        Random random = new Random();

        // формирование массива
        for (int i = 0; i < arraySize; i++) {
            array.add(random.nextInt(MAX_NUM));
        }

        Logger logger = Logger.getAnonymousLogger();
        logger.info(array.toString());
        logger.info(mergeSort(array).toString());
    }

    // алгоритм сортировки
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array){
        int partArraySize = arraySize / 2 - 1;
        array = sortPart(array, 0, partArraySize);
        array = sortPart(array, partArraySize+1, array.size()-1);

        return array;
    }

    public static ArrayList<Integer> sortPart(ArrayList<Integer> arrayList, int start, int end){
        Logger logger = Logger.getAnonymousLogger();
        int sizePart = end - start;

        if(sizePart > 1){
            // вызвать разделение
            int halfSize = (end - start + 1) / 2;
            arrayList = sortPart(arrayList, start, start + halfSize);
            arrayList = sortPart(arrayList, start + halfSize+1, end);
        }else if (sizePart == 1) {
            if (arrayList.get(start) > arrayList.get(end)) {
                int tmp = arrayList.get(start);
                arrayList.set(start, arrayList.get(end));
                arrayList.set(end, tmp);
                logger.info(arrayList.toString());
            }
        }
        return arrayList;
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение целочисленного значения с консоли
    public static int readIntConsole(String message){
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
