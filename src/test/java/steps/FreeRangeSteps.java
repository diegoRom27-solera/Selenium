package steps;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class FreeRangeSteps {
    PaginaPrincipal landingPage = new PaginaPrincipal();
    @Given("I navigate")
    public void iNavigateToRFT(){
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public  void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }
}
