package SeleniumFirst;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
 

public class StreamsandLambdaExpretion {
    // Programa para saber saber cuantos names empiezan con una letra especifica
    // ejemplo A

    ArrayList<String> names = new ArrayList<String>();
    String letter;
    
    public void usingjava() {

        names.add("Jonathan");
        names.add("Adriana");
        names.add("Carlos");
        names.add("Fatima");
        names.add("Alejandra");
        names.add("Karla");

        
        letter = JOptionPane.showInputDialog("Please inset the string toi check with initial letter");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).contains(letter)) {
                count++;

            }
        }
        System.out.println("Completed successfully " + " Count number is equals to " + count);

    }

    public void StreamsexampleUsingLambdaExprexion(){
        long contador =   names.stream().filter(s -> s.startsWith(letter)).count(); 
         System.out.println(contador);

         //Como imprimir los nombres que tienen mas de 6  letras con stream 
         names.stream().filter(s->s.length()>6).forEach(s-> System.out.println(s));

         //como imprimir los nombres dependiendo del limite max size 
         names.stream().filter(s->s.length()>1).limit(5).forEach(s->System.out.println(s));
    }

    public void Streamof(){
        // This is an example to how to creeate the Array List into streams API 
        //There is no life intermediate operation is there is no terminal operation 
        //terminal operation will execute only if intermediate operation (filter) returns true
        //We can create stream 
        //How to use filter in stream API  

        String charr = JOptionPane.showInputDialog("New char to check ");

        long d2 =  Stream.of("Luis", "Pedro","Ramon", "David", "Daniel", "Dormamu").filter(s ->
        {
            s.startsWith(charr);
            return true;
        }).count();

        JOptionPane.showMessageDialog(null, d2);

        


    }

    public static void main(String[] args) {
        StreamsandLambdaExpretion objeto = new StreamsandLambdaExpretion();
        objeto.usingjava();
        objeto.StreamsexampleUsingLambdaExprexion();
        objeto.Streamof();
    }
}
