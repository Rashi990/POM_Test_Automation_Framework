package page_obeject_model.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazLadiesWatchPage extends BasePage{

    private WebDriverWait wait;

    //WebElements
    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='8.8_campaign' and @businesstype='multiple']")
    public WebElement campaignCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='31510:21772' and @businesstype='multiple']")
    public WebElement roseGoldCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @businessvalue='7:201045' and @businesstype='multiple']")
    public WebElement brandWarrantyCheckbox;

    @FindBy(xpath = "//a[contains(@href, 'rose-gold-womens-watches-luxury-led-digital-watch-for-women')]")
    public WebElement roseGoldWomenWatchLink;


    public DarazLadiesWatchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods for WebElements

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


    //Method to select watch strap color
    public void selectWatchStrapColorCheckBox() {
        if (roseGoldCheckbox != null && !roseGoldCheckbox.isSelected()) {
            roseGoldCheckbox.click();
        } else if (roseGoldCheckbox == null) {
            throw new IllegalStateException("Watch strap color checkbox was not selected properly");
        }
    }
    // Method to check if watch strap color checkbox is selected
    public boolean isWatchStrapColorCheckBoxSelected() {
        return roseGoldCheckbox.isSelected();
    }

    //Method to select warranty type
    public void selectWarrantyTypeCheckBox() {
        if (brandWarrantyCheckbox != null && !brandWarrantyCheckbox.isSelected()) {
            brandWarrantyCheckbox.click();
        } else if (brandWarrantyCheckbox == null) {
            throw new IllegalStateException("Warranty type checkbox was not selected properly");
        }
    }
    // Method to check if warranty type checkbox is selected
    public boolean isWarrantyTypeCheckBoxSelected() {
        return brandWarrantyCheckbox.isSelected();
    }

    //Method to select watch
    public void selectWatchLink(){
        roseGoldWomenWatchLink.click();
    }

    @FindBy(xpath = "//div[contains(@class, 'pdp-mod-product-badge-wrapper')]//h1[contains(@class, 'pdp-mod-product-badge-title')]")
    public WebElement roseGoldWomenWatchTitle;

    //Check if select watch successful
    public boolean isSelectWatchSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(roseGoldWomenWatchTitle));
            return roseGoldWomenWatchTitle.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Return false if the element is not found or timeout occurs
        }
    }

}
