package org.speedy.parenting.advanced;

import org.speedy.parenting.AbstractParent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.ArrayList;
import java.util.List;

public abstract class AmericanParent extends AbstractParent<AmericanChild, AmericanParent> implements AmericanChild {

    @Override
    public AmericanParent copy() {
        return (AmericanParent) super.shallowCopy();
    }

    private List<AmericanChild> getChildList() {
        return this;
    }

    @XmlElements({
            @XmlElement(name = "northAmerican", type = NorthAmericanChild.class),
            @XmlElement(name = "southAmerican", type = SouthAmericanChild.class),
            @XmlElement(name = "northAmericanParent", type = NorthAmericanParent.class),
            @XmlElement(name = "southAmericanParent", type = SouthAmericanParent.class)
    })
    private void setChildList(List<AmericanChild> childList) {
        //copy is needed for java before version 8
        List<AmericanChild> children = new ArrayList<AmericanChild>(childList);
        this.clear();
        this.addAll(children);
    }
}
