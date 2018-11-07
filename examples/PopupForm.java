/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasglobal.popupformsubmission;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import java.io.IOException;

/**
 *
 * @author sami
 */
public class PopupForm {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FailingHttpStatusCodeException, IOException {
        PopupForm popupForm = new PopupForm();
        popupForm.homePageForm();
    }
    
    /*
     * This function using the WebClient and to get the Page and then 
     * open the popup form using the button click.
     */
    public void homePageForm() throws IOException {
        try (final WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED)) {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            final HtmlPage page = webClient.getPage("http://example.com/");
            // Get Button on which popup gets open
            final HtmlElement firstButton = (HtmlElement) page.getByXPath("//button[contains(@class, 'popup-form')]").get(0);
            // Click the Button which opens the Popup Form
            firstButton.click();

            // Gets the Form Fields and filled them out
            HtmlForm form = page.getForms().get(0);
            HtmlInput yourName = form.getInputByName("name");
            HtmlInput email = form.getInputByName("email");
            HtmlInput companyName = form.getInputByName("company");
            HtmlTextArea message = form.getTextAreaByName("description");
            
            // Fill the values in the fields
            yourName.setValueAttribute("Sami Ahmed Siddiqui");
            email.setValueAttribute("sami.siddiqui@yasglobal.com");
            companyName.setValueAttribute("YAS Global");
            message.setText("This is a testing submission of HTMLUnit.");
            
            // Get Submit Button using Class, it can be get using ID or some other attribute as well.
            final HtmlElement getStarted = (HtmlElement) form.getByXPath("//button[contains(@class, 'submit')]").get(0);            
            // Click  on Form Submit Button
            getStarted.click();
            // Exit the Function
            System.exit(0);
        }
    }
}
