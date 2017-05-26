package org.speedy.parenting.packaged;

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
        JAXBContext jc = JAXBContext.newInstance(PartOfSpeech.class, Punctuation.class, Space.class, SpaceParent.class,
                Word.class);
        Marshaller marshaller = jc.createMarshaller();
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><part-of-speech>" +
                "<word/>" +
                "<space-parent><space/></space-parent>" +
                "<part-of-speech><word/></part-of-speech>" +
                "<space/>" +
                "<word/>" +
                "<punctuation/>" +
                "</part-of-speech>";
        Reader reader = new StringReader(xmlString);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        PartOfSpeech partOfSpeech = (PartOfSpeech) unmarshaller.unmarshal(reader);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(partOfSpeech, stringWriter);
        assertThat(stringWriter.toString(), equalTo(xmlString));
    }

}
