/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 桶排序
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 *
 * @author gavin
 * @version $Id: BucketSort.java, v 1.0 2022年04月19日 6:45 PM apple copyright $
 */
public class BucketSort {
    public static void main(String[] args) {
        BucketSort main = new BucketSort();
        int[] array = new int[] {4,6,1,9,3,2};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] nums) {

    }
}
