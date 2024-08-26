package org.example.skyhms.Pages;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class StoresPage {
    private WebDriver driver;

    private By selectForms = By.xpath("//*[text()=\"Go To Form\"]");
    private By newPurchaseOrder = By.xpath("//*[text()=\"New Purchase Order\"]");
    private By selectVendor = By.xpath("//*[contains(@title,'Select Vendor')]");
    private By enterVendorName = By.xpath("//*[@id=\"page-top\"]/span/span/span[1]/input");
    private By checkVendor = By.xpath("//*[@id=\"select2-vendor-container\"]");
    private By payTerms = By.id("select2-payterms-container");
    private By enterPayterms = By.xpath("/html/body/span/span/span[1]/input");
    private By datePicker = By.id("flatpickrorder");
    private By creditDays = By.id("creditduration");
    private By addItemBtn = By.id("item_row_add");
    private By selectItem = By.id("select2-itemsrow-1-itemname-container");
    private By enterItem = By.xpath("//*[@id=\"page-top\"]/span/span/span[1]/input");
    private By enterQty = By.id("itemsrow-1-appqty");


    public StoresPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToForm(){
        driver.findElement(selectForms).click();
    }

    public void clickPurchaseOrder(){
        driver.findElement(newPurchaseOrder).click();
    }

    public void clickSelectVendor() {
        driver.findElement(selectVendor).click();
    }


    public void enterVendor(String vendor){
        driver.findElement(enterVendorName).sendKeys(vendor+ Keys.ENTER);
    }


    public String checkVendorName(){
        return driver.findElement(checkVendor).getText();
    }

    public void selectPayTerms(){
        driver.findElement(payTerms).click();
    }

    public void enterPayTerms(){
        driver.findElement(enterPayterms).sendKeys("credit"+Keys.ENTER);
    }

    public void selectDatePicker(){
        driver.findElement(datePicker).click();
        String script = "document.getElementById('flatpickrorder').value = '2024-08-20';";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    public void enterCreditDays(){
        driver.findElement(creditDays).sendKeys("30");
    }

    public void clickAddItembtn(){
        driver.findElement(addItemBtn).click();

    }
    public void scrollUpTillEleVisible() throws InterruptedException {
        WebElement elementToBeVisible = driver.findElement(By.id("item_row_add")); // Replace with your element's locator

        // Scroll up until the element is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;

//            if (elementToBeVisible.isDisplayed()) {
//                break; // Exit loop if the element is visible
//            }
            js.executeScript("window.scrollBy(0, -10000);"); // Scroll up by 100 pixels
            // Optionally wait for a short period to ensure scrolling
            Thread.sleep(500);
    }

    public void selectItemDropdown(List<String[]> itemName, String[] itemQty) throws InterruptedException {

        for(int i=0;i<=50;i++){

            String itemname = Arrays.toString(itemName.get(i));
            String itemname1= itemname.replace("[", "").replace("]", "");
            String quantity = itemQty[i];
            scrollUpTillEleVisible();
            //element.click()
            clickAddItembtn();
            String dynamicItem = "select2-itemsrow-" + (i+1) + "-itemname-container";
            driver.findElement(By.id(dynamicItem)).click();
            driver.findElement(enterItem).sendKeys(itemname1 + Keys.ENTER);
            String dynamicQty = "itemsrow-" + (i+1) + "-appqty";
            driver.findElement(By.id(dynamicQty)).sendKeys(quantity + Keys.ENTER);
            Thread.sleep(1000);
        }
    }


}
