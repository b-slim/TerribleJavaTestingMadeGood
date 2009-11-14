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
package org.testpatterns.dupcodeexample.fixture;

import com.google.common.collect.Maps;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Data fixture compoment providing facility for testing page layouts.
 * @author martinh
 */
@Component
public class PageDataFixture {

    final String dataItem = "-23456789-";

    /**
     * Create a map representing a page expectation for a SimplePage.
     *
     */
    public Map<Integer, String> createPageExpectation(int numLinesToCreate,
                                                      int numDataItemsPerLine) {
        Map<Integer, String> expectedLines = Maps.newHashMap();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numDataItemsPerLine; i++) {
            sb.append(dataItem);
        }

        String line = sb.toString();
        for (int i = 0; i < numLinesToCreate; i++) {
            expectedLines.put(i + 1, line);
        }

        return expectedLines;
    }

    public String getDataItem() {
        return dataItem;
    }
}

