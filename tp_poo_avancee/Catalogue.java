package tp_poo_avancee;
import java.util.stream.Stream;
import java.util.*;
// appliquer le pattern Iterator
public class Catalogue<T extends Document> implements Iterable<T> {
    private final List<T> elements = new ArrayList<>();

    public void ajouter(T element) {
        elements.add(element);
    }

    // implémentation de l'interface Iterable
    @Override
    public Iterator<T> iterator() {
        return Collections.unmodifiableList(elements).iterator();
    }
    // permet au client de realiser des traitement fonctionnels (ex: filtrage,tri,...) tout en preservant 
    // l'encapsulation de la collection interne 
    public Stream<T> stream() {
        return elements.stream();
    }
    // permet de rechercher un element par son titre
    public Optional<T> rechercherParTitre(String titre) {
        return elements.stream().filter(d -> d.getTitre().equalsIgnoreCase(titre)).findFirst();
    }

    // public void afficherTout () {
    // elements.forEach (d -> System.out.println (d.descriptionCourte ()));
    // }

    public static <T extends Comparable<? super T>> T max(List<T> liste) { // bonus
        T m = liste.get(0);
        for (T e : liste)
            if (e.compareTo(m) > 0)
                m = e;
        return m;
    }
}