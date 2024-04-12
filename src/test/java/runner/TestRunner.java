package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos feature
    glue =  "steps",// donde estan los step definitions
    plugin =  {"pretty","html:target/cucumber-reports.html"} // donde se van a guardar los archivos
 )

public class TestRunner {
    // con esto lo que se logra es que despues de cada una de las ejecucuiones de los test se ejecute ese codigo
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }


}
