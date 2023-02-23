import listaCircular.ListaCircular;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> listaCircular = new ListaCircular<>();

        listaCircular.add("1");
        listaCircular.add("2");
        listaCircular.add("3");

        System.out.println(listaCircular.get(0));
    }
}