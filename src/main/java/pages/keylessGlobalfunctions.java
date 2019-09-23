package pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import browserFactory.ReusableLibrary;
import browserFactory.ReusableLibrary1;

public class keylessGlobalfunctions extends ReusableLibrary1  {
	protected WebDriver driver;
	String jsonPath,jsonData;
    String value;
    public keylessGlobalfunctions(WebDriver driver)
    {
    	this.driver = driver;
    	jsonPath = getObjectfile(this.getClass().getSimpleName());
    	jsonData = getDatatfile(this.getClass().getSimpleName());
	
    }
    
    public void sendResidentInvite() throws Exception
	{	
		
		if(isDisplayed(locatorParser(jsonParser(jsonPath,"Invite","502badgateway")),"502BadGateway")==true) {
			Thread.sleep(1000);
			refresh();
		}
		else {
			
			JSONParser jsonParserObject = new JSONParser();
			try (FileReader reader = new FileReader(jsonData))
			{
				Object obj = jsonParserObject.parse(reader);
				JSONArray userlist = (JSONArray) obj;
				int i=-1;
				System.out.println(userlist.size());
				System.out.println("i="+i);
				while(i<userlist.size()-1)  {  
					++i;
					System.out.println(i);
					JSONObject props = (JSONObject) userlist.get(i);
					JSONObject prop = (JSONObject) props.get("InviteData"); 
					System.out.println("["+i+"]"+props);
					System.out.println("["+i+"]"+prop);
       
					WebDriverWait wait = new WebDriverWait(driver, 20);	
					WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","send_invite"))));
					ClickElement(locatorParser(jsonParser(jsonPath,"Invite","send_invite")),"send_invite");
	       	
					WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","choose_btn"))));
					ClickElement(locatorParser(jsonParser(jsonPath,"Invite","choose_btn")),"choose_btn");
	        
					WebElement element3=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","choose_text"))));
					WebElement choosetxt = driver.findElement(locatorParser(jsonParser(jsonPath,"Invite","choose_text")));
					choosetxt.sendKeys("Test (32095)");
					choosetxt.sendKeys(Keys.ENTER);
	        
					WebElement element4=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","first_name"))));
					sendKeysByAction(locatorParser(jsonParser(jsonPath,"Invite","first_name")),prop.get("fname").toString());
	   	    
					WebElement element5=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","last_name"))));
					sendKeysByAction(locatorParser(jsonParser(jsonPath,"Invite","last_name")),prop.get("lname").toString());
		    
					WebElement element6=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","from_date"))));
					EnterTextWithJS(locatorParser(jsonParser(jsonPath,"Invite","from_date")),prop.get("fdate").toString());
	       	
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","to_date"))));
					EnterTextWithJS(locatorParser(jsonParser(jsonPath,"Invite","to_date")),prop.get("tdate").toString());
	        
					WebElement element7=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","mail"))));
					sendKeysByAction(locatorParser(jsonParser(jsonPath,"Invite","mail")),prop.get("email").toString());
		    
					WebElement element8=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","phno"))));
					sendNumberByAction(locatorParser(jsonParser(jsonPath,"Invite","phno")),prop.get("phno").toString());
	        
					WebElement element9=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","doorcode"))));
					ClickElement(locatorParser(jsonParser(jsonPath,"Invite","doorcode")),"code");
					Thread.sleep(2000);
		    
					WebElement element10=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","invite_btn"))));
					ClickElement(locatorParser(jsonParser(jsonPath,"Invite","invite_btn")),"invite_btn");
					Thread.sleep(2000);        
          } 
       }catch (IOException e) {
    		e.printStackTrace();
    		}
		}
	        
	}
    public void refresh() throws Exception{
		
		driver.get("https://keyless.bluerently.com/occupants");
		driver.navigate().refresh();
	        
		}
	public void bulkmoveout() throws Exception{
		
		//WebElement element11=wait.until(ExpectedConditions.visibilityOfElementLocated(locatorParser(jsonParser(jsonPath,"Invite","moveout_btn"))));
	    ClickElement(locatorParser(jsonParser(jsonPath,"Invite","moveout_btn")),"moveout_btn");
	    Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
	}
/*	public void keylessLoginAuthentication() throws IOException, ParseException {
		
		JSONParser jsonParserObject = new JSONParser();
		JSONParser jsonParserData = new JSONParser();
	    try (FileReader reader = new FileReader(jsonPath))
        {
            Object obj = jsonParserObject.parse(reader);
            JSONArray userlist = (JSONArray) obj;
            userlist.forEach( emp -> {
				
					try {
						KeylessLogin( (JSONObject) emp );
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			} );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (FileReader data = new FileReader(jsonData))
        {
            Object obj = jsonParserData.parse(data);
            JSONArray datalist = (JSONArray) obj;
        
            datalist.forEach( emp -> {
				try {
					KeylessLogin( (JSONObject) emp );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
       
	} */
	
	public void KeylessLogin() throws IOException, ParseException
		{
			 	try {
					System.out.println("********Login for Manager Portal Executing*************");
					sendKeysByAction(locatorParser(jsonParser(jsonPath, "KeyLogin", "Email")),(jsonParser(jsonData, "KeyLoginData", "name")));
					sendKeysByAction(locatorParser(jsonParser(jsonPath, "KeyLogin", "Password")),
							(jsonParser(jsonData, "KeyLoginData", "password")));
					ClickElement(locatorParser(jsonParser(jsonPath,"KeyLogin","Siginbtn")),"moveout_btn");
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
    

}
