import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

    private final static String BASE_URL = "https://booking.com/ ";
    final static String SEARCH_STRING = "Анталья";

    @Test
    public void checkFiveStarsFromBooking() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.closeCookieClick()
                .searchAndSelectCity(SEARCH_STRING)
                .clickSearchButton();
        SearchPage searchPage = new SearchPage();
        searchPage.checkingTheInput()
                .closeModalWindow()
                .clickFiveStars()
                .checkingTheFiveStars();
    }

    @Test
    public void checkingTheDataCompliance() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.closeCookieClick()
                .searchAndSelectCity(SEARCH_STRING)
                .clickActualDates()
                .clickSearchButton();
        SearchPage searchPage = new SearchPage();
        searchPage.closeModalWindow()
                .clickOnTheMap();
        MapPage mapPage = new MapPage();
        mapPage.hoverOnFirstChild();
        String valueOneBefore = mapPage.hotelNameBefore();
        String valueTwoBefore = mapPage.hotelCoastBefore();
        String valueThreeBefore = mapPage.hotelRatingBefore();
        String valueFourBefore = mapPage.hotelReviewsBefore();
        mapPage.clickOnHotelMarker();
        HotelPage hotelPage = new HotelPage();
        String valueOneAfter = hotelPage.hotelNameFactAfter();
        String valueTwoAfter = hotelPage.hotelCostFactAfter();
        String valueThreeAfter = hotelPage.hotelRatingFactAfter();
        String valueFourAfter = hotelPage.hotelReviewsFactAfter();
        Assertions.assertEquals(valueOneBefore, valueOneAfter);
        Assertions.assertEquals(valueTwoBefore, valueTwoAfter);
        Assertions.assertTrue(valueThreeBefore.matches(valueThreeAfter));
        Assertions.assertEquals(valueFourBefore, valueFourAfter);
    }

}
