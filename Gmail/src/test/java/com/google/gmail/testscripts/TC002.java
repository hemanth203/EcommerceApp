package com.google.gmail.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gmail.pages.HomePage;
import com.google.gmail.pages.OrderDetailPage;
import com.google.gmail.pages.ProductDetailPage;
import com.google.gmail.pages.ProductsPage;

public class TC002 extends BaseTest
{
	@Test(description="Verify whether selected product is displayed in Order Detail Page after closing PopUp")
	public void testProductIsDiplayedInODPAfterClosingPopup()
	{
		HomePage hp = new HomePage(driver,webactionUtil);
		ProductsPage productsPage = hp.clickMenuItem("dresses");
		ProductDetailPage pdp = productsPage.selectProduct("5");
		pdp.increaseQuantity(3);
		pdp.selectSize("M");
		pdp.selectColor("Blue");
		pdp.clickOnAddToKart();
		pdp.clickOnClose();
		OrderDetailPage odp = hp.clickOnViewKart();
		Assert.assertEquals(odp.isProductDisplayed("5"), true);
	}
}
