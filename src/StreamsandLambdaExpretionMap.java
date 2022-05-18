
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;



import org.testng.Assert;

public class StreamsandLambdaExpretionMap {

    public void streamMap(){
        //Ejemplo de metodo de stream  filter() = filtra por alghuna letra especifica que empieze o termine con 
        //Ejemplo de metodo de stream  map() = que nos permite cambiar el string a mayusculaso minusculas en este ejemplo
        //Ejemplo de metodo de stream  sorted() = que nos permite ordenar los strings alfabeticamente 
        //Ejemplo de metodo de stream anymach() = buscara en la lista si existe ese nombre o string 
        //Ejemplo de metodo de stream collect() = convertira el stream en list strings  
        
        //Print the names wich have last letter as 'a' with Uppercase        
        Stream.of("Pedro", "Roberto", "Camila", "Karina").filter(y -> y.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
           
        
        //Print names wich have first letter as 'K' with Uppercase and sorted 
        String [] names = {"Pedro", "Roberto", "Camila", "Karina", "Karla", "Kira", "Kelia", "Alberto", "Alfredo", "Ignacion", "Haidee" };       
        List<String> nameslis = Arrays.asList(names);
        Stream<String> nameliss=  nameslis.stream();     

        //El metodo sorted agrupa los strings alfabeticamente despues de la k busca la A para ordenarlos por alfabeto los strings 
        nameslis.stream().filter(s->s.startsWith("K")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("\n" +s));


        String [] position = {"Armando", "Roberto", "Gilberto", "Cristian", "Ramon", "Raul", "Gregorio", "Eduardo",  "Salvador", "Berenice" };
        List<String> positions =  Arrays.asList(position);  
        Stream<String> positionss =  positions.stream();

        //Imprimiendo los nombre que tiener R como el las listas de webelements 
        positions.stream().filter(s->s.contains("R")).sorted().forEach(s-> JOptionPane.showMessageDialog(null, s));;

        //How to merge 2 streams into one  
        Stream<String> newStream =  Stream.concat(nameliss, positionss);
             
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Salvador"));
        Assert.assertTrue(flag); 

        List <String> ls = Stream.of("jony", "chon", "alfred", "remy").filter(s->s.endsWith("y")).map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
        System.out.println(ls.get(1));

    }

    public void programingexercise() {
        
        //Exercise print unique number from this array 
        //sort the array orden
        List<Integer> mylist =  Arrays.asList(33,55,7,9,6,8,44,2,1,4,7,9,0,8,79,6);

        mylist.stream().sorted().distinct().forEach(s-> System.out.println(s));

        Stream<Integer> ls = mylist.stream();

        ls.distinct().forEach(s->System.out.println(s));

        

    }

    public static void main(String[] args) {
        StreamsandLambdaExpretionMap objeto = new StreamsandLambdaExpretionMap();
        objeto.streamMap();
        objeto.programingexercise();
    }
}
