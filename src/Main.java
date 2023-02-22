public class Main {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<>();

        pilha.push("Eu");
        pilha.push("Tu");
        pilha.push("Nós");


        System.out.println(pilha);
        System.out.println(pilha.pop());
        System.out.println(pilha);
    }
}