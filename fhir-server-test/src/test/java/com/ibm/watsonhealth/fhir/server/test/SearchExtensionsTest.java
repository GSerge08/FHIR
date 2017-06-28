/**
 * (C) Copyright IBM Corp. 2017,2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.server.test;

import static com.ibm.watsonhealth.fhir.model.util.FHIRUtil.codeableConcept;
import static com.ibm.watsonhealth.fhir.model.util.FHIRUtil.integer;
import static com.ibm.watsonhealth.fhir.model.util.FHIRUtil.quantity;
import static com.ibm.watsonhealth.fhir.model.util.FHIRUtil.string;
import static com.ibm.watsonhealth.fhir.model.util.FHIRUtil.uri;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

import com.ibm.watsonhealth.fhir.core.MediaType;
import com.ibm.watsonhealth.fhir.model.Bundle;
import com.ibm.watsonhealth.fhir.model.Coding;
import com.ibm.watsonhealth.fhir.model.Patient;
import com.ibm.watsonhealth.fhir.model.Quantity;
import com.ibm.watsonhealth.fhir.model.Uri;

public class SearchExtensionsTest extends FHIRServerTestBase {
    private static final String EXTENSION_BASE_URL = "http://ibm.com/watsonhealth/fhir/extension/Patient/";
    private Patient savedCreatedPatientWithExtensions;

    @Test(groups = { "server-search" })
    public void testCreatePatientWithExtensions() throws Exception {
        WebTarget target = getWebTarget();
    
        Patient patient = readResource(Patient.class, "Patient_SearchExtensions.json");
        patient.withExtension(objFactory.createExtension().withUrl(EXTENSION_BASE_URL + "favorite-color").withValueString(string("blue")));
        patient.withExtension(objFactory.createExtension().withUrl(EXTENSION_BASE_URL + "favorite-number").withValueInteger(integer(5)));
        patient.withExtension(objFactory.createExtension().withUrl(EXTENSION_BASE_URL + "favorite-code").withValueCodeableConcept(codeableConcept("http://ibm.com/fhir/system", "someCode-1234")));
        patient.withExtension(objFactory.createExtension().withUrl(EXTENSION_BASE_URL + "favorite-uri").withValueUri(uri("http://www.ibm.com")));
        patient.withExtension(objFactory.createExtension().withUrl(EXTENSION_BASE_URL + "favorite-quantity").withValueQuantity(quantity(180, "lbs")));

        Entity<Patient> entity = Entity.entity(patient, MediaType.APPLICATION_JSON_FHIR);
        Response response = target.path("Patient").request().header("X-FHIR-TENANT-ID", "tenant1").post(entity, Response.class);
        assertResponse(response, Response.Status.CREATED.getStatusCode());
    
        // Get the patient's logical id value.
        String patientId = getLocationLogicalId(response);
    
        // Next, call the 'read' API to retrieve the new patient and verify it.
        response = target.path("Patient/" + patientId).request(MediaType.APPLICATION_JSON_FHIR).get();
        assertResponse(response, Response.Status.OK.getStatusCode());
        Patient responsePatient = response.readEntity(Patient.class);
        savedCreatedPatientWithExtensions = responsePatient;
        assertResourceEquals(patient, responsePatient);
    }

    @Test(groups = { "server-search" }, dependsOnMethods = { "testCreatePatientWithExtensions" })
    public void testSearchPatientWithExtensions() {
        WebTarget target = getWebTarget();

        String favoriteColor = savedCreatedPatientWithExtensions.getExtension().get(0).getValueString().getValue();
        Response response = target.path("Patient").queryParam("favorite-color", favoriteColor)
                .request(MediaType.APPLICATION_JSON_FHIR)
                .header("X-FHIR-TENANT-ID", "tenant1")
                .get();
        assertResponse(response, Response.Status.OK.getStatusCode());
        Bundle bundle = response.readEntity(Bundle.class);

        assertNotNull(bundle);
        assertTrue(bundle.getEntry().size() >= 1);
    }

    @Test(groups = { "server-search" }, dependsOnMethods = { "testCreatePatientWithExtensions" })
    public void testSearchPatientWithExtensionsNotFound() {
        WebTarget target = getWebTarget();

        Response response = target.path("Patient").queryParam("favorite-color", "red")
                .request(MediaType.APPLICATION_JSON_FHIR)
                .header("X-FHIR-TENANT-ID", "tenant1")
                .get();
        assertResponse(response, Response.Status.OK.getStatusCode());
        Bundle bundle = response.readEntity(Bundle.class);

        assertNotNull(bundle);
        assertTrue(bundle.getEntry().size() == 0);
    }

    @Test(groups = { "server-search" }, dependsOnMethods = { "testCreatePatientWithExtensions" })
    public void testSearchPatientWithBaseParametersAndExtensions() {
        WebTarget target = getWebTarget();
        String family = savedCreatedPatientWithExtensions.getName().get(0).getFamily().get(0).getValue();
        String favoriteColor = savedCreatedPatientWithExtensions.getExtension().get(0).getValueString().getValue();
        Integer favoriteNumber = savedCreatedPatientWithExtensions.getExtension().get(1).getValueInteger().getValue();
        Coding favoriteCode = savedCreatedPatientWithExtensions.getExtension().get(2).getValueCodeableConcept().getCoding().get(0);
        Uri favoriteUri = savedCreatedPatientWithExtensions.getExtension().get(3).getValueUri();
        Quantity favoriteQuantity = savedCreatedPatientWithExtensions.getExtension().get(4).getValueQuantity();
        
        Response response = target.path("Patient")
                .queryParam("family", family)
                .queryParam("favorite-color", favoriteColor)
                .queryParam("favorite-number", favoriteNumber)
                .queryParam("favorite-code", favoriteCode.getSystem().getValue() + "|" + favoriteCode.getCode().getValue())
                .queryParam("favorite-uri", favoriteUri.getValue())
                .queryParam("favorite-quantity", favoriteQuantity.getValue().getValue().toString() + "||" + favoriteQuantity.getUnit().getValue())
                .request(MediaType.APPLICATION_JSON_FHIR)
                .header("X-FHIR-TENANT-ID", "tenant1")
                .get();
        assertResponse(response, Response.Status.OK.getStatusCode());
        Bundle bundle = response.readEntity(Bundle.class);

        assertNotNull(bundle);
        assertTrue(bundle.getEntry().size() >= 1);
    }
}