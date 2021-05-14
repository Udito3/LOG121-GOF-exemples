package Iterateur.Name;

import java.util.*;

public class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Juliette", "laury"};
    Comparator<String> comparateur;

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    @Override
    public Iterator getIteratorReverse() {
        return new NameIterator(names.length);
    }

    public void setComparateur(Comparator<String> comparateur) {
        this.comparateur = comparateur;
    }

    public void sort() {
        Arrays.sort(names, comparateur);
    }

    private class NameIterator extends Subject implements Iterator {
        int index;

        public NameIterator() {
            this.index = 0;
        }

        public NameIterator(int index) {
            this.index = index - 1;
        }

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public boolean hasPrevious() {
            if (index >= 0) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                String name = names[index++];
                String state = " next " + name;
                super.setState(state);
                super.notifyObservers(state);
                super.notifyObservers();
                return name;
            }
            return null;
        }

        @Override
        public Object previous() {
            if (this.hasPrevious()) {
                String name = names[index--];
                String state = " previous " + name;
                super.setState(state);
                super.notifyObservers(state);
                super.notifyObservers();
                return name;
            }
            return null;
        }

        @Override
        public void addObserver(Observateur observateur) {
            super.addObserver(observateur);
        }
    }
}
