package com.tarun.practicetest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practiceclass {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.get("http://tutorialsninja.com/demo/");
		List<WebElement> links = dr.findElements(By.tagName("a"));
		for(WebElement link : links ) {
			String url = link.getAttribute("herf");
			if(url==null || url.isEmpty()) {
				continue;
			}
			else {
				HttpURLConnection con = (HttpURLConnection)(new URL(url).openConnection()) ;
					if(con.getResponseCode()>=400) {
						System.out.println("not OK");
					}
					else {
						System.out.println("OK");
					}
				
			}
		
		}	
	}
}
