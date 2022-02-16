import aquality.appium.mobile.application.AqualityServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class BaseTest {

    @BeforeEach
    void setUp() {
        AqualityServices.getApplication();
    }

    @AfterEach
    void tearDown() {
        AqualityServices.getApplication().quit();
    }
}
