package listaEncadeada;

public class No<T>{
    private T dado;
    private No<T> proximo;

    public No(T dado){
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "listaCircular.No{" + "conteudo=" + dado + '}';
    }
}
