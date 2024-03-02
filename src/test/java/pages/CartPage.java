package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement product1;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    public WebElement product2;

    @FindBy(xpath = "(//td[@class='cart_price'])[1]")
    public WebElement price1;

    @FindBy(xpath = "(//td[@class='cart_price'])[2]")
    public WebElement price2;

    @FindBy(xpath = "(//td[@class='cart_quantity'])[1]")
    public WebElement quantity1;

    @FindBy(xpath = "(//td[@class='cart_quantity'])[2]")
    public WebElement quantity2;

    @FindBy(xpath = "(//td[@class='cart_total'])[1]")
    public WebElement total1;

    @FindBy(xpath = "(//td[@class='cart_total'])[2]")
    public WebElement total2;



}
