package diapositivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creamos objeto de tipo Runtime
		Runtime runTime = Runtime.getRuntime();
		BufferedReader in = null;
		try {
			//creo procesos
	//		Process p = runTime.exec("notepad.exe");   para abrir el notepad
	//		Process p1 = runTime.exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");   para abrir el firefox
			String [] comandos = {"ping", "www.google.es","-n","3"};  //array de comandos
			Process p2 = runTime.exec(comandos);
			in = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			String s = "";
			while((s = in.readLine())!=null){
				System.out.println(s);
				
			}  
			System.out.println("Programa finalizado\nProcess value: "+p2.exitValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
