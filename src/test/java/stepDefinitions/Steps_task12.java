package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class Steps_task12 extends ReusableMethods{
    ProductPage locate=new ProductPage();
    CartPage cartPage=new CartPage();
    Actions actions;
    WebDriverWait wait;
    @Given("User goes to homePage")
    public void userGoesToHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertTrue(locate.homePage.isDisplayed());
    }
    @Then("Click {string} button")
    public void click_button(String arg) throws InterruptedException {

        if (arg.equals("Products")){
            showElementWithFrame("//a[@href='/products']");
           locate.productsButton.click();
           Thread.sleep(2000);
           Driver.getDriver().navigate().refresh();

        } else if (arg.equals("View Cart")) {
            showElementWithFrame("//a[text()=' Cart']");
            locate.viewCartButton.click();
        }

    }

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        Assert.assertTrue(cartPage.product1.isDisplayed() && cartPage.product2.isDisplayed());

    }
    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() throws InterruptedException {
        Assert.assertTrue(cartPage.price1.isDisplayed() && cartPage.price2.isDisplayed());
        Assert.assertTrue(cartPage.quantity1.isDisplayed() && cartPage.quantity2.isDisplayed());
        Assert.assertTrue(cartPage.total1.isDisplayed() && cartPage.total2.isDisplayed());

        int price1=Integer.parseInt(cartPage.price1.getText().split(" ")[1]);
        int price2=Integer.parseInt(cartPage.price2.getText().split(" ")[1]);
        System.out.println("price1 :"+price1+",  price2 :"+price2);
        int quantity1=Integer.parseInt(cartPage.quantity1.getText());
        int quantity2=Integer.parseInt(cartPage.quantity2.getText());
        int total1=Integer.parseInt(cartPage.total1.getText().split(" ")[1]);
        int total2=Integer.parseInt(cartPage.total2.getText().split(" ")[1]);
        System.out.println("total1 :"+total1+",  total2 :"+total2);

        showElementWithFrame("(//td[@class='cart_total'])[1]");
        Thread.sleep(1000);
        showElementWithFrame("(//td[@class='cart_total'])[2]");

        Assert.assertTrue(total1==price1*quantity1);
        Assert.assertTrue(total2==price2*quantity2);

    }


    @Then("user scrolls down the page")
    public void userScrollsDownThePage() throws InterruptedException {
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
    }

    @And("Hover over {string} product and click Add to cart")
    public void hoverOverProductAndClickAddToCart(String arg0) throws InterruptedException {
        wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        if (arg0.equals("first")){
            showElementWithFrame("(//a[@data-product-id='1'])");
            locate.firstProduct.click();
        } else if (arg0.equals("second")) {
            showElementWithFrame("(//a[@data-product-id='2'])");
            locate.secondProduct.click();
        }
        //Continue button açılan pencerede olduğu için explicit wait kullanıldı
        WebElement continueButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Continue Shopping']")));
        continueButton.click();

    }


}
