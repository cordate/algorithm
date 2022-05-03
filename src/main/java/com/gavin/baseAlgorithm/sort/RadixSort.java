/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
 * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
 * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 * @author gavin
 * @version $Id: RadixSort.java, v 1.0 2022年04月19日 6:56 PM apple copyright $
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort main = new RadixSort();
        int[] array = new int[] {4,6,1,9,3,2};
        main.radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void radixSort(int[] array) {

    }
}
