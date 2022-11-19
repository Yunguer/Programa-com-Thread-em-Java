package Questao3;
import java.util.*;
import java.lang.*;
import java.time.Duration;
import java.time.LocalTime;

public class ThreadA extends Thread 
{
    
    private List<Compra> compras = Collections.synchronizedList(new ArrayList<>()); // Lista Sincronizada de Compras
    
    public ThreadA(List<Compra> compras_) // Construtor
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
                if(compras.get(i).getEstado() == "Aberta" && Duration.between(compras.get(i).getTempo(), LocalTime.now()).toSeconds() == 3)
                {
                    compras.get(i).setAprovado(); // Se o estado for Aberto e o tempo for 3 segundos muda para Aprovado e Imprimi
                    compras.get(i).Imprimi();
                }
            }
        }
        
    }
}
