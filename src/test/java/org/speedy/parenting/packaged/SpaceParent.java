package org.speedy.parenting.packaged;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "space-parent")
public class SpaceParent extends AbstractPackageParent<Space> {

    @Override
    public SpaceParent copy() {
        return (SpaceParent) super.shallowCopy();
    }

    private List<Space> getChildList() {
        return this;
    }

    @XmlElements(
            @XmlElement(name = "space", type = Space.class)
    )
    private void setChildList(List<Space> childList) {
        //copy is needed for java before version 8
        List<Space> children = new ArrayList<Space>(childList);
        this.clear();
        this.addAll(children);
    }
}
