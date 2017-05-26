package org.speedy.parenting;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

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
