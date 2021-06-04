package Commande.Bottin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FicheActionFermer extends BottinAbstractAction {
		// private FicheDialog dialog;
		private final static long serialVersionUID = 93287412734982L;

	public FicheActionFermer(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon,
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeFermer(bottin, gdc));
	}
}
