package org.speedy.parenting.advanced;

import org.speedy.parenting.AbstractChild;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "northAmerican")
public class NorthAmericanChild extends AbstractChild<AmericanParent> implements AmericanChild {

    public NorthAmericanChild copy() {
        return new NorthAmericanChild();
    }

}
