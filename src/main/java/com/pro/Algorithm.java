package com.pro;

import org.junit.Test;

import java.util.*;

@SuppressWarnings("all")
public class Algorithm {

    @Test
    public void test() {

    }

    public static void main(String[] args) {
       method7(34264);
    }

    /**
     * 递归求阶乘
     */
    public static int method1(int num) {
        if (num == 0 || num == 1) {
            return num;
        } else {
            return num * method1(num - 1);
        }
    }

    /**
     * 编写一个程序，有1，2,3,4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     *
     * @param nums
     * @return
     */
    public static Set<Integer> method2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        int num = nums[i] * 100 + nums[j] * 10 + nums[k];
                        set.add(num);
                    }
                }
            }
        }
        return set;
    }

    /**
     * 639172每个位数上的数字都是不同的，且平方后所得数字的所有位数都不会出现组成它自身的数字。（
     * 639172*639172=408540845584），类似于639172这样的6位数还有几个？分别是什么？
     *
     * @return
     */
    public static List<Long> method3() {
        List<Long> list = new ArrayList<>();
        Set<Integer> setBefore = null;
        Set<Integer> setAfter = null;
        String numStr = "";

        for (long i = 100000; i < 1000000; i++) {
            String num = String.valueOf(i);
            setBefore = new HashSet<>();
            for (int j = 0; j < num.length(); j++) {
                if (j == num.length() - 1) {
                    setBefore.add(Integer.parseInt(num.substring(j)));
                } else {
                    setBefore.add(Integer.parseInt(num.substring(j, j + 1)));
                }
            }
            if (setBefore.size() == 6) {
                long numSquare = (long) i * (long) i;
                String numSquareStr = String.valueOf(numSquare);
                setAfter = new HashSet<>();
                for (int k = 0; k < numSquareStr.length(); k++) {
                    if (k == numSquareStr.length() - 1) {
                        setAfter.add(Integer.parseInt(numSquareStr.substring(k)));
                    } else {
                        setAfter.add(Integer.parseInt(numSquareStr.substring(k, k + 1)));
                    }
                }
                int totalSize = setAfter.size() + setBefore.size();
                for (int n : setAfter) {
                    setBefore.add(n);
                }
                if (setBefore.size() == totalSize) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    /**
     * 数据分拣
     */
    public static void method4(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        System.out.println(map);
    }

    /**
     * 斐波那契数列
     */
    public static void method5() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int arr[] = new int[length];
        arr[0] = 1;
        if (length > 1) {
            arr[1] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 求素数(1~100)
     */
    public static void method6() {
        for (int i = 1; i < 101; i++) {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = !flag;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 因式分解
     */
    public static void method7(int num) {
            boolean flag = false;
            int index = 0;
            for (int i = 2; i < num; i++) {
                index++;
                if (index == num - 2) {
                    System.out.println(i + 1);
                }
                if (num % i == 0) {
                    flag = !flag;
                    System.out.println(i);
                    method7(num / i);
                }
                if (flag) {
                    return;
                }
            }
    }
}
