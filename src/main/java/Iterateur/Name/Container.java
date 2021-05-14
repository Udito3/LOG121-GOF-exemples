package Iterateur.Name;

import java.util.Comparator;

public interface Container {
    public Iterator getIterator();
    public Iterator getIteratorReverse();
    public void setComparateur(Comparator<String> comparateur);
    public void sort();
}
