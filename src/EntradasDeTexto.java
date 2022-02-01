/*@author Liberto
 *@version 1.2
 *@description clase que permite introducir nuevas entradas en un fichero de texto sin alterar las anteriores
 */

//librerías
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EntradasDeTexto {
    public static void main(String[] args) {

        //declaramos un scanner y un string inicializado como cadena vacía
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        //los try catch son necesarios para usar Print y File Writer
        try (PrintWriter salida = new PrintWriter(new FileWriter("C:\\Games\\texto.txt",true))){

            //Instrucciones para el usuario
            System.out.println("Realice una entrada de texto");

            //si lo introducido por teclado es "FIN" el programa se detiene
            while (!cadena.equalsIgnoreCase("FIN")){
                //este print no imprime por pantalla si no que almacena en salida (como buffer que es) el contenido de cadena
                salida.println(cadena);

                //entrada por teclado
                cadena = sc.nextLine();

                //actualiza el contenido del archivo de texto con lo contenido en el buffer
                salida.flush();
            }
            //excepciones de las clases File y Print Writer
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
