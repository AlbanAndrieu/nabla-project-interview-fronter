/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.fronter.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nabla.project.fronter.selenium.tests.helper.SeleniumHelper;
import com.nabla.project.fronter.selenium.tests.pageobjects.RollsPage;

public class SimpleWebDriverSTest
{

    @Before
    public void setUp() throws Exception
    {

        SeleniumHelper.setUp();

    }

    // @Test
    // @InSequence(1)
    public void testWithGoodInputS() throws Exception
    {
        // Get the Start Time
        final long startTime = System.currentTimeMillis();

        // Create an instance of Loan Page class
        // and provide the driver
        final RollsPage rollsPage = new RollsPage();

        // Open the Loan Calculator Page
        rollsPage.get();

        rollsPage.calculateScore("XXX");

        // Get the End Time
        final long endTime = System.currentTimeMillis();

        // Measure total time
        final long totalTime = endTime - startTime;
        System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

        Assert.assertEquals("Kata Bowling Cost Calculator (Results)", SeleniumHelper.getDriver().findElement(By.cssSelector("h3")).getText());
        rollsPage.Ensure_score_is_complete("Score is : 30");
        final WebElement simpleTable = SeleniumHelper.getDriver().findElement(By.id("score"));
        SeleniumHelper.testWebTable(simpleTable, 121);
        Assert.assertEquals("30", SeleniumHelper.getDriver().findElement(By.xpath("//td[2]")).getText());

        SeleniumHelper.testTakesScreenshot("testWithGoodInputS.png", SeleniumHelper.getDriver());
        // Thread.sleep(1000);

        SeleniumHelper.getSelenium().open("/fronter/");
        SeleniumHelper.getSelenium().waitForPageToLoad("1500");

        rollsPage.close();
    }

    // @Test
    // @InSequence(2)
    public void testWithWrongInputS() throws Exception
    {
        // Get the StopWatch Object and start the StopWatch
        final StopWatch pageLoad = new StopWatch();
        pageLoad.start();

        // Create an instance of Loan Page class
        // and provide the driver
        final RollsPage loanPage = new RollsPage(/* SeleniumHelper.getDriver() */);

        // Open the Loan Calculator Page
        loanPage.get();

        loanPage.He_enters_rolls("ABC");

        // wait for the application to get fully loaded
        /*
         * final WebElement findOwnerLink = (new WebDriverWait(SeleniumHelper.getDriver(), 5)).until(new ExpectedCondition<WebElement>()
         * {
         * @Override
         * public WebElement apply(final WebDriver d)
         * {
         * // d.get(baseUrl);
         * return d.findElement(By.name("loan_form:paybackTime"));
         * }
         * });
         * findOwnerLink.click();
         */

        final WebDriverWait wait = new WebDriverWait(SeleniumHelper.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rolls_form:score")));
        SeleniumHelper.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        SeleniumHelper.getDriver().findElement(By.name("rolls_form:score")).click();

        loanPage.Ensure_a_transaction_failure_message(2, "Please enter the amount of your loan. Ex. 200000: Validation Error: Specified attribute is not between the expected values of 1 and 1,000,000,000.");
        loanPage.Ensure_a_transaction_failure_message(3, "Please enter the number of years you have to pay back your loan. Ex. 30: Validation Error: Specified attribute is not between the expected values of 1 and 120.");

        SeleniumHelper.testTakesScreenshot("testWithWrongInputS.png", SeleniumHelper.getDriver());
        // Thread.sleep(1000);

        SeleniumHelper.getSelenium().open("/fronter/");
        SeleniumHelper.getSelenium().waitForPageToLoad("1500");
    }

    @After
    public void tearDown() throws Exception
    {
        SeleniumHelper.tearDown();
    }
}
