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
        open("https://www.google.co.jp/");
    }
    @Test
    public void test() {
//        // Googleトップページ
//        // "selenide"を検索
//        open("https://www.google.co.jp/");
//        $("#lst-ib").val("selenide").pressEnter();
//
//        // 検索ページ
//        // Selenideの公式ページをクリック
//        $(By.linkText("Selenide: concise UI tests in Java")).click();
//
//        // Selenide公式ページ
//        // 「What is Selenide?」という文言があることを確認
//        $("body").shouldHave(text("What is Selenide?"));
    }
}
