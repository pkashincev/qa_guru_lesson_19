package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubTests extends BaseTest {
    private static final String REPOSITORY = "pkashincev/qa_guru_lesson_9";
    private static final String ISSUE_NAME = "My test issue";

    @DisplayName("Поиск Issue в репозитории, лямбда шаги через step")
    @Severity(SeverityLevel.MINOR)
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Test
    void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("input#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $("[data-testid=results-list] [href='/" + REPOSITORY + "']").click();
        });
        step("Переходим на вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Ищем issue с именем " + ISSUE_NAME, () -> {
            $("ul[data-listview-component=items-list]").shouldHave(text(ISSUE_NAME));
        });
    }
}
