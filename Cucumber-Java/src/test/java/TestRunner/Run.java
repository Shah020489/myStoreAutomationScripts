package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features=".//Feature/Customers.feature/",
        features = {".//Feature/ReportPage.feature"},
        glue = "StepDefinition",
        //tags = "@smoke",
        dryRun = true,
        monochrome = true,
        plugin = {"pretty", "json:target/cucumer-reports/report.json", "html:target/cucumer-reports/report.html"})
//plugin={"pretty","html:target/cucumer-reports/report.html"}
public class Run {
    /*This class is empty*/
}
