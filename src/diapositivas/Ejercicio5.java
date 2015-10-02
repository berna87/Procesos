package diapositivas;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
	public static void main(String[] args) {
		List<String> comandos1 = new ArrayList<String>();
		List<String> comandos2 = new ArrayList<String>();
		
		comandos1.add("ping");
		comandos1.add("www.google.es");
		
		comandos2.add("find");
		comandos2.add("\"ms\"");
		
		ProcessBuilder pBuilder = new ProcessBuilder(comandos1);
		ProcessBuilder pBuilder2 = new ProcessBuilder(comandos2);
		
		BufferedReader in1 = null;
		BufferedReader in2 = null;
		BufferedWriter out1 = null;
		
		try {
			Process p1 = pBuilder.start();
			Process p2 = pBuilder2.start();
			
			in1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			out1 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
			
			String s= "";
			while((s=in1.readLine())!=null){
				out1.write(s+"\n");
			}
			
			if(out1 != null){
				out1.close();
			}
			in2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			
			while((s=in2.readLine())!=null){
				System.out.println(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in1 != null){
					in1.close();
				}
				if(in2 != null){
					in2.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
