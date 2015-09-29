package diapositivas;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Ejercicio3 {

	public static void main(String[] args) {
		Runtime runTime = Runtime.getRuntime();
		String [] comandos1 = {"ping", "www.google.es","-n","3"};
		String [] comandos2 = {"find", "\"ms\""};
		try {
			Process p1 = Runtime.getRuntime().exec(comandos1);
			Process p2 = Runtime.getRuntime().exec(comandos2);
			p1.waitFor(); //espero hasta que el proceso 1 finalice para continuar el programa
			BufferedReader salidaP1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedWriter entradaP2 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
			
			String s, texto = "";
			while((s = salidaP1.readLine())!=null){
				texto += s+"\n";   //recojo la salida del proceso1 en un String
			}
			
			entradaP2.write(texto);    	//redirecciono el string obtenido a la entrada del proceso2
			entradaP2.flush();			//vacio el buffer
			entradaP2.close();			//cierro el flujo (no funcionaba sin hacerlo)

			BufferedReader salidaP2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			String s2 = "";
			while((s2 = salidaP2.readLine())!=null){
				System.out.println(s2); //imprimo por pantalla lo obtenido en el proceso2
			}
			System.out.println("Programa finalizado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
