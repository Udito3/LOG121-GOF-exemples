package Iterateur;

import Iterateur.Name.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameRepositoryTest {

	@Test
	public void testGetIterator() throws Exception {
		final Container namesRepository = new NameRepository();

		String names = "";
		final Iterator iter =  namesRepository.getIterator();
		while ( iter.hasNext()) {
			final String name = (String) iter.next();
		   System.out.println("Name : " + name);
		   names += name;
		}
		assertEquals("RobertJohnJuliettelaury", names);
	}

    @Test
    public void testOrdreAlphabetique() throws Exception {
        final Container namesRepository = new NameRepository();

        String names = "";
        // Ajoute strategie pour l'ordre
        namesRepository.setComparateur(new ComparatorNom());
        namesRepository.sort();
        final Iterator iter =  namesRepository.getIterator();
        while ( iter.hasNext()) {
            final String name = (String) iter.next();
            System.out.println("Name : " + name);
            names += name;
        }

        assertEquals("JohnJuliettelauryRobert", names);
    }

    @Test
    public void testOrdreAlphabetiqueInverse() throws Exception {
        // Sort reste le même, iterateur parcours inverse
        final Container namesRepository = new NameRepository();

        String names = "";
        namesRepository.setComparateur(new ComparatorNom());
        namesRepository.sort();
        final Iterator iter =  namesRepository.getIteratorReverse();

        while (iter.hasPrevious()) {
            final String name = (String) iter.previous();
            System.out.println("Name : " + name);
            names += name;
        }

        assertEquals("RobertlauryJulietteJohn", names);
    }

    @Test
    public void testObservateurNext() throws Exception {
        final Container namesRepository = new NameRepository();

        namesRepository.setComparateur(new ComparatorNom());
        namesRepository.sort();
        final Iterator iter =  namesRepository.getIterator();

        Observateur observateur1 = new Observateur("Observateur 1", iter);
        Observateur observateur2 = new Observateur("Observateur 2", iter);
        Observateur observateur3 = new Observateur("Observateur 3", iter);

        // Creer les observateurs
        iter.addObserver(observateur1);
        iter.addObserver(observateur2);
        iter.addObserver(observateur3);

        while (iter.hasNext()) {
            final String name = (String) iter.next();
            assertEquals("Observateur 1 next " + name, observateur1.getMessage());
            assertEquals("Observateur 2 next " + name, observateur2.getMessage());
            assertEquals("Observateur 3 next " + name, observateur3.getMessage());
        }
    }

    @Test
    public void testObservateurPrevious() throws Exception {
        final Container namesRepository = new NameRepository();

        namesRepository.setComparateur(new ComparatorNom());
        namesRepository.sort();
        final Iterator iter =  namesRepository.getIteratorReverse();

        Observateur observateur1 = new Observateur("Observateur 1", iter);
        Observateur observateur2 = new Observateur("Observateur 2", iter);
        Observateur observateur3 = new Observateur("Observateur 3", iter);

        // Creer les observateurs
        iter.addObserver(observateur1);
        iter.addObserver(observateur2);
        iter.addObserver(observateur3);

        while (iter.hasPrevious()) {
            final String name = (String) iter.previous();
            assertEquals("Observateur 1 previous " + name, observateur1.getMessage());
            assertEquals("Observateur 2 previous " + name, observateur2.getMessage());
            assertEquals("Observateur 3 previous " + name, observateur3.getMessage());
        }
    }

	// 0 - Mettre le diagramme de classe à jour, ajouter les tests
	// 1-afficher par ordre alphabétique
	// 2-Afficher par ordre alphabétique inversé en utilisant un itérateur qui parcours les donées à l'inverse
	// 3-Ajouter un nombre variable d'observateurs qui sont identifé par leur nom et
    // qui affichent les nom des personnes dans la console à chaque fois qu'il sont utilisés par l'itérateur dans la fonction next ou previous.
	// Vous devez faire deux version de la méthode update en utilisant la surcharge
	// une version avec parametre
	// une version sans parametre
	// dans les deux cas la sortie devrait correspondre à:
	//      observer1 next Robert  -> update avec les paramêtres
	//      observer1 next Robert  -> update sans paramètres
	//      observer2 next Robert
	//		....
	//
	//      observer1 previous Laury
	//      ....

}
