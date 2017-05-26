package org.speedy.parenting.advanced;

import org.speedy.parenting.AbstractChild;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "southAmerican")
public class SouthAmericanChild extends AbstractChild<AmericanParent> implements AmericanChild {

    public SouthAmericanChild copy() {
        return new SouthAmericanChild();
    }

}
