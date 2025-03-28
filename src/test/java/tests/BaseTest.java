package tests;

import config.ConfigApplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeAll
    static void setBrowserConfig() {
        ConfigApplier configApplier = new ConfigApplier();
        configApplier.applyConfig();
    }

    @AfterEach
    void close() {
        closeWebDriver();
    }
}