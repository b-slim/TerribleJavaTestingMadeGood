package com.tekdesign.lineutil;

import java.util.HashMap;
import java.util.Map;

/**
 * Provide string building methods.
 *
 * @author martinh
 */
public class StringPageMap {

    static int FIXED_PAGE_WIDTH = 42;

    public static Map<Integer, String> assembleLine(String item, int numItems) {
        Map<Integer, String> pageMap = new HashMap<Integer, String>();
        final int maxLineWidth = FIXED_PAGE_WIDTH + item.length();

        int lineNumber = 0;
        StringBuilder sb = new StringBuilder(maxLineWidth);
        for (int i = 0; i < numItems; i++) {
            sb.append(item);
            if (sb.length() > FIXED_PAGE_WIDTH) {
                pageMap.put(++lineNumber, sb.toString());
                sb.delete(0, sb.length());
            }
        }


        return pageMap;
    }

    public static int numLinesOnPage(Map page) {
        return page.size();
    }

}
