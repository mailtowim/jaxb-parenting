package org.speedy.parenting;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class AbstractParent<C extends Child, P extends Parent> extends AbstractChild<P> implements Parent<C, P> {

    protected MArrayList<C> children = new MArrayList<C>();

    public abstract AbstractParent<C, P> copy();

    protected AbstractParent<C, P> shallowCopy() {
        try {
            AbstractParent<C, P> nodeContainer = getClass().newInstance();
            for (C c : this) {
                nodeContainer.add((C) c.copy());
            }
            return nodeContainer;
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int size() {
        return children.size();
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public boolean contains(Object o) {
        return children.contains(o);
    }

    public Iterator<C> iterator() {
        return new Itr();
    }

    public Object[] toArray() {
        return children.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return children.toArray(a);
    }

    public boolean add(C c) {
        if (c.getParent() != null) {
            throw new IllegalStateException();
        }
        c.setParent(this);
        return children.add(c);
    }

    public boolean remove(Object o) {
        boolean removed = children.remove(o);
        if (removed) {
            ((Child) o).setParent(null);
        }
        return removed;
    }

    public boolean containsAll(Collection<?> collection) {
        return children.containsAll(collection);
    }

    public boolean addAll(Collection<? extends C> collection) {
        for (C child : collection) {
            if (child.getParent() != null) {
                throw new IllegalStateException();
            }
        }
        for (C child : collection) {
            child.setParent(this);
        }
        return children.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends C> collection) {
        for (C child : collection) {
            if (child.getParent() != null) {
                throw new IllegalStateException();
            }
        }
        for (C child : collection) {
            child.setParent(this);
        }
        return children.addAll(index, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        List<Child> removeableList = new ArrayList<Child>();
        for (Object child : collection) {
            if (child instanceof Child) {
                removeableList.add((Child) child);
            }
        }
        removeableList.retainAll(children);

        for (Child child : removeableList) {
            child.setParent(null);
        }
        return children.removeAll(removeableList);
    }

    public boolean retainAll(Collection<?> collection) {
        List<C> list = new ArrayList<C>();
        list.addAll(this);
        list.removeAll(collection);
        for (Child child : list) {
            child.setParent(null);
        }
        return children.retainAll(collection);
    }

    public void clear() {
        for (C child : this) {
            child.setParent(null);
        }
        children.clear();
    }

    public C get(int index) {
        return children.get(index);
    }

    public C set(int index, C element) {
        if (element.getParent() != null) {
            throw new IllegalStateException();
        }
        C oldChild = children.set(index, element);
        if (oldChild != null) {
            oldChild.setParent(null);
        }
        return oldChild;
    }

    public void add(int index, C element) {
        if (element.getParent() != null) {
            throw new IllegalStateException();
        }
        element.setParent(this);
        children.add(index, element);
    }

    public C remove(int index) {
        C child = children.remove(index);
        if (child != null) {
            child.setParent(null);
        }
        return child;
    }

    public int indexOf(Object o) {
        return children.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return children.lastIndexOf(o);
    }

    public ListIterator<C> listIterator() {
        return new ListItr(0);
    }

    public ListIterator<C> listIterator(int index) {
        return new ListItr(index);
    }

    public List<C> subList(int fromIndex, int toIndex) {
        return children.subList(fromIndex, toIndex);
    }

    @Override
    public Stream<C> stream() {
        return children.stream();
    }

    @Override
    public Stream<C> parallelStream() {
        return children.parallelStream();
    }

    @Override
    public Spliterator<C> spliterator() {
        return children.spliterator();
    }

    @Override
    public void forEach(Consumer<? super C> action) {
        children.forEach(action);
    }

    private class Itr implements Iterator<C> {

        int cursor = 0;

        int lastRet = -1;

        int expectedModCount = children.getModCount();

        public boolean hasNext() {
            return cursor != size();
        }

        public C next() {
            checkForComodification();
            try {
                int i = cursor;
                C next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbstractParent.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = children.getModCount();
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (children.getModCount() != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class ListItr extends Itr implements ListIterator<C> {
        ListItr(int index) {
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public C previous() {
            checkForComodification();
            try {
                int i = cursor - 1;
                C previous = get(i);
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void set(C e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbstractParent.this.set(lastRet, e);
                expectedModCount = children.getModCount();
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(C e) {
            checkForComodification();

            try {
                int i = cursor;
                AbstractParent.this.add(i, e);
                lastRet = -1;
                cursor = i + 1;
                expectedModCount = children.getModCount();
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class MArrayList<R> extends ArrayList<R> {
        protected int getModCount() {
            return modCount;
        }
    }
}
