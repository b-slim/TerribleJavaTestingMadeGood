/*
 *  Copyright (C) 2009 Martin Allan Harris martinhport-q@yahoo.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package com.tekdesign.lineutil.unit;

import com.tekdesign.lineutil.SimplePage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Terrible Test SimplePage Function.
 *
 * @author martinh
 */
public class TerribleSimplePageTest {

    @Test
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
    public void testAddLines() {

        String item = "-23456789-";

        SimplePage page = SimplePage.newInstance(item, 20);


        Map<Integer, String> additionalLines = new HashMap<Integer, String>();

        additionalLines.put(1, item + item + item + item + item);
        additionalLines.put(2, item + item + item + item + item);
        additionalLines.put(3, item + item + item + item + item);
        additionalLines.put(4, item + item + item + item + item);
        
        page.appendLines(item, 20);

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
