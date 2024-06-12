package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features=".//Feature/Customers.feature/",
        features = {".//Feature/Vendor.feature"},
        glue = "StepDefinition",
        //tags = "@smoke",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/cucumer-reports/report.json", "html:target/cucumer-reports/report.html"})
//plugin={"pretty","html:target/cucumer-reports/report.html"}
public class Run {
    /*This class is empty*/
}
