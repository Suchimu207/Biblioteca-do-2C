import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    private Scanner teclado;
    private Sistema funcionário;
    private ArrayList<Autor> autores;
    private ArrayList<Livro> livros;
    private ArrayList<String> categorias;
    private ArrayList<String> gêneros;

    private int comandos [];
    //0 = comando
    //1 = escolha

    private String autor [];
    //0 = nome
    //1 = anoNasc
    //2 = cpf

    private String título;
    private String ISBN;
    private String categoria;
    private String gênero;
    private Autor aut;
    private Livro liv;

    public void Iniciar_menu(){
        teclado = new Scanner(System.in);
        comandos = new int[2];
        funcionário = new Sistema();
        autor = new String[3];
        autores = new ArrayList<Autor>();
        livros = new ArrayList<Livro>();
        categorias = new ArrayList<String>();
        gêneros = new ArrayList<String>();

        Criar_categorias();

        Menu();
        //===
    }

    private void Criar_categorias(){
        categorias.add("Literatura");
        categorias.add("Geografia");
        categorias.add("Biografia");
        categorias.add("História");
        categorias.add("Gramática");
        categorias.add("Artes-desenho");
        categorias.add("Construção cívil");
        categorias.add("Administração");
        categorias.add("Educação Física");
        categorias.add("Biologia");
        categorias.add("Química");
        categorias.add("Física");
        categorias.add("Matemática");
        categorias.add("Sociologia");
        categorias.add("Segurança do trabalho");
        categorias.add("Autoajuda");
        categorias.add("Religião");
        categorias.add("Filosofia");
        categorias.add("Informática");
        categorias.add("Dicionário");

        //===
    }

    private void Desenha_título(){
        System.out.println("");
        System.out.println("\u001B[32m==========================\u001B[0m");
        System.out.println("\u001B[32m     Biblioteca do 2C\u001B[0m");
        System.out.println("\u001B[32m==========================\u001B[0m");
        System.out.println("");
        //===
    }

    private void Menu(){
        comandos[0] = 1;
        while (comandos[0] != 0){
            funcionário.limpaTela();
            Desenha_título();

            System.out.println("==========================");
            System.out.println("1. Criar livro");
            System.out.println("2. Criar autor");
            System.out.println("3. Criar gênero");
            System.out.println("4. Ver lista");
            System.out.println("5. Sair");
            System.out.println("==========================");

            System.out.print(">");
            comandos[0] = teclado.nextInt();

            switch (comandos[0]){
                case 1:
                    if (autores.isEmpty() || gêneros.isEmpty()){
                        System.out.println("");
                        System.out.println("\u001B[31mVocê não possui autores e/ou gêneros! Digite 0 para voltar.\u001B[0m");
                        System.out.print(">");
                        teclado.next();
                    }else{
                        System.out.println("");

                        ISBN = funcionário.Gerar_ISBN();

                        System.out.println("Insira título:");
                        System.out.print(">");
                        título = teclado.next();

                        System.out.println("");

                        System.out.println("==========================");
                        for (int i = 0; i <= categorias.size()-1; i++){
                            categoria = categorias.get(i);
                            System.out.println(i+". "+categoria);
                        }
                        System.out.println("==========================");

                        System.out.println("");

                        System.out.println("Escolha\u001B[34m uma categoria:\u001B[0m");
                        System.out.print(">");
                        comandos[1] = teclado.nextInt();

                        categoria = categorias.get(comandos[1]);

                        System.out.println("");

                        System.out.println("==========================");
                        for (int i = 0; i <= gêneros.size()-1; i++){
                            gênero = gêneros.get(i);
                            gênero = gênero.toUpperCase();
                            System.out.println(i+". "+gênero);
                        }
                        System.out.println("==========================");

                        System.out.println("Escolha\u001B[34m um gênero:\u001B[0m");
                        System.out.print(">");
                        comandos[1] = teclado.nextInt();

                        gênero = gêneros.get(comandos[1]);

                        System.out.println("");

                        System.out.println("==========================");
                        for (int i = 0; i <= autores.size()-1; i++){
                            aut = autores.get(i);
                            autor[0] = aut.getNome();
                            System.out.println(i+". "+autor[0]);
                        }
                        System.out.println("==========================");

                        System.out.println("");

                        System.out.println("Escolha\u001B[34m um autor:\u001B[0m");
                        System.out.print(">");
                        comandos[1] = teclado.nextInt();

                        aut = autores.get(comandos[1]);

                        liv = new Livro(ISBN, título, aut, categoria, gênero);
                        livros.add(liv);
                    }
                    break;
                case 2:
                    System.out.println("");

                    System.out.println("Insira nome:");
                    System.out.print(">");
                    autor[0] = teclado.next();

                    System.out.println("");

                    System.out.println("Insira data de nascimento:");
                    System.out.print(">");
                    autor[1] = teclado.next();

                    System.out.println("");

                    System.out.println("Insira cpf:");
                    System.out.print(">");
                    autor[2] = teclado.next();

                    aut = new Autor(autor[0],autor[1],autor[2]);
                    autores.add(aut);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Insira o nome do gênero:");
                    System.out.print(">");
                    gênero = teclado.next();

                    gêneros.add(gênero);
                    break;
                case 4:
                    funcionário.limpaTela();
                    Desenha_título();
                    System.out.println("==========================");
                    System.out.println("1. Livros");
                    System.out.println("2. Autores");
                    System.out.println("3. Voltar");
                    System.out.println("==========================");

                    if (autores.isEmpty() || livros.isEmpty()){
                        System.out.println("");
                        System.out.println("\u001B[31mVocê não possui livros e/ou autores! "+
                                "Digite 0 para voltar.\u001B[0m");

                        System.out.print(">");
                        teclado.next();
                    }else{
                        comandos[1] = 1;
                        while (comandos[1] != 0){
                            System.out.print(">");
                            comandos[1] = teclado.nextInt();

                            switch (comandos[1]){
                                case 1:
                                    System.out.println("");
                                    System.out.println("==========================");
                                    for (int i = 0; i <= livros.size()-1; i++){
                                        liv = livros.get(i);
                                        título = liv.getTitulo();
                                        System.out.println(i+". "+título);

                                    }
                                    System.out.println("==========================");

                                    System.out.println("");

                                    System.out.println("Consultar livro:");
                                    System.out.print(">");
                                    comandos[1] = teclado.nextInt();
                                    liv = livros.get(comandos[1]);

                                    título = liv.getTitulo();
                                    ISBN = liv.getISBN();
                                    categoria = liv.getCategoria();
                                    aut = liv.getAutor();
                                    autor[0] = aut.getNome();
                                    gênero = liv.getGênero();
                                    gênero = gênero.toUpperCase();

                                    System.out.println("");

                                    System.out.println("==========================");
                                    System.out.println("Título: "+título);
                                    System.out.println("Autor: "+autor[0]);
                                    System.out.println("Gênero: "+gênero);
                                    System.out.println("ISBN: "+ISBN);
                                    System.out.println("Categoria: "+categoria);
                                    System.out.println("==========================");
                                    System.out.println("");

                                    System.out.println("Digite 0 para voltar.");
                                    System.out.print(">");
                                    teclado.next();
                                    comandos[1] = 0;
                                    break;
                                case 2:
                                    System.out.println("");
                                    System.out.println("==========================");

                                    for (int i = 0; i <= autores.size()-1; i++){
                                        aut = autores.get(i);
                                        autor[0] = aut.getNome();
                                        System.out.println(i+". "+autor[0]);

                                    }
                                    System.out.println("==========================");

                                    System.out.println("");

                                    System.out.println("Consultar autor:");
                                    System.out.print(">");
                                    comandos[1] = teclado.nextInt();
                                    aut = autores.get(comandos[1]);

                                    autor[0] = aut.getNome();
                                    autor[1] = aut.getAnoNasc();
                                    autor[2] = aut.getCpf();

                                    System.out.println("");

                                    System.out.println("==========================");
                                    System.out.println("Nome: "+autor[0]);
                                    System.out.println("Data de nascimento: "+autor[1]);
                                    System.out.println("CPF: "+autor[2]);
                                    System.out.println("==========================");
                                    System.out.println("");

                                    System.out.println("Digite 0 para voltar.");
                                    System.out.print(">");
                                    teclado.next();
                                    comandos[1] = 0;
                                    break;
                                case 3:
                                    comandos[1] = 0;
                                    break;
                            }
                            //===
                        }
                        //===
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                //===
            }
            //===
        }
        //===
    }
    //===
}