package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import model.HomePage;
import model.LoginPage;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class TestCases {
     WebDriver driver;
     WebDriverWait wait;
     LoginPage loginPage;
     HomePage homePage;
     String TEST_DATA_FILE = "TestData.xlsx";
     String filePath = "C:\\Users\\KIIT\\Desktop\\";
 	 String tabname = "TestData";

    @BeforeTest
    public void setUp() {
        // Set up ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Create page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        // Launch the browser and navigate to the URL
        driver.get("https://demo.guru99.com/V4/");
    }

    @Test(priority = 1)
    public void testValidateloginPageTitle() {
        String expectedTitle = "Guru99 Bank Home Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void testValidateUIElements() {
        Assert.assertTrue(loginPage.isUserIdInputDisplayed());
        Assert.assertTrue(loginPage.isPasswordInputDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        Assert.assertTrue(loginPage.isResetButtonDisplayed());
        Assert.assertTrue(loginPage.isSeleniumLinkDisplayed());
        Assert.assertTrue(loginPage.isInsuranceProjectLinkDisplayed());
    }

    @Test(priority = 3)
    public void testLogin() throws IOException {
        FileInputStream fis = new FileInputStream(filePath + TEST_DATA_FILE);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        String userId = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();

        loginPage.login(userId, password);

        //Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");

        workbook.close();
        fis.close();
    }
    
//    @Test(priority = 4)
//    public void testValidateHomepageTitle() {
//    	
//    	String expectedTitle = "Guru99 Bank Manager HomePage";
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, expectedTitle);
//    }
    
    @Test(priority = 4)
    public void testValidateHomepageTitle() {
        String expectedTitle = "Guru99 Bank Manager HomePage";
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Test(priority = 5)
    public void testUIElementsInHomePage() {
        Assert.assertTrue(homePage.isManagerLinkDisplayed());
        Assert.assertTrue(homePage.isNewCustomerLinkDisplayed());
    }
    
    @AfterTest
    public void close() {
        // Close the browser
        driver.quit();
    }

}