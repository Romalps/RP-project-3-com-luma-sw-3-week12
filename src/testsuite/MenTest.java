package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldAddProductSuccessfullyToShoppingCart() {

        // * Mouse Hover on Men Menu
        //* Mouse Hover on Bottoms
        //* Click on Pants
        actionsMethodForMouseHover(By.xpath("//span[normalize-space()='Men']"), By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"), By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //* Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on size 32.
        actionsMethodForOneMouseHover(By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='products wrapper grid products-grid']/ol[@class='products list items product-items']/li[1]/div[1]"));
        clickOnElement(By.cssSelector("body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        actionsMethodForOneMouseHover(By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='products wrapper grid products-grid']/ol[@class='products list items product-items']/li[1]/div[1]"));

        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        actionsMethodForOneMouseHover(By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='products wrapper grid products-grid']/ol[@class='products list items product-items']/li[1]/div[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));

        //* Verify the text 'You added Cronus Yoga Pant to your shopping cart.’
        assertMethod(By.xpath("//div[@class='message-success success message']"), "You added Cronus Yoga Pant to your shopping cart.");

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[@class='action showcart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));

        //* Verify the text ‘Shopping Cart.’
        assertMethod(By.xpath("//span[@class='base']"), "Shopping Cart");
        //* Verify the product name ‘Cronus Yoga Pant’
        assertMethod(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");

        //* Verify the product size ‘32’
        assertMethod(By.xpath("//dd[contains(text(),'32')]"), "32");

        //* Verify the product colour ‘Black’
        assertMethod(By.xpath("//dd[contains(text(),'Black')]"), "Black");

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
