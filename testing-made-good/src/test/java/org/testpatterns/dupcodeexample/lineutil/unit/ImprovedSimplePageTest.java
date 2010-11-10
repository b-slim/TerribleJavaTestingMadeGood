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

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;
import org.testpatterns.dupcodeexample.lineutil.SimplePage;

/**
 * Test the SimplePage object.
 * 
 * @author martinh
 */
public class ImprovedSimplePageTest {

	private static final String ITEM = "-23456789-";
	private static final int LINES_4 = 4;

	@Test
	public void pageAssembley_GeneratesAndStoresPageContent() {

		Map<Integer, String> expectedLines = createLineExpectations(ITEM, LINES_4);

		SimplePage page = SimplePage.newInstance(ITEM, 20);
		Map<Integer, String> actualMap = page.getMap();

		assertThat(actualMap, is(expectedLines));

	}

	@Test
	public void pageAssembley_GeneratesPageKeySet() {

		Map<Integer, String> expectedLines = createLineExpectations(ITEM, LINES_4);

		SimplePage page = SimplePage.newInstance(ITEM, 20);
		Set<Integer> actualKeySet = page.getKeySet();

		assertThat(actualKeySet, is(expectedLines.keySet()));

	}

	@Test
	public void appendLines_AddsLinesToEndOfPage() {

		SimplePage page = SimplePage.newInstance(ITEM, 20);
		page.appendItems(ITEM, 19);

		Map<Integer, String> actualMap = page.getMap();
		assertThat(actualMap.size(), is(8));

		String expectedLastLine = ITEM;

		page.appendItems(ITEM, 1);
		actualMap = page.getMap();
		String lastLine = getLastLine(actualMap);
		assertThat(actualMap.size(), is(9));
		assertThat(lastLine, is(expectedLastLine));

	}

	private String getLastLine(Map<Integer, String> expectedLines) {
		Set<Entry<Integer, String>> entrySet = expectedLines.entrySet();
		String line = null;
		for (Entry<Integer, String> entry : entrySet) {
			line = entry.getValue();
		}
		return line;
	}

	private Map<Integer, String> createLineExpectations(String item, int numLinesToCreate) {
		Map<Integer, String> expectedLines = newHashMap();

		StringBuilder sb = new StringBuilder();
		sb.append(item).append(item).append(item).append(item).append(item);
		String line = sb.toString();
		for (int i = 0; i < numLinesToCreate; i++) {
			expectedLines.put(i + 1, line);
		}

		return expectedLines;
	}
}
