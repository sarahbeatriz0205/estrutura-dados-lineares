package exercicios.trabalho_vetor;

public class VetorDuplamenteEncadeado implements IVetor{
    private No head;
    private No tail;
    private int size;

    public VetorDuplamenteEncadeado(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.head == null && this.tail == null){
            return true;
        }
        return false;
    }

    public Object elemAtRank(int r) throws VetorExcecao{
        No aux = this.head; // começou no começo
        if (r < 0 || r >= this.size){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        return aux.getElemento();
    }

    public Object removeAtRank(int r) throws VetorExcecao{
        if (r < 0 || r >= this.size){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        if (isEmpty()){
            throw new VetorExcecao("Erro! Vetor vazio");
        }
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        if (aux.getAnterior() != null){
            aux.getAnterior().setProximo(aux.getProximo()); // significa que o próximo do anterior deve ser o próximo do atual
        }
        else{
            this.head = aux.getProximo();
        }
        if (aux.getProximo() != null){
            aux.getProximo().setAnterior(aux.getAnterior());
        }
        else{
            this.tail = aux.getAnterior();
        } 
        this.size--;
        return element;  
    }

    public Object replaceAtRank(int r, Object o){
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        
    }   
}