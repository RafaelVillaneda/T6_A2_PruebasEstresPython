import java.util.Arrays;
import java.util.Scanner;
class MetodosBusqueda{
	int [] contador=new int[3];// 1-> recorridos 2-> intercambios 3-> comparaciones
	public void reiniciarContador() {
		contador[0]=0;
		contador[2]=0;
	}
	public  int busquedaBinaria(int[]matriz,int valorBuscado) {
	 if(matriz.length==0) {
         return -1;
     }
     int mitad,inferior =0;
     int superior = matriz.length-1;
     do {
    	 contador[0]++;
         mitad = (int)(inferior + superior) / 2;
         contador[2]++;
         if (valorBuscado > matriz[mitad]) {
         inferior = mitad + 1;
         } else {
         superior = mitad-1;
         }
         } while (matriz[mitad] != valorBuscado && inferior <= superior);
     contador[2]++;
         if (matriz[mitad] == valorBuscado) {
             System.out.println("Encontrado");
             return mitad;

         } else {
             System.out.println("No se encontro");
         return -1;
         }
	}
	public void mostrarContador() {
		System.out.println("Numero de recorridos-> "+contador[0]);
		System.out.println("Numero de Comparaciones-> "+contador[2]);
		contador[0]=0;
		contador[1]=0;
		contador[2]=0;
	}
	public int [] ordenamientoMezclaDirecto(int arreglo[]) {
		int i,j,k;
		contador[2]++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
			//Copiado elementos izquierdo
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				contador[0]++;
			}
			//arreglo derecho
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				contador[0]++;
			}
			/*La separacion
			System.out.println(Arrays.toString(arregloDerecha));
			System.out.println(Arrays.toString(arregloIzquierdo));
			*/
			
			//Ahora se aplica la recursividad
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			/*
			 * i=pocicion en el arreglo original
			 * j=pocicion en el arreglo izquierdo
			 * k=pocicion en el arreglo derecho
			 */
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {//Ordena el arreglo (Sublistas)
				contador[2]++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					contador[1]++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					contador[1]++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				contador[0]++;
			}
			//Arreglo final parte izquierda
			while(arregloIzquierdo.length!=j) {
				contador[1]++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				contador[0]++;
			}
			//Arreglo final parte derecha
			while(arregloDerecha.length!=k) {
				contador[1]++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				contador[0]++;
			}
		}//IF
		
		return arreglo;
	}

	
}
class FuncionHash{
	String [] arreglo;
	int tamaño;
	int contador;
	int [] contador1=new int[3];// 1-> recorridos 2-> intercambios 3-> comparaciones
	public void reiniciarContador() {
		contador1[0]=0;
		contador1[2]=0;
	}
	public void mostrarContador() {
		System.out.println("Numero de recorridos-> "+contador1[0]);
		System.out.println("Numero de Comparaciones-> "+contador1[2]);
		contador1[0]=0;
		contador1[2]=0;
	}
	public FuncionHash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	public void funsionHash(String[] cadArreglo,String[]arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 99;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tamaño; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	}
	//Metodo para mostrar la tabla hash
	public void mostrar(){
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 100;
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 100; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			for (int k = 0; k < 100; k++) {
			}
			System.out.println();
			for (j = incremento - 100; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
		}
	}//Metodo
	public String buscarClave(String elemento) {
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo] == elemento) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			if (contador > 99) {
				System.out.println("Error");
				break;
			}
		}
		return null;
	}
}

class pruebasEstres{
	public void pruebaEstres(String op,int buscado,int vector100elementos[]) {
		
		if(op.equals("1")) {
			MetodosBusqueda busqueda=new MetodosBusqueda();
			vector100elementos=busqueda.ordenamientoMezclaDirecto(vector100elementos);
			busqueda.reiniciarContador();
			System.out.println(Arrays.toString(vector100elementos ));
			busqueda.busquedaBinaria(vector100elementos, buscado);
			busqueda.mostrarContador();
		}else {
			String vectorConvertido[]=new String[vector100elementos.length];
			for (int i = 0; i < vectorConvertido.length; i++) {
				vectorConvertido[i]=String.valueOf(vector100elementos[i]);
			}
			System.out.println(Arrays.toString(vectorConvertido ));
			FuncionHash funcion=new FuncionHash(100);
			funcion.funsionHash(vectorConvertido, funcion.arreglo);
			funcion.mostrar();
			funcion.buscarClave(String.valueOf(buscado));
		}
		
	}
	
}

public class Pruebas {

	public static void main(String[] args) {
			Scanner entrada=new Scanner(System.in);
			String op="";
			boolean bandera=false;
			pruebasEstres pruebas=new pruebasEstres();
			int vector100elementos[]=new int[100];
			for(int i=0;i<vector100elementos.length;i++) {
				vector100elementos[i]=(int) (Math.random() * 100);
			}
			while(bandera==false) {
			long tTnicio,tFin;
			System.out.println("Con que quieres probar?");
			System.out.println("1-> Busqueda binaria");
			System.out.println("2-> Busqueda por funcion hash");
			System.out.println("3-> Salir");
			op=entrada.nextLine();
			switch (op) {
			case "1":
				System.out.println("Que valor deseas buscar");
				int valorBuscar=entrada.nextInt();
				entrada.nextLine();
				pruebas.pruebaEstres(op, valorBuscar,vector100elementos);
				break;
			case "2":
				System.out.println("Que valor deseas buscar");
				int valorBuscar2=entrada.nextInt();
				entrada.nextLine();
				pruebas.pruebaEstres(op, valorBuscar2,vector100elementos);
				break;
			case "3":
				System.out.println("Saliendo.....");
				bandera=true;
				break;
			default:
				System.out.println("ELIGE UNA OPCION DISPONBLE");
				break;
			}
	}
	}
}
