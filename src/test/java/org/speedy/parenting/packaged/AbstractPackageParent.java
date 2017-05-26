package org.speedy.parenting.packaged;

import org.speedy.parenting.AbstractParent;
import org.speedy.parenting.Child;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractPackageParent<C extends PackageChild>
        extends AbstractParent<C, PackageParent<? extends PackageChild>>
        implements Child<PackageParent<? extends PackageChild>>, PackageChild, PackageParent<C> {

    @Override
    public abstract AbstractPackageParent<C> copy();

    @Override
    protected AbstractPackageParent<C> shallowCopy() {
        return (AbstractPackageParent<C>) super.shallowCopy();
    }

    @Override
    public Iterator<C> iterator() {
        return super.iterator();
    }

    @Override
    public boolean add(C c) {
        return super.add(c);
    }

    @Override
    public boolean addAll(Collection<? extends C> collection) {
        return super.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends C> collection) {
        return super.addAll(index, collection);
    }

    @Override
    public C get(int index) {
        return super.get(index);
    }

    @Override
    public C set(int index, C element) {
        return super.set(index, element);
    }

    @Override
    public void add(int index, C element) {
        super.add(index, element);
    }

    @Override
    public C remove(int index) {
        return super.remove(index);
    }

    @Override
    public ListIterator<C> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<C> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public List<C> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
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
