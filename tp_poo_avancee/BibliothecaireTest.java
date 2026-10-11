package tp_poo_avancee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BibliothecaireTest {

    @Test
    void chercherDelegueAuCatalogue() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre("Dune", 1965, "F. Herbert", 612));
        Bibliothecaire b = new Bibliothecaire("Sami", c);

        assertTrue(b.chercher("dune").isPresent());        // case-insensitive, via the catalog
        assertFalse(b.chercher("Inconnu").isPresent());
    }

    @Test
    void catalogueDeTestInjectable() {
        Bibliothecaire b = new Bibliothecaire("Sami", new Catalogue<>());   // empty catalog
        assertTrue(b.chercher("Dune").isEmpty());
    }
}