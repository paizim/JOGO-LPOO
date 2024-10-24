import java.util.ArrayList;

public class Decks {

    public static ArrayList<Carta> criarDeck1() {
        ArrayList<Carta> deck = new ArrayList<>();

        ArrayList<String> habilidadesCavaleiro = new ArrayList<>();
        deck.add(new Criatura("Cavaleiro", 1, 6, 3, habilidadesCavaleiro));

        ArrayList<String> habilidadesPaladino = new ArrayList<>();
        habilidadesPaladino.add("Regeneração");
        deck.add(new Criatura("Paladino", 3, 7, 4, habilidadesPaladino));

        ArrayList<String> habilidadesArqueiro = new ArrayList<>();
        habilidadesArqueiro.add("Rapidez");
        deck.add(new Criatura("Arqueiro", 1, 3, 2, habilidadesArqueiro));

        ArrayList<String> habilidadesEspadachim = new ArrayList<>();
        habilidadesEspadachim.add("Esquiva");
        deck.add(new Criatura("Espadachim", 2, 4, 4, habilidadesEspadachim));

        ArrayList<String> habilidadesGrifo = new ArrayList<>();
        habilidadesGrifo.add("Splash");
        deck.add(new Criatura("Grifo Guardião", 6, 6, 6, habilidadesGrifo));

        ArrayList<String> habilidadesDragao = new ArrayList<>();
        habilidadesDragao.add("Provocar");
        deck.add(new Criatura("Dragão", 9, 9, 9, habilidadesDragao));

        ArrayList<String> habilidadesGuerreiro = new ArrayList<>();
        deck.add(new Criatura("Guerreiro", 4, 6, 6, habilidadesGuerreiro));

        ArrayList<String> habilidadesCleriga = new ArrayList<>();
        habilidadesCleriga.add("Regeneração");
        deck.add(new Criatura("Clériga", 3, 6, 5, habilidadesCleriga));

        ArrayList<String> habilidadesSentinela = new ArrayList<>();
        habilidadesSentinela.add("Provocar");
        deck.add(new Criatura("Sentinela", 1, 5, 3, habilidadesSentinela));

        ArrayList<String> habilidadesGuardiao = new ArrayList<>();
        deck.add(new Criatura("Guardião", 2, 7, 4, habilidadesGuardiao));

        return deck;
    }

    public static ArrayList<Carta> criarDeck2() {
        ArrayList<Carta> deck = new ArrayList<>();

        ArrayList<String> habilidadesGuerreiroGoblin = new ArrayList<>();
        deck.add(new Criatura("Guerreiro Goblin", 1, 5, 4, habilidadesGuerreiroGoblin));

        ArrayList<String> habilidadesOgros = new ArrayList<>();
        habilidadesOgros.add("Provocar");
        deck.add(new Criatura("Ogros", 1, 7, 6, habilidadesOgros));

        ArrayList<String> habilidadesXamaGoblin = new ArrayList<>();
        habilidadesXamaGoblin.add("Esquiva");
        deck.add(new Criatura("Xamã Goblin", 2, 9, 5, habilidadesXamaGoblin));

        ArrayList<String> habilidadesLadrao = new ArrayList<>();
        habilidadesLadrao.add("Rapidez");
        deck.add(new Criatura("Ladrão", 2, 2, 3, habilidadesLadrao));

        ArrayList<String> habilidadesGoblinExplosivo = new ArrayList<>();
        habilidadesGoblinExplosivo.add("Splash");
        deck.add(new Criatura("Goblin Explosivo", 2, 1, 2, habilidadesGoblinExplosivo));

        ArrayList<String> habilidadesTroll = new ArrayList<>();
        deck.add(new Criatura("Troll", 3, 5, 4, habilidadesTroll));

        ArrayList<String> habilidadesBerserkerOrc = new ArrayList<>();
        habilidadesBerserkerOrc.add("Regeneração");
        deck.add(new Criatura("Berserker Orc", 3, 4, 5, habilidadesBerserkerOrc));

        ArrayList<String> habilidadesDragaoNegro = new ArrayList<>();
        habilidadesDragaoNegro.add("Provocar");
        deck.add(new Criatura("Dragão Negro", 8, 9, 9, habilidadesDragaoNegro));

        ArrayList<String> habilidadesGoblinVenenoso = new ArrayList<>();
        deck.add(new Criatura("Goblin Venenoso", 2, 2, 3, habilidadesGoblinVenenoso));

        ArrayList<String> habilidadesGigante = new ArrayList<>();
        deck.add(new Criatura("Gigante", 5, 7, 7, habilidadesGigante));

        return deck;
    }
}
