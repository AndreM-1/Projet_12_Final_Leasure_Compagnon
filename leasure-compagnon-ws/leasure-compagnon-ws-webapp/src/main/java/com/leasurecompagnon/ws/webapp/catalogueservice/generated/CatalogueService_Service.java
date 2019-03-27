package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-27T12:25:43.891+01:00
 * Generated source version: 3.2.5
 *
 */
@WebServiceClient(name = "CatalogueService",
                  wsdlLocation = "file:/C:/Users/Jean%20et%20Maria/Parcours_Developpeur_Application_Java/P12_Final/leasure-compagnon-ws/leasure-compagnon-ws-webapp/src/main/resources/wsdl/CatalogueService.wsdl",
                  targetNamespace = "http://www.example.org/CatalogueService/")
public class CatalogueService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/CatalogueService/", "CatalogueService");
    public final static QName CatalogueServiceSOAP = new QName("http://www.example.org/CatalogueService/", "CatalogueServiceSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/Jean%20et%20Maria/Parcours_Developpeur_Application_Java/P12_Final/leasure-compagnon-ws/leasure-compagnon-ws-webapp/src/main/resources/wsdl/CatalogueService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CatalogueService_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/Jean%20et%20Maria/Parcours_Developpeur_Application_Java/P12_Final/leasure-compagnon-ws/leasure-compagnon-ws-webapp/src/main/resources/wsdl/CatalogueService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CatalogueService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CatalogueService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CatalogueService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CatalogueService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CatalogueService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CatalogueService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CatalogueService
     */
    @WebEndpoint(name = "CatalogueServiceSOAP")
    public CatalogueService getCatalogueServiceSOAP() {
        return super.getPort(CatalogueServiceSOAP, CatalogueService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CatalogueService
     */
    @WebEndpoint(name = "CatalogueServiceSOAP")
    public CatalogueService getCatalogueServiceSOAP(WebServiceFeature... features) {
        return super.getPort(CatalogueServiceSOAP, CatalogueService.class, features);
    }

}
