package page_obeject_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import page_obeject_model.pages.*;
import page_obeject_model.utilities.ExcelHanlder;
import page_obeject_model.utilities.Utilities;

import java.io.IOException;
import java.time.Duration;

public class DarazTests extends Utilities {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Starting Test Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Starting Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Starting Test Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Starting a new Test Method.....");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Test Method is completed");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Test Class is completed");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Test is completed");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Test Suite is completed");
    }


    //Testcases

    //Testcase for search headphones
    @Test
    public void searchHeadphones() {
        System.out.println("Testcase 1 : Search Headphones");
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = basePage.loadURL("https://www.daraz.lk/#?");
        homePage.typeTextToSearchBox("headphones");

        DarazHeadphonesPage headphonesPage = homePage.clickSearchButton("headphones");
        Assert.assertNotNull(headphonesPage, "Headphones page should be loaded");
        headphonesPage.scrollPage(browserFactory.getDriver(),0, 200);

        // Select brand
        headphonesPage.selectBrandCheckBox();
        Assert.assertTrue(headphonesPage.isBrandCheckBoxSelected(), "Brand checkbox should be selected");

        // Select free shipping
        headphonesPage.setFreeShippingCheckbox();
        Assert.assertTrue(headphonesPage.isFreeShippingSelected(), "Free shipping should be selected");

        //Set price range
        headphonesPage.typeTextToMinPrice("1000");
        headphonesPage.typeTextToMaxPrice("20000");
        headphonesPage.clickPriceButton();

        // Select warranty period
        headphonesPage.selectWarrantyPeriod();
        Assert.assertTrue(headphonesPage.isWarrantyPeriodSelected(), "Warranty period should be selected");

        //Select product
        headphonesPage.selectHeadphoneLink();
        boolean isSelectHeadphoneSuccessful = headphonesPage.isSelectHeadphoneSuccessful();
        Assert.assertTrue(isSelectHeadphoneSuccessful, "Headphone selection should be successful");
    }

    //Testcase for search shoes
    @Test
    public void searchShoes() {
        System.out.println("Testcase 2 : Search Shoes");
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = basePage.loadURL("https://www.daraz.lk/#?");
        homePage.typeTextToSearchBox("shoes");

        DarazShoesPage shoesPage = homePage.clickSearchButton("shoes");
        Assert.assertNotNull(shoesPage, "Shoes page should be loaded");
        shoesPage.scrollPage(browserFactory.getDriver(),0, 200);

        // Select brand checkbox
        shoesPage.selectBrandCheckBox();
        Assert.assertTrue(shoesPage.isBrandCheckBoxSelected(), "Brand checkbox should be selected");

        // Select color checkbox
        shoesPage.selectColorCheckbox();
        Assert.assertTrue(shoesPage.isColorCheckBoxSelected(), "Color checkbox should be selected");

        //Select sneaker style checkbox
        shoesPage.selectSneakerStyleCheckBox();
        Assert.assertTrue(shoesPage.isSneakerStyleCheckBoxSelected(), "Sneakery style checkbox should be selected");

        //Select shoes
        shoesPage.selectIelgyHighHeelsLink();
        boolean isSelectProductSuccessful = shoesPage.isSelectProductSuccessful();
        Assert.assertTrue(isSelectProductSuccessful, "Shoes selection should be successful");
    }

    //Testcase for login
    // DataProvider for login test using Excel
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return ExcelHanlder.readExcelData("src/test/resources/TestData.xlsx", "LoginData");
    }
    @Test(priority = 1, dataProvider = "loginData")
    public void login(String email, String password){
        System.out.println("Testcase 3 : Login");
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = basePage.loadURL("https://www.daraz.lk/#?");
        DarazLoginPage loginPage = PageFactory.initElements(browserFactory.getDriver(), DarazLoginPage.class);

        // Navigate to login page
        homePage.clickSelectLoginButton();

        // Perform login
        loginPage.login(email, password);

        // Verify login is successful using isLoginSuccessful method
        System.out.println("Checking if login was successful...");
        boolean isLoginSuccessful = loginPage.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful");

    }

    //Testcase for search frocks
    @Test
    public void searchFrocks() {
        System.out.println("Testcase 4 : Search Frocks");
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = basePage.loadURL("https://www.daraz.lk/#?");
        homePage.typeTextToSearchBox("frocks");

        DarazFrocksPage frocksPage = homePage.clickSearchButton("frocks");
        Assert.assertNotNull(frocksPage, "Frocks page should be loaded");
        frocksPage.scrollPage(browserFactory.getDriver(),0, 200);

        // Select shipped location
        frocksPage.selectShippedFromCheckBox();
        Assert.assertTrue(frocksPage.isShippedFromCheckBoxSelected(), "Shipped from checkbox should be selected");

        // Select service and promotions
        frocksPage.selectServiceAndPromotionsCheckBox();
        Assert.assertTrue(frocksPage.isServiceAndPromotionsCheckBoxSelected(), "Service & promotions should be selected");

        // Select sleeveless
        frocksPage.selectSleevelessCheckBox();
        Assert.assertTrue(frocksPage.isSleevelessCheckBoxSelected(), "Sleeveless checkbox should be selected");

        //Select frock
        frocksPage.selectFrockLink();
        boolean isSelectFrockSuccessful = frocksPage.isSelectFrockSuccessful();
        Assert.assertTrue(isSelectFrockSuccessful, "Frock selection should be successful");
    }

    //Testcase for search ladies watch
    @Test
    public void searchLadiesWatch() {
        System.out.println("Testcase 5 : Search Ladies Watch");
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = basePage.loadURL("https://www.daraz.lk/#?");
        homePage.typeTextToSearchBox("ladies watch");

        DarazLadiesWatchPage ladiesWatchPage = homePage.clickSearchButton("ladies watch");
        Assert.assertNotNull(ladiesWatchPage, "Ladies Watch page should be loaded");
        ladiesWatchPage.scrollPage(browserFactory.getDriver(),0, 200);

        // Select service and promotions
        ladiesWatchPage.selectServiceAndPromotionsCheckBox();
        Assert.assertTrue(ladiesWatchPage.isServiceAndPromotionsCheckBoxSelected(), "Service & promotions should be selected");

        // Select shipped location
        ladiesWatchPage.selectWatchStrapColorCheckBox();
        Assert.assertTrue(ladiesWatchPage.isWatchStrapColorCheckBoxSelected(), "Rose Gold watch strap checkbox should be selected");

        // Select warranty type
        ladiesWatchPage.selectWarrantyTypeCheckBox();
        Assert.assertTrue(ladiesWatchPage.isWarrantyTypeCheckBoxSelected(), "Brand Warranty checkbox should be selected");

        //Select watch
        ladiesWatchPage.selectWatchLink();
        boolean isSelectFrockSuccessful = ladiesWatchPage.isSelectWatchSuccessful();
        Assert.assertTrue(isSelectFrockSuccessful, "Watch selection should be successful");
    }

}
