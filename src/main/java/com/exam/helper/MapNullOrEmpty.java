package com.exam.helper;

import java.util.Map;

public class MapNullOrEmpty {
    private static boolean isNullOrEmptyMap(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isNotNullOrEmptyMap(Map<?, ?> map) {
        return isNullOrEmptyMap(map);
    }
}
