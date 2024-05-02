package steps;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;

public class FreeRangeSteps {
    PaginaCursos cursosPage =  new PaginaCursos();
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaFundamentosTesting fundamentosPage =  new PaginaFundamentosTesting();
    @Given("I navigate")
    public void iNavigateToRFT(){
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public  void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("select Introduccion al Testing")
    public void navigateToIntro(){
        cursosPage.clickElementTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @And("I select Elegir Plan")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }
 
}
