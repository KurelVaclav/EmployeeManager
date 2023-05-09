package com.employeemanager.utils;

import java.util.UUID;

public class UUIDGenerator {
    private static long lastTimestamp = 0L;
    private static int counter = 0;

    public static synchronized UUID getNextUUID() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp == lastTimestamp) {
            counter++;
        } else {
            counter = 0;
            lastTimestamp = currentTimestamp;
        }
        byte[] inputBytes = (currentTimestamp + ":" + counter).getBytes();
        return UUID.nameUUIDFromBytes(inputBytes);
    }
}
