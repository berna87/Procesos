package diapositivas;

import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) {
		try {
			Process p1 = new ProcessBuilder("notepad").start();
			System.out.println("Abriendo notepad");
/*			Thread.sleep(10_000); //detiene la ejecucion del programa 10s
			p1.destroy();*/
			p1.waitFor();
			System.out.println("Programa finalizado");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
