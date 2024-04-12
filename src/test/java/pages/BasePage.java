package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;


// Usaremos esta como una clase madre
public class BasePage {
    // Se crea una variable que se llama Driver que será compartida por todas las instancias del Base Page y sus subclases
    protected static WebDriver driver;
    // Esto lo que hace es que cuando se utilice el web driver por defecto se van a esperar 5 seg
    //Declaracion de la instancia wait que se usa para las esperas explicitas en elementos web
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // Este loque estatico lo que hace es crear la instancia del web Driver dr chrome al principio en la ejecucion
    // se configura el webDriver para chrome usando el webDriverManager
    
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //Creamos el constructor de la base page esto lo haremosp or que en la herencia aqui heredara este contructor
    public BasePage (WebDriver driver){
        // Con esto lo que vamos a hacer es cuando heredemos la clase y le dara acceso a este contructor y por defecto al driver
        BasePage.driver =driver;
    }
    public static void navigateTo(String url){
        driver.get(url);
    }
    // Ya que el web driverfue definido en el bloque static debemos indicar que su uso sera del mismo tipo
    public static void closeBrowser(){
        driver.quit();
    }

    // Ahora lo que sigue es trabajar con locators

    // El objeto web element viene de selenium y nos permite invocar funciones para trabajar con ellos su nombre sera find
    // se le pasa un locator de tipo string
    // Este elemento esta privado por que solo queremos usar este web element dentro de esta clase no se va a heredar solo vamos a compartir las acciones
    private WebElement Find(String locator){
        // Devolvemos un objeto de tipo dweb element y decimos que espere hasta que el elemento este presente y que lo busque by xptahs
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Esta si es una pagina que nos permitirá heredarse 
    public void clickElement(String locator){
        /// Aqui hacemos uso del Find locator con esto conseguimos evitar usar el WAIT en cada lugar y solo lo colocamos una sola vez
        Find(locator).click();
    }

    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }


    public void selectFromDropDownByValue(String locator, String value){
        // Elemento Propio de selenium
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
    public void selectFromDropDownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions =dropdown.getOptions();
        return dropdownOptions.size();
    }







    
}
