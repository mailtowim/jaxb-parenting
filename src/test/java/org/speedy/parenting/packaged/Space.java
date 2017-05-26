package org.speedy.parenting.packaged;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "space")
public class Space extends AbstractPackageChild {
    @Override
    public Space copy() {
        return new Space();
    }
}
