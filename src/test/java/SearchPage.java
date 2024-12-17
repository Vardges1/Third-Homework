import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    private final SelenideElement searchForm = $x("//input[@placeholder='Куда вы хотите поехать?']");
    private final SelenideElement checkBoxFiveStars = $x("//div[@data-filters-item='class:class=5']//input");
    private final SelenideElement buttonMap = $x("//button[@data-map-trigger-button='1']");
    private final ElementsCollection itemList = $$x("//div[./div[@data-testid='rating-stars']]");
    private final SelenideElement closeButton = $x("//button[@aria-label='Скрыть меню входа в аккаунт.']");

    public SearchPage checkingTheInput() {
        searchForm.shouldHave(value("Анталья"));
        return this;
    }

    public SearchPage closeModalWindow() {
        closeButton.click();
        return this;

    }

    public SearchPage clickFiveStars() {
        checkBoxFiveStars.scrollTo();
        checkBoxFiveStars.click();
        return this;
    }

    public SearchPage checkingTheFiveStars() {
        String firstAttributeValue = itemList.first().getAttribute("aria-label");
        itemList.forEach(element -> {
            String attributeValue = element.getAttribute("aria-label");
            assert attributeValue != null;
            if (!attributeValue.equals(firstAttributeValue)) {
                System.out.println("Не у всех отелей отображается 5 звезд");
            }
        });
        return this;
    }

    public SearchPage clickOnTheMap() {
        buttonMap.click();
        return this;
    }

}
