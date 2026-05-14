import javax.swing.JOptionPane;
 
public class Projeto {
 
    private static final String TITULO = "Fragmentos do Vazio";
 
    public static void main(String[] args) {
 
        while (true) {
 
            int opcaoMenu = menuPrincipal();
 
            if (opcaoMenu == 1) {
 
                iniciarJogo();
 
            } else if (opcaoMenu == 2) {
 
                mostrarSobre();
 
            } else if (opcaoMenu == 3) {
 
                mostrarCreditos();
 
            } else {
 
                JOptionPane.showMessageDialog(
                        null,
                        "Obrigado por jogar!",
                        TITULO,
                        JOptionPane.INFORMATION_MESSAGE
                );
 
                System.exit(0);
            }
        }
    }
 
    static int menuPrincipal() {
 
        while (true) {
 
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "=== " + TITULO + " ===\n\n"
                    + "1 - Jogar\n"
                    + "2 - Sobre\n"
                    + "3 - Créditos\n"
                    + "4 - Sair\n\n"
                    + "Digite uma opção:",
                    TITULO,
                    JOptionPane.QUESTION_MESSAGE
            );
 
            if (entrada == null) {
                return 4;
            }
 
            entrada = entrada.trim();
 
            if (entrada.equals("1")) {
                return 1;
 
            } else if (entrada.equals("2")) {
                return 2;
 
            } else if (entrada.equals("3")) {
                return 3;
 
            } else if (entrada.equals("4")) {
                return 4;
            }
 
            JOptionPane.showMessageDialog(
                    null,
                    "Opção inválida. Digite de 1 a 4.",
                    TITULO,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
 
    static void mostrarSobre() {
 
        String texto = "FRAGMENTOS DO VAZIO\n\n"
                + "Esse é um RPG narrativo em texto feito utilizando Java e JOptionPane.\n"
                + "O jogador acorda dentro de uma nave espacial sem memória e precisa tomar decisões,\n"
                + "encontrar pistas e descobrir o que aconteceu com a tripulação.\n\n"
                + "Como funciona:\n"
                + "- cada cena possui duas escolhas;\n"
                + "- algumas escolhas alteram pistas e sanidade;\n"
                + "- dependendo das decisões, o jogo possui finais diferentes;\n"
                + "- o jogador pode sair para o menu a qualquer momento.\n\n"
                + "Objetivo:\n"
                + "sobreviver e descobrir a verdade escondida dentro da nave.";
 
        JOptionPane.showMessageDialog(
                null,
                texto,
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
 
    static void mostrarCreditos() {
 
        String texto = "CRÉDITOS\n\n"
                + "Projeto: Fragmentos do Vazio\n"
                + "Tipo: RPG narrativo em texto\n"
                + "Ferramenta: Java + JOptionPane\n\n"
                + "Desenvolvido para o Projeto Integrador do 1º semestre.\n\n"
                + "Curso: Análise e Desenvolvimento de Sistemas\n"
                + "Turma: TURMA - D\n"
                + "Professor: Eliseu\n\n"
                + "Integrantes:\n"
                + "- Yuri do Amaral Andrade Santos\n"
                + "- Samuel Costa da Silva\n"
                + "- Davi Silva Silverio\n"
                + "- Peterson Ryan Santiago Messias\n"
                + "- Pedro Henrique Santana Gomes\n"
                + "- Lucas Campos Ribeiro";
 
        JOptionPane.showMessageDialog(
                null,
                texto,
                "Créditos",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
 
    static void iniciarJogo() {
 
        int pistas = 0;
        int sanidade = 10;
 
        boolean gravador = false;
        boolean viuReflexo = false;
        boolean memoriaFragmentada = false;
 
        mostrarTexto(
                "Fragmentos do Vazio",
 
                "Você desperta com o corpo pesado e a cabeça latejando.\n"
                + "A sala é fria, metálica e iluminada por luzes fracas que piscam sem parar.\n"
                + "Ao lado da maca onde você acordou, há manchas escuras no metal e um painel apagado.\n\n"
                + "Você não sabe onde está.\n"
                + "Não sabe quem é.\n"
                + "E, pior de tudo, não sabe por que está ali."
        );
 
        int escolha1 = escolher(
                "Escolha 1",
 
                "Um som seco ecoa em algum lugar da nave.\n\n"
                + "O que você faz?",
 
                "Ir até a janela e observar o lado de fora.",
                "Seguir o barulho vindo do corredor."
        );
 
        if (escolha1 == 0) {
            return;
        }
 
        if (escolha1 == 1) {
 
            sanidade--;
 
            mostrarTexto(
                    "A janela",
 
                    "Você se aproxima devagar e sente o vidro gelado.\n"
                    + "Lá fora existe apenas o espaço, escuro e silencioso.\n"
                    + "Ao longe, uma estrutura enorme aparece destruída, como restos de outra estação.\n\n"
                    + "Quando você olha mais de perto, percebe uma marca fina no vidro.\n"
                    + "Parece o desenho de uma mão encostada por dentro."
            );
 
            int escolha2 = escolher(
                    "Escolha 2",
 
                    "Antes que consiga entender o que viu, o alto-falante chia.\n\n"
                    + "Uma voz falhada diz:\n"
                    + "\"Não abra a porta principal.\"\n\n"
                    + "O que você faz?",
 
                    "Procurar outra saída na sala.",
                    "Ignorar o aviso e abrir a porta principal."
            );
 
            if (escolha2 == 0) {
                return;
            }
 
            if (escolha2 == 1) {
 
                pistas++;
                gravador = true;
 
                mostrarTexto(
                        "Sala de manutenção",
 
                        "Você encontra uma pequena porta emperrada e entra com dificuldade.\n"
                        + "Lá dentro existem fios, caixas de energia e um monitor ainda ligado.\n\n"
                        + "Na tela aparece:\n"
                        + "\"Tripulação registrada: 12\"\n\n"
                        + "Logo depois, a contagem muda sozinha para 11.\n\n"
                        + "No chão existe um gravador.\n"
                        + "Ao apertar o botão, uma voz chiada avisa:\n"
                        + "\"Se alguém acordar sem memória, mantenha longe do Núcleo.\""
                );
 
            } else {
 
                sanidade -= 2;
 
                mostrarTexto(
                        "A porta principal",
 
                        "Você ignora o aviso e abre a porta.\n"
                        + "O corredor está escuro, com marcas profundas nas paredes.\n"
                        + "Mais à frente, dois caminhos aparecem:\n"
                        + "sala de controle e enfermaria."
                );
            }
        }
 
        mostrarTexto(
                "Sala de controle",
 
                "A sala de controle está quase toda apagada.\n"
                + "Alguns monitores ainda funcionam e mostram corredores vazios.\n\n"
                + "Sobre a mesa há papéis espalhados.\n"
                + "Em um deles está escrito:\n"
                + "\"Nem tudo que fala na nave é humano.\""
        );
 
        int escolhaFinal = escolher(
                "Escolha Final",
 
                "Duas rotas principais aparecem diante de você.\n\n"
                + "O que deseja fazer?",
 
                "Ir até o Núcleo Central.",
                "Tentar fugir pelas cápsulas de escape."
        );
 
        if (escolhaFinal == 0) {
            return;
        }
 
        if (escolhaFinal == 1) {
 
            if (pistas >= 1 && gravador) {
 
                mostrarTexto(
                        "Final 1 - A verdade",
 
                        "No Núcleo Central, você encontra uma estrutura viva presa por cabos.\n"
                        + "A nave inteira parece pulsar junto dela.\n\n"
                        + "Sua memória retorna em fragmentos.\n"
                        + "Você fazia parte da equipe que tentou conter aquilo.\n\n"
                        + "A nave não trouxe você de volta por acaso.\n"
                        + "Ela estava esperando."
                );
 
            } else {
 
                mostrarTexto(
                        "Final 2 - O erro",
 
                        "Você tenta acessar o Núcleo sem entender o sistema.\n"
                        + "As luzes se apagam.\n"
                        + "As portas se trancam.\n\n"
                        + "No escuro, algo começa a andar na sua direção."
                );
            }
 
        } else {
 
            if (sanidade >= 7) {
 
                mostrarTexto(
                        "Final 3 - A fuga",
 
                        "Você consegue ativar a cápsula de escape.\n"
                        + "A nave fica para trás, silenciosa no vazio.\n\n"
                        + "Por alguns segundos, parece que tudo terminou.\n"
                        + "Então uma respiração surge atrás de você."
                );
 
            } else {
 
                mostrarTexto(
                        "Final 4 - O reflexo",
 
                        "Você corre desesperadamente até a cápsula.\n"
                        + "Quando o painel acende, seu reflexo aparece no vidro.\n\n"
                        + "Mas ele sorri antes de você."
                );
            }
        }
 
        JOptionPane.showMessageDialog(
                null,
                "Fim do jogo.",
                TITULO,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
 
    static void mostrarTexto(String titulo, String texto) {
 
        JOptionPane.showMessageDialog(
                null,
                texto,
                titulo,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
 
    static int escolher(
            String titulo,
            String texto,
            String opcaoA,
            String opcaoB
    ) {
 
        while (true) {
 
            String entrada = JOptionPane.showInputDialog(
                    null,
 
                    texto + "\n\n"
                    + "1 - " + opcaoA + "\n"
                    + "2 - " + opcaoB + "\n\n"
                    + "Cancelar ou fechar a janela volta ao menu.",
 
                    titulo,
                    JOptionPane.QUESTION_MESSAGE
            );
 
            if (entrada == null) {
 
                if (confirmarSaida()) {
                    return 0;
                }
 
                continue;
            }
 
            entrada = entrada.trim();
 
            if (entrada.equals("1")) {
                return 1;
            }
 
            if (entrada.equals("2")) {
                return 2;
            }
 
            JOptionPane.showMessageDialog(
                    null,
                    "Escolha inválida. Digite 1 ou 2.",
                    titulo,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
 
    static boolean confirmarSaida() {
 
        String[] opcoes = {"Sim", "Não"};
 
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Deseja sair desta partida e voltar ao menu?",
                TITULO,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[1]
        );
 
        return escolha == 0;
    }
}