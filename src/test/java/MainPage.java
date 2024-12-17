import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@name ='ss']");
    private final SelenideElement buttonSearch = $x("//button[@type='submit']");
    private final SelenideElement divLetter = $x("//*[@id='autocomplete-result-0']/div/div/span");
    private final SelenideElement closeCookie = $x("//button[@id='onetrust-reject-all-handler']");
    private final ElementsCollection dropper = $$x("//ul[@role='group']");
    private final ElementsCollection actualDates = $$x("//td//span[@class=\"cf06f772fa ef091eb985\"]");

    public MainPage clickActualDates(){
        actualDates.get(1).scrollTo().click();
        actualDates.get(4).scrollTo().click();
        return this;
    }


    public MainPage(String url) { 
        Selenide.open(url);
    }

    public MainPage searchAndSelectCity(String searchString) {
        textBoxInput.sendKeys(searchString);
        dropper.get(0).shouldHave(Condition.text(searchString));
        divLetter.click();
        return this;
    }

    public MainPage clickSearchButton() {
        buttonSearch.click();
        return this;
    }

    public MainPage closeCookieClick() {
        if (closeCookie.isDisplayed()) {
            closeCookie.click();
        }
        return this;
    }
}
