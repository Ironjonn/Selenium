import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsandLambdaExpretionMap {

    public void streamMap(){
        //Print the names wich have last letter as 'a' with Uppercase
        
        Stream.of("Pedro", "Roberto", "Camila", "Karina").filter(s -> s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
           

        //Print names wich have first letter as 'K' with Uppercase and sorted 
        String [] names = {"Pedro", "Roberto", "Camila", "Karina", "Karla", "Kira", "Kelia"};
        List<String> nameslis = Arrays.asList(names);

        

        //El metodo sorted agrupa los strings alfabeticamente despues de la k busca la A para ordenarlos por alfabeto los strings 
        nameslis.stream().filter(s->s.startsWith("K")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("\n" +s));
    }

    public static void main(String[] args) {
        StreamsandLambdaExpretionMap objeto = new StreamsandLambdaExpretionMap();
        objeto.streamMap();
    }
}
