package pilha;

public class Pilha<T> {
    private No<T> ref;

    public Pilha(){
        this.ref = null;
    }

    public T top(){
        return (T) ref.getDado();
    }

    public void push(T no){
        var novo = new No<>(no);
        novo.setProximo(ref);
        ref = novo;
    }

    public T pop(){
        if(!isEmpty()){
            var no = ref;
            ref = ref.getProximo();
            return (T) no.getDado();
        }
        return null;
    }

    public boolean isEmpty(){
        return ref == null;
    }

    public String toString(){
        StringBuilder header = new StringBuilder("----------------\n");
        header.append("     PILHA\n");
        header.append("----------------\n");

        var aux = ref;

        while (aux!=null){
            header.append("  [listaCircular.No{dado=").append(aux.getDado()).append("}]\n");
            aux = aux.getProximo();
        }

        return header.toString();

    }

}
