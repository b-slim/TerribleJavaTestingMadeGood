package org.testpatterns.jbehave.scenarios;

import org.jbehave.scenario.JUnitScenario;
import org.jbehave.scenario.MostUsefulConfiguration;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import org.testpatterns.jbehave.scenarios.steps.SimplePageSteps;

public class SimplePageScenario extends JUnitScenario {

	public SimplePageScenario() {
		super(new MostUsefulConfiguration() {
			@Override
			public ScenarioDefiner forDefiningScenarios() {
				return new ClasspathScenarioDefiner(new UnderscoredCamelCaseResolver(".scn"),
						new PatternScenarioParser());
			}
		});

		addSteps(new SimplePageSteps());
	}

}
