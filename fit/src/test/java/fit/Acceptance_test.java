package fit;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		plugin = {"summary","html:target/cucumber/report.html"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		glue = "fit"
		)

public class Acceptance_test{

}

