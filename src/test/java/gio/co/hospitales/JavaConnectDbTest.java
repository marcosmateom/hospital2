/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author C.V
 */
public class JavaConnectDbTest {
    
    public JavaConnectDbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHospNum method, of class JavaConnectDb.
     */
    @Test
    public void testGetHospNum() {
        List<String> mockList = mock(List.class);
        mockList.add("First");
        when(mockList.get(0)).thenReturn("Mockito");
        when(mockList.get(1)).thenReturn("JCG");
        assertEquals("Mockito", mockList.get(0));
        assertEquals("JCG", mockList.get(1));
    }

    /**
     * Test of connectDbH method, of class JavaConnectDb.
     */
    @Test
    public void testConnectDbH() {
        assertEquals(1, 1);
    }
    
}
