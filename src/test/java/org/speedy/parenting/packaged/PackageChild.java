package org.speedy.parenting.packaged;

import org.speedy.parenting.Child;

public interface PackageChild extends Child<PackageParent<? extends PackageChild>> {

    @Override
    PackageParent<? extends PackageChild> getParent();

    @Override
    void setParent(PackageParent<? extends PackageChild> untypedChildren);

    @Override
    PackageChild copy();
}
