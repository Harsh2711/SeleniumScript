import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test",plugin = {"pretty", "html:target/Report/report.html"},features = {"src/test/java/Feature"})
public class Runner {


}
