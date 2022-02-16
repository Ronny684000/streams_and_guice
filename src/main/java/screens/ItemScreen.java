package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ItemScreen extends Screen {

    private ILabel lblBrandName = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemBrand"), "Brand name");
    private ILabel lblOriginalPrice = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemOriginalPrice"), "Original price");
    private ILabel lblDiscountPrice = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemPrice"), "Discount price");
    private ILabel lblDiscountValue = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemDiscount"), "Discount value");
    private ILabel lblSellerName = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerName"), "Seller name");
    private ILabel lblSellerAvatar = AqualityServices.getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/ivSellerAvatar"), "Seller logo");

    public ItemScreen() {
        super(By.id("com.zdv.secretcloset:id/rlSellerInfo"), "Item screen");
    }

    public boolean isItemDisplayed() {
        return lblBrandName.state().waitForDisplayed();
    }

    public void tapSellerLogo() {
        lblSellerAvatar.click();
    }

    public String getOriginalPrice() {
       return lblOriginalPrice.getText();
    }

    public String getDiscountPrice() {
        return lblDiscountPrice.getText();
    }

    public String getDiscountValue() {
        return lblDiscountValue.getText();
    }

    public String getSellerName() {
        return lblSellerName.getText();
    }
}
