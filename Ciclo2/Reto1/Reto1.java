import java.util.Scanner;

public class Reto1 {

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        String[] fraseGroot = new String[(n+1)];
        
        fraseGroot[0] = "I am";
        fraseGroot[n] = " it";
        
        String mensajePar = " that I am";
        String mensajeImpar = " that I groot";
        
        for (int i = 1; i < (fraseGroot.length-1); i++) {
            if (i%2 == 0) {
                fraseGroot[i] = mensajePar;
            } else {
                fraseGroot[i] = mensajeImpar;
            }
        }

        for (int i = 0; i < (fraseGroot.length); i++) {
            System.out.print(fraseGroot[i]);
            
        }
    }
}