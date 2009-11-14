/*
 *  Copyright 2009 martinh.
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

import com.google.common.collect.Maps;
import com.tekdesign.lineutil.SimplePage;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martinh
 */
public class LocalFixtureBasedPageTest {

    class DataFixture {

        final String ITEM = "-23456789-";

        Map<Integer, String> createLineExpectations(String item,
                                                    int numLinesToCreate) {
            Map<Integer, String> expectedLines = Maps.newHashMap();

            StringBuilder sb = new StringBuilder();
            sb.append(item).append(item).append(item).append(item).append(item);
            String line = sb.toString();
            for (int i = 0; i < numLinesToCreate; i++) {
                expectedLines.put(i + 1, line);
            }

            return expectedLines;
        }
    }
    DataFixture dataFixture = new DataFixture();

    @Test
    public void testPageAssembley_GeneratesAndStoresPageContent() {

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(dataFixture.ITEM, 4);

        SimplePage page = SimplePage.newInstance(dataFixture.ITEM, 20);
        Map<Integer, String> actualMap = page.getMap();

        assertEquals(expectedLines, actualMap);

    }

    @Test
    public void testPageAssembley_GeneratesPageKeySet() {

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(dataFixture.ITEM, 4);

        SimplePage page = SimplePage.newInstance(dataFixture.ITEM, 20);
        Set<Integer> actualKeySet = page.getKeySet();

        assertEquals(expectedLines.keySet(), actualKeySet);

    }

    @Test
    public void testAppendLines_AddsLinesToEndOfPage() {

        SimplePage page = SimplePage.newInstance(dataFixture.ITEM, 20);

        page.appendLines(dataFixture.ITEM, 20);

        Map<Integer, String> actualMap = page.getMap();

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(dataFixture.ITEM, 8);
        assertEquals(expectedLines, actualMap);

    }
}