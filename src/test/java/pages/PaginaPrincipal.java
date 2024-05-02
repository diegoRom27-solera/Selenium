package pages;

public class PaginaPrincipal extends BasePage {
    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal (){
        // para poder inicializar la base page necesitamos utilizar el elemento driver
        // super lo que hace es inicializar el constructor de la clase madre 
        super(driver);
    }

    //Metodo para navegar
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com/");
    }
    public void clickOnSectionNavigationBar(String section){
        // reemplazar el marcador de posicion en el sectionlink con el nokbre
        String xpathSection= String.format(sectionLink, section);
        clickElement(xpathSection);
    }
    
    public void clickOnElegirPlanButton() {
        clickElement(elegirUnPlanButton);
    }
    
    
}
