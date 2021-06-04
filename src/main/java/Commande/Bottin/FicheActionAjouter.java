package Commande.Bottin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FicheActionAjouter extends BottinAbstractAction {
	private final static long serialVersionUID = 309060409890l;

	public FicheActionAjouter(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon,
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		index = index < 0 ? bottin.size() : index;
		gdc.faireCommande(new FicheCommandeAjouter(bottin, index, gdc));
	}
}
