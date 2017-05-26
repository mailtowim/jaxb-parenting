package org.speedy.parenting;

public interface Child<P extends Parent> {

    P getParent();

    void setParent(P p);

    Child<P> copy();

    void detach();
}
