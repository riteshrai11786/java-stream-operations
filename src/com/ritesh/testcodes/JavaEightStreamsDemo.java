
package com.ritesh.testcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaEightStreamsDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "google.com");
        map.put(2, "apple.com");

        String result = "";
        for (Map.Entry<Integer, String> entrySet : map.entrySet()) {
            if("google.com".equals(entrySet.getValue())) {
                result = result.concat(entrySet.getValue());
            }
        }

        System.out.println(result);

        java8Way();
    }

    private static void java8Way() {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        String results = "";
        for (Map.Entry<Integer, String> entrySet : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entrySet.getValue())) {
                results = entrySet.getValue();
            }
        }

        System.out.println("Before Java 8 : " + results);

        //Map -> Stream -> Filters -> String
        results = HOSTING.entrySet().stream()
                .filter(map -> "aws.amazon.com".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("Before Java 8 : " + results);

        // filter more values

        results = HOSTING.entrySet().stream()
                .filter(x -> {
                    if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
                        return true;
                    }
                    return false;
                })
                .map(map -> map.getValue())
                .collect(Collectors.joining(","));

        System.out.println("With Java 8 : " + results);

    }
}
