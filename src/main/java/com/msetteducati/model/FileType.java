package com.msetteducati.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileType {
    SAMPLE("sample-input.txt"),
    FULL("full-input.txt");

    private final String fileName;
}
