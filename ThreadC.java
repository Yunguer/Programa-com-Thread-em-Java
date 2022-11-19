package Questao3;
import java.util.*;
import java.lang.*;
import java.time.Duration;
import java.time.LocalTime;

public class ThreadC extends Thread 
{
    
    private List<Compra> compras = Collections.synchronizedList(new ArrayList<>()); // Lista Sincronizada de Compras
    
    public ThreadC(List<Compra> compras_) // Construtor
    {
        compras = compras_;
    }
    
    @Override
    public void run()
    {
        while(!isInterrupted()) // Enquanto a Thread não é interrompida
        {
            for(int i = 0; i < compras.size(); i++) // Para todas as compras
            {
                if(compras.get(i).getEstado() == "Despachada" && Duration.between(compras.get(i).getTempo(), LocalTime.now()).toSeconds() == 15)
                {
                    compras.get(i).setRecebida(); // Se o estado for Despachada e o tempo for 15 segundos muda para Recebida e Imprimi
                    compras.get(i).Imprimi();
                }
            }
        }
    }
}
