package com.epam.rd.izh.service;

import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.InvertStringCase;
import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.InvertStringCaseResponse;
import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.TextCasing;
import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.TextCasingSoapType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapService {
    public static void main(String[] args) {
        TextCasing textCasing = new TextCasing();
        SoapService soapService = new SoapService();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("com.epam.rd.izh.soap.com.dataaccess.webservicesserver");
        soapService.invertStringCase("lower casez");
    }


    public String invertStringCase(String sAString) {

        InvertStringCase request = new InvertStringCase();
        request.setSAString(sAString);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("com.epam.rd.izh.soap.com.dataaccess.webservicesserver");
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);


        InvertStringCaseResponse response = (InvertStringCaseResponse) webServiceTemplate
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/TextCasing.wso?op=InvertStringCase",
                        request, new SoapActionCallback("https://www.dataaccess.com/webservicesserver/TextCasing.wso/InvertStringCase"));
        System.out.println(response.getInvertStringCaseResult());
        return null;
    }

}
