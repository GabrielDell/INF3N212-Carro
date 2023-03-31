/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 182120002
 */
public class INF3N212Carro {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;

        do {
            System.out.println("\n-- Sistema de Cadastro --");
            menuP();
            opM = leiaNumInt();

            switch (opM) {//Inicio do primeiro switch case
                case 1:
                case 2:
                    do {

                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {//Inicio do segundo switch case
                            case 1:
                                System.out.println("1 - Cadastrar : ");
                                if (opM == 1) {
                                    cadastrarPessoa();
                                }else{
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("2 - Editar : ");
                                if (opM == 1) {
                                    editarPessoa();
                                }else{
                                    editarCarro();
                                }
                                break;
                            case 3:
                                System.out.println("3 - Listar: ");
                                if (opM == 1) {
                                    listarPessoa();
                                }else{
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("4 - Deletar : ");
                                if (opM == 1) {
                                    deletarPessoa();
                                }else{
                                    deletarCarro();
                                }
                                break;
                            case 0:
                                System.out.println("0 - Sair: ");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                        }//Fim do segundo switch case 
                    } while (opSM != 0);//Fim do 'do' primeiro
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }//Fim do primeiro switch case 
        } while (opM != 0);

    }//Fim do main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente novamente");
            leiaNumInt();
        }
        return 99;
    }//Fim da leiaNumInt()

    public static void menuP() {
        System.out.println("--- Menu Principal ---");
        System.out.println("1 - Ger.Pessoa");
        System.out.println("2 - Ger.Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }//Fim do menu()

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }//Fim do primeiro if
        if (opM == 2) {
            subM = "Carro";
        }//Fim do segundo if

        System.out.println("-- Ger. " + subM + " --");
        System.out.println("1 - Cadastrar" + subM);
        System.out.println("2 - Editar" + subM);
        System.out.println("3 - Listar" + subM + "s");
        System.out.println("4 - Deletar" + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");

    }//Fim do subMenu(int opM)

    private static void cadastrarPessoa() {
        System.out.println("Cadastar Pessoa");
    }

    private static void cadastrarCarro() {
        System.out.println("Cadastrar Carro");
    }

    private static void editarPessoa() {
        System.out.println("Editar Pessoa");
    }

    private static void editarCarro() {
        System.out.println("Editar Carro");
    }

    private static void listarPessoa() {
        System.out.println("Listar Pessoa");
    }

    private static void listarCarro() {
        System.out.println("Listar Carro");
    }

    private static void deletarPessoa() {
        System.out.println("Deletar Pessoa");
    }

    private static void deletarCarro() {
        System.out.println("Deletar Carro");
    }
}//Fim da classe INF3N212Carro
