package testinium.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import testinium.pages.DummyClass;
import testinium.pages.GittiGidiyorPage;
import testinium.utilities.BrowserUtils;
import testinium.utilities.ConfigurationReader;
import testinium.utilities.Driver;
import testinium.utilities.Log4j;



public class StepDefs {

    GittiGidiyorPage gittiGidiyorPage = new GittiGidiyorPage();
    DummyClass dummyClass = new DummyClass();


    @Given("the user enters the web page")
    public void the_user_enters_the_web_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        dummyClass.acceptCookies.click();


    }

    @Then("user type {string} to search box")
    public void user_type_to_search_box(String string) {

        String bilg = "bilgisayar";
        gittiGidiyorPage.SearchBox.click();
        gittiGidiyorPage.SearchBox.sendKeys(bilg);
        gittiGidiyorPage.BulButton.click();
        BrowserUtils.waitFor(3);


    }

    @Then("user click to second page from search results")
    public void user_click_to_second_page_from_search_results() {
        BrowserUtils.waitForClickablility(gittiGidiyorPage.PageNumberTwo,5);
        gittiGidiyorPage.PageNumberTwo.click();

        BrowserUtils.waitFor(5);

    }

    @Then("the user should be able to see {string} as web page URL")
    public void the_user_should_be_able_to_see_as_web_page_URL(String expectedUrl) {
        BrowserUtils.waitFor(3);
        String actualUrl = Driver.get().getCurrentUrl();
       Assert.assertEquals(expectedUrl, actualUrl);


        //İkinci yol olarak sayfa altındaki sonuç sayfa numaralarından da assert yapılabilir.
        //Assert.assertTrue(gittiGidiyorPage.PageNumberTwo.isSelected());
    }

    @Then("the user choose a random product")
    public void the_user_choose_a_random_product() {
        BrowserUtils.waitFor(2);
        gittiGidiyorPage.clickRandomProduct();
        Log4j.info("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir");
        BrowserUtils.waitFor(3);

    }

    @Then("the user type chosen product's information and price on txt file")
    public void the_user_type_chosen_product_s_information_and_price_on_txt_file() {
        BrowserUtils.waitFor(2);
        gittiGidiyorPage.writeProductInfoToTxtFile();
        Log4j.info("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır");

    }

    @Then("the user add the chosen product to basket")
    public void the_user_add_the_chosen_product_to_basket() {
        gittiGidiyorPage.addToBasket.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user verify that they are same the product price and the product which is in the basket")
    public void the_user_verify_that_they_are_same_the_product_price_and_the_product_which_is_in_the_basket() {

        BrowserUtils.clickWithJS(gittiGidiyorPage.basket);
        BrowserUtils.waitFor(3);
        String basketPrice = gittiGidiyorPage.basketPrice.getText();
        String computerPrice = gittiGidiyorPage.computerPrice.getText();
        if (basketPrice.equals(computerPrice)){
            System.out.println("Step passed.");

        }else{
            System.out.println("Step failed");
        }

    }

    @Then("the user increase the number of product and verify that is {int}")
    public void the_user_increase_the_number_of_product_and_verify_that_is(int amount) {
        BrowserUtils.waitFor(2);
        gittiGidiyorPage.selectAmount(amount);
        BrowserUtils.waitFor(3);

        int actual = Integer.parseInt(gittiGidiyorPage.numberOfComputer.getAttribute("value"));
        Assert.assertEquals(actual,amount);
        BrowserUtils.waitFor(3);

    }

    @Then("the user delete the product and verify that the basket is empty")
    public void the_user_delete_the_product_and_verify_that_the_basket_is_empty() {
        gittiGidiyorPage.delete.click();
        BrowserUtils.waitForVisibility(gittiGidiyorPage.emptyText,10);
        String text ="Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(gittiGidiyorPage.emptyText.getText(),text);
        BrowserUtils.waitFor(3);


    }
}
