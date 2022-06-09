package testinium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testinium.utilities.Driver;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class GittiGidiyorPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Keşfetmeye Bak']")
    public WebElement SearchBox;

    @FindBy(xpath = "//span[normalize-space()='BUL']")
    public WebElement BulButton;

    @FindBy (xpath = "//span[normalize-space()='2']")
    public WebElement PageNumberTwo;

    @FindBy(xpath="//div[@data-cy='pageinfo']/../div[3]//li")
    public List<WebElement> productList;


   public WebElement getSearchPageElement(int i){
        WebElement element = Driver.get().findElement(By.xpath("//li[@data-testid]["+i+"]//span"));
        return element;
    }
    public void clickRandomProduct (){
        Random rd = new Random();
        int randomProduct = rd.nextInt(productList.size());
        productList.get(randomProduct).click();
    }
    public void refreshPage(){
        try {
            if (pageNotFoundError.getText().equals("Sayfa Bulunamadı.")){
                Driver.get().navigate().refresh();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void writeProductInfoToTxtFile(){
        String url ="src/test/resources/product.txt";
        File file=new File(url);
        try {
            file.createNewFile();
            FileWriter myWriter = new FileWriter( file.getAbsolutePath());

            myWriter.write("Ürün Bilgisi: " + productInfo.getText() + "\nÜrün Fiyatı: "+productPrice.getText());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FindBy(css="#sp-subTitle")
    public WebElement productInfo;

    @FindBy(xpath="//div[@id='sp-price-container']")
    public WebElement productPrice;

    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement addToBasket;

    @FindBy(xpath = "//div[normalize-space()='Sepetim']")
    public WebElement basket;

    @FindBy(css = "div[class='total-price'] strong")
    public WebElement computerPrice;

    @FindBy(css = ".gg-d-8.gg-m-10.detail-price")
    public WebElement basketPrice;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement numberOfComputer;

    public void selectAmount(int amount){
        Select dropdownAmount = new Select(numberOfComputer);
        dropdownAmount.selectByIndex(amount-1);
    }

    @FindBy(xpath = "//a[@title='Sil']")
    public WebElement delete;

    @FindBy(xpath = "//*[@id='empty-cart-container']//h2")
    public WebElement emptyText;



}
