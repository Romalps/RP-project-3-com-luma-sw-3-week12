package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldAddProductSuccessfullyToSHoppingCart() throws InterruptedException {
        // * Mouse Hover on Gear Menu
        //* Click on Bags

        actionsMethodFor2MouseHover(By.cssSelector("a[id='ui-id-6'] span:nth-child(2)"),By.cssSelector("a[id='ui-id-25'] span"));
        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //* Verify the text ‘Overnight Duffle’
        assertMethod(By.xpath("//span[@class='base']"), "Overnight Duffle");
        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        assertMethod(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Overnight Duffle to your shopping cart.");

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[@class='action showcart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));
        //* Verify the product name ‘Overnight Duffle’
        assertMethod(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
        Thread.sleep(2000);
        //* Verify the Qty is ‘3’
        //assertMethod(By.cssSelector(".input-text.qty"), "3");
        String expectedMessage= "3";
        WebElement actualTextElement = driver.findElement(By.cssSelector(".input-text.qty"));
        String actualMessage= actualTextElement.getAttribute("value");
        Assert.assertEquals(expectedMessage,actualMessage);

        //* Verify the product price ‘$135.00’
        assertMethod(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"), "$135.00");
        //* Change Qty to ‘5’
        driver.findElement(By.cssSelector(".input-text.qty")).clear();
        sendTextToElement(By.cssSelector(".input-text.qty"), "5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //* Verify the product price ‘$225.00’
        assertMethod(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"), "$225.00");
    }


    @After
    public void tearDrop() {
        closeBrowser();
    }


}
