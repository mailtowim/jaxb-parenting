package org.speedy.parenting.advanced;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestJaxb {

    @Test
    public void testMarshallCycle() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AmericanParent.class);
        Marshaller marshaller = jc.createMarshaller();
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><southAmericanParent>" +
                "<northAmerican/>" +
                "<northAmericanParent><northAmerican/></northAmericanParent>" +
                "<southAmerican/>" +
                "<northAmerican/>" +
                "</southAmericanParent>";
        Reader reader = new StringReader(xmlString);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        AmericanParent americanParent = (AmericanParent) unmarshaller.unmarshal(reader);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(americanParent, stringWriter);
        assertThat(stringWriter.toString(), equalTo(xmlString));
    }

}
