package Questao3;
import java.util.*;

public class Principal3 {

    public static void main(String[] args) 
    {
        int op = 0;
        
        Scanner sc = new Scanner(System.in);
        
        List<Compra> Compras = Collections.synchronizedList(new ArrayList<>()); // Lista Sincronizada das Compras
        
        ThreadA t1 = new ThreadA(Compras); // Cria T1
        ThreadB t2 = new ThreadB(Compras); // Cria T2
        ThreadC t3 = new ThreadC(Compras); // Cria T3
        
        t1.start(); // Starta T1
        t2.start(); // Starta T2
        t3.start(); // Starta T3
        
        while(op != -1)
        {
            System.out.println("O que deseja fazer?");
            System.out.println("(1 = Deseja criar uma Compra)\n(-1 = Parar)");
            op = sc.nextInt();
            if(op == 1)
            {
                System.out.println("Digite o ID da Compra:");
                int ID = sc.nextInt();
                Compras.add(new Compra(ID)); // Se op == 1 Cria Compra e insere na lista
            }
        }
        
        t1.interrupt(); // Interrompe T1
        t2.interrupt(); // Interrompe T2
        t3.interrupt(); // Interrompe T3
    }
}
