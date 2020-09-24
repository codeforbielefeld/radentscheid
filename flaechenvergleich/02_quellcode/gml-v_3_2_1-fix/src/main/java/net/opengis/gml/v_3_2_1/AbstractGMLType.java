//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.opengis.gml.v_3_2_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom2;
import org.jvnet.jaxb2_commons.lang.MergeStrategy2;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AbstractGMLType",
        propOrder = {"metaDataProperty", "description", "descriptionReference", "identifier"}
)
@XmlSeeAlso({AbstractTopologyType.class, CompositeValueType.class, AbstractGeometryType.class, AbstractTimeObjectType.class, BagType.class, ArrayType.class, AbstractTimeSliceType.class, DefinitionBaseType.class, AbstractFeatureType.class})
public abstract class AbstractGMLType implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2 {
    protected List<MetaDataPropertyType> metaDataProperty;
    protected StringOrRefType description;
    protected ReferenceType descriptionReference;
    protected CodeWithAuthorityType identifier;
    @XmlAttribute(
            name = "id",
            namespace = "http://www.opengis.net/gml/3.2",
            required = true
    )
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(
            name = "ID"
    )
    protected String id;

    public AbstractGMLType() {
    }

    public List<MetaDataPropertyType> getMetaDataProperty() {
        if (this.metaDataProperty == null) {
            this.metaDataProperty = new ArrayList();
        }

        return this.metaDataProperty;
    }

    public boolean isSetMetaDataProperty() {
        return this.metaDataProperty != null && !this.metaDataProperty.isEmpty();
    }

    public void unsetMetaDataProperty() {
        this.metaDataProperty = null;
    }

    public StringOrRefType getDescription() {
        return this.description;
    }

    public void setDescription(StringOrRefType value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return this.description != null;
    }

    public ReferenceType getDescriptionReference() {
        return this.descriptionReference;
    }

    public void setDescriptionReference(ReferenceType value) {
        this.descriptionReference = value;
    }

    public boolean isSetDescriptionReference() {
        return this.descriptionReference != null;
    }

    public CodeWithAuthorityType getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(CodeWithAuthorityType value) {
        this.identifier = value;
    }

    public boolean isSetIdentifier() {
        return this.identifier != null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return this.id != null;
    }

