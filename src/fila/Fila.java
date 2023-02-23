package fila;



public class Fila<T> {

    private No<T> ref;

    public Fila(){
        this.ref = null;
    }

    public T first(){
        if (!isEmpty()){
            var aux = ref;
            while (aux.getProximo()!=null){
                aux = aux.getProximo();
            }
            return (T) aux.getDado();
        }
        return null;
    }

    public void enqueue(T no){
        var novo = new No<>(no);
        novo.setProximo(ref);
        ref = novo;
    }

    public T dequeue(){
        if (!isEmpty()){
            var prox = ref;
            var aux = ref;
            while (prox.getProximo()!=null){
                aux = prox;
                prox = prox.getProximo();
            }
            aux.setProximo(null);
            return (T) prox.getDado();
        }
        return null;
    }

    public boolean isEmpty(){
        return ref == null;
    }

    @Override
    public String toString() {
        StringBuilder header = new StringBuilder();
        No<T> aux = ref;
        while(aux!=null){
            header.append("[listaCircular.No{dado=").append(aux.getDado()).append("}] -> ");
            aux = aux.getProximo();
        }

        header.append("null");
        return header.toString();
    }
}
