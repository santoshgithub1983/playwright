import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://demo.guru99.com/test/newtours/");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}
