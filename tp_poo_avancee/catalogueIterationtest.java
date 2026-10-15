package tp_poo_avancee;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class catalogueIterationtest {

    @Test
    void testForEachLoop() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Livre livre = new Livre("Effective Java", 2018, "Joshua Bloch", 416);
        Dvd dvd = new Dvd("Interstellar", 2014, 169);

        catalogue.ajouter(livre);
        catalogue.ajouter(dvd);

        List<Document> recuperes = new ArrayList<>();
        // Test de la boucle for-each (permise grâce à Iterable)
        for (Document doc : catalogue) {
            recuperes.add(doc);
        }

        assertEquals(2, recuperes.size());
        assertEquals("Effective Java", recuperes.get(0).getTitre());
        assertEquals("Interstellar", recuperes.get(1).getTitre());
    }

    @Test
    void testIteratorDirect() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Livre livre = new Livre("Clean Code", 2008, "Robert C. Martin", 464);
        catalogue.ajouter(livre);

        Iterator<Document> iterator = catalogue.iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals(livre, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCatalogueVide() {
        Catalogue<Document> catalogue = new Catalogue<>();
        Iterator<Document> iterator = catalogue.iterator();

        assertNotNull(iterator);
        assertFalse(iterator.hasNext());

        int count = 0;
        for (Document ignored : catalogue) {
            count++;
        }
        assertEquals(0, count);
    }
}
