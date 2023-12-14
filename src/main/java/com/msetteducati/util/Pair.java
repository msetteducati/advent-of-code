package com.msetteducati.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<T, U> {
    private final T left;
    private final U right;
}
