package tp_poo_avancee;

import java.util.ArrayList;
import java.util.List;

/** Memorise les titres empruntes ; utilisable dans un try-with-resources. */
public class RapportEmprunt implements AutoCloseable {
    private final List<String> titres = new ArrayList<>();
    private boolean ferme = false;

    public void enregistrer(String titre) { titres.add(titre); }

    public List<String> getTitres() { return titres; }

    public boolean estFerme() { return ferme; }

    @Override
    public void close() { ferme = true; }
}
