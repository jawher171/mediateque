package tp_poo_avancee;

import java.util.List;

/**
 * SOLID Principles Demonstrated:
 *
 * 1. SRP (Single Responsibility Principle):
 *    Cette classe a pour unique responsabilité de transformer des documents
 *    au format texte CSV (colonnes séparées par des points-virgules).
 *    Elle ne gère ni l'écriture sur disque, ni l'affichage, ni les notifications.
 *
 * 2. LSP (Liskov Substitution Principle):
 *    Cette classe implémente complètement et respecte le contrat de FormatRapport.
 *    Elle peut se substituer de manière transparente à toute autre implémentation
 *    de FormatRapport sans altérer le bon fonctionnement de RapportService.
 *
 * Pattern associé: Concrete Strategy du pattern Strategy.
 */
public class FormatCsv implements FormatRapport {
    @Override
    public String formater(List<Document> docs) {
        StringBuilder sb = new StringBuilder();
        for (Document d : docs) {
            sb.append(d.getTitre()).append(';').append(d.getId()).append('\n');
        }
        return sb.toString();
    }
}
