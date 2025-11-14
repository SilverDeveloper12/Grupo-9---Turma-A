// package Main.java;
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
        mostrarDialogo(textoLimpo, 95, 27);
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
                 As terras de Algorithma são agressivas aos viajantes que buscam uma vida melhor em suas jornadas, Talon é um aventureiro que acabou de começar as suas aventuras 
                 quando um terrível acontecimento o faz ter de ir para a terra de Algorithma, ele deseja aprender sobre o arcano envolvendo a escola de magia JAVA, mas após 
                 um embate ele se vê perdido em meio a ruínas sem lembranças doque ocorreu em sua vida, ainda se lembra de quem é mas não se recorda de sua jornada até Algorithma 
                 ou o porque está ali, e você vai ajuda-lo a voltar para casa repetindo os possíveis passos de Talon pelas terras de Algorithma.
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
            Talon desperta em um deserto de Algorithma chamado "Deserto de J.I.T." A brisa quente toca seu rosto, e uma sensação
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
                    fala("(3) han??");
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
            fala("""
                 Talon: Só um momento, por que o senhor está me ajudando? acabamos de nos conhecer...
                 """);
            fala("""
                 Feiticeiro: Eu não tenho motivos, apenas percebi que um jovem feiticeiro
                 como eu já fui antes precisava de ajuda, agora, deseja que eu volte a 
                 falar dos feitiços em Java?
                 """);
            
            fala("Talon: sou muito grato, sim pode continuar, mas como eu canalizo esses feitiços?");
            
            fala("""
                 Feiticeiro: Ao pegar seu cajado, tua alma se conecta com o encantamento, você se sente como se fora de seu corpo e ao mesmo tempo vivendo o aqui e agora, e assim que se conecta com teu cajado você entra em fase de "Coding", que seria algo como o momento em que as palavras de java juntas fariam sentido para resolver o seu problema, no caso, realizar um feitiço.
                 """);
            
            fala("Talon: assim como aquilo que você me perguntou agora a pouco?");
            
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
            
            fala("""
                 Porem, ao olhar aos seus arredores, o feticeiro misterioso que o ajudou a se recordar
                 simplesmente sumiu sem deixar rastros...
                 """);
            fala("A primeira coisa que Talon pensa, é de como chegar a taverna.");
            
            fala("""
                 Ao caminhar pelo deserto usando o som dos ventos batendo nas dunas como
                 um guia, ele ouve os ventos se acalmarem e baterem contra objetos resistentes,
                 Talon tem certeza que é uma vila, mas para garantir que não vai se perder
                 decide olhar sua bússola, que bizarramente tem uma marcação para o Norte.
                 """);
            executando = true;
            
            while(executando){
                fala("Talon: Devo ir para qual direção?");
                fala("\n(1)Norte\n(2)Leste\n(3)Oeste\n(4)Sul");
                    fala("(1) Norte");
                    fala("(2) Leste");
                    fala("(3) Oeste");
                    fala("(4) Sul");
            
                entrada = input.nextInt();
            
                if(entrada == 1){
                    fala("\n Talon: Bom, era a única opção óbvia não é...");
                    executando = false;
                }
                else if(entrada == 2 || entrada == 3 || entrada == 4) {
                    fala("\n Talon: Tem algo me dizendo que estão tentando me confundir...");
                    do{
                    fala("Talon: Devo ir para qual direção?");
                    fala("\n(1)Norte\n(2)Leste\n(3)Oeste\n(4)Sul");
                    fala("(1) Norte");
                    fala("(2) Leste");
                    fala("(3) Oeste");
                    fala("(4) Sul");
                    entrada = input.nextInt();
                    if(entrada == 1){
                        executando = false;
                    }else if(entrada != 1){
                    do{    
                    fala("Talon: Olha cara, só escolhe o norte logo pelo amor de Deus...");
                    fala("\n(1)Norte\n(2)Leste\n(3)Oeste\n(4)Sul");
                    fala("(1) Norte");
                    fala("(2) Leste");
                    fala("(3) Oeste");
                    fala("(4) Sul");
                    entrada = input.nextInt();
                    if(entrada == 1){
                        executando = false;
                    }
                    }while(entrada != 1);
                    }
                    }while(entrada != 1);
                }
                fala("""
                     Talon segue ao norte e acaba encontrando o uma pequena vila localizada logo após
                     o deserto de J.I.T, estranhamente ao lado de um deserto a vila é muito verde e 
                     parece ser próspera.
                     """);
                fala("""
                     Ao explorar um pouco Talon nota uma taverna ao horizonte, ele se lembra de seu
                     flash de memória e reconhece a taverna do sonho que teve, e então ele segue em
                     direção a taverna determinado em descobrir suas respostas!
                     """);
                fala("""
                     Assim como em toda taverna de um bom RPG, diversos clientes barulhentos estão 
                     comemorando, diversos aventureiros cantando as garçonetes, jovens sonhadores
                     contando histórias de suas novas aventuras, musica medieval e 
                     seniores aventureiros se vangloriando do passado.
                     """);
                fala("""
                     Talon se aproxima lentamente da pequena porta do salão e a abre confuso do
                     porque sonhou com a taverna, ao entrar na taverna, TODOS FICAM EM SILÊNCIO
                     E OLHAM FIXADAMENTE NA DIREÇÃO DO NOSSO HERÓI.
                     """);
                fala("""
                     Aqueles que antes tinham expressões alegres, fecharam a cara e começaram
                     a encarar Talon, ele confuso e desconfortável anda em direção ao bar, onde
                     o Bartender o atende e diz o seguinte:
                     """);
                fala("""
                     Bartender: Você tem muita coragem de dar as caras aqui novamente meu jovem...
                     """);
                fala("""
                     De maneira constrangedora, Talon o responde com a voz baixa...
                     """);
                fala("""
                     Talon: eu poderia dizer que não me recordo do que posso ter feito, porque não me recordo
                     ... mas por sua expressão e a reação dos clientes... não parece que foi coisa boa... né?
                     """);
                fala("""
                     Bartender: Meu rapaz, suas desculpas ficam para seu julgamento, porque dizer que não se 
                     lembra de roubar o tesouro da cidade e o restante do ouro do banco, é muita falta de 
                     vergonha na cara...
                     """);
                fala("""
                     Talon se enfurece e aumenta a voz para o bartender.
                     """);
                fala("""
                     Talon: ROUBAR??? EU NÃO ROUBEI NADA EU NÃO SOU LADRÃO!!!
                     """);
                fala("""
                     Ao criar uma cena no bar o restante dos clientes se revoltam e começam
                     a gritar com Talon
                     """);
                fala("""
                     "COMO VOCÊ OUSA MENTIR DESTE JEITO??? ROUBOU A PEDRA DE PYTHITA ROSA, RARÍSSIMA NA
                     NATUREZA DE NOSSA CIDADE!!! ELA NOS TRAZIA AS BENÇÃOS DO DEUS PYTHON!!!"
                     """);
                fala("""
                     Talon confuso com este nome o recita em tom baixo...
                     """);
                fala("""
                     Talon: Pedra de Pythita ros-
                     """);
                fala("""
                     Ao falar estas palavras, mais uma vez passa por sua mente memórias das visões
                     que ele teve ao conversar com o feiticeiro, ele se lembra de uma das figuras
                     misteriosas de sua visão e vê um Goblin segurando o que parece ser a tal Pedra
                     de Pythita Rosa, o mesmo estava na noite onde Talon perdeu a memória e parece que 
                     ele tem ligação com o resto das figuras que estavam na visão de Talon.
                     """);
                fala("""
                     Talon: EU SEI QUEM ROUBOU O TESOURO DA SUA CIDADE! FOI UM GOBLIN MUITO HORRIVEL
                     E ESQUISITO! ELE ESTAVA NA NOITE QUE PERDI A MEMÓRIA! EU JURO QUE NÃO FUI EU QUEM ROUBOU
                     O TESOURO DA CIDADE DE VOCÊS!!!
                     """);
                fala("""
                     "FORASTEIRO VOCÊ ACHA QUE VAMOS ACREDITAR EM VOCÊ?!?"
                     "QUEM VOCÊ PENSA QUE É?"          
                     "VAMOS PEGAR ELE!"
                     "LINCHEM-NO!"
                                "PEGUEM ELE!"
                                                "SUMA DAQUI PRAGA!"
                     """);
                fala("""
                     Bartender: SE ACALMEM! lembrem-se de minha regra de não agressão!
                     """);
                fala("""
                     O bartender então olha para Talon e nota a sinceridade em seu olhar...
                     """);
                fala("""
                     Bartender: hahahaha! Goblin é? hmm, quem diria que depois de se juntar a 
                     aqueles cultistas ele voltaria para cidade...
                     """);
                fala("""
                     Talon: Cultistas?
                     """);
                fala("""
                     Bartender: não sei ao certo quem são ou quem seguem, mas sei que a
                     antiga praga da cidade, este goblin, fez parte do bando deles, o maldito
                     se chama "Monzlevis", e assola nossa cidade desde que eu era uma criança.
                     """);
                fala("""
                     Talon: Eu sou um feiticeiro senhor bartender, eu tive uma visão deste
                     Goblin com um item rosa em sua mão! creio que era a pedra de Pythita Rosa,
                     eu gostaria de ir atrás dele para recuperar a pedra e provar minha inocência!
                     """);
                fala("""
                     Bartender: Vejo veracidade em suas palavras rapaz, mas qual seu objetivo?
                     """);
                fala("""
                     Talon: Não me lembro ao certo... mas sei que devo voltar pra casa... eu não
                     me lembro o porque mas sei que esqueci de algo muito importante...
                     """);
                fala("""
                     Bartender: Bom... se serve de consolo, caso pegue Monzlevis, eu gostaria que
                     aceitasse esses fragmentos de RubyOnRail, eles podem ser úteis para um feiticeiro.
                     """);
                fala("""
                     Talon: O senhor sabe me dizer onde Monzlevis reside?
                     """);
                fala("""
                     Bartender: Em uma caverna próxima daqui, não muito longe, ela estava abandonada
                     mas tenho certeza que Monzlevis voltou para la com seus dois capangas, tome cuidado
                     meu jovem, pode ser perigoso...
                     """);
                fala("""
                     Talon: Vai ficar tudo bem meu jovem senhor, eu sou duro na queda!!!
                     """);
                fala("""
                     Bartender: HAHAHA! Bem, siga em direção a montanha Golang e você verá a caverna
                     de Monzlevis, enquanto isso vou chamar o prefeito da vila para recebe-lo caso derrote
                     o maldito Goblin!
                     """);
                fala("""
                     Então Talon segue para a caverna, mas antes ele deseja testar suas habilidades com Java.
                     """);
                fala("""
                     Talon: Vamo lá! eu sei que posso usar estrutura de repetição para clonar 5 desta mesma pedra!
                     """);
                fala("""
                     𝓔𝓧𝓟𝓐𝓝𝓓𝓔 𝓐𝓝𝓘𝓜𝓤𝓜 𝓣𝓤𝓤𝓜: 𝓒𝓞𝓓𝓘𝓝𝓖 //expanda tua mente com: CODING.
                     """);
 
                executando = true;
                while(executando){
                    fala("Qual destas estruturas vós tens de usar para repetir vezes já determinadas?");
                    fala("\n(1)For\n(2)While\n(3)Do-While\n(4)If");
                    
                    entrada = input.nextInt();
                    if(entrada == 1){
                        fala("Como serás a estrutura de repetição?");
                        fala("\n(1) for(int i=1; i<6; i++)\n(2) for(int i=0; i<= 5; i++);\n(3) for(int i=5; i>=5; i--);\n(4) for(int i=2; i>1; i++);");
                        int entrada2 = input.nextInt();
                        if(entrada2 == 1){
                            executando = false;
                        }
                            
                    }else{
                        do{
                            fala("""
                             Java: Feitiço com instruções erradas, tente novamente...
                             """);
                            fala("-----------------------------------------------------");
                            fala("Qual destas estruturas vós tens de usar para repetir vezes já determinadas?");
                            fala("\n(1)For\n(2)While\n(3)Do-While\n(4)If");
                            entrada = input.nextInt();
                            
                        }while(entrada != 1);
                    }
                                        
                }
            }
            
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
                  ******    *          ******     *******    *******   *******    *********    *    *    **      **    ******
                  *    *    *         *          *       *   *     *      *           *        *    *    * *    * *    *    *
                  ******    *         *   ****   *       *   *******      *           *        ******    *  *  *  *    ******    
                  *    *    *         *      *   *       *   *  *         *           *        *    *    *   **   *    *    *
                  *    *    *******    *******    *******    *    *    *******        *        *    *    *        *    *    *
                               
                                                                                                            RETURN TO YOUR PAST                                      
                                           """);
            System.out.println(" ");
            System.out.println("\nDigite a opção desejada: ");
            System.out.println(" ");
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