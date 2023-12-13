package com.msetteducati.y2023.d9;

import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public class OasisReport {
    private List<OasisHistorySequence> sequences;

    public long getExtrapolatedValuesSum() {
        return sequences.stream()
                .map(OasisHistorySequence::getExtrapolatedVal)
                .mapToLong(Long::longValue)
                .sum();
    }


    public static OasisReport fromInput(List<String> input) {
        List<OasisHistorySequence> sequences = input.stream()
                .map(OasisHistorySequence::fromInput)
                .collect(Collectors.toList());

        return OasisReport.builder()
                .sequences(sequences)
                .build();
    }


    public static OasisReport fromInputPart2(List<String> input) {
        List<OasisHistorySequence> sequences = input.stream()
                .map(OasisHistorySequence::fromInputPart2)
                .collect(Collectors.toList());

        return OasisReport.builder()
                .sequences(sequences)
                .build();
    }
}
