public class ListaDuplamenteEncadeada<T>{

    private NoDuplo<T> primeiro;
    private NoDuplo<T> ultimo;
    private int size;

    public ListaDuplamenteEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T dado){
        NoDuplo<T> novo = new NoDuplo<>(dado);
        novo.setProximo(null);
        novo.setAnterior(ultimo);

        if (primeiro == null)
            primeiro = novo;

        if (ultimo!=null)
            ultimo.setProximo(novo);

        ultimo = novo;
        size++;
    }

    public void add(int index, T dado){
        NoDuplo<T> aux = getNo(index);
        NoDuplo<T> novo = new NoDuplo<>(dado);
        novo.setProximo(aux);

        if(novo.getProximo() != null){
            novo.setAnterior(aux.getAnterior());
            novo.getProximo().setAnterior(novo);
        }else{
            novo.setAnterior(ultimo);
            ultimo = novo;
        }

        if (index == 0)
            primeiro = novo;
        else
            novo.getAnterior().setProximo(novo);

        size++;
    }

    public void remove(int index){
        if(index==0){
            primeiro = primeiro.getProximo();
            if(primeiro != null)
                primeiro.setAnterior(null);
        }else{
            var aux = getNo(index);
            aux.getAnterior().setProximo(aux.getProximo());
            if (aux!=ultimo){
               aux.getProximo().setAnterior(aux.getAnterior());
            }else {
                ultimo = aux;
            }
        }

        this.size--;
    }

    public T get(int index){
        return this.getNo(index).getDado();
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> aux = primeiro;

        for(int i = 0; (i<index && aux!=null); i++){
            aux=aux.getProximo();
        }

        return aux;
    }

    public int size(){
        return this.size;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();

        for(var i = primeiro; i != null; i = i.getProximo())
            ret.append("[No{dado=").append(i).append("}] -> ");

        ret.append("null");
        return ret.toString();
    }
}
