package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.Todo;
import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.InvertStringCase;
import com.epam.rd.izh.soap.com.dataaccess.webservicesserver.InvertStringCaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

public class SoapService {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    public static void main(String[] args) {

        SoapService soapService = new SoapService();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("com.epam.rd.izh.soap.com.dataaccess.webservicesserver");
        System.out.println(soapService.invertStringCase("lower case", marshaller));

        try {
            System.out.println(soapService.getTodo());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    public String invertStringCase(String lineForCaseInvert, Jaxb2Marshaller marshaller) {

        InvertStringCase request = new InvertStringCase();
        request.setSAString(lineForCaseInvert);

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);


        InvertStringCaseResponse response = (InvertStringCaseResponse) webServiceTemplate
                .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/TextCasing.wso?op=InvertStringCase", request);

        return response.getInvertStringCaseResult();
    }

    public Todo getTodo() throws JsonProcessingException {

        String result = REST_TEMPLATE.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(result, Todo.class);
    }
}
