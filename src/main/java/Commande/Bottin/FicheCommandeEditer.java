package Commande.Bottin;

public class FicheCommandeEditer extends ACommande {

	private int index;
	private Fiche ficheOriginale = null;
	private Fiche ficheRetiree = null;
	private Bottin bottin;

	public FicheCommandeEditer(Bottin bottin, int index, GestionnaireDeCommandes gdc) {
	    super(gdc);
		this.bottin = bottin;
		this.index = index;
	}

	public void faire() {
        gdc.clearARefaire();
		Fiche fiche = bottin.get(index);
		ficheOriginale = new Fiche(fiche);
		FicheDialog dialog = new FicheDialog(fiche, FicheDialog.Type.EDITER);
		dialog.setVisible(true);
		if (dialog.isOKPressed()) {
			bottin.set(index, dialog.getFiche());
			gdc.addFirstHistoire(this);
		} else {
            gdc.clearHistoire();
        }
	}

	public void defaire() {
		ficheRetiree = bottin.get(index);
		bottin.set(index, ficheOriginale);
	}

	public void refaire() {
		bottin.set(index, ficheRetiree);
	}
}
