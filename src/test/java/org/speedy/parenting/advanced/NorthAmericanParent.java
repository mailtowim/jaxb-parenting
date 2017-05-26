package org.speedy.parenting.advanced;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "northAmericanParent")
public class NorthAmericanParent extends AmericanParent {
    @Override
    public NorthAmericanParent copy() {
        return (NorthAmericanParent) super.copy();
    }
}
