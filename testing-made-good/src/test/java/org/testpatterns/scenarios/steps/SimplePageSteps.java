package org.testpatterns.scenarios.steps;

import static org.hamcrest.Matchers.is;
import static org.jbehave.Ensure.ensureThat;
import static org.springframework.util.Assert.notNull;

import java.util.Map;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.testpatterns.dupcodeexample.fixture.PageDataFixture;
import org.testpatterns.dupcodeexample.lineutil.SimplePage;

public class SimplePageSteps extends Steps {

	private SimplePage page;

	private final PageDataFixture dataFixture = new PageDataFixture();

	@Given("a data fixture")
	public void givenASpringDataFixture() {
		notNull(dataFixture);
	}

	@When("a page is created with $itemsOnAPage items on a page")
	public void createPage(int itemsOnAPage) {
		page = SimplePage.newInstance(dataFixture.getDataItem(), itemsOnAPage);
	}

	@Then("expected lines on a page is $linesOnAPage with data items in a line $itemsInALine")
	public void validatePage(int linesOnAPage, int itemsInALine) {
		Map<Integer, String> expectedLines = dataFixture.createPageExpectation(linesOnAPage, itemsInALine);

		Map<Integer, String> actualMap = page.getMap();

		ensureThat(actualMap, is(expectedLines));

	}

}
