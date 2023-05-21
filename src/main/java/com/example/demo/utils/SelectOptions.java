package com.example.demo.utils;

import java.time.Duration;
import java.time.ZoneId;
import java.util.Set;

public class SelectOptions {




    public static final int[] CBValues = {0, 20, 40, 60, 80};


    public static String[] zoneIds() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        String[] formattedOffsets = new String[zoneIds.size()];
        int index = 0;

        for (String zoneId : zoneIds) {
            ZoneId id = ZoneId.of(zoneId);
            Duration offset = Duration.ofSeconds(id.getRules().getOffset(java.time.Instant.now()).getTotalSeconds());
            String formattedOffset = formatOffset(offset);
            formattedOffsets[index] = formattedOffset;
            index++;
        }

        return formattedOffsets;
    }
    private static String formatOffset(Duration offset) {
        boolean isNegative = offset.isNegative();
        offset = offset.abs();

        long hours = offset.toHours();
        long minutes = offset.toMinutesPart();

        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);

        return (isNegative ? "-" : "+") + formattedHours + ":" + formattedMinutes;
    }

}
