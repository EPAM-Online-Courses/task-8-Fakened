package efs.task.unittests;


import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PlannerTest {
    private Planner planner = new Planner();

    @BeforeEach
    void setUp() {
        planner = new Planner();
    }

    @ParameterizedTest
    @EnumSource(ActivityLevel.class)
    void shouldCheckDailyCaloriesDemand(ActivityLevel activityLevel) {
        User constantUser = TestConstants.TEST_USER;
        Map<ActivityLevel, Integer> activityLevelMap = TestConstants.CALORIES_ON_ACTIVITY_LEVEL;

        int dailyCaloriesDemand = planner.calculateDailyCaloriesDemand(constantUser, activityLevel);

        Assertions.assertEquals(activityLevelMap.get(activityLevel), dailyCaloriesDemand);

    }

    @Test
    void shouldCheckDailyIntake() {
        User constantUser = TestConstants.TEST_USER;
        DailyIntake dailyIntake = TestConstants.TEST_USER_DAILY_INTAKE;

        DailyIntake calculatedDailyIntake = planner.calculateDailyIntake(constantUser);

        Assertions.assertEquals(dailyIntake.getCalories(), calculatedDailyIntake.getCalories());
        Assertions.assertEquals(dailyIntake.getProtein(), calculatedDailyIntake.getProtein());
        Assertions.assertEquals(dailyIntake.getFat(), calculatedDailyIntake.getFat());
        Assertions.assertEquals(dailyIntake.getCarbohydrate(), calculatedDailyIntake.getCarbohydrate());
    }
}
