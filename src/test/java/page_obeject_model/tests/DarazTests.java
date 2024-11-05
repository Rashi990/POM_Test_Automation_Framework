package page_obeject_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import page_obeject_model.pages.BasePage;
import page_obeject_model.pages.DarazHeadphonesPage;
import page_obeject_model.pages.DarazHomePage;
import page_obeject_model.pages.DarazShoesPage;
import page_obeject_model.utilities.Utilities;

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
    }



}
