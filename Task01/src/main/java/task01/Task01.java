/*
    Реализовать алгоритм сортировки слиянием

    Основная идея — разделение неотсортированного массива на две части и сортировка
    отдельных половинок по рекурсивному принципу.

    Исходный массив заздадим при помощи генерации, количесво элементов
    запрашиваем у пользователя.
 */

package task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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


        mergeSort();

    }

    // алгоритм сортировки
    public static void mergeSort(ArrayList<int> array){
        int partArraySize = arraySize / 2;
        sortPart(array, 0, partArraySize);
        sortPart(array, partArraySize+1, array.length-1);

    }

    public static void sortPart(ArrayList<int> arrayList, int start, int end){

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
