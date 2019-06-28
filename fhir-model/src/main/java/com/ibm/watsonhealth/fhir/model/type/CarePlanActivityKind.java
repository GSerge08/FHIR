/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.type;

import java.util.Collection;

public class CarePlanActivityKind extends Code {
    public static final CarePlanActivityKind APPOINTMENT = CarePlanActivityKind.of(ValueSet.APPOINTMENT);

    public static final CarePlanActivityKind COMMUNICATION_REQUEST = CarePlanActivityKind.of(ValueSet.COMMUNICATION_REQUEST);

    public static final CarePlanActivityKind DEVICE_REQUEST = CarePlanActivityKind.of(ValueSet.DEVICE_REQUEST);

    public static final CarePlanActivityKind MEDICATION_REQUEST = CarePlanActivityKind.of(ValueSet.MEDICATION_REQUEST);

    public static final CarePlanActivityKind NUTRITION_ORDER = CarePlanActivityKind.of(ValueSet.NUTRITION_ORDER);

    public static final CarePlanActivityKind TASK = CarePlanActivityKind.of(ValueSet.TASK);

    public static final CarePlanActivityKind SERVICE_REQUEST = CarePlanActivityKind.of(ValueSet.SERVICE_REQUEST);

    public static final CarePlanActivityKind VISION_PRESCRIPTION = CarePlanActivityKind.of(ValueSet.VISION_PRESCRIPTION);

    private CarePlanActivityKind(Builder builder) {
        super(builder);
    }

    public static CarePlanActivityKind of(java.lang.String value) {
        return CarePlanActivityKind.builder().value(value).build();
    }

    public static CarePlanActivityKind of(ValueSet value) {
        return CarePlanActivityKind.builder().value(value).build();
    }

    public static String string(java.lang.String value) {
        return CarePlanActivityKind.builder().value(value).build();
    }

    public static Code code(java.lang.String value) {
        return CarePlanActivityKind.builder().value(value).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id = id;
        builder.extension.addAll(extension);
        builder.value = value;
        return builder;
    }

    public static class Builder extends Code.Builder {
        private Builder() {
            super();
        }

        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder value(java.lang.String value) {
            return (Builder) super.value(ValueSet.from(value).value());
        }

        public Builder value(ValueSet value) {
            return (Builder) super.value(value.value());
        }

        @Override
        public CarePlanActivityKind build() {
            return new CarePlanActivityKind(this);
        }
    }

    public enum ValueSet {
        APPOINTMENT("Appointment"),

        COMMUNICATION_REQUEST("CommunicationRequest"),

        DEVICE_REQUEST("DeviceRequest"),

        MEDICATION_REQUEST("MedicationRequest"),

        NUTRITION_ORDER("NutritionOrder"),

        TASK("Task"),

        SERVICE_REQUEST("ServiceRequest"),

        VISION_PRESCRIPTION("VisionPrescription");

        private final java.lang.String value;

        ValueSet(java.lang.String value) {
            this.value = value;
        }

        public java.lang.String value() {
            return value;
        }

        public static ValueSet from(java.lang.String value) {
            for (ValueSet c : ValueSet.values()) {
                if (c.value.equals(value)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(value);
        }
    }
}