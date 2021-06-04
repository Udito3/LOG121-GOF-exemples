package Commande.Bottin;

public class FicheCommandeVoir extends ACommande {

	private int index;
	private Bottin bottin;

	public FicheCommandeVoir(Bottin bottin, int index, GestionnaireDeCommandes gdc) {
	    super(gdc);
		this.index = index;
		this.bottin = bottin;
	}

	public void faire() {
		Fiche fiche = bottin.get(index);
		FicheDialog dialog = new FicheDialog(fiche, FicheDialog.Type.VOIR);
		dialog.setVisible(true);
	}

	public void defaire() { }

	public void refaire() {	}
}
