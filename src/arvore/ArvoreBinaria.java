package arvore;

import javax.swing.plaf.SplitPaneUI;

public class ArvoreBinaria<T extends Comparable<T>> {
    private NoBin<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void add(T dado){
        NoBin<T> novo = new NoBin<>(dado);
        raiz = add(raiz,novo);
    }

    private NoBin<T> add(NoBin<T> atual, NoBin<T> novo){

        if (atual == null){
            return novo;
        }else if (novo.getDado().compareTo(atual.getDado()) < 0){
            atual.setEsquerda(add(atual.getEsquerda(),novo));
        }else {
            atual.setDireita(add(atual.getDireita(),novo));
        }

        return atual;
    }

    public void remover(T dado){
        try{
            var atual = raiz;
            NoBin<T> pai = null;
            NoBin<T> filho = null;
            NoBin<T> aux = null;

            while(atual != null && !atual.getDado().equals(dado)){
                pai = atual;
                if(dado.compareTo(atual.getDado())< 0){
                    atual = atual.getEsquerda();
                }else{
                    atual = atual.getDireita();
                }
            }

            if (atual==null){
                System.out.println("Dado não encontrado");
            }

            if (pai == null){
                if (atual.getDireita() == null){
                    raiz = atual.getEsquerda();
                }else if (atual.getEsquerda() == null){
                    raiz = atual.getDireita();
                }else {
                    for (
                            aux = atual, filho = atual.getEsquerda();
                            filho.getDireita() != null;
                            aux = filho, filho  = filho.getEsquerda()
                    ){
                        if (filho != atual.getEsquerda()){
                            aux.setDireita(filho.getEsquerda());
                            filho.setEsquerda(raiz.getEsquerda());
                        }
                    }
                    filho.setDireita(filho.getEsquerda());
                    raiz = filho;
                }

            }else if (atual.getDireita() == null){
                if (pai.getEsquerda() == atual){
                    pai.setEsquerda(atual.getEsquerda());
                }else{
                    pai.setDireita(atual.getEsquerda());
                }
            }else if (atual.getEsquerda() == null){
                if (pai.getEsquerda() == atual){
                    pai.setEsquerda(atual.getDireita());
                }else{
                    pai.setDireita(atual.getDireita());
                }
            }else{
                for(
                        aux = atual, filho = atual.getEsquerda();
                        filho.getDireita() != null;
                        aux = filho, filho  = filho.getDireita()
                ){
                    if (filho!=atual.getEsquerda()){
                        aux.setDireita(filho.getEsquerda());
                        filho.setEsquerda(atual.getEsquerda());
                    }
                    filho.setDireita(atual.getDireita());
                    if (pai.getEsquerda() == atual){
                        pai.setEsquerda(filho);
                    }else{
                        pai.setDireita(filho);
                    }
                }
            }

        }catch (NullPointerException e){
            System.out.println("Dado não encontrado");
        }
    }

    public void exibirInOrdem(){
        System.out.println("\n Exibindo em Ordem.");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(NoBin<T> atual){
        if(atual!=null){
            exibirInOrdem(atual.getEsquerda());
            System.out.println(atual.getDado() + ",");
            exibirInOrdem(atual.getDireita());
        }
    }
    public void exibirPosOrdem(){
        System.out.println("\n Exibindo em Ordem.");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(NoBin<T> atual){
        if(atual!=null){
            exibirPosOrdem(atual.getEsquerda());
            exibirPosOrdem(atual.getDireita());
            System.out.println(atual.getDado() + ",");

        }
    }
    public void exibirPreOrdem(){
        System.out.println("\n Exibindo em Ordem.");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(NoBin<T> atual){
        if(atual!=null){
            System.out.println(atual.getDado() + ",");
            exibirPreOrdem(atual.getEsquerda());
            exibirPreOrdem(atual.getDireita());
        }
    }
}
