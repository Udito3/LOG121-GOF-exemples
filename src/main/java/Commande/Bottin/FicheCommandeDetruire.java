package Commande.Bottin;

public class FicheCommandeDetruire extends ACommande {

	private int index;
	private Fiche ficheOriginale = null;
	private Bottin bottin;

	public FicheCommandeDetruire(Bottin bottin, int index, GestionnaireDeCommandes gdc) {
	    super(gdc);
		this.bottin = bottin;
		this.index = index;
	}

	public void faire() {
        gdc.clearARefaire();
		ficheOriginale = new Fiche(bottin.get(index));
		bottin.remove(index);
		gdc.addFirstHistoire(this);
	}

	public void defaire() {
		bottin.insertElementAt(ficheOriginale, index);
	}

	public void refaire() {
		bottin.remove(index);
	}
}
