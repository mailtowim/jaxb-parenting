package org.speedy.parenting;

import javax.xml.bind.annotation.XmlTransient;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class VoidParent implements Parent<Child<VoidParent>, VoidParent> {

    private VoidParent() {
        throw new IllegalStateException();
    }

    @Override
    public VoidParent getParent() {
        throw new IllegalStateException();
    }

    @Override
    @XmlTransient
    public void setParent(VoidParent voidChildren) {
        throw new IllegalStateException();
    }

    @Override
    public Parent<Child<VoidParent>, VoidParent> copy() {
        throw new IllegalStateException();
    }

    @Override
    public void detach() {
        throw new IllegalStateException();
    }

    @Override
    public int size() {
        throw new IllegalStateException();
    }

    @Override
    public boolean isEmpty() {
        throw new IllegalStateException();
    }

    @Override
    public boolean contains(Object o) {
        throw new IllegalStateException();
    }

    @Override
    public Iterator<Child<VoidParent>> iterator() {
        throw new IllegalStateException();
    }

    @Override
    public Object[] toArray() {
        throw new IllegalStateException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new IllegalStateException();
    }

    @Override
    public boolean add(Child<VoidParent> voidChild) {
        throw new IllegalStateException();
    }

    @Override
    public boolean remove(Object o) {
        throw new IllegalStateException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new IllegalStateException();
    }

    @Override
    public boolean addAll(Collection<? extends Child<VoidParent>> c) {
        throw new IllegalStateException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Child<VoidParent>> c) {
        throw new IllegalStateException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new IllegalStateException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new IllegalStateException();
    }

    @Override
    public void clear() {
        throw new IllegalStateException();
    }

    @Override
    public Child<VoidParent> get(int index) {
        throw new IllegalStateException();
    }

    @Override
    public Child<VoidParent> set(int index, Child<VoidParent> element) {
        throw new IllegalStateException();
    }

    @Override
    public void add(int index, Child<VoidParent> element) {
        throw new IllegalStateException();
    }

    @Override
    public Child<VoidParent> remove(int index) {
        throw new IllegalStateException();
    }

    @Override
    public int indexOf(Object o) {
        throw new IllegalStateException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new IllegalStateException();
    }

    @Override
    public ListIterator<Child<VoidParent>> listIterator() {
        throw new IllegalStateException();
    }

    @Override
    public ListIterator<Child<VoidParent>> listIterator(int index) {
        throw new IllegalStateException();
    }

    @Override
    public List<Child<VoidParent>> subList(int fromIndex, int toIndex) {
        throw new IllegalStateException();
    }

    @Override
    public void replaceAll(UnaryOperator<Child<VoidParent>> operator) {
        throw new IllegalStateException();
    }

    @Override
    public Spliterator<Child<VoidParent>> spliterator() {
        throw new IllegalStateException();
    }

    @Override
    public boolean removeIf(Predicate<? super Child<VoidParent>> filter) {
        throw new IllegalStateException();
    }

    @Override
    public Stream<Child<VoidParent>> stream() {
        throw new IllegalStateException();
    }

    @Override
    public Stream<Child<VoidParent>> parallelStream() {
        throw new IllegalStateException();
    }

    @Override
    public void forEach(Consumer<? super Child<VoidParent>> action) {
        throw new IllegalStateException();
    }

    @Override
    public void sort(Comparator<? super Child<VoidParent>> comparator) {
        throw new IllegalStateException();
    }
}
