package org.speedy.parenting.simple;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "southAmerican")
public class SouthAmericanChild extends AmericanChild {

    public SouthAmericanChild copy() {
        return new SouthAmericanChild();
    }

}
