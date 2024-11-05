package page_obeject_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DarazHomePage extends BasePage{

    WebDriver driver;

    @FindBy(xpath = "//input[@id='q']")
    public WebElement SearchBox;

    @FindBy(xpath = "//*[@id='topActionHeader']//form//a")
    public WebElement SearchButton;

    public DarazHomePage(WebDriver driver){
        super(driver);
    }


    //Methods for above WebElements
    public void typeTextToSearchBox(String searchText){
        SearchBox.sendKeys(searchText);
    }

    public <T> T clickSearchButton(String searchText) {
        SearchButton.click();

        if (searchText.equalsIgnoreCase("headphones")) {
            return (T) PageFactory.initElements(driver, DarazHeadphonesPage.class);
        } else {
            return (T) PageFactory.initElements(driver, DarazShoesPage.class);
        }
    }




}
