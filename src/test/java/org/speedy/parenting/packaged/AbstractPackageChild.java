package org.speedy.parenting.packaged;

import org.speedy.parenting.AbstractChild;
import org.speedy.parenting.Child;

import javax.xml.bind.annotation.XmlTransient;

public abstract class AbstractPackageChild
        extends AbstractChild<PackageParent<? extends PackageChild>>
        implements Child<PackageParent<? extends PackageChild>>, PackageChild {

    @Override
    public abstract AbstractPackageChild copy();

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    public PackageParent<? extends PackageChild> getParent() {
        return super.getParent();
    }

    @XmlTransient
    @Override
    public void setParent(PackageParent<? extends PackageChild> parent) {
        super.setParent(parent);
    }
}
