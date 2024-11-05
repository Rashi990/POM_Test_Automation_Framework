package page_obeject_model.utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Utilities {

    protected BrowserFactory browserFactory;

    @BeforeTest
    public void initialize_browser(){
        browserFactory = BrowserFactory.getBrowserFactory();
        browserFactory.getDriver().manage().window().maximize();
        browserFactory.getDriver().get("https://www.daraz.lk/#?");
    }

    @AfterTest
    public void close_browser(){
        browserFactory.getDriver().quit();
    }
}
