package Commande.Bottin;

import javax.swing.*;
import java.io.*;

/**
 * Bottin - Bottin téléphonique
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public class Bottin extends DefaultListModel<Fiche> {
	public final static String NOM_FICHIER = "Bottin.txt";

	/**
	 * Constructeur du bottin
	 */
	public Bottin() {
		super();
	}

    /**
     * Lire le bottin à partir d'un fichier texte
     * @param fichier - File spécifiant le fichier
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lire() throws FileNotFoundException, IOException {
	    	File fichier = new File(NOM_FICHIER);
	    	if (fichier.exists()) {
	    		BufferedReader in = new BufferedReader(new FileReader(fichier));
	    		while(in.ready()) addElement(Fiche.lire(in));
	    		in.close();
	    	}
    }

    /**
     * Écrire le bottin dans un fichier texte
     * @param fichier - File spécifiant le fichier
     * @throws IOException
     */
    public void ecrire() throws IOException {
	    	File fichier = new File(NOM_FICHIER);
	    	PrintWriter out
	    	   = new PrintWriter(new BufferedWriter(new FileWriter(fichier, false)));
	    	for (int i = 0; i < size(); i++) {
	    		get(i).ecrire(out);
	    	}
	    	out.close();
    }
}
