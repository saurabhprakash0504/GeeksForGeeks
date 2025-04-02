package com.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DummyClass {

    public static void main(String[] args) {

        String[][] string = {{"A", "B", "C"}, {"A", "D", "E"}, {"C", "D", "P"}};

        System.out.println(Arrays.stream(string).flatMap(Stream::of).filter(x -> x == "A").collect(Collectors.toList()));

        HashMap<String, List<String>> map = new HashMap<>();

        for (String[] s : string) {

            if(map.containsKey(s[0])){
                List<String> list = map.get(s[0]);
                list.add(s[1]);
                map.put(s[0], list);
            }else {

                ArrayList<String> list = new ArrayList<>();
                list.add(s[1]);
                map.put(s[0], list);
            }

        }

        System.out.println(Collections.singletonList(map));

    }

}
