public class Main {
    public static void main(String[] args) {
       ListaDuplamenteEncadeada<String> listaDupla = new ListaDuplamenteEncadeada<>();

       listaDupla.add("Douglas 1");
       listaDupla.add("Douglas 2");
       listaDupla.add("Douglas 3");
       listaDupla.add("Douglas 4");
       listaDupla.add("Douglas 5");

       System.out.println(listaDupla);

       listaDupla.remove(3);
       System.out.println(listaDupla);

       listaDupla.add(3,"Douglas");
       System.out.println(listaDupla);
    }
}