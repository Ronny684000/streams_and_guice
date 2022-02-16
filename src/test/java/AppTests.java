import org.junit.jupiter.api.Test;
import screens.ItemScreen;
import screens.MainScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTests extends BaseTest {

    private static final String CITY = "London";

    @Test
    void case1() {
        MainScreen mainScreen = new MainScreen();
        mainScreen.tapCityLabel();
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        selectCityScreen.tapDoNotShowAgain();
        selectCityScreen.typeInSearchField(CITY);
        selectCityScreen.findAndTapOptionByName(CITY);
        assertThat(mainScreen.isCityEquals(CITY)).isTrue();
        String itemOriginalPrice = mainScreen.getOriginalPrice();
        String itemDiscountPrice = mainScreen.getDiscountPrice();
        String itemDiscountValue = mainScreen.getDiscountValue();
        mainScreen.tapOnItem();
        ItemScreen itemScreen = new ItemScreen();
        assertThat(itemScreen.isItemDisplayed()).isTrue();
        assertThat(itemScreen.getOriginalPrice()).isEqualTo(itemOriginalPrice);
        assertThat(itemScreen.getDiscountPrice()).isEqualTo(itemDiscountPrice);
        assertThat(itemScreen.getDiscountValue()).isEqualTo(itemDiscountValue);
        String sellerName = itemScreen.getSellerName();
        itemScreen.tapSellerLogo();
        SellerScreen sellerScreen = new SellerScreen();
        assertThat(sellerScreen.getSellerCity()).isEqualTo(CITY);
        assertThat(sellerScreen.getSellerName()).isEqualTo(sellerName);
    }
}
