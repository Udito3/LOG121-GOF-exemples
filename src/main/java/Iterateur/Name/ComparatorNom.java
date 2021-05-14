package Iterateur.Name;

import java.util.Comparator;

public class ComparatorNom implements Comparator<String> {

	@Override
	public int compare(String nom1, String nom2) {
		return nom1.compareToIgnoreCase(nom2);
	}
}
