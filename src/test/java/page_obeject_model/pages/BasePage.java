package page_obeject_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    //protected WebDriver driver;
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public DarazHomePage loadURL(String url){
        driver.get(url);
        return PageFactory.initElements(driver, DarazHomePage.class);
    }

    public void scrollPage(WebDriver driver, int x, int y){
        new Actions(driver).scrollByAmount(x, y).perform();
    }

}
