package Commande.Bottin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings({"deprecation"})
public class FicheActionDefaire extends BottinAbstractAction implements Observer {
	private final static long serialVersionUID = 435243523L;

	public FicheActionDefaire(Bottin bottin,
			VuePrincipale vue, String texte, Icon icon,
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
		gdc.addObserver(this);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeDefaire(gdc));
	}

	public void update(Observable o, Object arg) {
		setEnabled(gdc.peutDefaire());
	}

}
