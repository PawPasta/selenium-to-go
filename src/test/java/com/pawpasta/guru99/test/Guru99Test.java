package com.pawpasta.guru99.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.*;

class Guru99Test {

    //TEST CASE KIỂM THỬ CHỨC NĂNG LOGIN CHẠY ĐÚNG  HAY KHÔNG VỚI ACC MANAGER
    //Test case #1: Verify Login Function With A Valid Manager Account
    // Step/Procedures:
    // 1. Open a certain browser, e.g. Chrome, FireFox, Edge
    // 2. Type the following URL to reach the Demo Guru 99 login page:
    //               https://demo.guru99.com/V4/
    // 3. Input a valid Manager account , e.g. user/pass:	mngr598895/ebYqybu
    // 4. Hit enter to activate the login process

    //Expected Result:
    // 2. The login page appears with 3 existing elements regarding to
    //              the login process
    //              username textbox, password textbox, login button
    // 4. The manager dashboard appears with a welcome message included
    // under the format:
    //          Manager Id: <mã-số-user-login>

    //Status: Passed / Failed

    //NẾU TEST CASE NÀY ĐƯỢC RUN BẰNG TAY, THEO ĐÚNG BƯỚC MÔ TẢ, NHẬP VÀ NHẤN NUÚT
    //VÀ ĐỌC MÀN HÌNH ĐỂ SO SÁNH KẾT QUẢ TRẢ VỀ CÓ NHƯ KÌ VỌNG HAY KHÔNG -->
    // MANUAL TEST

    //NẾU TEST CASE NÀY DĐƯỢC RUN BẰNG CODE, CODE TỰ MỞ TRÌNH DUYỆT, CODE TÌM
    //Ô NHẬP RỒI GÕ DATA, CODE TỰ SO SÁNH GIÁ TỊ TRẢ VỀ VÀ EXPECTED
    //KĨ THUẬT NÀY GỌI LÀ AUTOMATION TEST
    //ĐỂ LÀM AUTO TA CHỈ CẦN SELENIUM VÀ NHỮNG TOOL TƯƠNG ĐƯƠNG: APPIUM, PLAYWRIGHT, CYPRESS ...)
    //VÀ KÈM THÊM, KÉ THÊM JUNIT ĐỂ SO SÁNH XANH ĐỎ, ĐỂ LÀM CI

    //KHAI BÁO BIẾN TRÌNH DUYỆN myBROWSER DÙNG CHUNG CHO NHIỀU HÀM @TEST
    private static WebDriver myBrowser; // Chua new được vì thiếu phần settings
    //trỏ tới file .exe, mở ẩn danh ...

    @Test
    public void testLoginGivenManagerValidManagerAccountReturnsWell() throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/V4/");
        //Nhap user va password vao trang login va nhan enter va check message
        // Ta phai di tim cac tag trong trang login tuong ung

        WebElement userTextBox = myBrowser.findElement(By.name("uid"));
        userTextBox.sendKeys("mngr598895");

        WebElement passwordTextBox = myBrowser.findElement(By.name("password"));
        passwordTextBox .sendKeys("ebYqybu");

        WebElement loginButton = myBrowser.findElement(By.name("btnLogin"));
        loginButton.click();

        //Neu login thanh cong thi phia chao mung Manager Id: mngr598895
        //Login thanh cong sang tarng moi, va ta di tim tag welcome
        //O trang moi, tuc la myBrowser phai cho 1 xiu de trang moi tai ve
        // Khai niem wait ra doi
        //Khong co wait() khi chuyen trang, 99.9% loi khong tim thay tag

        Thread.sleep(3000);

        WebElement welcomeMsgTag = myBrowser.findElement(By.cssSelector("tr.heading3 > td:nth-child(1)"));
        String expectedMessage = "Manger Id : mngr598895";
        String actualMessage = welcomeMsgTag.getText();
        //<h1>Chu bu nhen</h1> -> Chu bu nhen la getText() tuc la content
        //ben trong 1 tag

        assertEquals(expectedMessage, actualMessage);
        System.out.println("Actual Msg" + actualMessage);
    }

    //Đây là 1 hàm đặc biệt (@BeforeAll) mà nó được tự động bởi JVM
    //Và nó chạy trước tất cả các test
    //Dùng để: thiết lập các biến, các giá trị default, khởi động
    @BeforeAll
    public static void  setUp() {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("--lang=en-GB");
        myBrowser = new FirefoxDriver(options);

        myBrowser.manage().window().maximize();

    }
    // Dùng để dọn dẹp các connection, clear data rác đã thêm vào khi ta run các test
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        myBrowser.quit();
    }
}