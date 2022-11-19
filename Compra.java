package Questao3;
import java.time.LocalTime;

public class Compra 
{
    private int id; // ID da Compra
    private String estado; // Estado da Compra
    private LocalTime tempo; // Horario que a Compra foi efutada
    
    public Compra(int id_) // Construtor
    {
        id = id_;
        estado = "Aberta";
        tempo = LocalTime.now(); 
    }
    
    public int getId() // Pega ID
    {
        return id;
    }
    
    public String getEstado() // Pega o Estado
    {
        return estado;
    }
    
    public LocalTime getTempo() // Pega o Tempo
    {
        return tempo;
    }
    
    public void setAprovado() // Muda para Aprovado
    {
        estado = "Aprovado";
    }
    
    public void setDespachada() // Muda para Despachada
    {
        estado = "Despachada";
    }
    
    public void setRecebida() // Muda para Recebida
    {
        estado = "Recebida";
    }
    
    public void Imprimi() // Imprimi Compra
    {
        System.out.println("ID da Compra: "+id);
        System.out.println("Estado da Compra: "+estado);
    }
}
