package Commande.Bottin;

public abstract class ACommande implements Commande {
    protected GestionnaireDeCommandes gdc;

    public ACommande(GestionnaireDeCommandes gdc) {
        this.gdc = gdc;
    }

}
