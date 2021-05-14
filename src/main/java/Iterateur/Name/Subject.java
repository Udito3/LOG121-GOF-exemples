package Iterateur.Name;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {
    private String state;
    List<IObservateur> observateurs;

    public Subject() {
        observateurs = new ArrayList<>();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void notifyObservers(Object arg) {
        this.state = String.valueOf(arg);

        for (IObservateur observateur : observateurs) {
            observateur.update(arg);
        }
    }

    public void notifyObservers() {
        for (IObservateur observateur : observateurs) {
            observateur.update();
        }
    }

    public void addObserver(Observateur observateur) {
        this.observateurs.add(observateur);
    }
}
