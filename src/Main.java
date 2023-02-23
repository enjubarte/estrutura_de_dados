public class Main {
    public static void main(String[] args) {
       ListaEncadeada<String> lista = new ListaEncadeada<>();
       lista.add("1");
       lista.add("2");
       lista.add("3");

       System.out.println(lista);

       lista.set(2, "atualizou");
       System.out.println(lista);
    }
}