package pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pages.SendInvite;
import browserFactory.ReusableLibrary;
import pages.keylessGlobalfunctions;

public class keyless extends keylessGlobalfunctions {
	protected WebDriver driver;
	//String jsonPath,jsonData;
	public keyless(WebDriver driver)
	{
		super(driver);
    	this.driver = driver;
	}
	public void keylessportal() throws Exception, ParseException
	{   
		// Send invitation in Keyless Manager Portal
		KeylessLogin();
		sendResidentInvite();
		bulkmoveout();
		
	}
}
