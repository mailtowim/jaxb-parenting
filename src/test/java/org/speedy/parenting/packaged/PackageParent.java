package org.speedy.parenting.packaged;

import org.speedy.parenting.Child;
import org.speedy.parenting.Parent;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface PackageParent<C extends PackageChild>
        extends Child<PackageParent<? extends PackageChild>>, PackageChild,
        Parent<C, PackageParent<? extends PackageChild>> {

    @Override
    PackageParent<? extends PackageChild> getParent();

    @Override
    void setParent(PackageParent<? extends PackageChild> untypedChildren);

    @Override
    PackageParent<C> copy();

    @Override
    C get(int index);

    @Override
    C set(int index, C element);

    @Override
    C remove(int index);
}

