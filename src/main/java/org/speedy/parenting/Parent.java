package org.speedy.parenting;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface Parent<C extends Child, P extends Parent> extends List<C>, Child<P> {

    P getParent();

    void setParent(P p);

    Parent<C,P> copy();

    void detach();

    @Override
    C get(int index);

    @Override
    C set(int index, C element);

    @Override
    C remove(int index);
}
