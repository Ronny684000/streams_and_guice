package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SellerScreen extends Screen {

    private ILabel lblSellerCity = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city");
    private ILabel lblSellerName = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget." +
                    "RelativeLayout/android.view.ViewGroup/android.widget.TextView"), "Seller city");

    public SellerScreen() {
        super(By.xpath("com.zdv.secretcloset:id/textView51"), "Seller screen");
    }

    public String getSellerCity() {
        return lblSellerCity.getText();
    }

    public String getSellerName() {
        return lblSellerName.getText();
    }
}
