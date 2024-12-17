import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MapPage {
    private final SelenideElement parentElement = $x("//div[@data-capla-component-boundary='b-search-web-searchresults/PropertiesListMap']//ul//li[1]");
    private final SelenideElement hotelName = $x("//div[@data-capla-component-boundary='b-search-web-searchresults/PropertiesListMap']//ul//li[1]//h2");
    private final SelenideElement hotelCoast = $x("//div[@data-capla-component-boundary='b-search-web-searchresults/PropertiesListMap']//ul//li[1]//span[contains(text(),'руб')][2]");
    private final SelenideElement hotelRating = $x("//div[@data-capla-component-boundary='b-search-web-searchresults/PropertiesListMap']//ul//li[1]//div[contains(text(),'Оценка')]");
    private final SelenideElement hotelReviews = $x("//div[@data-capla-component-boundary='b-search-web-searchresults/PropertiesListMap']//ul//li[1]//div[contains(text(),'отзыв')]");

    public MapPage hoverOnFirstChild() {
        parentElement.hover();
        return this;
    }

    public String hotelNameBefore() {
        return hotelName.getText();
    }


    public String hotelCoastBefore() {
        return hotelCoast.getText();
    }

    public String hotelRatingBefore() {
        return hotelRating.getText();
    }

    public String hotelReviewsBefore() {
        return hotelReviews.getText();
    }

    public MapPage clickOnHotelMarker() {
        parentElement.click();
        switchTo().window(1);
        return this;
    }

}
