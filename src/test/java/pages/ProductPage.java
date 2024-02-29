package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {
    public ProductPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//html")
    public WebElement homePage;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "(//a[@data-product-id='1'])")
    public WebElement firstProduct;

    @FindBy(xpath = "(//a[@data-product-id='2'])")
    public WebElement secondProduct;

    //bu elemente expilicit wait atandığı için kullanılmadı
    @FindBy(xpath= "//*[text()='Continue Shopping']")
    public WebElement continueButton;

    @FindBy(xpath = "//a[text()=' Cart']")
    public WebElement viewCartButton;



}
