/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.type.BackboneElement;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.DateTime;
import com.ibm.watsonhealth.fhir.model.type.Element;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Instant;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.Period;
import com.ibm.watsonhealth.fhir.model.type.ProvenanceEntityRole;
import com.ibm.watsonhealth.fhir.model.type.Reference;
import com.ibm.watsonhealth.fhir.model.type.Signature;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or 
 * otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling 
 * trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become 
 * important records with their own provenance. Provenance statement indicates clinical significance in terms of 
 * confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document 
 * Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust 
 * policies.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class Provenance extends DomainResource {
    private final List<Reference> target;
    private final Element occurred;
    private final Instant recorded;
    private final List<Uri> policy;
    private final Reference location;
    private final List<CodeableConcept> reason;
    private final CodeableConcept activity;
    private final List<Agent> agent;
    private final List<Entity> entity;
    private final List<Signature> signature;

    private Provenance(Builder builder) {
        super(builder);
        this.target = ValidationSupport.requireNonEmpty(builder.target, "target");
        this.occurred = ValidationSupport.choiceElement(builder.occurred, "occurred", Period.class, DateTime.class);
        this.recorded = ValidationSupport.requireNonNull(builder.recorded, "recorded");
        this.policy = builder.policy;
        this.location = builder.location;
        this.reason = builder.reason;
        this.activity = builder.activity;
        this.agent = ValidationSupport.requireNonEmpty(builder.agent, "agent");
        this.entity = builder.entity;
        this.signature = builder.signature;
    }

    /**
     * <p>
     * The Reference(s) that were generated or updated by the activity described in this resource. A provenance can point to 
     * more than one target if multiple resources were created/updated by the same activity.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Reference}.
     */
    public List<Reference> getTarget() {
        return target;
    }

    /**
     * <p>
     * The period during which the activity occurred.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Element}.
     */
    public Element getOccurred() {
        return occurred;
    }

    /**
     * <p>
     * The instant of time at which the activity was recorded.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Instant}.
     */
    public Instant getRecorded() {
        return recorded;
    }

    /**
     * <p>
     * Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy 
     * documents, such as patient consent, guarantor funding, etc.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Uri}.
     */
    public List<Uri> getPolicy() {
        return policy;
    }

    /**
     * <p>
     * Where the activity occurred, if relevant.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getLocation() {
        return location;
    }

    /**
     * <p>
     * The reason that the activity was taking place.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getReason() {
        return reason;
    }

    /**
     * <p>
     * An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, 
     * processing, transforming, modifying, relocating, using, or generating entities.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept}.
     */
    public CodeableConcept getActivity() {
        return activity;
    }

    /**
     * <p>
     * An actor taking a role in an activity for which it can be assigned some degree of responsibility for the activity 
     * taking place.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Agent}.
     */
    public List<Agent> getAgent() {
        return agent;
    }

    /**
     * <p>
     * An entity used in this activity.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Entity}.
     */
    public List<Entity> getEntity() {
        return entity;
    }

    /**
     * <p>
     * A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the 
     * signature is indicated.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Signature}.
     */
    public List<Signature> getSignature() {
        return signature;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(target, "target", visitor, Reference.class);
                accept(occurred, "occurred", visitor, true);
                accept(recorded, "recorded", visitor);
                accept(policy, "policy", visitor, Uri.class);
                accept(location, "location", visitor);
                accept(reason, "reason", visitor, CodeableConcept.class);
                accept(activity, "activity", visitor);
                accept(agent, "agent", visitor, Agent.class);
                accept(entity, "entity", visitor, Entity.class);
                accept(signature, "signature", visitor, Signature.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder(target, recorded, agent);
        builder.id = id;
        builder.meta = meta;
        builder.implicitRules = implicitRules;
        builder.language = language;
        builder.text = text;
        builder.contained.addAll(contained);
        builder.extension.addAll(extension);
        builder.modifierExtension.addAll(modifierExtension);
        builder.occurred = occurred;
        builder.policy.addAll(policy);
        builder.location = location;
        builder.reason.addAll(reason);
        builder.activity = activity;
        builder.entity.addAll(entity);
        builder.signature.addAll(signature);
        return builder;
    }

    public static Builder builder(List<Reference> target, Instant recorded, List<Agent> agent) {
        return new Builder(target, recorded, agent);
    }

    public static class Builder extends DomainResource.Builder {
        // required
        private final List<Reference> target;
        private final Instant recorded;
        private final List<Agent> agent;

        // optional
        private Element occurred;
        private List<Uri> policy = new ArrayList<>();
        private Reference location;
        private List<CodeableConcept> reason = new ArrayList<>();
        private CodeableConcept activity;
        private List<Entity> entity = new ArrayList<>();
        private List<Signature> signature = new ArrayList<>();

        private Builder(List<Reference> target, Instant recorded, List<Agent> agent) {
            super();
            this.target = target;
            this.recorded = recorded;
            this.agent = agent;
        }

        /**
         * <p>
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * </p>
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * </p>
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * <p>
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * </p>
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * <p>
         * The base language in which the resource is written.
         * </p>
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * <p>
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * </p>
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * The period during which the activity occurred.
         * </p>
         * 
         * @param occurred
         *     When the activity occurred
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder occurred(Element occurred) {
            this.occurred = occurred;
            return this;
        }

        /**
         * <p>
         * Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy 
         * documents, such as patient consent, guarantor funding, etc.
         * </p>
         * 
         * @param policy
         *     Policy or plan the activity was defined by
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder policy(Uri... policy) {
            for (Uri value : policy) {
                this.policy.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy 
         * documents, such as patient consent, guarantor funding, etc.
         * </p>
         * 
         * @param policy
         *     Policy or plan the activity was defined by
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder policy(Collection<Uri> policy) {
            this.policy.addAll(policy);
            return this;
        }

        /**
         * <p>
         * Where the activity occurred, if relevant.
         * </p>
         * 
         * @param location
         *     Where the activity occurred, if relevant
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder location(Reference location) {
            this.location = location;
            return this;
        }

        /**
         * <p>
         * The reason that the activity was taking place.
         * </p>
         * 
         * @param reason
         *     Reason the activity is occurring
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder reason(CodeableConcept... reason) {
            for (CodeableConcept value : reason) {
                this.reason.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The reason that the activity was taking place.
         * </p>
         * 
         * @param reason
         *     Reason the activity is occurring
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder reason(Collection<CodeableConcept> reason) {
            this.reason.addAll(reason);
            return this;
        }

        /**
         * <p>
         * An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, 
         * processing, transforming, modifying, relocating, using, or generating entities.
         * </p>
         * 
         * @param activity
         *     Activity that occurred
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder activity(CodeableConcept activity) {
            this.activity = activity;
            return this;
        }

        /**
         * <p>
         * An entity used in this activity.
         * </p>
         * 
         * @param entity
         *     An entity used in this activity
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder entity(Entity... entity) {
            for (Entity value : entity) {
                this.entity.add(value);
            }
            return this;
        }

        /**
         * <p>
         * An entity used in this activity.
         * </p>
         * 
         * @param entity
         *     An entity used in this activity
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder entity(Collection<Entity> entity) {
            this.entity.addAll(entity);
            return this;
        }

        /**
         * <p>
         * A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the 
         * signature is indicated.
         * </p>
         * 
         * @param signature
         *     Signature on target
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder signature(Signature... signature) {
            for (Signature value : signature) {
                this.signature.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the 
         * signature is indicated.
         * </p>
         * 
         * @param signature
         *     Signature on target
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder signature(Collection<Signature> signature) {
            this.signature.addAll(signature);
            return this;
        }

        @Override
        public Provenance build() {
            return new Provenance(this);
        }
    }

    /**
     * <p>
     * An actor taking a role in an activity for which it can be assigned some degree of responsibility for the activity 
     * taking place.
     * </p>
     */
    public static class Agent extends BackboneElement {
        private final CodeableConcept type;
        private final List<CodeableConcept> role;
        private final Reference who;
        private final Reference onBehalfOf;

        private Agent(Builder builder) {
            super(builder);
            this.type = builder.type;
            this.role = builder.role;
            this.who = ValidationSupport.requireNonNull(builder.who, "who");
            this.onBehalfOf = builder.onBehalfOf;
        }

        /**
         * <p>
         * The participation the agent had with respect to the activity.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept}.
         */
        public CodeableConcept getType() {
            return type;
        }

        /**
         * <p>
         * The function of the agent with respect to the activity. The security role enabling the agent with respect to the 
         * activity.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link CodeableConcept}.
         */
        public List<CodeableConcept> getRole() {
            return role;
        }

        /**
         * <p>
         * The individual, device or organization that participated in the event.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getWho() {
            return who;
        }

        /**
         * <p>
         * The individual, device, or organization for whom the change was made.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getOnBehalfOf() {
            return onBehalfOf;
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(type, "type", visitor);
                    accept(role, "role", visitor, CodeableConcept.class);
                    accept(who, "who", visitor);
                    accept(onBehalfOf, "onBehalfOf", visitor);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return Builder.from(this);
        }

        public static Builder builder(Reference who) {
            return new Builder(who);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final Reference who;

            // optional
            private CodeableConcept type;
            private List<CodeableConcept> role = new ArrayList<>();
            private Reference onBehalfOf;

            private Builder(Reference who) {
                super();
                this.who = who;
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * The participation the agent had with respect to the activity.
             * </p>
             * 
             * @param type
             *     How the agent participated
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * <p>
             * The function of the agent with respect to the activity. The security role enabling the agent with respect to the 
             * activity.
             * </p>
             * 
             * @param role
             *     What the agents role was
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder role(CodeableConcept... role) {
                for (CodeableConcept value : role) {
                    this.role.add(value);
                }
                return this;
            }

            /**
             * <p>
             * The function of the agent with respect to the activity. The security role enabling the agent with respect to the 
             * activity.
             * </p>
             * 
             * @param role
             *     What the agents role was
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder role(Collection<CodeableConcept> role) {
                this.role.addAll(role);
                return this;
            }

            /**
             * <p>
             * The individual, device, or organization for whom the change was made.
             * </p>
             * 
             * @param onBehalfOf
             *     Who the agent is representing
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder onBehalfOf(Reference onBehalfOf) {
                this.onBehalfOf = onBehalfOf;
                return this;
            }

            @Override
            public Agent build() {
                return new Agent(this);
            }

            private static Builder from(Agent agent) {
                Builder builder = new Builder(agent.who);
                builder.id = agent.id;
                builder.extension.addAll(agent.extension);
                builder.modifierExtension.addAll(agent.modifierExtension);
                builder.type = agent.type;
                builder.role.addAll(agent.role);
                builder.onBehalfOf = agent.onBehalfOf;
                return builder;
            }
        }
    }

    /**
     * <p>
     * An entity used in this activity.
     * </p>
     */
    public static class Entity extends BackboneElement {
        private final ProvenanceEntityRole role;
        private final Reference what;
        private final List<Provenance.Agent> agent;

        private Entity(Builder builder) {
            super(builder);
            this.role = ValidationSupport.requireNonNull(builder.role, "role");
            this.what = ValidationSupport.requireNonNull(builder.what, "what");
            this.agent = builder.agent;
        }

        /**
         * <p>
         * How the entity was used during the activity.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link ProvenanceEntityRole}.
         */
        public ProvenanceEntityRole getRole() {
            return role;
        }

        /**
         * <p>
         * Identity of the Entity used. May be a logical or physical uri and maybe absolute or relative.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getWhat() {
            return what;
        }

        /**
         * <p>
         * The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other 
         * agents. This description can be understood as shorthand for saying that the agent was responsible for the activity 
         * which generated the entity.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link Agent}.
         */
        public List<Provenance.Agent> getAgent() {
            return agent;
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(role, "role", visitor);
                    accept(what, "what", visitor);
                    accept(agent, "agent", visitor, Provenance.Agent.class);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return Builder.from(this);
        }

        public static Builder builder(ProvenanceEntityRole role, Reference what) {
            return new Builder(role, what);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final ProvenanceEntityRole role;
            private final Reference what;

            // optional
            private List<Provenance.Agent> agent = new ArrayList<>();

            private Builder(ProvenanceEntityRole role, Reference what) {
                super();
                this.role = role;
                this.what = what;
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other 
             * agents. This description can be understood as shorthand for saying that the agent was responsible for the activity 
             * which generated the entity.
             * </p>
             * 
             * @param agent
             *     Entity is attributed to this agent
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder agent(Provenance.Agent... agent) {
                for (Provenance.Agent value : agent) {
                    this.agent.add(value);
                }
                return this;
            }

            /**
             * <p>
             * The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other 
             * agents. This description can be understood as shorthand for saying that the agent was responsible for the activity 
             * which generated the entity.
             * </p>
             * 
             * @param agent
             *     Entity is attributed to this agent
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder agent(Collection<Provenance.Agent> agent) {
                this.agent.addAll(agent);
                return this;
            }

            @Override
            public Entity build() {
                return new Entity(this);
            }

            private static Builder from(Entity entity) {
                Builder builder = new Builder(entity.role, entity.what);
                builder.id = entity.id;
                builder.extension.addAll(entity.extension);
                builder.modifierExtension.addAll(entity.modifierExtension);
                builder.agent.addAll(entity.agent);
                return builder;
            }
        }
    }
}