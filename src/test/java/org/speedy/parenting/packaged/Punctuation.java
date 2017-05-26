package org.speedy.parenting.packaged;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "punctuation")
public class Punctuation extends AbstractPackageChild {

    @Override
    public Punctuation copy() {
        return new Punctuation();
    }
}
