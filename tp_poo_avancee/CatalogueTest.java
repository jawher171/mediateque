package tp_poo_avancee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    @Test
    void testSimple() {
        assertTrue(true);
    }

    // throws : emprunter() leve une exception checked
    @Test
    void empruntNominal() throws DocumentIndisponibleException {
        Livre l = new Livre("Clean Code", 2008, "R. Martin", 464);
        l.emprunter();
        assertFalse(l.estDisponible());
        l.rendre();
        assertTrue(l.estDisponible());
    }

    @Test
    void doubleEmpruntLeveExceptionMetier() throws DocumentIndisponibleException {
        Livre l = new Livre("Refactoring", 1999, "M. Fowler", 448);
        l.emprunter();
        DocumentIndisponibleException ex = assertThrows(DocumentIndisponibleException.class, l::emprunter);
        assertTrue(ex.getMessage().contains("Refactoring")); // le titre est dans le message
    }

    @Test
    void doubleEmpruntDvdLeveExceptionMetier() throws DocumentIndisponibleException {
        Dvd d = new Dvd("Inception", 2010, 148);
        d.emprunter();
        DocumentIndisponibleException ex = assertThrows(DocumentIndisponibleException.class, d::emprunter);
        assertTrue(ex.getMessage().contains("Inception"));
    }

    @Test
    void rechercheInfructueuse() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Revue("Science", 2026, 412));
        assertFalse(c.rechercherParTitre("Nature").isPresent());
    }

    @Test
    void rechercheIgnoreLaCasse() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Dvd("Inception", 2010, 148));
        assertTrue(c.rechercherParTitre("INCEPTION").isPresent());
    }
}
