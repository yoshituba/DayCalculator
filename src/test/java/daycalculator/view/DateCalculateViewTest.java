package daycalculator.view;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class DateCalculateViewTest {

    @BeforeClass
    public static void setUp(){
        // タイムアウトの時間を5000ミリ秒にする(デフォルト:4000ミリ秒)
        Configuration.timeout = 5000;

        // ベースURLを変更する (デフォルト:http://localhost:8080)
        Configuration.baseUrl = "http://localhost:8080/datecalculate/";

        // テスト実行後にブラウザを開いたままにする
        Configuration.holdBrowserOpen = true;
    }

    @Before
    public void  setUpTest(){
        open("http://localhost:8080/datecalculate/");
    }
    @Test
    public void 計算画面で計算基準日に20181201を入れて結果が一覧取得できること() {
        $(By.id("baseDate")).setValue("2018/12/01");

        $(By.id("calculateBtn")).click();

        $(By.cssSelector("table tbody")).shouldBe(visible);

    }
}
