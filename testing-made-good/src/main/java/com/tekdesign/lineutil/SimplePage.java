package com.tekdesign.lineutil;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple page object.
 *
 * @author martinh
 */
public class SimplePage {

    final static int FIXED_PAGE_WIDTH = 42;
    private ImmutableMap<Integer, String> simplePage;

    private SimplePage() {
    }

    private SimplePage(String item, int numItems) {
        this.simplePage = assemblePage(item, numItems);
    }

    public static SimplePage newInstance(String item, int numItems) {
        return new SimplePage(item, numItems);
    }

    public Map<Integer, String> getMap() {
        return this.simplePage;
    }

    public Set<Integer> getKeySet() {
        return this.simplePage.keySet();
    }

    public void addLines(Map<Integer, String> expectedLines) {
        Map<Integer,String> page = Maps.newHashMap(this.simplePage);
        page.putAll(expectedLines);
        simplePage = ImmutableMap.copyOf(page);
    }

    private ImmutableMap<Integer, String> assemblePage(String item, int numItems) {

        final int maxLineWidth = FIXED_PAGE_WIDTH + item.length();

        int lineNumber = 0;
        StringBuilder sb = new StringBuilder(maxLineWidth);
        ImmutableMap.Builder<Integer, String> iMapBuilder = ImmutableMap.builder();

        for (int i = 0; i < numItems; i++) {
            sb.append(item);
            if (sb.length() > FIXED_PAGE_WIDTH) {
                iMapBuilder.put(++lineNumber, sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return iMapBuilder.build();
    }


}
