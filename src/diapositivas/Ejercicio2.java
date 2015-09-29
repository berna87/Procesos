package diapositivas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//comandos
		List<String> comandos = new ArrayList<String>();
		comandos.add("netstat");
		comandos.add("-an");
		//process builder
		ProcessBuilder pBuilder = new ProcessBuilder(comandos);
		try {
			Process p = pBuilder.start();
			BufferedReader in =new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedWriter out = new BufferedWriter(new PrintWriter(new File("prueba.txt")));
			String s = "";
			while((s=in.readLine())!=null){
				System.out.println(s);
				out.write(s+"\n");
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
