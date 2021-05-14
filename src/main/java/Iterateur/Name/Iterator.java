package Iterateur.Name;

public interface Iterator extends ISubject {
    public boolean hasNext();
    public boolean hasPrevious();
    public Object next();
    public Object previous();
}
