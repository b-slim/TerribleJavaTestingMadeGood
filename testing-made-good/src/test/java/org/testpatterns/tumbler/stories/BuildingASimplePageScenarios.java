package org.testpatterns.tumbler.stories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static tumbler.Tumbler.given;
import static tumbler.Tumbler.then;
import static tumbler.Tumbler.when;

import java.util.Map;

import org.junit.runner.RunWith;
import org.testpatterns.dupcodeexample.fixture.PageDataFixture;
import org.testpatterns.dupcodeexample.lineutil.SimplePage;

import tumbler.Scenario;
import tumbler.Story;
import tumbler.TumblerRunner;

@RunWith(TumblerRunner.class)
@Story("Building a simple page")
public class BuildingASimplePageScenarios {
	private SimplePage page;

	@Scenario(pending = false)
	public void shouldCreateAPage4LinesLongWith5DataItemsInEachLine() {
		given("a data fixture capable of complex page checking");
		final PageDataFixture dataFixture = new PageDataFixture();

		when("a page is created with 'twenty' items on a page");
		page = SimplePage.newInstance(dataFixture.getDataItem(), 20);

		then("there should be 'four' lines on a page with 'five' data items on each line");
		Map<Integer, String> expectedLines = dataFixture.createPageExpectation(4, 5);

		Map<Integer, String> actualMap = page.getMap();

		assertThat(actualMap, is(expectedLines));
	}
}