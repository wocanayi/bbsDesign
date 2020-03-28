package com.qtt.bbs.common.system;

import java.util.Random;

/**
 * Project name：bbsDesign
 * Class name：ArrayTest2
 * description：TODO
 * date：2020/3/15 10:44
 *
 * @author ：XC
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int[][] arr = new int[5][4];
       forEach(assignValue(arr));
    }

    /**
     * 遍历二维数组
     *
     * @param arr
     */
    public static void forEach(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给学生的学号和成绩赋值
     *
     * @param arr
     * @return
     */
    public static int[][] assignValue(int[][] arr) {
        int[][] arr2 = new int[arr.length][arr[0].length + 1];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 2020 + i;
            arr2[i][0] = arr[i][0];
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = random.nextInt(100);
                arr2[i][j] = arr[i][j];
            }
        }

        // 求和
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 2; j < arr2[0].length; j++) {
                arr2[i][arr2[0].length - 1] += arr[i][j - 1];
            }
        }

        // 排序
        for (int i = 0; i < arr2.length - 1; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i][arr2[0].length - 1] < arr2[j][arr2[0].length - 1]) {
                    int[] row = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = row;
                }
            }
        }
        return arr2;
    }
}
