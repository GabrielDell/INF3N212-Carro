/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

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
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("2 - Editar : ");
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("4 - Deletar : ");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
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
        System.out.println("-- Cadastro de Pessoa --");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.getPessoaCPF(cpf) != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }//Fim do terceiro 'if'
                } else {

                    tcpf = false;

                }//Fim do segundo 'if else'
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.println("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }//Fim do quarto 'if'
                tcpf = true;
            }//Fim do primeiro 'if else'
        } while (tcpf);//Fim do 'do while'
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome() + " cadastro com sucesso!");
    }

    private static void cadastrarCarro() {
        System.out.println("-- Cadastrar Carro --");
        String placa;   
        String marca;
        String modelo;
        int anoFab;
        int anoMod;
        String cor;
        String tpCambio;
        String combustivel;
        Pessoa proprietario;
        boolean pCarro = true;
        do {
            System.out.print("Informe a placa: ");
            placa = leia.nextLine();
            pCarro = Validadores.validarPlaca(placa);
            if (pCarro) {
                Carro carro = cadCarro.getCarroPlaca(placa);
                if (carro == null) {
                    //segue fluxo de cadastro
                }else{
                    System.out.println("Placa já cadastrada.");
                }//Fim do segundo 'if'
            }else{
                System.out.println("Placa inválida! Tente novamente!");
                pCarro = true;
            }//Fim do primeiro 'if'
        } while (pCarro);//Fim do 'do while'
    }

    private static void editarPessoa() {
        System.out.println("-- Editar Pessoa --");
        boolean isCPF;
        do {
            System.out.print("Informe o CPF da pessoa a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    do {
                        System.out.println("Quais dados de " + p.getNome() + "deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Endereço");
                        System.out.println("3 - Telefone");
                        System.out.println("4 - Todos");
                        System.out.println("0 - Cancelar");
                        System.out.println("Digite aqui: ");
                        int op = leiaNumInt();
                        if (op == 1 || op == 4) {
                            System.out.print("Informe o novo nome: ");
                            p.setNome(leia.nextLine());
                            System.out.println("Nome alterado com sucesso para " + p.getNome());
                        }
                        if (op == 2 || op == 4) {
                            System.out.print("Informe o novo endereço: ");
                            p.setEndereco(leia.nextLine());
                            System.out.println("Endereço alterado com sucesso para " + p.getEndereco());
                        }

                        if (op == 3 || op == 4) {
                            System.out.print("Informe o novo telefone: ");
                            p.setTelefone(leia.nextLine());
                            System.out.println("Telefone alterado com sucesso para " + p.getTelefone());
                        }

                        if (op == 0) {
                            System.out.print("Operação cancelada pelo usuário! ");
                            isCPF = false;
                        }
                      
                        if (op < 0 || op > 4) {
                            System.out.println("Opção inválida, tente novamente!");
                        }
                        
                    } while (isCPF);//Fim do segundo 'do while'
                    
                } else {
                    System.out.println("CPF não cadastrado!");
                    isCPF = false;
                }//Fim do segundo 'if else'
            } else {
                System.out.println("CPF inválido!");
                System.out.print("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                isCPF = op == 1; // Variavel isCPF boolean recebendo um teste lógico true/false
            } //Fim do primeiro 'if else'

        } while (isCPF);//Fim do primeiro 'do while'

    }

    private static void editarCarro() {
        System.out.println("Editar Carro");
    }

    private static void listarPessoa() {
        System.out.println("-- Listar Pessoa --");
        for (Object pessoa : cadPessoa.getPessoas()) {
            System.out.println(pessoa.toString());

        }
    }

    private static void listarCarro() {
        System.out.println("-- Listar Carro --");
        for (Object carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());
        }
    }

    private static void deletarPessoa() {
        System.out.println("-- Deletar Pessoa --");
        boolean delCPF = false;
        do {
            System.out.println("Informe o CPF da pessoa a ser deletada: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Deseja realmente deletar " + p.getNome() + "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println("Pessoa deletada com sucesso!");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário!");
                        delCPF = false;
                    }//Fim do terceiro 'if else'
                } else {
                    System.out.println("CPF não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.println("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;
                    }

                }//Fim do segundo 'if else'

            } else {
                System.out.println("CPF inválido!"
                        + "\nTente novamente.");
                delCPF = true;
            }//Fim do primeiro 'if else'

        } while (delCPF);//Fim do 'do while'

    }

    private static void deletarCarro() {
        System.out.println("Deletar Carro");
    }
}//Fim da classe INF3N212Carro
