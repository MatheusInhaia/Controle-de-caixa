import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Sistema {

    int caixa = 1;
    int opcaoMenu;

    private ArrayList<Cliente> filaNormal;
    private ArrayList<Cliente> filaPrioritaria;

    public Sistema (){
        filaNormal = new ArrayList<>();
        filaPrioritaria = new ArrayList<>();

    }

    public void Menu(){
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("-//- Opções -//-");
            System.out.println("1- Registrar cliente na fila");
            System.out.println("2- Chamar cliente para o caixa");
            System.out.println("0- sair");
            System.out.print("\nDigite a opção: ");
            opcaoMenu = ler.nextInt();

            switch(opcaoMenu){
                case 1:
                    try {
                        registrarCliente();
                        System.out.println("Cliente registrado");
                    }catch(Exception e){
                        System.out.println("ERRO AO REGISTRAR");
                    }
                    break;
                case 2:
                    chamarClienteAoCaixa();
                    break;
                case 0:
                    System.out.println("Desconectando do sistema.");
                    break;
                default:
                    Menu();
                    break;
            }
        }while(opcaoMenu!=0);

    }

    public void chamarClienteAoCaixa(){
        switch(caixa){
            case 1:
                atenderCliente(caixa);
                caixa = 2;
                break;
            case 2:
                atenderCliente(caixa);
                caixa = 3;
                break;
            case 3:
                atenderCliente(caixa);
                caixa = 4;
                break;
            case 4:
                atenderCliente(caixa);
                caixa = 5;
                break;
            case 5:
                atenderCliente(caixa);
                caixa = 6;
                break;
            case 6:
                atenderClienteNormal(caixa);
                caixa = 1;
                break;


        }


    }

    public void atenderCliente(int numero){
        if(!filaPrioritaria.isEmpty()) {
            System.out.println("--Caixa "+numero+"--" + "\n" + filaPrioritaria.get(0).toString());
            removerClientePrioritarioFila();
        }else if(!filaNormal.isEmpty()){
            System.out.println("--Caixa "+numero+"--" + "\n" + filaNormal.get(0).toString());
            removerClienteFila();
        }else{
            System.out.println("Não há clientes na fila!");
        }

    }

    public void atenderClienteNormal(int numero){
        if(!filaNormal.isEmpty()){
            System.out.println("--Caixa "+numero+"--" + "\n" + filaNormal.get(0).toString());
            removerClienteFila();
        }else{
            System.out.println("Não há clientes na fila!");
        }

    }
    public void removerClientePrioritarioFila(){
        filaPrioritaria.remove(0);
    }
    public void removerClienteFila(){
        filaNormal.remove(0);
    }

    public void adicionarClienteFila(Cliente c){
        if(c.getIdade()>=60){
            filaPrioritaria.add(c);
        }else{
            filaNormal.add(c);
        }

    }

    public void registrarCliente(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = ler.nextLine();
        System.out.println("Digite sua idade: ");
        String idade = ler.nextLine();
        Cliente novo = new Cliente(nome, Integer.parseInt(idade));
        adicionarClienteFila(novo);

    }



}
