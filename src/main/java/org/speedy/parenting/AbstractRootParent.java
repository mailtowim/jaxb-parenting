package org.speedy.parenting;

import javax.xml.bind.annotation.XmlTransient;

public abstract class AbstractRootParent<C extends Child>
        extends AbstractParent<C, VoidParent>
        implements Parent<C, VoidParent> {

    @Override
    public VoidParent getParent() {
        return super.getParent();
    }

    @Override
    @XmlTransient
    public void setParent(VoidParent parent) {
        throw new IllegalStateException();
    }

    @Override
    public abstract AbstractRootParent<C> copy();

    @Override
    protected AbstractRootParent<C> shallowCopy() {
        return (AbstractRootParent<C>) super.shallowCopy();
    }
}
