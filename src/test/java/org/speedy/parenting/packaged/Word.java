package org.speedy.parenting.packaged;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "word")
public class Word extends AbstractPackageChild {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Word copy() {
        Word word = new Word();
        word.setValue(value);
        return word;
    }
}
