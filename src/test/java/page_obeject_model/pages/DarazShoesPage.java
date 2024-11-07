package page_obeject_model.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazShoesPage extends BasePage{

    //private WebDriver driver;
    private WebDriverWait wait;

    //WebElements
    @FindBy(xpath = "//input[@type='checkbox' and @businesstype='brand' and @businessvalue='ielgy-123802449']")
    public WebElement brandIelgyCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='30129:3739']")
    public WebElement colorCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='40369:112320' and @businesstype='multiple']")
    public WebElement sneakerStyleSportsCheckbox;

    @FindBy(xpath = "//a[contains(@href, 'ielgy-super-high-heels-thick-sole-inner-heightened-waterproof-platform-womens-shoes')]")
    public WebElement productIelgyHighHeelsLink;


    public DarazShoesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods for WebElements

    //Method to select brand
    public void selectBrandCheckBox() {
        if (brandIelgyCheckbox != null && !brandIelgyCheckbox.isSelected()) {
            brandIelgyCheckbox.click();
        } else if (brandIelgyCheckbox == null) {
            throw new IllegalStateException("Brand checkbox was not selected properly");
        }
    }
    // Method to check if brand checkbox is selected
    public boolean isBrandCheckBoxSelected() {
        return brandIelgyCheckbox.isSelected();
    }

    //Method to select color
    public void selectColorCheckbox() {
        if (colorCheckbox != null && !colorCheckbox.isSelected()) {
            colorCheckbox.click();
        } else if (colorCheckbox == null) {
            throw new IllegalStateException("Color checkbox was not selected properly");
        }
    }
    // Method to check if color checkbox is selected
    public boolean isColorCheckBoxSelected() {
        return colorCheckbox.isSelected();
    }

    //Method to select sneaker style
    public void selectSneakerStyleCheckBox() {
        if (sneakerStyleSportsCheckbox != null && !sneakerStyleSportsCheckbox.isSelected()) {
            sneakerStyleSportsCheckbox.click();
        } else if (sneakerStyleSportsCheckbox == null) {
            throw new IllegalStateException("Sneaker Style checkbox was not selected properly");
        }
    }
    // Method to check if sneaker style checkbox is selected
    public boolean isSneakerStyleCheckBoxSelected() {
        return sneakerStyleSportsCheckbox.isSelected();
    }

    //Method to select product
    public void selectIelgyHighHeelsLink(){
        productIelgyHighHeelsLink.click();
    }

    @FindBy(xpath = "//div[contains(@class, 'pdp-mod-product-badge-wrapper')]//h1[contains(@class, 'pdp-mod-product-badge-title')]")
    public WebElement productTitle;

    //Check if select product successful
    public boolean isSelectProductSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(productTitle));
            return productTitle.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Return false if the element is not found or timeout occurs
        }
    }

}
