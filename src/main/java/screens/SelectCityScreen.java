package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SelectCityScreen extends Screen {

    private ITextBox searchField = AqualityServices.getElementFactory()
            .getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "Search field");
    private IButton btnDoNotShowAgain = AqualityServices.getElementFactory()
            .getButton(By.id("android:id/button2"), "Button 'Do not show again'");
    private ILabel option;

    public SelectCityScreen() {
        super(By.xpath("//android.widget.TextView[starts-with(@text, 'Select city')]"), "Select city screen");
    }

    public void typeInSearchField(String stringToType) {
        searchField.clearAndType(stringToType);
    }

    public void tapDoNotShowAgain() {
        btnDoNotShowAgain.click();
    }

    public void findAndTapOptionByName(String name) {
        option = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format("//android.widget.TextView[starts-with(@text, 'London')]", name)), "Option");
        option.click();
    }

}
