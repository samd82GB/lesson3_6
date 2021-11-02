package ru.gb;

import org.apache.logging.log4j.core.appender.ScriptAppenderSelector;

import java.util.Arrays;

public final class ArrayOperation {
    public static void main(String[] args) {
        int array [] = {1, 4, 2, 4, 2, 3, 4, 1, 8};
        int array2 [] = {1, 4, 4, 1, 4, 1};
        System.out.println(Arrays.toString(checkArray(array)));
        System.out.println(checkArrayFor1And4(array2));
    }
    public ArrayOperation() {
    }


    //метод, возвращающий массив с данными после последней 4-ки
    public static int [] checkArray (int [] ar){
        int last4Position = 0;
        int count4 = 0;
        for (int i =0; i< ar.length; i++) {
            if (ar [i] == 4) {
            last4Position = i;
            count4++;
            }
        }
        if (count4==0){
            throw new RuntimeException ("Нет цифры 4 в проверяемом массиве!");
        }
        int newArLength = ar.length - last4Position -1;
        int checkedArr [] = new int[newArLength];

        for (int i = 0; i<newArLength; i++) {
            int n=last4Position++;
            checkedArr [i] = ar[n+1];
        }
        return checkedArr;
    }
//метод проверки массива на содержание 1 и 4, должны быть только 1 и 4
    public static boolean checkArrayFor1And4 (int [] ar) {
        boolean checked = false;
        int count1 = 0;
        int count4 = 0;

        for (int i = 0; i < ar.length; i++) {
            switch (ar[i]) {
                case 1:
                    count1++;
                    break;
                case 4:
                    count4++;
                    break;
                default:
                    checked = false;
            }
        }
        int count = count1+count4;
        if (count1 !=0 && count4 !=0 && count== ar.length) {
            checked = true;
        }

        return checked;
    }


}
