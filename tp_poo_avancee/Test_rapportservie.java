package tp_poo_avancee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test_rapportservie {

    @Test
    void genereEtNotifie() throws IOException {
        StringBuilder disque = new StringBuilder(); // fausse sortie
        List<String> notifs = new ArrayList<>();     // faux notificateur

        RapportService service = new RapportService(
                docs -> " contenu - teste ",         // faux format (lambda !)
                contenu -> disque.append(contenu),
                message -> notifs.add(message)
        );

        service.generer(List.of());

        assertEquals(" contenu - teste ", disque.toString());
        assertEquals(1, notifs.size());
    }
}