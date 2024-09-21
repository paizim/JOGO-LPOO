package Decks;
import java.util.ArrayList;

class Carta {
 String nome;
 int custoMana;

 public Carta(String nome, int custoMana) {
     this.nome = nome;
     this.custoMana = custoMana;
 }

 public String toString() {
     return "Nome: " + nome + ", Custo de Mana: " + custoMana;
 }
}


class Criatura extends Carta {
 int poder;
 int resistencia;
 String habilidade;

 public Criatura(String nome, int custoMana, int poder, int resistencia, String habilidade) {
     super(nome, custoMana);
     this.poder = poder;
     this.resistencia = resistencia;
     this.habilidade = habilidade;
 }


 public String toString() {
     return super.toString() + ", Poder: " + poder + ", Resistência: " + resistencia + ", Habilidade: " + habilidade;
 }
}

// feiticos
class Feitico extends Carta {
 String efeito;

 public Feitico(String nome, int custoMana, String efeito) {
     super(nome, custoMana);
     this.efeito = efeito;
 }

 
 public String toString() {
     return super.toString() + ", Efeito: " + efeito;
 }
}

// encantamentos
class Encantamento extends Carta {
 String efeitoContinuo;

 public Encantamento(String nome, int custoMana, String efeitoContinuo) {
     super(nome, custoMana);
     this.efeitoContinuo = efeitoContinuo;
 }

 
 public String toString() {
     return super.toString() + ", Efeito Contínuo: " + efeitoContinuo;
 }
}

public class Decks {

