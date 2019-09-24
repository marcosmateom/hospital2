/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author C.V
 */
public class loginPageTest {
    @Test
public void homePage() throws Exception {
    try (final WebClient webClient = new WebClient()) {
        final HtmlPage page = webClient.getPage("http://localhost:8080/proyectoDB2-Hospital1/login_h1.jsp");
        Assert.assertEquals("Inicio de sesion", page.getTitleText());
        final String pageAsText = page.asText();
        Assert.assertTrue(pageAsText.contains("Inicia sesión"));
        final String HospitalNo = page.asText();
        Assert.assertTrue(HospitalNo.contains("Hospital 1"));
    }
}
}
