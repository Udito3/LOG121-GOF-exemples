package Iterateur.Name;

public interface ISubject {
    public String getState();
    public void setState(String state);
    public void notifyObservers(Object arg);
    public void notifyObservers();
    public void addObserver(Observateur observateur);
}
