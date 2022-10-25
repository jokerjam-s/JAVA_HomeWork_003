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
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        int partArraySize = arraySize / 2 - 1;
        sortPart(array, 0, partArraySize);
        sortPart(array, partArraySize + 1, array.size() - 1);

        unionParts(array, 0, array.size() - 1, partArraySize);
        return array;
    }

    public static ArrayList<Integer> sortPart(ArrayList<Integer> arrayList, int start, int end) {
        int sizePart = end - start;

        if (sizePart > 1) {     // полученная часть велика - делим дальше
            int halfSize = (end - start) / 2;
            int halfPos = start + halfSize;

            // todo: Здесь можно сделать проверку на величину полученной части массива
            //       для исключения вызова сортировки из одного элемента.
            //       Есть ? эффективности, проверка будет в каждом вызове рекурсии,
            //       вызов для единичного элемента только в определенных случаях.
            sortPart(arrayList, start, halfPos);
            sortPart(arrayList, halfPos + 1, end);

            unionParts(arrayList, start, end, halfPos);

        } else if (sizePart == 1) { // можем сравнить (имееем два элемента), если передан один - он уже отсортирован
            if (arrayList.get(start) > arrayList.get(end)) {
                swapArr(arrayList, start, end);
            }
        }
        return arrayList;
    }

    //
    private static ArrayList<Integer> unionParts(ArrayList<Integer> array, int start, int end, int half) {
        int i = start;
        int j = half + 1;

        ArrayList<Integer> tmp = new ArrayList<>();
        // объединение отсортированных частей
        while (i <= half && j <= end) {
            if (array.get(i) < array.get(j)) {
                tmp.add(array.get(i));
                i++;
            } else {
                tmp.add(array.get(j));
                j++;
            }
        }
        // дописывание "остатков", если есть - сработает только 1 из циклов
        while (i <= half) {
            tmp.add(array.get(i));
            i++;
        }
        while (j <= end) {
            tmp.add(array.get(j));
            j++;
        }
        // замена на сортированный кусок
        for (int k = 0; k < tmp.size(); k++) {
            array.set(start + k, tmp.get(k));
        }

        return array;
    }

    // обмен элементов массива
    private static ArrayList<Integer> swapArr(ArrayList<Integer> array, int firstPos, int secondPos) {
        int tmp = array.get(firstPos);
        array.set(firstPos, array.get(secondPos));
        array.set(secondPos, tmp);

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
