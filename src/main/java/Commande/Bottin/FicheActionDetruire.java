package Commande.Bottin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FicheActionDetruire extends BottinAbstractAction {
		// private FicheDialog dialog;
		private static final long serialVersionUID=1234132412;

	public FicheActionDetruire(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon,
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new FicheCommandeDetruire(bottin, index, gdc));
	}
}
