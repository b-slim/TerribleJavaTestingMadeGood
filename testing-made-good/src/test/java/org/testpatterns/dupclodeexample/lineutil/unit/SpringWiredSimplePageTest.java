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

import com.tekdesign.fixture.PageDataFixture;
import com.tekdesign.lineutil.SimplePage;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Test the SimplePage object.
 *
 * @author martinh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springAppConfig.xml")
public class SpringWiredSimplePageTest {

    @Autowired
    PageDataFixture dataFixture;

    @Test
    public void testPageAssembley_GeneratesAndStoresPageContent() {

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(4);

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), 20);
        Map<Integer, String> actualMap = page.getMap();

        assertEquals(expectedLines, actualMap);

    }

    @Test
    public void testPageAssembley_GeneratesPageKeySet() {

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(4);

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), 20);
        Set<Integer> actualKeySet = page.getKeySet();

        assertEquals(expectedLines.keySet(), actualKeySet);

    }

    @Test
    public void testAppendLines_AddsLinesToEndOfPage() {

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), 20);

        page.appendLines(dataFixture.getDataItem(), 20);

        Map<Integer, String> actualMap = page.getMap();

        Map<Integer, String> expectedLines = dataFixture.createLineExpectations(8);
        assertEquals(expectedLines, actualMap);

    }
}
