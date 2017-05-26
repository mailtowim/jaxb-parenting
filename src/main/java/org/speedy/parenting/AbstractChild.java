package org.speedy.parenting;

import javax.xml.bind.annotation.XmlTransient;

public abstract class AbstractChild<P extends Parent> implements Child<P>{

    protected P parent;

    @Override
    public P getParent() {
        return parent;
    }

    @XmlTransient
    @Override
    public void setParent(P parent) {
        this.parent = parent;
    }

    public void detach() {
        if (getParent() != null) {
            getParent().remove(this);
        }
    }
}
