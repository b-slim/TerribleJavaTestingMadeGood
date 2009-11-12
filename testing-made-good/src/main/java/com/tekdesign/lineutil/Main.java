package com.tekdesign.lineutil;

import java.util.Map;

/**
 * Run the line assembler.
 * @author martinh
 */
public class Main {

    public static void main(String[] args) {
        SimplePage pageMap = SimplePage.newInstance("ManyOfMe | ", 100);
        Map<Integer, String> page = pageMap.getMap();
        for (Integer line : page.keySet()) {
            System.out.printf("%d %s\n", line, page.get(line));
        }
    }
}
