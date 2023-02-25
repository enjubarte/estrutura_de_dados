package arvore;

public class NoBin<T extends Comparable<T>> {
    private T dado;
    private NoBin<T> esquerda;
    private NoBin<T> direita;

    public NoBin(T dado){
        this.dado = dado;
        this.esquerda = this.direita = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoBin<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoBin<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoBin<T> getDireita() {
        return direita;
    }

    public void setDireita(NoBin<T> direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return "NoBin{" +
                "dado=" + dado +
                '}';
    }
}
