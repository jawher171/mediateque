package tp_poo_avancee;

/**
 * SOLID Principles Demonstrated:
 *
 * 1. SRP (Single Responsibility Principle):
 *    Responsable uniquement de définir le contrat d'émission d'une notification
 *    (e.g., email, SMS, log, console).
 *
 * 2. DIP (Dependency Inversion Principle):
 *    RapportService dépend d'un contrat abstrait de notification, sans connaître
 *    les détails concrets (serveur SMTP, API tierce, etc.).
 *
 * 3. ISP (Interface Segregation Principle):
 *    Interface minimale et focalisée sur le besoin du client (une seule méthode notifier).
 *
 * Pattern associé: Observer / Strategy.
 */
public interface Notificateur {
    void notifier(String message);
}
