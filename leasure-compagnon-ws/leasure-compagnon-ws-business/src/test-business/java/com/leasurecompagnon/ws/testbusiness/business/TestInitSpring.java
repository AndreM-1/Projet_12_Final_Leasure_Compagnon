package com.leasurecompagnon.ws.testbusiness.business;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Classe de test de l'initialisation du contexte Spring.
 * @author André Monnier
 */
public class TestInitSpring extends BusinessTestCase {
    
	/**
     * Constructeur.
     */
    public TestInitSpring() {
        super();
    }

    /**
     * Test l'initialisation du contexte Spring
     */

    @Test
    public void testInit() {
        assertNotNull(getManagerFactory());
        assertNotNull(getDataSource());  
    }
}