package or.shop.context;

import og.shop.ShopApplication;
import og.shop.configuration.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ShopApplication.class})
class ContextTests {

    @Autowired
    private AppConfig appConfig;

    @Test
    void contextLoads() {
        assertNotNull(appConfig, () -> "Application Context not loading properly");
    }
}