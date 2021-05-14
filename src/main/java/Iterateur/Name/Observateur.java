package Iterateur.Name;

public class Observateur implements IObservateur {

    private String nom;
    private String state;
    private ISubject subject;

    public Observateur(String nom, ISubject subject) {
        this.nom = nom;
        this.subject = subject;
    }

    public void update(Object arg) {
        this.state = String.valueOf(arg);
        System.out.println(getMessage());
    }

    public void update() {
        this.state = subject.getState();
        System.out.println(getMessage() + " -> update sans les paramêtres");
    }

    public String getMessage() {
        return nom + state;
    }
}
