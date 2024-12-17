import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class HotelPage {
    private final SelenideElement hotelNameFact = $x("//div[@class='hp__hotel-title pp-header']//h2");
    private final SelenideElement hotelRatingFact = $x("//div[@data-testid='review-score-right-component']//div[contains(text(),'Оценка')][1]");
    private final SelenideElement hotelReviewsFact = $x("//div[@data-testid='review-score-right-component']//div[contains(text(),'отзыв')]");
    private final SelenideElement hotelCostFact = $x("//table[@id='hprt-table']//tr[1]//span[contains(text(),'руб')]");

    public String hotelNameFactAfter() {
        return hotelNameFact.getText();
    }

    public String hotelCostFactAfter() {
        return hotelCostFact.getText();
    }

    public String hotelRatingFactAfter() {
        return hotelRatingFact.getText();
    }

    public String hotelReviewsFactAfter() {
        return hotelReviewsFact.getText();
    }
}
