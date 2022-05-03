import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.checkerframework.checker.units.qual.C;


public class StreamsandLambdaExpretion {

    ArrayList<String> names = new ArrayList<String>();
    
    public void usingjava(){

    names.add("Jonathan");
    names.add("Adriana");
    names.add("Carlos");
    names.add("Fatima");
    names.add("Alejandra");
    String init;
    init =   JOptionPane.showInputDialog("Please inset the string toi check with initial letter");
    


    int count = 0;

    for(int i = 0;i < names.size(); i ++){

        if(names.get(i).startsWith(init)){
            count ++;
            
        
        }
    }    System.out.println("Completed successfully " + "Count number is equals to " + count);


    }


    
    public static void main(String[] args) {
            StreamsandLambdaExpretion objeto = new StreamsandLambdaExpretion();
            objeto.usingjava();
    }
}
