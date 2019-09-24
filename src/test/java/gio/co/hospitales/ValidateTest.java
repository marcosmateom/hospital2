/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author C.V
 */
public class ValidateTest {
    
    public ValidateTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of doGet method, of class Validate.
     */
    @Test
    public void testDoGet() throws Exception {
        assertEquals("perro", "perro");
    }

    /**
     * Test of doPost method, of class Validate.
     */
    @Test
    public void testDoPost() throws Exception {
        assertEquals("chucho", "chucho");
    }
    
}
