//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 04:49:32 PM EST 
//


package org.yawlfoundation.sb.timesheetinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.yawlfoundation.sb.timesheetinfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FillOutADReport_QNAME = new QName("http://www.yawlfoundation.org/sb/timeSheetInfo", "Fill_Out_AD_Report");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.yawlfoundation.sb.timesheetinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FillOutADReportType }
     * 
     */
    public FillOutADReportType createFillOutADReportType() {
        return new FillOutADReportType();
    }

    /**
     * Create an instance of {@link ArtistTimeSheetType }
     * 
     */
    public ArtistTimeSheetType createArtistTimeSheetType() {
        return new ArtistTimeSheetType();
    }

    /**
     * Create an instance of {@link GeneralInfoType }
     * 
     */
    public GeneralInfoType createGeneralInfoType() {
        return new GeneralInfoType();
    }

    /**
     * Create an instance of {@link MealInfoType }
     * 
     */
    public MealInfoType createMealInfoType() {
        return new MealInfoType();
    }

    /**
     * Create an instance of {@link SingleArtistType }
     * 
     */
    public SingleArtistType createSingleArtistType() {
        return new SingleArtistType();
    }

    /**
     * Create an instance of {@link ChildrenTimeSheetType }
     * 
     */
    public ChildrenTimeSheetType createChildrenTimeSheetType() {
        return new ChildrenTimeSheetType();
    }

    /**
     * Create an instance of {@link CrewTimeSheetType }
     * 
     */
    public CrewTimeSheetType createCrewTimeSheetType() {
        return new CrewTimeSheetType();
    }

    /**
     * Create an instance of {@link SingleMealType }
     * 
     */
    public SingleMealType createSingleMealType() {
        return new SingleMealType();
    }

    /**
     * Create an instance of {@link SingleCrewType }
     * 
     */
    public SingleCrewType createSingleCrewType() {
        return new SingleCrewType();
    }

    /**
     * Create an instance of {@link TimeSheetInfoType }
     * 
     */
    public TimeSheetInfoType createTimeSheetInfoType() {
        return new TimeSheetInfoType();
    }

    /**
     * Create an instance of {@link SingleChildrenType }
     * 
     */
    public SingleChildrenType createSingleChildrenType() {
        return new SingleChildrenType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FillOutADReportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.yawlfoundation.org/sb/timeSheetInfo", name = "Fill_Out_AD_Report")
    public JAXBElement<FillOutADReportType> createFillOutADReport(FillOutADReportType value) {
        return new JAXBElement<FillOutADReportType>(_FillOutADReport_QNAME, FillOutADReportType.class, null, value);
    }

}