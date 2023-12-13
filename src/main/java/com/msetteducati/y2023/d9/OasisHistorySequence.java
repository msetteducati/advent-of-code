package com.msetteducati.y2023.d9;

import lombok.AccessLevel;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder(access = AccessLevel.PRIVATE)
public class OasisHistorySequence {
    private List<List<Long>> nums;

    public long getExtrapolatedVal() {
       while (!isTerminal()) {
           var curNums = this.nums.get(this.nums.size() - 1);
           nums.add(getNextNums(curNums));
       }

       for (int i = this.nums.size() - 1; i > 0; i--) {
           long prevExtrapolatedVal = getLastVal(i) + this.getLastVal(i-1);
           this.nums.get(i-1).add(prevExtrapolatedVal);
       }

       return getLastVal(0);
    }

    public long getLastVal(int i) {
        return this.nums.get(i).get(this.nums.get(i).size() - 1);
    }

    private boolean isTerminal() {
        return nums.get(nums.size() - 1).stream()
                .allMatch(num -> num == 0);
    }

    private List<Long> getNextNums(List<Long> curNums) {
        List<Long> nextNums = new ArrayList<>();
        for (int i = 0; i < curNums.size() - 1; i++) {
            nextNums.add(curNums.get(i+1) - curNums.get(i));
        }
        return nextNums;
    }

    public static OasisHistorySequence fromInput(String input) {
        List<Long> initialNums = Stream.of(input.split(" "))
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<List<Long>> nums = new ArrayList<>();
        nums.add(initialNums);

        return OasisHistorySequence.builder()
                .nums(nums)
                .build();
    }

    public static OasisHistorySequence fromInputPart2(String input) {
        List<Long> initialNums = Stream.of(input.split(" "))
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Collections.reverse(initialNums);
        List<List<Long>> nums = new ArrayList<>();
        nums.add(initialNums);

        return OasisHistorySequence.builder()
                .nums(nums)
                .build();
    }

}
