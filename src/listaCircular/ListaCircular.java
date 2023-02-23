package listaCircular;

public class ListaCircular<T> {

    private No<T> inicio;
    private No<T> fim;
    private int size;

    public ListaCircular(){
        this.inicio = null;
        this.fim = null;
        this.size = 0;
    }

    public void add(T dado){
        No<T> novo = new No<>(dado);
        if (size==0){
            inicio = novo;
            fim = inicio;
            inicio.setProximo(fim);
        }else{
            novo.setProximo(fim);
            inicio.setProximo(novo);
            fim = novo;
        }
        size++;
    }

    public void remove(int index){
        if(index >= size)
            throw new IndexOutOfBoundsException("Indice maior que o tamanho da lista");

        if(index==0){
            inicio = inicio.getProximo();
            fim.setProximo(inicio);
        } else if (index==1) {
            inicio.setProximo(inicio.getProximo().getProximo());
        }else{
            var aux = inicio;
            for (int i = 0; i<index-1;i++)
                aux = aux.getProximo();
            aux.setProximo(aux.getProximo().getProximo());
        }
        size--;
    }

    public T get(int index){
        return getNo(index).getDado();
    }

    private No<T> getNo(int index){
        if(isEmpty())
            throw  new IndexOutOfBoundsException("Lista vazia");
        if (index == 0)
            return fim;

        var aux = inicio;

        for(int i = 0; i<index;i++)
            aux = aux.getProximo();

        return aux;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        var aux = fim;
        for(int i = 0; i< size;i++){
            ret.append("[No{dado=").append(aux.getDado()).append("}] ->");
            aux = aux.getProximo();
        }
        ret.append(size!=0 ? "(retorna ao inicio)":"[]");
        return ret.toString();
    }
}
