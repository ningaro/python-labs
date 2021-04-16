package com.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите кол-во раз которые будет выполняется тестирование: ");
        int countRepeats = in.nextInt();
        System.out.print("Введите размерность исходного массива (Степень двойки): ");
        int command = in.nextInt();

        while (command != 0) {

            System.out.print("\nLoading...");

            int[][] bnSrStat = new int[countRepeats][3];
            int[][] bnTrStat = new int[countRepeats][3];
            int[][] fibStat = new int[countRepeats][3];
            int[][] intStat = new int[countRepeats][3];

            int bnSrSearch = 0;

            int bnTrSearch = 0;
            int bnTrInsert = 0;
            int bnTrDel = 0;

            int fibSearch = 0;
            int fibInsert = 0;
            int fibDel = 0;

            int intSearch = 0;
            int intInsert = 0;
            int intDel = 0;

            for (int i = 0; i < countRepeats; i++) {

                String load = String.format("\rLoading... (%d %%) ", i*100/countRepeats);

                ArrayList<Integer> arrTest = ArrayGenerator.gen(command);
                arrTest.sort(Comparator.naturalOrder());
                int searchVal = ArrayGenerator.randomSizeNotMoreArr(command);
                int insertVal = ArrayGenerator.randomSizeNotMoreArr(command);
                int delVal = ArrayGenerator.randomSizeNotMoreArr(command);
                System.out.print(load + "Массив сгенерирован и заполнен.");

                BinarySearch bnSearch = new BinarySearch();
                BinaryTree bnTree = new BinaryTree();
                Fibonacci fib = new Fibonacci();
                Interpolation inter = new Interpolation();

                bnSearch.add(arrTest);
                System.out.print(load + "Бинарный поиск от сортирован.");
                bnTree.add(arrTest);
                System.out.print(load + "Поиск в бинарном дереве прошел сортировку.");
                fib.add(arrTest);
                System.out.print(load + "Поиск фибоначи, в плане сортировки готов.");
                inter.add(arrTest);
                System.out.print(load + "Интерполяц. поиск сортировку завершил.");

                bnSrStat[i][0] = bnSearch.search(searchVal);
                System.out.print(load + "Бинарный поиск завершен.");
                bnTrStat[i][0] = bnTree.search(searchVal);
                System.out.print(load + "Поиск в бинарном дереве завершен.");
                fibStat[i][0] = fib.search(searchVal);
                System.out.print(load + "Поиск фибоначи, готов.");
                intStat[i][0] = inter.search(searchVal);
                System.out.print(load + "Интерполяц. поиск завершен.");

                bnTrStat[i][1] = bnTree.insert(insertVal);
                fibStat[i][1] = fib.insert(insertVal);
                intStat[i][1] = inter.insert(insertVal);

                bnTrStat[i][2] = bnTree.del(delVal);
                fibStat[i][2] = fib.del(delVal);
                intStat[i][2] = inter.del(delVal);

            }

            for (int[] ints : bnSrStat) {
                bnSrSearch += ints[0];
            }

            for (int[] ints : bnTrStat) {
                bnTrSearch += ints[0];
                bnTrInsert += ints[1];
                bnTrDel += ints[2];
            }

            for (int[] ints : fibStat) {
                fibSearch += ints[0];
                fibInsert += ints[1];
                fibDel += ints[2];
            }

            for (int[] ints : intStat) {
                intSearch += ints[0];
                intInsert += ints[1];
                intDel += ints[2];
            }

            System.out.printf("\rПоиск %d ms | Бинарный поиск", bnSrSearch / countRepeats);
            System.out.printf("\nПоиск %d ms | Добавление %d ms | Удаление %d ms | Бинарное дерево", bnTrSearch / countRepeats, bnTrInsert / countRepeats, bnTrDel / countRepeats);
            System.out.printf("\nПоиск %d ms | Добавление %d ms | Удаление %d ms | Фибоначи", fibSearch / countRepeats, fibInsert / countRepeats, fibDel / countRepeats);
            System.out.printf("\nПоиск %d ms | Добавление %d ms | Удаление %d ms | Интерполяционный", intSearch / countRepeats, intInsert / countRepeats, intDel / countRepeats);

            System.out.print("\n\nВведите кол-во раз которые будет выполняется тестирование: ");
            countRepeats = in.nextInt();
            System.out.print("Введите размерность исходного массива (Степень двойки): ");
            command = in.nextInt();
        }
    }

}
