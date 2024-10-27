import java.util.ArrayList;

public class Decks {

    public static ArrayList<Carta> criarDeck1() {
        ArrayList<Carta> deck = new ArrayList<>();
        deck.add(new Criatura("Cavaleiro", 5, 6, 7, "Por honra e glória, eu enfrentarei qualquer desafio!"));
        deck.add(new Criatura("Paladino", 9, 8, 9, "A luz da justiça ilumina meu caminho, e cura aqueles que necessitam." ));
        deck.add(new Criatura("Arqueiro", 3, 4, 3, "A distância não é um obstáculo; minha flecha sempre encontra o alvo." ));
        deck.add(new Criatura("Espadachim", 4, 5, 5,"Com a velocidade de um relâmpago, minha lâmina dançará no campo de batalha." ));
        deck.add(new Criatura("Grifo Guardião", 7, 6, 6,"Com asas de aço e coragem indomável, eu protejo meu reino das trevas." ));
        deck.add(new Criatura("Dragão", 10, 10, 9,"Do céu eu desço, e a terra treme sob meu rugido devastador!" ));
        deck.add(new Criatura("Guerreiro", 4, 6, 5,"Com cada carga, um inimigo a menos, e a vitória é minha!" ));
        deck.add(new Criatura("Clériga", 3, 3, 6,"A fé é a minha arma, e a cura, meu presente para os que lutam." ));
        deck.add(new Criatura("Sentinela", 2, 2, 3,"Com bravura em meu coração, eu protejo os fracos e mantenho a linha." ));
        deck.add(new Criatura("Guardião", 2, 3, 4,"Minha resistência é a muralha que se ergue contra a tempestade." ));
        deck.add(new Feitico("Cura Divina", 4, "cura"));
        deck.add(new Feitico("Escudo da Virtude", 3, "defesa"));
        deck.add(new Feitico("Chama Purificadora", 2, "dano"));
        deck.add(new Feitico("Bênção do Rei", 2, "defesa"));
        deck.add(new Feitico("Reviver os Caídos", 4, "cura"));
        deck.add(new Feitico("Barreira Celestial", 3, "defesa"));
        deck.add(new Feitico("Golpe Devastador", 3, "dano"));
        deck.add(new Feitico("Golpe da Justiça", 4, "dano"));
        deck.add(new Feitico("Vento da Vitória", 4, "dano"));
        deck.add(new Feitico("Luz Purificadora", 4, "cura"));
        deck.add(new Encantamento("Proteção Sagrada", 5, "escudo"));
        deck.add(new Encantamento("Benção de Avalon", 5, "escudo"));
        deck.add(new Encantamento("Muralha Impenetrável", 5, "escudo"));
        deck.add(new Encantamento("Fúria dos Deuses", 5, "ataque"));
        deck.add(new Encantamento("Campo de Força Divino", 3, "aumentaMana"));
        deck.add(new Encantamento("Aura da Luz", 3, "aumentaMana"));
        deck.add(new Encantamento("Chama Sagrada", 3, "diminuiMana"));
        deck.add(new Encantamento("Escudo de Cristal", 5, "escudo"));
        deck.add(new Encantamento("Bênção Real", 3, "diminuiMana"));
        deck.add(new Encantamento("Campo de Energia Arcana", 5, "ataque"));
        // Adicione mais cartas conforme necessário
        return deck;
    }

    public static ArrayList<Carta> criarDeck2() {
        ArrayList<Carta> deck = new ArrayList<>();
        deck.add(new Criatura("Guerreiro Goblin", 3, 4, 3, "Pequeno em estatura, enorme em bravura! Prepare-se para a velocidade do ataque!"));
        deck.add(new Criatura("Ogros", 5, 8, 6, "Com minha força bruta, serei a rocha que impede seu avanço!" ));
        deck.add(new Criatura("Xamã Goblin", 2, 3, 4, "Com o poder dos espíritos, meu inimigo sentirá a fúria da natureza!"));
        deck.add(new Criatura("Ladrão", 2, 2, 2,"Na calada da noite, eu levo o que é seu, deixando apenas a confusão!" ));
        deck.add(new Criatura("Goblin Explosivo", 4, 5, 3,"Sou um presente indesejado; ao morrer, meu impacto será eterno!" ));
        deck.add(new Criatura("Troll", 7, 9, 8,"Nada me detém! Minha regeneração é tão feroz quanto meu rugido!" ));
        deck.add(new Criatura("Berserker Orc", 4, 6, 4,"Duas lâminas, dois ataques, uma única fúria! Prepare-se para o caos!" ));
        deck.add(new Criatura("Dragão Negro", 9, 9, 9,"Sombrios são meus voos, e a devastação que trago é indiscutível!" ));
        deck.add(new Criatura("Goblin Venenoso", 3, 2, 3, "Um toque do meu punhal e você se tornará uma sombra do que era!" ));
        deck.add(new Criatura("Gigante", 10, 10, 10, "Sou a tempestade que não pode ser detida, e sua mágica é inútil contra mim!" ));
        deck.add(new Feitico("Raio Negro", 3, "dano"));
        deck.add(new Feitico("Raio Negro", 3, "dano"));
        deck.add(new Feitico("Chuva de Fogo", 2, "dano"));
        deck.add(new Feitico("Maldição da Ruína", 3, "dano"));
        deck.add(new Feitico("Explosão Goblin", 4, "dano"));
        deck.add(new Feitico("Praga das Sombras", 5, "cura"));
        deck.add(new Feitico("Chama Infernal", 4, "cura"));
        deck.add(new Feitico("Vento do Caos", 2, "defesa"));
        deck.add(new Feitico("Destruição Ancestral", 4, "dano"));
        deck.add(new Feitico("Magia Sombria", 3, "cura"));
        deck.add(new Feitico("Bola de Fogo", 2, "dano"));
        deck.add(new Encantamento("Vontade Sombria", 3, "diminuiMana"));
        deck.add(new Encantamento("Corrupção das Trevas", 3, "aumentaMana"));
        deck.add(new Encantamento("Escudo de Ossos", 5, "escudo"));
        deck.add(new Encantamento("Rugido do Tirano", 5, "ataque"));
        deck.add(new Encantamento("Aura de Terror", 3, "diminuiMana"));
        deck.add(new Encantamento("Ciclo Sombrio", 4, "diminuiMana"));
        deck.add(new Encantamento("Sombra da Destruição", 5, "ataque"));
        deck.add(new Encantamento("Força dos Goblins", 5, "escudo"));
        deck.add(new Encantamento("Campo de Ossos", 5, "escudo"));
        deck.add(new Encantamento("Olho do Tirano", 3, "aumentaMana"));
        // Adicione mais cartas conforme necessário
        return deck;
    }
}

