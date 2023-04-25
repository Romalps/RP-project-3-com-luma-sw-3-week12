package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {


    // This method will find element and click
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // This method find element and send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // This method find element and  return the text
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    // ******************************* Assert Method**********************
    public void assertMethod(By by, String expectedMessage) {
        WebElement actualTextElement = driver.findElement(by);
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    // ***************************** Actions Method for Mouse Hover  ***********************
    public void actionsMethodForMouseHover(By by1,By by2,By by3) {
        WebElement element_1 = driver.findElement(by1);
        WebElement element_2 = driver.findElement(by2);
        WebElement element_3 =driver.findElement(by3);
        Actions actions = new Actions(driver);
        actions.moveToElement(element_1).moveToElement(element_2).moveToElement(element_3).click().build().perform();
    }

    public void actionsMethodFor2MouseHover(By by1, By by2){
        WebElement element1=driver.findElement(by1);
        WebElement element2=driver.findElement(by2);
        Actions actions=new Actions(driver);
        actions.moveToElement(element1).moveToElement(element2).click().build().perform();
    }
    public void actionsMethodForOneMouseHover(By by){
        WebElement element=driver.findElement(by);
        Actions actions= new Actions(driver);
        actions.moveToElement(element).perform();
    }
    //*************************  Select Methods   **************************

    public void selectByVisibleTextFromDropDown(By by, String text) {

        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // select by visible text
        select.selectByVisibleText(text);

    }



}
