package TestRunner;



//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	//	features = ".//features/Login.feature",
	//	features = ".//features/SelectProduct.feature",
		//if we want to rune alfeature file together then we dont need to add feature file name add only feature project name
		//features = ".//features/",
		//We can multiple feature file by sprating them using coma
		features = {".//features/Login.feature",".//features/SelectProduct.feature"},
		
		glue = "StepDefinations",
		dryRun = false,
		monochrome = true,
		//tags = "@smoke",
		//plugin = {"pretty","junit:target/Cucumber.target/reports1_xml.xml","json:target/Cucumber.target/reports1_json.json","html:target/Cucumber.target/reports1.html"}
		//Extent report plug IN
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
	
//plugin = {"pretty","junit:target/Cucumber.target/reports1_xml.xml"}
//plugin = {"pretty","json:target/Cucumber.target/reports1_json.json"} json formate
//plugin = {"pretty","html:target/Cucumber.target/reports1.html"} to genrat HTML report
public class Run extends AbstractTestNGCucumberTests{
	

}
