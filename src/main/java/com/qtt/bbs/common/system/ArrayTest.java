package com.qtt.bbs.common.system;

import java.util.Random;

/**
 * Project name：bbsDesign
 * Class name：ArrayTest
 * description：TODO
 * date：2020/3/15 09:06
 *
 * 用C或Java或JavaScript语言写一个方法，入参为N*4的二维数组（第一列学生学号第二列数学成绩第三列物理成绩第四列化学成绩），
 * 返回值为N*5的二维数组（前四列相同，第五列为总分列），要求返回的二维数组按照总分列倒序。
 *
 * @author ：XC
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[][] arr = new String[3][4];
        arr[0][0] = "学号";
        arr[0][1] = "数学";
        arr[0][2] = "物理";
        arr[0][3] = "化学";
        convert(assignValue(arr));
        System.out.println("总和 " + getSum(arr)[0] + " " + getSum(arr)[1] + " " + getSum(arr)[2]);
    }

    /**
     * 遍历二维数组
     * @param arr
     */
    public static void convert(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 生成学号和成绩
     * @param arr
     * @return
     */
    public static String[][] assignValue(String[][] arr) {
        Random random = new Random();
        String[][] arr2 = new String[arr.length + 1][arr[0].length];
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = "202" + i;
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf((random.nextInt(100)));
            }
            System.out.println();
        }
        // System.out.println(getSum(arr)[0]);
        // System.out.println(Arrays.toString(getSum(arr)));
        return arr;
    }

    /**
     * 求和 排序
     * @param arr
     * @return
     */
    public static int[] getSum(String[][] arr) {
        int[] sum = new int[arr[0].length];
        for(int i = 1; i < sum.length; i++){
            for(int j = 1; j <arr.length; j++){
                sum[i] += Integer.parseInt(arr[j][i]);
            }
        }
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[i] < sum[j]) {
                    int temp = sum[i];
                    sum[i] = sum[j];
                    sum[j] = temp;
                }
            }
        }
        return sum;
    }
}
