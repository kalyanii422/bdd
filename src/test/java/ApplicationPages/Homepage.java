package ApplicationPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import WebConnector.webconnector;
import static WebConnector.webconnector.driver;
import java.io.IOException;

public class Homepage {
	webconnector wc = new webconnector();

	public void goToHomePage() throws InvalidFormatException, IOException {
		driver.get("https://www.ebay.com/");
		wc.waitForCondition("PageLoad", "", 60);
	}
	
	public void searchApple() throws Exception {
		wc.PerformActionOnElement("searchText", "Type", "iPhone11");
		wc.PerformActionOnElement("searchButton", "Click", "");
	}
	
	public void selectApple() throws Exception {
		wc.PerformActionOnElement("clickPhoneLink", "Click", "");
		String currentTab = wc.CurrentTab();
		wc.SwitchToTab(currentTab);
		Thread.sleep(3000);
		wc.PerformActionOnElement("addToCartBtn", "Click", "");
	}

	public String assertText() throws Exception {
		return wc.getText("itemsInCart");
	}
}