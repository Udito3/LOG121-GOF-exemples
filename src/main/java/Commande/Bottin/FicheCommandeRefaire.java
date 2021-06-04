package Commande.Bottin;

public class FicheCommandeRefaire extends ACommande {

    public FicheCommandeRefaire(GestionnaireDeCommandes gdc) {
        super(gdc);
    }

    @Override
	public void faire() {
        System.out.println("FicheCommandeRefaire::faire");
        if (gdc.getARefaireSize() > 0) {
            Commande commandeARefaire = gdc.removeARefaireFirst();
            commandeARefaire.refaire();
            gdc.addFirstHistoire(commandeARefaire);
        }
	}

	@Override
	public void defaire() {
        System.out.println("FicheCommandeRefaire::defaire");
	}

	@Override
	public void refaire() {
		System.out.println("FicheCommandeRefaire::refaire");
	}

}
