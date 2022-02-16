package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.time.Duration;

public class MainScreen extends Screen {

    private ILabel cityLabel = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "City label");
    private ILabel item = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//android.widget.TextView[starts-with(@text, 'MICHAEL KORS')]/parent::*"), "Item");
    private ILabel itemOriginalPrice = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"), "Item price");
    private ILabel itemDiscountPrice = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout[2]/android.widget.TextView"), "Item discount price");
    private ILabel itemDiscountValue = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvDiscount"), "Item discount");
    private String cityLabelTemplate = "//android.widget.TextView[starts-with(@text, '%s')]";

    public MainScreen() {
        super(By.xpath("//android.widget.TextView[starts-with(@text, 'SecretCloset')]"), "Main screen");
    }

    public void tapCityLabel() {
        cityLabel.click();
    }

    public boolean isCityEquals(String expectedCity) {
        ILabel changedCityLabel = AqualityServices.getElementFactory().getLabel(By.xpath(String.format(cityLabelTemplate, expectedCity)), "City label with changed name");
        return changedCityLabel.state().waitForDisplayed(Duration.ofSeconds(10));
    }

    public void tapOnItem() {
        item.click();
    }

    public String getOriginalPrice() {
        return itemOriginalPrice.getText();
    }

    public String getDiscountPrice() {
        return itemDiscountPrice.getText();
    }

    public String getDiscountValue() {
        return itemDiscountValue.getText();
    }
}
