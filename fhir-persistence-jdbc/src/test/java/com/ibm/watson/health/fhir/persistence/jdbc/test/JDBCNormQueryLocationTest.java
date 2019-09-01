/**
 * (C) Copyright IBM Corp. 2017,2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watson.health.fhir.persistence.jdbc.test;

import java.util.Properties;

import com.ibm.watson.health.fhir.persistence.FHIRPersistence;
import com.ibm.watson.health.fhir.persistence.jdbc.impl.FHIRPersistenceJDBCNormalizedImpl;
import com.ibm.watson.health.fhir.persistence.jdbc.test.util.DerbyInitializer;
import com.ibm.watson.health.fhir.persistence.test.common.AbstractQueryLocationTest;


public class JDBCNormQueryLocationTest extends AbstractQueryLocationTest {
    
    private Properties testProps;
    
    public JDBCNormQueryLocationTest() throws Exception {
        this.testProps = readTestProperties("test.normalized.properties");
    }

    @Override
    public void bootstrapDatabase() throws Exception {
        DerbyInitializer derbyInit;
        String dbDriverName = this.testProps.getProperty("dbDriverName");
        if (dbDriverName != null && dbDriverName.contains("derby")) {
            derbyInit = new DerbyInitializer(this.testProps);
            derbyInit.bootstrapDb(false);
        }
    }
    
    @Override
    public FHIRPersistence getPersistenceImpl() throws Exception {
        return new FHIRPersistenceJDBCNormalizedImpl(this.testProps);
    }
}