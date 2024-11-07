package page_obeject_model.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazHeadphonesPage extends BasePage{

    final WebDriverWait wait;

    //WebElements
    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='anker' and @businesstype='brand']")
    public WebElement brandAnkerCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='free_shipping' and @businesstype='multiple']")
    public WebElement freeShippingCheckbox;

    @FindBy(xpath = "//input[@type='number' and @placeholder='Min' and @class='q9tZB']")
    public WebElement minPrice;

    @FindBy(xpath = "//input[@type='number' and @placeholder='Max' and @class='q9tZB']")
    public WebElement maxPrice;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'ant-btn-primary') and .//span[@role='img' and @aria-label='caret-right']]")
    public WebElement priceButton;

    @FindBy(xpath = "//input[@type='checkbox' and @class='ant-checkbox-input' and @businessvalue='8:4456' and @businesstype='multiple']")
    public WebElement warrantyPeriodCheckbox;

    @FindBy(xpath = "//a[contains(@href, 'anker-soundcore-h30i-wireless-on-ear-headphones-foldable-design-pure-bass-70h-playtime-bluetooth-53-lightweight-and-comfortable-app-connectivity-multipoint-connection')]")
    public WebElement headphoneLink;

    public DarazHeadphonesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods for above WebElements

    //Method to select brand
    public void selectBrandCheckBox() {
        if (brandAnkerCheckbox != null && !brandAnkerCheckbox.isSelected()) {
            brandAnkerCheckbox.click();
        } else if (brandAnkerCheckbox == null) {
            throw new IllegalStateException("Brand checkbox was not selected properly");
        }
    }
    // Method to check if brand checkbox is selected
    public boolean isBrandCheckBoxSelected() {
        return brandAnkerCheckbox.isSelected();
    }

    //Method to select free shipping
    public void setFreeShippingCheckbox() {
        if (freeShippingCheckbox != null && !freeShippingCheckbox.isSelected()) {
            freeShippingCheckbox.click();
        } else if (freeShippingCheckbox == null) {
            throw new IllegalStateException("Free Shipping was not selected properly");
        }
    }
    // Method to check if free shipping is selected
    public boolean isFreeShippingSelected() {
        return freeShippingCheckbox.isSelected();
    }

    //Method to set price range
    //Set min price
    public void typeTextToMinPrice(String minPriceValue){
        minPrice.sendKeys(minPriceValue);
    }
    //Set max price
    public void typeTextToMaxPrice(String maxPriceValue){
        maxPrice.sendKeys(maxPriceValue);
    }
    //Set price range
    public void clickPriceButton() {
        priceButton.click();
    }

    //Method to select warranty period
    public void selectWarrantyPeriod() {
        if (warrantyPeriodCheckbox != null && !warrantyPeriodCheckbox.isSelected()) {
            warrantyPeriodCheckbox.click();
        } else if (warrantyPeriodCheckbox == null) {
            throw new IllegalStateException("Warranty period was not selected properly");
        }
    }
    // Method to check if warranty period is selected
    public boolean isWarrantyPeriodSelected() {
        return warrantyPeriodCheckbox.isSelected();
    }

    //Method to select headphone
    public void selectHeadphoneLink(){
        headphoneLink.click();
    }

    @FindBy(xpath = "//div[contains(@class, 'pdp-mod-product-badge-wrapper')]//h1[contains(@class, 'pdp-mod-product-badge-title')]")
    public WebElement headphoneTitle;

    //Check if select product successful
    public boolean isSelectHeadphoneSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(headphoneTitle));
            return headphoneTitle.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Return false if the element is not found or timeout occurs
        }
    }
}
