package org.speedy.parenting.advanced;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "southAmericanParent")
public class SouthAmericanParent extends AmericanParent {
    @Override
    public SouthAmericanParent copy() {
        return (SouthAmericanParent) super.copy();
    }
}
