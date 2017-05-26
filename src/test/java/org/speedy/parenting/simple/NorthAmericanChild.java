package org.speedy.parenting.simple;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "northAmerican")
public class NorthAmericanChild extends AmericanChild {

    public NorthAmericanChild copy() {
        return new NorthAmericanChild();
    }
	
}
