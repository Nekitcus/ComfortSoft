package com.example.comfortsoft.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class QuickSelect {

    private final Random random = new Random();

    public int findNthSmallest(List<Integer> nums, int n) {
        if (nums.isEmpty()) throw new IllegalArgumentException("Список пустой");
        List<Integer> copy = new ArrayList<>(nums);
        return quickSelect(copy, 0, copy.size() - 1, n - 1);
    }

    private int quickSelect(List<Integer> nums, int left, int right, int n) {
        if (left == right) return nums.get(left);

        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (n == pivotIndex) return nums.get(n);
        else if (n < pivotIndex) return quickSelect(nums, left, pivotIndex - 1, n);
        else return quickSelect(nums, pivotIndex + 1, right, n);
    }

    private int partition(List<Integer> nums, int left, int right, int pivotIndex) {
        int pivotValue = nums.get(pivotIndex);
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums.get(i) < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

}
