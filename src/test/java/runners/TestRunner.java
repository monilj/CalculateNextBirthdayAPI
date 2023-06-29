package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "D:\\Data Backup 2022\\IntellijProjects\\CalcalateBirthday\\src\\test\\resources\\feature\\NextBirthdayCalculator.feature",
        glue={"stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
