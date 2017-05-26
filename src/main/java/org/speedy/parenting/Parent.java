package org.speedy.parenting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface Parent<C extends Child, P extends Parent> extends List<C>, Child<P> {

    P getParent();

    void setParent(P p);

    Parent<C, P> copy();

    @Override
    C get(int index);

    @Override
    C set(int index, C element);

    @Override
    C remove(int index);

    @Override
    default void sort(Comparator<? super C> comparator) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) comparator);
        this.clear();
        for (Object e : a) {
            this.add((C) e);
        }
    }
}
