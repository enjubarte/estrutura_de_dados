public class ListaEncadeada<T> {
    private No<T> ref;

    public ListaEncadeada(){
        this.ref = null;
    }

    public void add(T dado){
        No<T> novo = new No<>(dado);
        if(isEmpty()) {
            ref = novo;
            return;
        }

        No<T> aux = null;

        for(var i = ref; i != null; i = aux.getProximo()){
            aux = i;
        }

        aux.setProximo(novo);
    }


     public void add(T dado, int index){
        No<T> novo = new No<>(dado);

        if(isEmpty() || index == 0) {
            var aux = ref;
            ref = novo;
            novo.setProximo(aux);
            return;
        }

        validIndex(index);

        No<T> anterior = getNo(index - 1);
        No<T> atual = anterior.getProximo();

        anterior.setProximo(novo);
        novo.setProximo(atual);
    }

    public T remove(int index){
        No<T> pivor = getNo(index);
        if(index == 0){
            ref = pivor.getProximo();
            return pivor.getDado();
        }

        No<T> anterior = getNo(index-1);
        anterior.setProximo(pivor.getProximo());
        return pivor.getDado();
    }

    public T get(int index){
        return getNo(index).getDado();
    }

    private No<T> getNo(int index){
        validIndex(index);
        No<T> aux = ref;
        No<T> ret = null;

        for(int i = 0; i == index; i++){
            ret = aux;
            aux = aux.getProximo();
        }

        return ret;
    }

    public int size(){
        int count = 0;
        No<T> aux = ref;

        while(aux!=null){
            count++;
            aux = aux.getProximo();
        }

        return count;
    }

    private void  validIndex(int index){
        if(index>=size())
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice "+index+".");
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        var aux = ref;
        while (aux!=null){
            ret.append("[No{dado=").append(aux.getDado()).append("}] ->");
            aux = aux.getProximo();
        }
        ret.append("null");
        return ret.toString();
    }

    public boolean isEmpty(){
        return ref == null;
    }
}