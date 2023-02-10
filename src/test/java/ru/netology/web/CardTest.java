package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CardTest {
    @Test
    void test() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");

        $("[data-test-id='city'] input").setValue("Чебоксары");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue("15.03.2023");
        $("[data-test-id='name'] input").setValue("Владимир Семенов");
        $("[data-test-id='phone'] input").setValue("+79383893838");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на 15.03.2023"));
    }
}

