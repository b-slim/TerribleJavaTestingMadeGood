package org.testpatterns.dupcodeexample.lineutil;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import java.util.Set;

/**
 * A simple page object for demonstrating some testing.
 * Once the page has been created, its possible to fetch maps with getMap()
 * or the keys, getKeySet() from the backing object.
 * In addition its possible to appendLines() to the page.
 *
 * @author martinh
 */
public class SimplePage {

    public final static int MINIMUM_PAGE_WIDTH = 42;
    private ImmutableMap<Integer, String> simplePage;

    private SimplePage() {
        //Do not extend this object.
    }

    private SimplePage(String item, int numItems) {
        this.simplePage = assemblePage(item, numItems);
    }

    /**
     * Create a simple page populated with items that fill lines
     * of a fixed length.  If the length is exceeded by a word,
     * leave the word intact and fill past the line to the end of the word.
     *
     * @param item The item used for page content.
     * @param numItems The number of items to use required.
     * @return The formatted page.
     */
    public static SimplePage newInstance(String item, int numItems) {
        return new SimplePage(item, numItems);
    }

    public Map<Integer, String> getMap() {
        return this.simplePage;
    }

    public Set<Integer> getKeySet() {
        return this.simplePage.keySet();
    }

    /**
     * Add lines to the end of the map.
     * 
     * @param item The item used for page content.
     * @param numItems The number of items appended.
     */
    public void appendLines(String item, int numItems) {
        ImmutableMap.Builder<Integer, String> immutableMapBuilder = ImmutableMap.builder();
        final int numberOfLinesCreated = addExistingBackingStoreToBuilder(immutableMapBuilder);
        
        addItemsStartAtIndex(numItems, item, numberOfLinesCreated, immutableMapBuilder);
        this.simplePage = immutableMapBuilder.build();
    }

    private void addItemsToBuilderFromStartIndex(int numItems,
                                                 String item,
                                                 Builder<Integer, String> immutableMapBuilder,
                                                 int lineNumber) {
        StringBuilder sb = new StringBuilder(maxLineWidth(item));

        for (int i = 0; i < numItems; i++) {
            sb.append(item);
            if (sb.length() > MINIMUM_PAGE_WIDTH) {
                immutableMapBuilder.put(++lineNumber, sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }

    private ImmutableMap<Integer, String> assemblePage(String item, int numItems) {

        ImmutableMap.Builder<Integer, String> iMapBuilder = ImmutableMap.builder();
        addItemsStartAtZeroIndex(numItems, item, iMapBuilder);

        return iMapBuilder.build();
    }

    private void addItemsStartAtZeroIndex(int numItems, String item,
                                          Builder<Integer, String> iMapBuilder) {
        addItemsToBuilderFromStartIndex(numItems, item, iMapBuilder, 0);
    }

    private void addItemsStartAtIndex(int numItems, String item, int startIndex,
                                      Builder<Integer, String> iMapBuilder) {
        addItemsToBuilderFromStartIndex(numItems, item, iMapBuilder, startIndex);
    }

    private int addExistingBackingStoreToBuilder(
            Builder<Integer, String> iMapBuilder) {
        int lineNumber = 0;

        for (Map.Entry<Integer, String> lines : this.simplePage.entrySet()) {
            iMapBuilder.put(++lineNumber, lines.getValue());

        }

        return lineNumber;
    }

    private int maxLineWidth(String item) {
        return MINIMUM_PAGE_WIDTH + item.length();
    }
}
