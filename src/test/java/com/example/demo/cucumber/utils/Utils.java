package com.example.demo.cucumber.utils;

import jakarta.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Utils {

    public static String getResourceFileAsString(String resourcePath) throws IOException {
        InputStream is = getResourceFileAsInputStream(resourcePath);
        if (is == null)
            throw new IllegalArgumentException("Файл " + resourcePath + " не найден");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    @Nullable
    public static InputStream getResourceFileAsInputStream(String resourcePath){
        return Utils.class.getResourceAsStream(resourcePath);
    }

}
