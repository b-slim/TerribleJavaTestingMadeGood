package com.tekdesign.lineutil;

import java.util.Map;

/**
 * Run the line assembler.
 * @author martinh
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, String> page = StringPageMap.assembleLine("ManyOfMe | ", 100);
        for (Integer line : page.keySet()) {
            System.out.printf("%d %s\n", line, page.get(line));
        }
    }
}