    public String toString() {
        ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        StringBuilder buffer = new StringBuilder();
        this.append((ObjectLocator)null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        this.appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        List<MetaDataPropertyType> theName = this.isSetMetaDataProperty() ? this.getMetaDataProperty() : null;
        strategy.appendField(locator, this, "metaDataProperty", buffer, theName, this.isSetMetaDataProperty());
        StringOrRefType theDescription = this.getDescription();
        strategy.appendField(locator, this, "description", buffer, theDescription, this.isSetDescription());
        ReferenceType theDescriptionReference = this.getDescriptionReference();
        strategy.appendField(locator, this, "descriptionReference", buffer, theDescriptionReference, this.isSetDescriptionReference());
        CodeWithAuthorityType theIdentifier = this.getIdentifier();
        strategy.appendField(locator, this, "identifier", buffer, theIdentifier, this.isSetIdentifier());
        String theId = this.getId();
        strategy.appendField(locator, this, "id", buffer, theId, this.isSetId());
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if (object != null && this.getClass() == object.getClass()) {
            if (this == object) {
                return true;
            } else {
                AbstractGMLType that = (AbstractGMLType)object;
                List<MetaDataPropertyType> lhsName = this.isSetMetaDataProperty() ? this.getMetaDataProperty() : null;
                List<MetaDataPropertyType> rhsName = that.isSetMetaDataProperty() ? that.getMetaDataProperty() : null;
                if (!strategy.equals(LocatorUtils.property(thisLocator, "metaDataProperty", lhsName), LocatorUtils.property(thatLocator, "metaDataProperty", rhsName), lhsName, rhsName, this.isSetMetaDataProperty(), that.isSetMetaDataProperty())) {
                    return false;
                } else {
                    StringOrRefType lhsDescription = this.getDescription();
                    StringOrRefType rhsDescription = that.getDescription();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription, this.isSetDescription(), that.isSetDescription())) {
                        return false;
                    } else {
                        ReferenceType lhsDescriptionReference = this.getDescriptionReference();
                        ReferenceType rhsDescriptionReference = that.getDescriptionReference();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "descriptionReference", lhsDescriptionReference), LocatorUtils.property(thatLocator, "descriptionReference", rhsDescriptionReference), lhsDescriptionReference, rhsDescriptionReference, this.isSetDescriptionReference(), that.isSetDescriptionReference())) {
                            return false;
                        } else {
                            CodeWithAuthorityType lhsIdentifier = this.getIdentifier();
                            CodeWithAuthorityType rhsIdentifier = that.getIdentifier();
                            if (!strategy.equals(LocatorUtils.property(thisLocator, "identifier", lhsIdentifier), LocatorUtils.property(thatLocator, "identifier", rhsIdentifier), lhsIdentifier, rhsIdentifier, this.isSetIdentifier(), that.isSetIdentifier())) {
                                return false;
                            } else {
                                String lhsId = this.getId();
                                String rhsId = that.getId();
                                return strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId, this.isSetId(), that.isSetId());
                            }
                        }
                    }
                }
            }
        } else {
            return false;
        }
    }

    public boolean equals(Object object) {
        EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return this.equals((ObjectLocator)null, (ObjectLocator)null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        List<MetaDataPropertyType> theName = this.isSetMetaDataProperty() ? this.getMetaDataProperty() : null;
        int currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaDataProperty", theName), 1, theName, this.isSetMetaDataProperty());
        StringOrRefType theDescription = this.getDescription();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription, this.isSetDescription());
        ReferenceType theDescriptionReference = this.getDescriptionReference();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descriptionReference", theDescriptionReference), currentHashCode, theDescriptionReference, this.isSetDescriptionReference());
        CodeWithAuthorityType theIdentifier = this.getIdentifier();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identifier", theIdentifier), currentHashCode, theIdentifier, this.isSetIdentifier());
        String theId = this.getId();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId, this.isSetId());
        return currentHashCode;
    }

    public int hashCode() {
        HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode((ObjectLocator)null, strategy);
    }

    public Object clone() {
        return this.copyTo(this.createNewInstance());
    }

    public Object copyTo(Object target) {
        CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return this.copyTo((ObjectLocator)null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        if (null == target) {
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");
        } else {
            if (target instanceof AbstractGMLType) {
                AbstractGMLType copy = (AbstractGMLType)target;
                java.lang.Boolean idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetMetaDataProperty());
                List sourceName;
                List copyName;
                List uniqueNamel;
                if (idShouldBeCopiedAndSet == java.lang.Boolean.TRUE) {
                    sourceName = this.isSetMetaDataProperty() ? this.getMetaDataProperty() : null;
                    copyName = (List)strategy.copy(LocatorUtils.property(locator, "metaDataProperty", sourceName), sourceName, this.isSetMetaDataProperty());
                    copy.unsetMetaDataProperty();
                    if (copyName != null) {
                        uniqueNamel = copy.getMetaDataProperty();
                        uniqueNamel.addAll(copyName);
                    }
                } else if (idShouldBeCopiedAndSet == java.lang.Boolean.FALSE) {
                    copy.unsetMetaDataProperty();
                }

                idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetDescription());
                if (idShouldBeCopiedAndSet == java.lang.Boolean.TRUE) {
                    StringOrRefType sourceDescription = this.getDescription();
                    StringOrRefType copyDescription = (StringOrRefType)strategy.copy(LocatorUtils.property(locator, "description", sourceDescription), sourceDescription, this.isSetDescription());
                    copy.setDescription(copyDescription);
                } else if (idShouldBeCopiedAndSet == java.lang.Boolean.FALSE) {
                    copy.description = null;
                }

                idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetDescriptionReference());
                if (idShouldBeCopiedAndSet == java.lang.Boolean.TRUE) {
                    ReferenceType sourceDescriptionReference = this.getDescriptionReference();
                    ReferenceType copyDescriptionReference = (ReferenceType)strategy.copy(LocatorUtils.property(locator, "descriptionReference", sourceDescriptionReference), sourceDescriptionReference, this.isSetDescriptionReference());
                    copy.setDescriptionReference(copyDescriptionReference);
                } else if (idShouldBeCopiedAndSet == java.lang.Boolean.FALSE) {
                    copy.descriptionReference = null;
                }

                idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetIdentifier());
                if (idShouldBeCopiedAndSet == java.lang.Boolean.TRUE) {
                    CodeWithAuthorityType sourceIdentifier = this.getIdentifier();
                    CodeWithAuthorityType copyIdentifier = (CodeWithAuthorityType)strategy.copy(LocatorUtils.property(locator, "identifier", sourceIdentifier), sourceIdentifier, this.isSetIdentifier());
                    copy.setIdentifier(copyIdentifier);
                } else if (idShouldBeCopiedAndSet == java.lang.Boolean.FALSE) {
                    copy.identifier = null;
                }

                idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetId());
                if (idShouldBeCopiedAndSet == java.lang.Boolean.TRUE) {
                    String sourceId = this.getId();
                    String copyId = (String)strategy.copy(LocatorUtils.property(locator, "id", sourceId), sourceId, this.isSetId());
                    copy.setId(copyId);
                } else if (idShouldBeCopiedAndSet == java.lang.Boolean.FALSE) {
                    copy.id = null;
                }
            }

            return target;
        }
    }

    public void mergeFrom(Object left, Object right) {
        MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        this.mergeFrom((ObjectLocator)null, (ObjectLocator)null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy2 strategy) {
        if (right instanceof AbstractGMLType) {
            AbstractGMLType leftObject = (AbstractGMLType)left;
            AbstractGMLType rightObject = (AbstractGMLType)right;
            java.lang.Boolean idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetMetaDataProperty(), rightObject.isSetMetaDataProperty());
            List lhsName;
            List rhsName;
            List mergedName;
            List uniqueNamel;
            if (idShouldBeMergedAndSet == java.lang.Boolean.TRUE) {
                lhsName = leftObject.isSetMetaDataProperty() ? leftObject.getMetaDataProperty() : null;
                rhsName = rightObject.isSetMetaDataProperty() ? rightObject.getMetaDataProperty() : null;
                mergedName = (List)strategy.merge(LocatorUtils.property(leftLocator, "metaDataProperty", lhsName), LocatorUtils.property(rightLocator, "metaDataProperty", rhsName), lhsName, rhsName, leftObject.isSetMetaDataProperty(), rightObject.isSetMetaDataProperty());
                this.unsetMetaDataProperty();
                if (mergedName != null) {
                    uniqueNamel = this.getMetaDataProperty();
                    uniqueNamel.addAll(mergedName);
                }
            } else if (idShouldBeMergedAndSet == java.lang.Boolean.FALSE) {
                this.unsetMetaDataProperty();
            }

            idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetDescription(), rightObject.isSetDescription());
            if (idShouldBeMergedAndSet == java.lang.Boolean.TRUE) {
                StringOrRefType lhsDescription = leftObject.getDescription();
                StringOrRefType rhsDescription = rightObject.getDescription();
                StringOrRefType mergedDescription = (StringOrRefType)strategy.merge(LocatorUtils.property(leftLocator, "description", lhsDescription), LocatorUtils.property(rightLocator, "description", rhsDescription), lhsDescription, rhsDescription, leftObject.isSetDescription(), rightObject.isSetDescription());
                this.setDescription(mergedDescription);
            } else if (idShouldBeMergedAndSet == java.lang.Boolean.FALSE) {
                this.description = null;
            }

            idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetDescriptionReference(), rightObject.isSetDescriptionReference());
            if (idShouldBeMergedAndSet == java.lang.Boolean.TRUE) {
                ReferenceType lhsDescriptionReference = leftObject.getDescriptionReference();
                ReferenceType rhsDescriptionReference = rightObject.getDescriptionReference();
                ReferenceType mergedDescriptionReference = (ReferenceType)strategy.merge(LocatorUtils.property(leftLocator, "descriptionReference", lhsDescriptionReference), LocatorUtils.property(rightLocator, "descriptionReference", rhsDescriptionReference), lhsDescriptionReference, rhsDescriptionReference, leftObject.isSetDescriptionReference(), rightObject.isSetDescriptionReference());
                this.setDescriptionReference(mergedDescriptionReference);
            } else if (idShouldBeMergedAndSet == java.lang.Boolean.FALSE) {
                this.descriptionReference = null;
            }

            idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetIdentifier(), rightObject.isSetIdentifier());
            if (idShouldBeMergedAndSet == java.lang.Boolean.TRUE) {
                CodeWithAuthorityType lhsIdentifier = leftObject.getIdentifier();
                CodeWithAuthorityType rhsIdentifier = rightObject.getIdentifier();
                CodeWithAuthorityType mergedIdentifier = (CodeWithAuthorityType)strategy.merge(LocatorUtils.property(leftLocator, "identifier", lhsIdentifier), LocatorUtils.property(rightLocator, "identifier", rhsIdentifier), lhsIdentifier, rhsIdentifier, leftObject.isSetIdentifier(), rightObject.isSetIdentifier());
                this.setIdentifier(mergedIdentifier);
            } else if (idShouldBeMergedAndSet == java.lang.Boolean.FALSE) {
                this.identifier = null;
            }

            idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator, rightLocator, leftObject.isSetId(), rightObject.isSetId());
            if (idShouldBeMergedAndSet == java.lang.Boolean.TRUE) {
                String lhsId = leftObject.getId();
                String rhsId = rightObject.getId();
                String mergedId = (String)strategy.merge(LocatorUtils.property(leftLocator, "id", lhsId), LocatorUtils.property(rightLocator, "id", rhsId), lhsId, rhsId, leftObject.isSetId(), rightObject.isSetId());
                this.setId(mergedId);
            } else if (idShouldBeMergedAndSet == java.lang.Boolean.FALSE) {
                this.id = null;
            }
        }

    }

    public void setMetaDataProperty(List<MetaDataPropertyType> value) {
        this.metaDataProperty = null;
        if (value != null) {
            List<MetaDataPropertyType> draftl = this.getMetaDataProperty();
            draftl.addAll(value);
        }

    }

    public AbstractGMLType withMetaDataProperty(MetaDataPropertyType... values) {
        if (values != null) {
            MetaDataPropertyType[] arr$ = values;
            int len$ = values.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                MetaDataPropertyType value = arr$[i$];
                this.getMetaDataProperty().add(value);
            }
        }

        return this;
    }

    public AbstractGMLType withMetaDataProperty(Collection<MetaDataPropertyType> values) {
        if (values != null) {
            this.getMetaDataProperty().addAll(values);
        }

        return this;
    }

    public AbstractGMLType withDescription(StringOrRefType value) {
        this.setDescription(value);
        return this;
    }

    public AbstractGMLType withDescriptionReference(ReferenceType value) {
        this.setDescriptionReference(value);
        return this;
    }

    public AbstractGMLType withIdentifier(CodeWithAuthorityType value) {
        this.setIdentifier(value);
        return this;
    }

    public AbstractGMLType withId(String value) {
        this.setId(value);
        return this;
    }

    public AbstractGMLType withMetaDataProperty(List<MetaDataPropertyType> value) {
        this.setMetaDataProperty(value);
        return this;
    }
}
