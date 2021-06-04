package Commande.Bottin;

import javax.swing.*;
import java.io.IOException;

public class FicheCommandeFermer extends ACommande {

	private Bottin bottin;

	public FicheCommandeFermer(Bottin bottin, GestionnaireDeCommandes gdc) {
	    super(gdc);
		this.bottin = bottin;
	}

	public void faire() {
        gdc.clearARefaire();
		try {
			bottin.ecrire();
		} catch (IOException e) {
    		JOptionPane.showMessageDialog(null,
	    			"Erreur", "Erreur à l'écriture du bottin", JOptionPane.ERROR_MESSAGE, null);
		} finally {
			System.exit(0);
		}
		gdc.clearHistoire();
	}

	public void defaire() {	}

	public void refaire() {	}
}
