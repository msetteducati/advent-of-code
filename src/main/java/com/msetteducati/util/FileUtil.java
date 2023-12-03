package com.msetteducati.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FileUtil {

    public BufferedReader getBufferedReader(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + fileName);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.defaultCharset());
        return new BufferedReader(inputStreamReader);
    }

    @SneakyThrows
    public List<String> getLines(BufferedReader reader) {
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            lines.add(line);
        }
        return lines;
    }

    @SneakyThrows
    public List<String> getLines(String fileName) {
        BufferedReader reader = getBufferedReader(fileName);
        return getLines(reader);
    }
}
