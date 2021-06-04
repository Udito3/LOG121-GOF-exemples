package Commande.Bottin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FicheActionEditer extends BottinAbstractAction {
    // private FicheDialog dialog;
		private static final long serialVersionUID = 1414124314312l;

	public FicheActionEditer(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon,
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new FicheCommandeEditer(bottin, index, gdc));
	}
}
