package com.tekdesign.lineutil.unit;

import com.tekdesign.lineutil.SimplePage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test SimplePage Function
 * @author martinh
 */
public class TerribleSimplePageTest {

    @Test
    //testPageAssembley_ProducesPageContent()
    public void testPageAssembley() {

        String item = "-23456789-";

        Map<Integer, String> expectedLines = new HashMap<Integer, String>();

        expectedLines.put(1, item + item + item + item + item);
        expectedLines.put(2, item + item + item + item + item);
        expectedLines.put(3, item + item + item + item + item);
        expectedLines.put(4, item + item + item + item + item);

        SimplePage page = SimplePage.newInstance(item, 20);
        Map<Integer, String> actualMap = page.getMap();

        assertEquals(expectedLines, actualMap);

    }

    @Test
    //testPageAssembley_ProducesPageContent()
    public void testPageKeySet() {

        String item = "-23456789-";

        Map<Integer, String> expectedLines = new HashMap<Integer, String>();

        expectedLines.put(1, item + item + item + item + item);
        expectedLines.put(2, item + item + item + item + item);
        expectedLines.put(3, item + item + item + item + item);
        expectedLines.put(4, item + item + item + item + item);

        SimplePage page = SimplePage.newInstance(item, 20);
        Set<Integer> actualKeySet = page.getKeySet();

        assertEquals(expectedLines.keySet(), actualKeySet);

    }

    @Test
    //testPageAssembley_ProducesPageContent()
    public void testAddLines() {

        String item = "-23456789-";

        SimplePage page = SimplePage.newInstance(item, 20);


        Map<Integer, String> additionalLines = new HashMap<Integer, String>();

        additionalLines.put(1, item + item + item + item + item);
        additionalLines.put(2, item + item + item + item + item);
        additionalLines.put(3, item + item + item + item + item);
        additionalLines.put(4, item + item + item + item + item);
        
        page.addLines(item, 20);

        Map<Integer, String> actualMap = page.getMap();


        Map<Integer, String> expectedLines = new HashMap<Integer, String>();

        expectedLines.put(1, item + item + item + item + item);
        expectedLines.put(2, item + item + item + item + item);
        expectedLines.put(3, item + item + item + item + item);
        expectedLines.put(4, item + item + item + item + item);
        expectedLines.put(5, item + item + item + item + item);
        expectedLines.put(6, item + item + item + item + item);
        expectedLines.put(7, item + item + item + item + item);
        expectedLines.put(8, item + item + item + item + item);
        assertEquals(expectedLines, actualMap);

    }
}
