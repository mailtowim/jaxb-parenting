package org.speedy.parenting.simple;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestJaxb {

    @Test
    public void testMarshallCycle() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AmericanParent.class);
        Marshaller marshaller = jc.createMarshaller();
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><americanParent>" +
                "<northAmerican/>" +
                "<southAmerican/>" +
                "<northAmerican/>" +
                "</americanParent>";
        Reader reader = new StringReader(xmlString);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        AmericanParent americanParent = (AmericanParent) unmarshaller.unmarshal(reader);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(americanParent, stringWriter);
        assertThat(stringWriter.toString(), equalTo(xmlString));
    }

}
