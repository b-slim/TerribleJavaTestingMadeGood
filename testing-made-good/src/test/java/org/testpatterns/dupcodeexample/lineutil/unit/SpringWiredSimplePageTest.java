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
package org.testpatterns.dupcodeexample.lineutil.unit;

import org.testpatterns.dupcodeexample.lineutil.SimplePage;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.testpatterns.dupcodeexample.fixture.PageDataFixture;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test the SimplePage object.
 *
 * @author martinh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springAppConfig.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class SpringWiredSimplePageTest {

    private static final int NUMBER_OF_ITEMS_ON_PAGE_20 = 20;
    private static final int NUMBER_LINES_ON_PAGE_4 = 4;
    private static final int NUMBER_LINES_ON_PAGE_8 = 8;
    private static final int NUMBER_DATA_ITEMS_IN_LINE_5 = 5;
    
    @Autowired
    private PageDataFixture dataFixture;

    @Test
    public void pageAssembley_GeneratesAndStoresPageContent() {

        Map<Integer, String> expectedLines = dataFixture.createPageExpectation(NUMBER_LINES_ON_PAGE_4, NUMBER_DATA_ITEMS_IN_LINE_5);

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), NUMBER_OF_ITEMS_ON_PAGE_20);
        Map<Integer, String> actualMap = page.getMap();

        assertThat(actualMap, is(expectedLines));

    }

    @Test
    public void pageAssembley_GeneratesPageKeySet() {

        Map<Integer, String> expectedLines = dataFixture.createPageExpectation(NUMBER_LINES_ON_PAGE_4, NUMBER_DATA_ITEMS_IN_LINE_5);

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), NUMBER_OF_ITEMS_ON_PAGE_20);
        Set<Integer> actualKeySet = page.getKeySet();

        assertThat(actualKeySet, is(expectedLines.keySet()));

    }

    @Test
    public void appendLines_AddsLinesToEndOfPage() {

        Map<Integer, String> expectedLines = dataFixture.createPageExpectation(NUMBER_LINES_ON_PAGE_8, NUMBER_DATA_ITEMS_IN_LINE_5);

        SimplePage page = SimplePage.newInstance(dataFixture.getDataItem(), NUMBER_OF_ITEMS_ON_PAGE_20);
        page.appendItems(dataFixture.getDataItem(), NUMBER_OF_ITEMS_ON_PAGE_20);
        Map<Integer, String> actualMap = page.getMap();

        assertThat(actualMap, is(expectedLines));

        String item = dataFixture.getDataItem();
        String expectedLastLine = item;

        page.appendItems(item, 1);
        actualMap = page.getMap();
        String lastLine = dataFixture.getLastMapValue(actualMap);
        assertThat(actualMap.size(), is(9));
        assertThat(lastLine, is(expectedLastLine));

    }
}
