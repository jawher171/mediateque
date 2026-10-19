package tp_poo_avancee;

import java.io.IOException;
import java.util.List;

/**
 * SOLID Principles Demonstrated:
 *
 * 1. DIP (Dependency Inversion Principle) & Dependency Injection:
 *    Ce module de haut niveau ne dépend d'aucun module de bas niveau concret
 *    (pas de new FormatCsv(), pas de FileWriter direct, pas de console directe).
 *    Il dépend EXCLUSIVEMENT d'abstractions (FormatRapport, SortieRapport, Notificateur).
 *    Toutes les dépendances sont injectées par le constructeur (Inversion de Contrôle / IoC).
 *
 * 2. SRP (Single Responsibility Principle):
 *    RapportService a pour UNIQUE rôle d'orchestrer le flux :
 *    (1) formater les données, (2) écrire le résultat, (3) envoyer une notification.
 *    Il délègue entièrement la mise en forme, l'E/S et l'envoi de messages.
 *
 * 3. OCP (Open/Closed Principle):
 *    Cette classe est FERMÉE à la modification (son code n'a pas besoin de changer)
 *    mais OUVERTE à l'extension : on peut lui associer n'importe quelle nouvelle
 *    combinaison de format (JSON, XML), de sortie (Fichier, Réseau) ou de notificateur (Email, Slack).
 */
public class RapportService {
    private final FormatRapport format;
    private final SortieRapport sortie;
    private final Notificateur notificateur;

    public RapportService(FormatRapport f, SortieRapport s, Notificateur n) {
        this.format = f;
        this.sortie = s;
        this.notificateur = n;
    }

    public void genererRapport(List<Document> docs) throws IOException {
        String contenu = format.formater(docs);
        sortie.ecrire(contenu);
        if (notificateur != null) {
            notificateur.notifier("Rapport généré avec succès (" + docs.size() + " documents)");
        }
    }

    public FormatRapport getFormat() {
        return format;
    }

    public SortieRapport getSortie() {
        return sortie;
    }

    public Notificateur getNotificateur() {
        return notificateur;
    }
}
