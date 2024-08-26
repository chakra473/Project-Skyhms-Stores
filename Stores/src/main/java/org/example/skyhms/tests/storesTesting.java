package org.example.skyhms.tests;

import org.example.skyhms.Pages.DashboardPage;
import org.example.skyhms.Pages.StoresPage;
import org.example.skyhms.base.BaseTest;

import org.example.skyhms.Pages.LoginPage;
import org.example.skyhms.data.StoresData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class storesTesting extends BaseTest {

    @Test(enabled = false)
    public void testLoginSuccess() throws InterruptedException {
        driver.get("https://devnew.skyhms.in/login/");

        LoginPage loginPage = new LoginPage(driver);

        // Enter valid credentials
        loginPage.enterPropertyid("dev");
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLoginButton();

        Thread.sleep(1000);
        // Wait and assert successful login
        // You might want to add WebDriverWait here for dynamic content

        // Check for a successful login indicator (e.g., URL or element)
        String expectedUrl = "https://devnew.skyhms.in/login/Dashboard"; // Adjust based on actual URL after login
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login was not successful");
    }

    @Test(enabled = false)
    public void testLoginFailure() throws InterruptedException {
        driver.get("https://devnew.skyhms.in/login/");

        LoginPage loginPage = new LoginPage(driver);

        // Enter invalid credentials
        loginPage.enterUsername("invalid-username");
        loginPage.enterPassword("invalid-password");
        loginPage.clickLoginButton();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText); // Print the alert text
        alert.accept(); // Click the "OK" button

        // Wait and assert failed login
        // You might want to add WebDriverWait here for dynamic content

        // Assert error message
//        String expectedErrorMessage = "Invalid credentials"; // Adjust based on actual error message
//        String actualErrorMessage = loginPage.getErrorMessage();
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not displayed correctly");
        String expectedUrl = "https://devnew.skyhms.in/login/"; // Adjust based on actual URL after login
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login was not successful/incorrect user credentials");
    }

    @Test(enabled = false)
    public void testDashboard() throws InterruptedException {
        testLoginSuccess();
        DashboardPage dashboardPage= new DashboardPage(driver);
        String actualResult = dashboardPage.clickDashboard();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult,"Current page is not in dashboard");

    }
    @Test(enabled = false)
    public void testStoresUrl() throws InterruptedException {
        testDashboard();
        DashboardPage dashboardPage= new DashboardPage(driver);
        String actualTitle = dashboardPage.clickStores();
        String expectedTitle = "Stores";
        Assert.assertEquals(actualTitle,expectedTitle,"landed on incorrect page");
    }
     // Corresponding quantities
    String vendorName="Mathu";
//    @DataProvider(name = "vendor name")
//    public Object[][] loginDataProvider() {
//        return new Object[][] {
//                { "Mathu"},
//                { "Sulakshana"},
//                { "Samson"}
//        };
//    }


    @Test
    public void testPurchaseOrder() throws InterruptedException {
        testStoresUrl();
        StoresPage storesPage= new StoresPage(driver);
        storesPage.goToForm();
        storesPage.clickPurchaseOrder();
        storesPage.clickSelectVendor();
        storesPage.enterVendor("Mathu");
        String actualVendor = storesPage.checkVendorName();
        Assert.assertEquals(actualVendor, vendorName,"entered vendor name is incorrect");
        storesPage.selectPayTerms();
        storesPage.enterPayTerms();
        storesPage.selectDatePicker();
        storesPage.enterCreditDays();
        String[] itemNames = {"Idly", "Sambar Idly", "Vada"}; // Add more item names as needed
        String[] quantities = new String[100];
        int j=1;
        for(int i=0;i<=50;i++){
            quantities[i]= String.valueOf(j);
        };
        StoresData storesData=new StoresData();
        List<String[]> itemNameList = storesData.ItemList();
        storesPage.selectItemDropdown(itemNameList,quantities);


    }

}
