package uiautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features = "src/test/resources/features",
        glue = {"uiautomation.base",
                "uiautomation.stepdefinitions",
        },
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberRunner {
}
