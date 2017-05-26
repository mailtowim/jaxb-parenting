package org.speedy.parenting.packaged;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "part-of-speech")
public class PartOfSpeech extends AbstractPackageParent<PackageChild> {

    @Override
    public PartOfSpeech copy() {
        PartOfSpeech partOfSpeech = (PartOfSpeech) super.shallowCopy();
        return partOfSpeech;
    }

    private List<PackageChild> getChildList() {
        return this;
    }

    @XmlAnyElement(lax = true)
    private void setChildList(List<PackageChild> childList) {
        //copy is needed for java before version 8
        List<PackageChild> children = new ArrayList<PackageChild>(childList);
        this.clear();
        this.addAll(children);
    }
}
