package com.bruno13palhano;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Utils {
    public static List<String> stringToList(String type) {
        if (type == null || type.isEmpty()) {
            return List.of();
        } else {
            try {
                return Arrays.stream(type.split(",")).toList();
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
                return List.of();
            }
        }
    }
}
