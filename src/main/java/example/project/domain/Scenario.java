package example.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

    private double euclidean(List<Float> x, List<Float> y) {
        double x_calc = 0;
        for (float i: x) {
            x_calc += Math.pow(i, 2);
        }
        x_calc = Math.sqrt(x_calc);

        double y_calc = 0;
        for (float i: y) {
            y_calc += Math.pow(i, 2);
        }
        y_calc = Math.sqrt(y_calc);

        return Math.abs(x_calc - y_calc);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Scenario scenario = (Scenario) obj;

        return roadType.equals(scenario.roadType) &&
                weatherCondition.equals(scenario.weatherCondition) &&
                euclidean(initEgoCarPos, scenario.initEgoCarPos) <= 0.05 &&
                euclidean(initCarInFrontPos, scenario.initCarInFrontPos) <= 0.05;
    }
}
