package Questao3;
import java.util.*;
import java.lang.*;
import java.time.Duration;
import java.time.LocalTime;

public class ThreadB extends Thread 
{
    
    private List<Compra> compras = Collections.synchronizedList(new ArrayList<>()); // Lista Sincronizada de Compras
    
    public ThreadB(List<Compra> compras_) // Construtor
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
                if(compras.get(i).getEstado() == "Aprovado" && Duration.between(compras.get(i).getTempo(), LocalTime.now()).toSeconds() == 8)
                {
                    compras.get(i).setDespachada(); // Se o estado for Aprovado e o tempo for 8 segundos muda para Despachada e Imprimi
                    compras.get(i).Imprimi();
                }
            }   
        }
    }
}
