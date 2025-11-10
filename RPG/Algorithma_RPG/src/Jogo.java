package Main.java;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jogo {

    // =============================
    // MÉTODOS DE DIÁLOGO RPG
    // =============================

    private static void digitarLinha(String texto, int velocidadeMs) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            TimeUnit.MILLISECONDS.sleep(velocidadeMs);
        }
        System.out.println(); // Quebra a linha no final
    }
    
    
    /**
     * Helper que simula a digitação de uma única linha, caractere por caractere.
     */
    
     public static void mostrarDialogo(String texto, int larguraMaxima, int velocidadeMs) throws InterruptedException {
        String[] palavras = texto.split(" ");
        StringBuilder linha = new StringBuilder();

        for (String palavra : palavras) {
            // Verifica se a palavra cabe na linha atual
            if (linha.length() + palavra.length() + 1 > larguraMaxima) {
                // Se não couber, digita a linha atual e começa uma nova
                digitarLinha(linha.toString(), velocidadeMs);
                linha = new StringBuilder();
            }
            //break de linha após chegar ao canto do terminal maximo
            linha.append(palavra).append(" ");
        }

        // Digita a última linha que sobrous
        if (linha.length() > 0) {
            digitarLinha(linha.toString(), velocidadeMs);
            System.out.println();
        }
    }
     
    private static void fala(String texto) throws InterruptedException {
        String textoLimpo = texto.replaceAll("\\n", " ").replaceAll("\\s+", " ").trim();
        mostrarDialogo(textoLimpo, 95, 20);
    }

    /**
     * Exibe um texto formatado, quebrando linhas pela largura e com efeito de digitação.
     * @param texto A string completa a ser exibida.
     * @param larguraMaxima O número máximo de colunas antes de quebrar a linha.
     * @param velocidadeMs O tempo em milissegundos entre cada caractere.
     */
   
    
    // =============================
    // CENAS DO JOGO
    // =============================

    /**
     * Exibe a cena do Enredo. Agora recebe o Scanner como parâmetro.
     */
    
    public static void enredo(Scanner input) throws InterruptedException {
        int entrada;

        while (true) {
            System.out.println();
            fala("""
            As terras de Algorithma são agressivas aos viajantes que buscam uma vida melhor em suas jornadas.
            Talon é um aventureiro que acabou de começar as suas aventuras quando um terrível acontecimento o faz
            ter de ir para a terra de Algorithma. Ele deseja aprender sobre o arcano envolvendo a escola de magia JAVA,
            mas após um embate ele se vê perdido em meio a um deserto e sem lembranças do que ocorreu até o presente momento. Ainda se
            lembra de quem é, mas não se recorda de sua jornada até Algorithma ou o porquê está ali. E você vai ajudá-lo
            a se lembrar, o objetivo de Talon é voltar para casa..
            """);
            
            System.out.println("\n\n2 - Voltar\n");
            entrada = input.nextInt();
            if (entrada == 2)
                return;
        }
    }

    /**
     * Exibe a cena inicial do Jogo. Agora recebe o Scanner como parâmetro.
     */
    public static void jogar(Scanner input) throws InterruptedException {
        int entrada;
        boolean executando = true;
        
            System.out.println();
            fala("""
            Talon desperta em um deserto de Algorithma chamado J.I.T. A brisa quente toca seu rosto, e uma sensação
            de confusão domina sua mente. Você se lembra de seu nome, mas não de como chegou aqui.
            Ao olhar ao redor, vê sua mochila de aprendiz, seu cajado e uma adaga multiuso.
            """);
            
            fala("""
            De repente uma figura misteriosa aparece ao horizonte e Talon fica alerta, ele se arma com a adaga para se defender 
            da possível ameaça, ao se aproximar, a figura começa a tomar a forma de um homem alto que parece ser mais velho, 
            aos poucos Talon vê mais detalhes do homem que se aproxima, aparentemente algo como um feiticeiro viajante que por algum motivo o conforta, 
            ele também é um feiticeiro.
            """);
            
            fala("Ao se aproximar o feiticeiro fala um trocadilho para Talon:");
            
            fala("Feiticeiro: Parece que vós deseja passar gordura animal em mim, não sou sua presa sabia?");
            
            fala("Talon: o que? quem é você?");
            
            fala("""
                Feiticeiro: Entendo que ao conhecer uma pessoa pela primeira vez, nosso instinto é saber quem ela é, mas é mal educado não se apresentar primeiro para os mais velhos...
                 """);
            
            fala("""
                 Talon: Ah! mil perdões, Meu nome é... Ta...lon? TALON! meu nome é Talon!
                 """);
            
            fala("Feiticeiro: um nome formidável, mas antes de me apresentar eu vos tenho uma pergunta jovem Talon.");
                 
            fala("Talon: Qual é sua pergunta?");
            
            while(executando) {
                fala("Feiticeiro: Qual a saída do terminal na seguinte linha de comando?");
                fala("\nSystem.out.println(\"Hello, world!\");");
                    fala("(1) oi??");
                    fala("(2) que??");
                    fala("(1) han??");
                    fala("(4) Hello, world... ué?");
            
                entrada = input.nextInt();
            
                if(entrada == 1 || entrada == 2 || entrada == 3) {
                    fala("\n Feiticero: Hahahaha! Ora imaginei que eu faria você ficar confuso jovem Talon, irei te explicar melhor agora.");
                    executando = false;
                }
                else if(entrada == 4) {
                    fala("\n Feiticeiro: Ora... você é um espertinho mesmo né? com certeza você realmente não sabe o que falou não é?");
                    fala("Talon: não... ");
                    fala("Feiticeiro: Foi o que imaginei...");
                    executando = false;
                }
                else {
                fala("Feiticeiro: Jovem Talon... tens apenas de responder a pergunta, nao inventar firulas!");
                executando = false;
                }
            }
            
            fala("""
                 Feiticeiro: Bom, como eu ia dizendo isso que eu te falei foi Java, Java é uma forma de se comunicar com os deuses e realizar diversas tarefas a partir dos feitiços, você precisa primeiro de um cajado para utilizar de java.
                 """);
            
            fala("""
                 Talon: senhor feiticeiro, eu sequer sei onde estou e não compreendo muito bem o que o senhor quer dizer com tudo isto, eu tenho um cajado e imagino que eu saberia numa situação normal utilizar dele, mas agora eu estou tão confuso que parece que o senhor está falando grego pra mim...
                 """);
            
            fala("Feiticeiro: Grego?");
            
            fala("Talon: foi só uma figura de linguagem, ignora...");
            
            fala("Feiticeiro: Jovem Talon, as coisas que pra nós são confusas à primeira vista se tornam parte de nós ao convivermos com elas...");
            
            fala("Talon: como assim?");
            
            fala("""
                 Feiticeiro: Se você busca respostas, você precisa se esforçar para entender isto que te falei, você sabe que com Java você pode  lembrar do que aconteceu e porque está aqui, o que estou fazendo por você é apenas te auxiliando pro seu próximo passo.
                 """);
            
            fala("Talon: entendo, então, o que é esse negócio de \"Java\"?");
            
            fala("""
                 Feiticeiro: Como eu havia dito, Java é a linguagem dos deuses capaz de realizar diversas tarefas, essas tarefas são muito complexas para um aprendiz e por isso vou te ensinar o básico que todas as outras escolas de magia também aplicam, a "Forma sequencial de Java", para resolver seus problemas é necessário compreender o que cada palavra significa e como elas juntas formam um feitiço.
                 """);
            
            fala("""
                 Feiticeiro: De antemão é necessário um Cajado com runas romaji que representam o encantamento do cajado para serem capazes de realizar as ações da língua Java, no seu cajado há runas escrito "Java Developer Kit - Staff IDE", runas simples que servem justamente para realizar os feitiços básicos em Java. 
                 """);
            
            fala("Talon: entendo, mas como eu canalizo esses feitiços?");
            
            fala("""
                 Feiticeiro: Ao pegar seu cajado, tua alma se conecta com o encantamento, você se sente como se fora de seu corpo e ao mesmo tempo vivendo o aqui e agora, e assim que se conecta com teu cajado você entra em fase de "Coding", que seria algo como o momento em que as palavras de java juntas fariam sentido para resolver o seu problema, no caso, realizar um feitiço.
                 """);
            
            fala("Talon: assim como aquilo que você me perguntou quando nos conhecemos?");
            
            fala("""
                 Feiticeiro: Exatamente, e Talon, por exemplo aquele feitiço é simplesmente para deixar claro ao feiticeiro que está usando do Java que está tudo certo e ele consegue se comunicar na língua dos deuses.
                 """);
            
            fala("Talon: entendi!");
            
            fala("""
                 Feiticeiro: e na fase de Coding, é necessário que você mantenha a calma e tente ser o mais racional possível, a magia segue uma sequência de passos baseada na lógica do feiticeiro onde, se ele comete um erro, o cajado não terá a culpa, e sim o feiticeiro.
                 """);
            
            fala("""
                 Feiticeiro: Para realizar um feitiço na fase Coding, você focaliza sua alma e conecta-a ao cajado, recita as palavras chave em Java e se souber como resolver seu problema, deixa o Java fazer o resto.
                 """);
            
            fala("Talon: eu preciso me lembrar o que aconteceu comigo! estou com medo doque posso ter feito e acabado nessa situação!");
            
            fala("""
                  Feiticeiro: acima de tudo você é um aventureiro que faz o certo não é? então o seu passado virá a tona dependendo do quanto você quer se aventurar meu jovem, explore e tente novas formas.
                 """);
            
            fala("Talon: e o que eu preciso pra começar?");
            
            fala("""
                 E então, o feiticeiro entrega um item importantíssimo para realizar feitiços com o cajado, uma joia Javius que possibilita canalizar coding no cajado e expelir a mente do corpo.
                 """);
            
            fala("Ao segurar a jóia um tipo de apagão acontece na mente de Talon e ele se lembra de flashes em sua mente.");
            
            fala("""
                 Primeiro o flash de uma cama, logo em seguida o flash de um horizonte e por fim, dois seres impossíveis de discernir suas formas e rostos segurando itens brilhantes. """);
            
            fala("Talon se viu perguntando algo em uma taverna.");
            
            fala("Talon se vê andando e de repente, um apagão. ");
            
            fala("Por fim ele volta ao presente, e se lembra de algumas coisas em Java.");
            
            
        }

    /**
     * Exibe os Créditos. Agora recebe o Scanner como parâmetro.
     */
    public static void creditos(Scanner input) throws InterruptedException {
        int entrada;

        while (true) {
            System.out.println();
            // Nota: Este texto não precisa de limpeza, pois já é uma string formatada.
            String texto = "Créditos:\nDiogo Sena - Enzo Oliveira";
            mostrarDialogo(texto, 80, 20);
            String texto2 = "TADS Senac - 2025";
            mostrarDialogo(texto2, 80, 20);

            System.out.println("\n\n2 - Voltar\n");
            entrada = input.nextInt();
            if (entrada == 2)
                return;
        }
    }

    // =============================
    // MENU PRINCIPAL
    // =============================
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int entrada;
        boolean executando = true;
        
        do {
            System.out.println("""
                  ******    *          ******     *******   *******  ********   *********   *    *
                  *    *    *         *          *       *  *     *     *           *       *    *
                  ******    *         *   ****   *       *  *******     *           *       ****** 
                  *    *    *         *      *   *       *  *  *        *           *       *    *
                  *    *    *******    *******    *******   *    *   *******        *       *    *
                 """);
            System.out.println("\nDigite a opção desejada: ");
            System.out.println("1 - Enredo");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            entrada = input.nextInt();
            
            switch (entrada) {
                case 1 -> enredo(input);
                case 2 -> jogar(input);
                case 3 -> creditos(input);
                case 4 -> {
                    System.out.println("\nEncerrando o jogo...");
                    executando = false;
                }
                default -> System.out.println("Entrada inválida! Tente novamente!\n");
            }
        } while (executando);
        input.close(); 
    }
}