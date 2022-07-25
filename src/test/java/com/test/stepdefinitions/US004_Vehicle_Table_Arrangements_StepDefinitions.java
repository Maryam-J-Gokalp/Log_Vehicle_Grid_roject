package com.test.stepdefinitions;

import com.test.pages.HomePage;
import com.test.pages.VehiclePage;
import com.test.utilities.BrowserUtils;
import com.test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US004_Vehicle_Table_Arrangements_StepDefinitions {
    HomePage homePage = new HomePage();
    VehiclePage vehiclePage = new VehiclePage();

    @And("User clicks Flight-Vehicle module")
    public void userClicksFlightVehicleModule() {
        homePage.fleetButton.click();
        homePage.vehiclesButton.click();
        BrowserUtils.sleep(2);
    }


    @Then("User sees default value is twentyfive")
    public void userSeesDefaultValueIsTwentyfive() {
        BrowserUtils.sleep(2);
        System.out.println(vehiclePage.dropdownViewPerPage.getText());
        Assert.assertEquals("25", vehiclePage.dropdownViewPerPage.getText());  //AC-2
    }

    @Then("User can select each of the options")
    public void userCanSelectEachOfTheOptions() {   //AC-3
        BrowserUtils.sleep(2);
        Assert.assertTrue(vehiclePage.dropdown10.isEnabled());
        Assert.assertTrue(vehiclePage.dropdown25.isEnabled());
        Assert.assertTrue(vehiclePage.dropdown50.isEnabled());
        Assert.assertTrue(vehiclePage.dropdown100.isEnabled());
    }

    @Then("User can arrange rows and vehicle numbers to be displayed")
    public void userCanArrangeRowsAndVehicleNumbersToBeDisplayed() {
        BrowserUtils.sleep(2);
        vehiclePage.dropdownViewPerPage.click();
        vehiclePage.dropdown10.click();

        Assert.assertTrue(vehiclePage.tenthRow.isDisplayed());

        vehiclePage.dropdownViewPerPage.click();
        vehiclePage.dropdown25.click();
        Assert.assertTrue(vehiclePage.twentyfifthRow.isDisplayed());

        vehiclePage.dropdownViewPerPage.click();
        vehiclePage.dropdown50.click();
        Assert.assertTrue(vehiclePage.fiftiethRow.isDisplayed());

        vehiclePage.dropdownViewPerPage.click();
        vehiclePage.dropdown100.click();
        Assert.assertTrue(vehiclePage.lastRow.isDisplayed());
    }

    @Then("User sort a column in ascending or descending order by clicking the column name")
    public void userSortAColumnInAscendingOrDescendingOrderByClickingTheColumnName() {
        Assert.assertTrue(vehiclePage.licencePlateColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.driverColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.locationColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.chasisNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.modelYearColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.lastOdometerColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.immatriculationDateColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.firstContractDateColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.cvviColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.seatsNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.doorNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.colorColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.transmissionNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.fuelTypeNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.co2EmissionsNumberColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.horsepowerColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.horsepowerTaxColumnTag.getAttribute("class").contains("sortable"));
        Assert.assertTrue(vehiclePage.powerColumnTag.getAttribute("class").contains("sortable"));

    }

    @And("User sorts and filters by clicking columns and filters")
    public void userSortsAndFiltersByClickingColumnsAndFilters() {
        vehiclePage.filterBtn.click();
        vehiclePage.manageFilterBtn.click();
        BrowserUtils.sleep(2);
        vehiclePage.locationFilterCheckBox.click();
        BrowserUtils.sleep(2);
        vehiclePage.modelYearColumnTag.click();
        BrowserUtils.sleep(2);

    }

    @Then("User remove all sortings and filterings on the page by using the reset button")
    public void userRemoveAllSortingsAndFilteringsOnThePageByUsingTheResetButton() {
        vehiclePage.resetBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertEquals("https://qa.xfleetsolutions.com/entity/Extend_Entity_Carreservation", Driver.getDriver().getCurrentUrl());
    }
}