 public static void main(String[] args) {
     // primeiro deck
     ArrayList<Carta> deck1 = new ArrayList<>();

     // criaturas 
     deck1.add(new Criatura("Cavaleiro", 5, 6, 7, "Provocar"));
     deck1.add(new Criatura("Paladino", 7, 8, 9, "Cura aliados em 2 pontos de vida"));
     deck1.add(new Criatura("Arqueiro", 3, 4, 3, "Ataque à distância"));
     deck1.add(new Criatura("Espadachim", 4, 5, 5, "Ataque rápido"));
     deck1.add(new Criatura("Grifo Guardião", 6, 6, 6, "Voar"));
     deck1.add(new Criatura("Dragão", 9, 10, 9, "Ataque em área"));
     deck1.add(new Criatura("Guerreiro", 5, 6, 5, "Carga"));
     deck1.add(new Criatura("Clériga", 4, 3, 6, "Cura o jogador"));
     deck1.add(new Criatura("Sentinela", 2, 2, 3, "Provocar"));
     deck1.add(new Criatura("Guardião", 3, 3, 4, "Resistência extra"));

     // feitiços 
     deck1.add(new Feitico("Cura Divina", 4, "Restaura 6 pontos de vida às criaturas"));
     deck1.add(new Feitico("Escudo da Virtude", 3, "Concede +3 de resistência"));
     deck1.add(new Feitico("Chama Purificadora", 5, "Causa 6 de dano a uma criatura"));
     deck1.add(new Feitico("Bênção do Rei", 4, "Aumenta o poder das criaturas em +2"));
     deck1.add(new Feitico("Reviver os Caídos", 6, "Traz uma criatura do cemitério"));
     deck1.add(new Feitico("Barreira Celestial", 4, "Evita dano de um ataque inimigo"));
     deck1.add(new Feitico("Golpe Devastador", 3, "Dobra o poder de uma criatura"));
     deck1.add(new Feitico("Golpe da Justiça", 4, "Causa 4 de dano e cura o jogador"));
     deck1.add(new Feitico("Vento da Vitória", 2, "Concede +1 de ataque e resistência"));
     deck1.add(new Feitico("Luz Purificadora", 3, "Remove encantamentos negativos"));

     // encantamentos
     deck1.add(new Encantamento("Proteção Sagrada", 2, "+2 de resistência a uma criatura"));
     deck1.add(new Encantamento("Benção de Avalon", 3, "+1 de resistência para todas as criaturas"));
     deck1.add(new Encantamento("Muralha Impenetrável", 4, "Reduz o dano recebido em 1"));
     deck1.add(new Encantamento("Fúria dos Deuses", 5, "+3 de dano ao atacar"));
     deck1.add(new Encantamento("Campo de Força Divino", 3, "Evita os primeiros 2 de dano recebidos"));
     deck1.add(new Encantamento("Aura da Luz", 2, "-1 de ataque para criaturas inimigas"));
     deck1.add(new Encantamento("Chama Sagrada", 4, "Causa 1 de dano ao jogador inimigo"));
     deck1.add(new Encantamento("Escudo de Cristal", 3, "Proteção contra feitiços"));
     deck1.add(new Encantamento("Bênção Real", 2, "Ganha 1 de vida quando uma criatura ataca"));
     deck1.add(new Encantamento("Campo de Energia Arcana", 5, "+1 de ataque para todas as criaturas"));

     // exibir
     System.out.println("Deck 1 - Reino dos Cavaleiros:");
     for (Carta carta : deck1) {
         System.out.println(carta);
     }

     // segundo deck
     ArrayList<Carta> deck2 = new ArrayList<>();

     // criaturas
     deck2.add(new Criatura("Guerreiro Goblin", 3, 4, 3, "Ataque rápido"));
     deck2.add(new Criatura("Ogros", 6, 8, 6, "Provocar"));
     deck2.add(new Criatura("Xamã Goblin", 4, 3, 4, "Causa 3 de dano"));
     deck2.add(new Criatura("Ladrão", 2, 2, 2, "Rouba 1 mana do oponente"));
     deck2.add(new Criatura("Goblin Explosivo", 5, 5, 3, "Causa 5 de dano ao morrer"));
     deck2.add(new Criatura("Troll", 7, 9, 8, "Regenera 2 de vida"));
     deck2.add(new Criatura("Berserker Orc", 4, 6, 4, "Ataca duas vezes por turno"));
     deck2.add(new Criatura("Dragão Negro", 9, 9, 9, "Ataque em área"));
     deck2.add(new Criatura("Goblin Venenoso", 3, 2, 3, "Envenena ao atacar"));
     deck2.add(new Criatura("Gigante", 8, 10, 10, "Imune a feitiços"));

     // feitiços
     deck2.add(new Feitico("Raio Negro", 3, "Causa 4 de dano a uma criatura"));
     deck2.add(new Feitico("Chuva de Fogo", 6, "Causa 3 de dano a todas as criaturas"));
     deck2.add(new Feitico("Maldição da Ruína", 5, "Reduz o poder de uma criatura em -3"));
     deck2.add(new Feitico("Explosão Goblin", 4, "Causa 6 de dano ao jogador inimigo"));
     deck2.add(new Feitico("Praga das Sombras", 6, "Drena 4 pontos de vida do oponente"));
     deck2.add(new Feitico("Chama Infernal", 4, "Causa 5 de dano a uma criatura"));
     deck2.add(new Feitico("Vento do Caos", 2, "+2 de ataque para todas as criaturas"));
     deck2.add(new Feitico("Destruição Ancestral", 7, "Destrói todas as criaturas em campo"));
     deck2.add(new Feitico("Magia Sombria", 3, "Compra 2 cartas extras"));
     deck2.add(new Feitico("Bola de Fogo", 5, "Causa 6 de dano ao jogador inimigo"));

     // encantamentos
     deck2.add(new Encantamento("Vontade Sombria", 3, "+1 de ataque para suas criaturas"));
     deck2.add(new Encantamento("Corrupção das Trevas", 4, "-1 de resistência para criaturas inimigas"));
     deck2.add(new Encantamento("Escudo de Ossos", 3, "Reduz o dano recebido em 2 para uma criatura"));
     deck2.add(new Encantamento("Rugido do Tirano", 5, "+2 de ataque para suas criaturas"));
     deck2.add(new Encantamento("Aura de Terror", 2, "O oponente perde 1 ponto de vida por turno"));
     deck2.add(new Encantamento("Ciclo Sombrio", 6, "Destrói uma criatura inimiga por turno"));
     deck2.add(new Encantamento("Sombra da Destruição", 4, "Suas criaturas causam 1 de dano extra ao atacar"));
     deck2.add(new Encantamento("Força dos Goblins", 2, "+1 de resistência para goblins"));
     deck2.add(new Encantamento("Campo de Ossos", 4, "+1 de resistência para suas criaturas ao destruir inimigas"));
     deck2.add(new Encantamento("Olho do Tirano", 3, "O oponente descarta uma carta por turno"));

     // exibir
     System.out.println("\nDeck 2 - Horda dos Goblins:");
     for (Carta carta : deck2) {
         System.out.println(carta);
     }
 }
}
