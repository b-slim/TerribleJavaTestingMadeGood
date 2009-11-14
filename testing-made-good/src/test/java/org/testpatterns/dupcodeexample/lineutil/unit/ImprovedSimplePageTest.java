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
package org.testpatterns.dupcodeexample.lineutil.unit;

import com.google.common.collect.Maps;
import org.testpatterns.dupcodeexample.lineutil.SimplePage;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the SimplePage object.
 * 
 * @author martinh
 */
public class ImprovedSimplePageTest {

    static final String ITEM = "-23456789-";

    @Test
    public void testPageAssembley_GeneratesAndStoresPageContent() {

        Map<Integer, String> expectedLines = createLineExpectations(ITEM,4);

        SimplePage page = SimplePage.newInstance(ITEM, 20);
        Map<Integer, String> actualMap = page.getMap();

        assertEquals(expectedLines, actualMap);

    }

    @Test
    public void testPageAssembley_GeneratesPageKeySet() {

        Map<Integer, String> expectedLines = createLineExpectations(ITEM,4);

        SimplePage page = SimplePage.newInstance(ITEM, 20);
        Set<Integer> actualKeySet = page.getKeySet();

        assertEquals(expectedLines.keySet(), actualKeySet);

    }

    @Test
    public void testAppendLines_AddsLinesToEndOfPage() {

        SimplePage page = SimplePage.newInstance(ITEM, 20);

        page.appendLines(ITEM, 20);

        Map<Integer, String> actualMap = page.getMap();

        Map<Integer, String> expectedLines = createLineExpectations(ITEM,8);
        assertEquals(expectedLines, actualMap);

    }

    private Map<Integer, String> createLineExpectations(String item, int numLinesToCreate) {
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
