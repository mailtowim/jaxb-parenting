package org.speedy.parenting.simple;

import org.speedy.parenting.AbstractRootParent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "americanParent")
public class AmericanParent extends AbstractRootParent<AmericanChild> {

    @Override
    public AmericanParent copy() {
        return (AmericanParent) super.shallowCopy();
    }

    private List<AmericanChild> getChildList(){
        return this;
    }

    @XmlElements({
            @XmlElement(name = "northAmerican", type = NorthAmericanChild.class),
            @XmlElement(name = "southAmerican", type = SouthAmericanChild.class)
    })
    private void setChildList(List<AmericanChild> childList){
        //copy is needed for java before version 8
        List<AmericanChild> children=new ArrayList<AmericanChild>(childList);
        this.clear();
        this.addAll(children);
    }
}
