
import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class nonincognitomode {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Playwright playwright = Playwright.create();
       // Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setChannel("chrome").setArgs(arguments).setViewportSize(null));

        Page page = browserContext.newPage();
        page.navigate("https://demo.guru99.com/test/newtours/");
        System.out.println(page.title());
        page.locator("//input[@name='userName']").fill("mercury");
        page.locator("//input[@name='password']").fill("mercury");
        page.locator("//input[@name='submit']").click();
        System.out.println(page.locator("//h3[text()='Login Successfully']").innerText());

        assertThat(page.locator("//h3[text()='Login Successfully']")).hasText("Login Successfully");
        // find total number links on the page
        int count = 0;
        Locator linkInLeftTable = page.locator("//table[@border='2']//a");
        for(int i=0; i<linkInLeftTable.count(); i++){
            count =  count + 1;
            System.out.println(linkInLeftTable.nth(i).innerText());
        }
        System.out.println("total links in the left table is/are : "+count);
        page.onDialog(dialog -> {
                dialog.accept();
                    System.out.println(dialog.message());
                });
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./src/test/resources/screenshots/screenshot.png")));
        page.close();
        playwright.close();




    }
}
