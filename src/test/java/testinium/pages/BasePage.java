package testinium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testinium.utilities.Driver;


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//span[normalize-space()='Kapat']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//input[@placeholder='Keşfetmeye Bak']")
    public WebElement SearchBox;

    @FindBy(xpath = "//h1[.='Sayfa Bulunamadı.']")
    public WebElement pageNotFoundError;


}

