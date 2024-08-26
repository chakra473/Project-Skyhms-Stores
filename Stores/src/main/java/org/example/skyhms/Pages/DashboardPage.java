package org.example.skyhms.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class DashboardPage {

    private WebDriver driver;

    private By dashboard= By.xpath("//*[contains(p,\"Dashboard\")]");
    private By storesUrl= By.xpath("//*[contains(@src,\"stores\")]");

    public DashboardPage(WebDriver driver){

        this.driver = driver;
    }

    public String clickDashboard(){
        driver.findElement(dashboard).click();
        return driver.getTitle();

    }

    public String clickStores(){
        driver.findElement(storesUrl).click();
        // Get the list of window handles
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab (the last handle in the list)
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        return driver.getTitle();
    }



}
