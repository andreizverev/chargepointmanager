package com.homecorp.chargepointmanager.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class StringToDateTimeConverter {
    private static final Pattern NUMBER = Pattern.compile("\\d+");

    /*
        Datetime must be specified in at most two parts split by empty spaces.
        It's allowed to omit the whole time part or the date and time parts partly.
        The year is mandatory.
     */
    public static LocalDateTime convert(String str) {
        checkNotNull(str, "input must be not null");
        checkArgument(!"".equals(str.trim()), "input must be not empty");
        String[] parts = str.split("\\s+");
        if (parts.length > 2) {
            throw new IllegalArgumentException("More then 2 parts are specified by empty space.");
        }

        List<Integer> dateParts = parse(parts[0]);
        while (dateParts.size() < 3) {
            dateParts.add(1);
        }
        List<Integer> timeParts;
        if (parts.length == 1) {
            timeParts = List.of(0, 0, 0);
        } else {
            timeParts = parse(parts[1]);
        }
        while (timeParts.size() < 3) {
            timeParts.add(0);
        }
        return LocalDateTime.of(
                dateParts.get(0), dateParts.get(1), dateParts.get(2),
                timeParts.get(0), timeParts.get(1), timeParts.get(2));
    }

    private static List<Integer> parse(String part) {
        Matcher dateMatcher = NUMBER.matcher(part);
        List<Integer> parts = new ArrayList<>();
        while (dateMatcher.find()) {
            parts.add(Integer.valueOf(dateMatcher.group()));
        }
        if (parts.size() == 0) {
            checkArgument(dateMatcher.find(), "No numbers provided.");
        }
        return parts;
    }
}
