/*
 * (C) Copyright IBM Corp. 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.bucket.client;

import com.ibm.fhir.model.resource.Resource;

/**
 *
 */
public class FhirServerResponse {
    private int statusCode;
    private String statusMessage;
    private String locationHeader;
    private Resource resource;
    private long responseTime;
    
    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
    
    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }
    
    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    
    /**
     * @return the locationHeader
     */
    public String getLocationHeader() {
        return locationHeader;
    }

    
    /**
     * @param locationHeader the locationHeader to set
     */
    public void setLocationHeader(String locationHeader) {
        this.locationHeader = locationHeader;
    }

    
    /**
     * @return the resource
     */
    public Resource getResource() {
        return resource;
    }

    
    /**
     * @param resource the resource to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @return the responseTime
     */
    public long getResponseTime() {
        return responseTime;
    }

    /**
     * @param responseTime the responseTime to set
     */
    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
