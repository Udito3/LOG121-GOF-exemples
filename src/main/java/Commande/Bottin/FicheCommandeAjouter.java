package Commande.Bottin;

public class FicheCommandeAjouter extends ACommande {

	private int index;
	private Bottin bottin;
	private Fiche ficheRetiree = null;

	public FicheCommandeAjouter(Bottin bottin, int index, GestionnaireDeCommandes gdc) {
        super(gdc);
        this.bottin = bottin;
		this.index = index;
	}


	/**
	 * @return boolean
	 */
	public void faire() {
	    gdc.clearARefaire();
		FicheDialog dialog = new FicheDialog(new Fiche(), FicheDialog.Type.AJOUTER);
		dialog.setVisible(true);
		if (dialog.isOKPressed()) {
			Fiche fiche = dialog.getFiche();
			bottin.add(index, fiche);
			gdc.addFirstHistoire(this);
		} else {
		    gdc.clearHistoire();
        }
	}

	public void refaire() {
		bottin.add(index, ficheRetiree);
	}

	public void defaire() {
		ficheRetiree = bottin.remove(index);
	}
}
