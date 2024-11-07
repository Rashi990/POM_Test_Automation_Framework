package page_obeject_model.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazFrocksPage extends BasePage{

    private WebDriverWait wait;

    //WebElements

    @FindBy(xpath = "//input[@type='checkbox' and @class='ant-checkbox-input' and @businessvalue='Western' and @businesstype='location']")
    public WebElement westernLocationCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='8.8_campaign' and @businesstype='multiple']")
    public WebElement campaignCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='31319:14402' and @businesstype='multiple']")
    public WebElement sleevelessCheckbox;

    @FindBy(xpath = "//a[contains(@href, 'mock-neck-sleeveless-bodycon-short-frock')]")
    public WebElement mockNeckBodyconFrockLink;

    public DarazFrocksPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Methods for WebElements

    //Method to select shipped from
    public void selectShippedFromCheckBox() {
        if (westernLocationCheckbox != null && !westernLocationCheckbox.isSelected()) {
            westernLocationCheckbox.click();
        } else if (westernLocationCheckbox == null) {
            throw new IllegalStateException("Collar type checkbox was not selected properly");
        }
    }
    // Method to check if shipped from checkbox is selected
    public boolean isShippedFromCheckBoxSelected() {
        return westernLocationCheckbox.isSelected();
    }

    //Method to select service & promotions
    public void selectServiceAndPromotionsCheckBox() {
        if (campaignCheckbox != null && !campaignCheckbox.isSelected()) {
            campaignCheckbox.click();
        } else if (campaignCheckbox == null) {
            throw new IllegalStateException("Service & Promotions checkbox was not selected properly");
        }
    }
    // Method to check if service and promotions checkbox is selected
    public boolean isServiceAndPromotionsCheckBoxSelected() {
        return campaignCheckbox.isSelected();
    }


    //Method to select sleeves
    public void selectSleevelessCheckBox() {
        if (sleevelessCheckbox != null && !sleevelessCheckbox.isSelected()) {
            sleevelessCheckbox.click();
        } else if (sleevelessCheckbox == null) {
            throw new IllegalStateException("Sleeveless checkbox was not selected properly");
        }
    }
    // Method to check if sleeveless checkbox is selected
    public boolean isSleevelessCheckBoxSelected() {
        return sleevelessCheckbox.isSelected();
    }

    //Method to select frock
    public void selectFrockLink(){
        mockNeckBodyconFrockLink.click();
    }

    @FindBy(xpath = "//div[contains(@class, 'pdp-mod-product-badge-wrapper')]//h1[contains(@class, 'pdp-mod-product-badge-title')]")
    public WebElement mockNeckBodyconFrockTitle;

    //Check if select frock successful
    public boolean isSelectFrockSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(mockNeckBodyconFrockTitle));
            return mockNeckBodyconFrockTitle.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Return false if the element is not found or timeout occurs
        }
    }
}
