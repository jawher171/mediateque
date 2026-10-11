package tp_poo_avancee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {
    @Test
    void testSimple() {
        assertTrue(true);
    }

    @Test
    void empruntNominal() {
        Livre l = new Livre("Clean Code", 2008, "R. Martin", 464);
        l.emprunter();
        assertFalse(l.estDisponible());
        l.rendre();
        assertTrue(l.estDisponible());
    }

    @Test
    void doubleEmpruntLeveException() {
        Livre l = new Livre("Refactoring", 1999, "M. Fowler", 448);
        l.emprunter();
        assertThrows(IllegalStateException.class, () -> l.emprunter());
    }

    @Test
    void rechercheInfructueuse() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Revue("Science", 2026, 412));
        assertFalse(c.rechercherParTitre("Nature").isPresent());
    }
}
