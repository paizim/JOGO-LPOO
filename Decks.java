import java.util.ArrayList;

public class Decks {

    public static ArrayList<Carta> criarDeck1() {
        ArrayList<Carta> deck = new ArrayList<>();
        deck.add(new Criatura("Cavaleiro", 1, 3, 6));
        deck.add(new Criatura("Paladino", 3, 4, 7));
        deck.add(new Criatura("Arqueiro", 1, 6, 3));
        deck.add(new Criatura("Espadachim", 2, 5, 4));
        deck.add(new Criatura("Grifo Guardião", 6, 6, 6));
        deck.add(new Criatura("Dragão", 9, 10, 9));
        deck.add(new Criatura("Guerreiro", 4, 6, 6));
        deck.add(new Criatura("Clériga", 3, 3, 6));
        deck.add(new Criatura("Sentinela", 1, 2, 5));
        deck.add(new Criatura("Guardião", 2, 1, 7));
        deck.add(new Feitico("Cura Divina", 4));
        deck.add(new Feitico("Escudo da Virtude", 3));
        deck.add(new Feitico("Chama Purificadora", 5));
        deck.add(new Feitico("Bênção do Rei", 4));
        deck.add(new Feitico("Reviver os Caídos", 6));
        deck.add(new Feitico("Barreira Celestial", 4));
        deck.add(new Feitico("Golpe Devastador", 3));
        deck.add(new Feitico("Golpe da Justiça", 4));
        deck.add(new Feitico("Vento da Vitória", 2));
        deck.add(new Feitico("Luz Purificadora", 3));
        deck.add(new Encantamento("Proteção Sagrada", 2));
        deck.add(new Encantamento("Benção de Avalon", 3));
        deck.add(new Encantamento("Muralha Impenetrável", 4));
        deck.add(new Encantamento("Fúria dos Deuses", 5));
        deck.add(new Encantamento("Campo de Força Divino", 3));
        deck.add(new Encantamento("Aura da Luz", 2));
        deck.add(new Encantamento("Chama Sagrada", 4));
        deck.add(new Encantamento("Escudo de Cristal", 3));
        deck.add(new Encantamento("Bênção Real", 2));
        deck.add(new Encantamento("Campo de Energia Arcana", 5));
        return deck;
    }

    public static ArrayList<Carta> criarDeck2() {
        ArrayList<Carta> deck = new ArrayList<>();
        deck.add(new Criatura("Guerreiro Goblin", 1, 4, 5));
        deck.add(new Criatura("Ogros", 1, 3, 7));
        deck.add(new Criatura("Xamã Goblin", 2, 1, 9));
        deck.add(new Criatura("Ladrão", 2, 5, 2));
        deck.add(new Criatura("Goblin Explosivo", 2, 7, 1));
        deck.add(new Criatura("Troll", 3, 5, 5));
        deck.add(new Criatura("Berserker Orc", 3, 6, 4));
        deck.add(new Criatura("Dragão Negro", 8, 9, 9));
        deck.add(new Criatura("Goblin Venenoso", 2, 5, 2));
        deck.add(new Criatura("Gigante", 5, 7, 7));
        deck.add(new Feitico("Raio Negro", 3));
        deck.add(new Feitico("Chuva de Fogo", 6));
        deck.add(new Feitico("Maldição da Ruína", 5));
        deck.add(new Feitico("Explosão Goblin", 4));
        deck.add(new Feitico("Praga das Sombras", 6));
        deck.add(new Feitico("Chama Infernal", 4));
        deck.add(new Feitico("Vento do Caos", 2));
        deck.add(new Feitico("Destruição Ancestral", 7));
        deck.add(new Feitico("Magia Sombria", 3));
        deck.add(new Feitico("Bola de Fogo", 5));
        deck.add(new Encantamento("Vontade Sombria", 3));
        deck.add(new Encantamento("Corrupção das Trevas", 4));
        deck.add(new Encantamento("Escudo de Ossos", 3));
        deck.add(new Encantamento("Rugido do Tirano", 5));
        deck.add(new Encantamento("Aura de Terror", 2));
        deck.add(new Encantamento("Ciclo Sombrio", 6));
        deck.add(new Encantamento("Sombra da Destruição", 4));
        deck.add(new Encantamento("Força dos Goblins", 2));
        deck.add(new Encantamento("Campo de Ossos", 4));
        deck.add(new Encantamento("Olho do Tirano", 3));
        return deck;
    }
}
