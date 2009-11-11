package com.tekdesign.lineutil.unit;

import com.tekdesign.lineutil.StringPageMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test StringPageMap Function
 * @author martinh
 */
public class TerribleStringLineTest {

    @Test
    //testPageAssembley_ProducesPageContent()
    public void testPageAssembley() {

        String item = "-23456789-";

        Map<Integer, String> expectedLines = new HashMap<Integer, String>();

        expectedLines.put(1, item+item+item+item+item);
        expectedLines.put(2, item+item+item+item+item);
        expectedLines.put(3, item+item+item+item+item);
        expectedLines.put(4, item+item+item+item+item);

        Map<Integer, String> actualMap = StringPageMap.assembleLine(item,20);

        assertEquals(expectedLines, actualMap);
        


    }

     @Test
    //testPageAssembley_PageLinesOnPage()
    public void testLength() {

        String item = "-23456789-";

        Map<Integer, String> expectedLines = new HashMap<Integer, String>();

        expectedLines.put(1, item+item+item+item+item);
        expectedLines.put(2, item+item+item+item+item);
        expectedLines.put(3, item+item+item+item+item);
        expectedLines.put(4, item+item+item+item+item);



        Map<Integer, String> actualMap = StringPageMap.assembleLine(item,20);

        assertEquals(4,StringPageMap.numLinesOnPage(actualMap));




    }
}
