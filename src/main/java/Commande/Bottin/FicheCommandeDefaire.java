package Commande.Bottin;

public class FicheCommandeDefaire extends ACommande {

    public FicheCommandeDefaire(GestionnaireDeCommandes gdc) {
        super(gdc);
    }

    @Override
	public void faire() {
        System.out.print("defaire");
        if (gdc.getHistoireSize() > 0) {
            Commande commandeADefaire = gdc.removeHistoireFirst();
            commandeADefaire.defaire();
            gdc.addFirstARefaire(commandeADefaire);
        }
	}

	@Override
	public void defaire() {
        System.out.print("defaire");
	}

	@Override
	public void refaire() {
	 System.out.println("refaire");

	}

}
