package Commande.Bottin;

import java.util.LinkedList;
import java.util.Observable;

/*
 * CommandInvoker
 * Implementation du patron Command pour implementer les fonctionalites "defaire" et "refaire"
 * Tiré de [Grand2002]
 */
@SuppressWarnings({"deprecation"})
public class GestionnaireDeCommandes extends Observable {
	private boolean defaireStatut;
	private boolean refaireStatut;

    private LinkedList<Commande> histoire = new LinkedList<Commande>();
    private LinkedList<Commande> aRefaire = new LinkedList<Commande>();

    public boolean peutDefaire() {
    	return histoire.size() > 0;
    }

    public boolean peutRefaire() {
    	return aRefaire.size() > 0;
    }

	public void faireCommande(Commande commande) {
        statusInitialHistoire();

		commande.faire();

        if (histoireAChanger()) {
        	setChanged();
        	notifyObservers();
        }
	}

	private void statusInitialHistoire() {
        defaireStatut = peutDefaire();
        refaireStatut = peutRefaire();
    }

	private boolean histoireAChanger() {
        return defaireStatut ^ peutDefaire() || refaireStatut ^ peutRefaire();
    }

	public void clearARefaire() {
        aRefaire.clear();
    }

    public int getHistoireSize() {
        return histoire.size();
    }

    public int getARefaireSize() {
        return aRefaire.size();
    }

    public Commande removeHistoireFirst() {
        return histoire.removeFirst();
    }

    public Commande removeARefaireFirst() {
        return aRefaire.removeFirst();
    }

    public void addFirstARefaire(Commande commandeADefaire) {
        aRefaire.addFirst(commandeADefaire);
    }

    public void addFirstHistoire(Commande commandeARefaire) {
        histoire.addFirst(commandeARefaire);
    }

    public void clearHistoire() {
        histoire.clear();
    }
}
