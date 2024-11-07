package page_obeject_model.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazLoginPage extends BasePage{

    //WebElements
    @FindBy(xpath = "//input[@class='iweb-input']")
    public WebElement EmailField;

    @FindBy(xpath = "//input[@class='iweb-input' and @type='password']")
    public WebElement PasswordField;

    @FindBy(xpath = "//button[@type='button' and text()='LOG IN']")
    public WebElement LoginButton;

    public DarazLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Method to login
    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(EmailField));

        EmailField.sendKeys(email);
        PasswordField.sendKeys(password);
        LoginButton.click();
    }

    //WebElement for MyAccount
    @FindBy(xpath = "//span[contains(@class, 'top-links-item-text-limit') and contains(text(), \"Rashini UCSC's account\")]")
    public WebElement MyAccountTrigger;

    //Check if login successful
    public boolean isLoginSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(MyAccountTrigger));
            return MyAccountTrigger.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Return false if the element is not found or timeout occurs
        }
    }

}
