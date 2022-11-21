import java.util.Scanner;


//para ocupar funciones o variables se tiene que aplicar el modificador static
// esto hace a que apunte a los valores de los atributos guardados en la clase.

public class EquisCero {
    static boolean fin = false;
    static String[][] matriz = new String[3][3];
    static void validacion( boolean jugador, String marca){
        for(int i = 0 ; i<3 ; i++){

            //Evaluacion de filas ---
                if( matriz[i][0] == matriz[i][1] && 
                    matriz[i][2] == matriz[i][1] && 
                    matriz[i][1] == marca ){
                    System.out.println("\nEl ganador es el jugador " + (jugador ? "1" : "2"));
                    fin = true;
                }
                //Evaluacion de columnas \\\
                if( matriz[0][i] == matriz[1][i] && 
                    matriz[2][i] == matriz[1][i] &&    
                    matriz[1][i] == marca ){
                    System.out.println("\nEl ganador es el jugador " + (jugador ? "1" : "2"));
                    fin = true;
                }           
        }
        //Evaluacion de Diagonal Principal xxx
        if( matriz[0][0] == matriz[1][1] && 
            matriz[2][2] == matriz[1][1] &&     
            matriz[1][1] == marca ){
            System.out.println("\nEl ganador es el jugador " + (jugador ? "1" : "2"));
            fin = true;
        }
        //Evaluacion de Diagonal Secundaria xxx
        if(matriz[2][0] == matriz[1][1] && 
            matriz[0][2] == matriz[1][1] && 
            matriz[1][1] == marca ){
            System.out.println("\nEl ganador es el jugador " + (jugador ? "1" : "2"));
            fin = true;
        } 
        
    }
   
    static boolean nuevoJuego(){
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if ( matriz[i][j] == " " ) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b;
         boolean _jugador = true;
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                matriz[i][j] = " ";
            }
        }
        
        while(!fin && nuevoJuego()){
            
            for(int i = 0 ; i<3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                   System.out.print( matriz[i][j]);
                   if( j < 2){
                    System.out.print("|");
                   } else {
                    System.out.print(" ");
                   }
                }
                System.out.println();
                if( i != 2) {
                    System.out.println("-----");
                }
            }

            System.out.println("ingresa las coordenadas del jugador " + 
                                (_jugador ? "1" : "2"));
            a = scanner.nextInt() - 1;
            b = scanner.nextInt() - 1;

            matriz[a][b] = (_jugador ? "x" : "o");

            validacion( _jugador , (_jugador ? "x" : "o"));

            _jugador = !_jugador;
            System.out.println();
            if(fin){

                for(int i = 0 ; i<3 ; i++){
                    for(int j = 0 ; j < 3 ; j++){
                       System.out.print( matriz[i][j]);
                       if( j < 2){
                        System.out.print("|");
                       } else {
                        System.out.print(" ");
                       }
                    }
                    System.out.println();
                    if( i != 2) {
                        System.out.println("-----");
                    }
                
                }
                break;
            }

        }
        System.out.println("Fin del programa");
        scanner.close();
    }


}
