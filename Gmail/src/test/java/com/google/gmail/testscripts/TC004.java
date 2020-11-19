package com.google.gmail.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gmail.generic.ExcelLibrary;
import com.google.gmail.generic.Utility;
import com.google.gmail.pages.HomePage;
import com.google.gmail.pages.OrderDetailPage;
import com.google.gmail.pages.ProductDetailPage;
import com.google.gmail.pages.ProductsPage;

public class TC004 extends BaseTest
{
	@Test(description="Verify whether selected product is displayed in Order Detail Page after closing PopUp")
	public void testProductIsDiplayedInODPAfterClosingPopup()
	{
		String sheetName = "TC003";
		String menuItem=ExcelLibrary.getCellData(XL_PATH, sheetName, 1, 0);
		String productID=Utility.splitString(ExcelLibrary.getCellData(XL_PATH, sheetName, 1, 1), ".")[0];
		int quantity=Integer.parseInt(Utility.splitString(ExcelLibrary.getCellData(XL_PATH, sheetName, 1, 2),".")[0]);
		String size=ExcelLibrary.getCellData(XL_PATH, sheetName, 1, 3);
		String color=ExcelLibrary.getCellData(XL_PATH, sheetName, 1, 4);
		HomePage hp = new HomePage(driver,webactionUtil);
		ProductsPage productsPage = hp.clickMenuItem(menuItem);
		ProductDetailPage pdp = productsPage.selectProduct(productID);
		pdp.increaseQuantity(quantity);
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		pdp.clickOnClose();
		OrderDetailPage odp = hp.clickOnViewKart();
		Assert.assertEquals(odp.isProductDisplayed(productID), true);
	}
}
