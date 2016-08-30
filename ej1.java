package listas;

import java.util.Scanner;

public class ej1 {
	public static class nodo{
		int dato;
		nodo sgte;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nodo a,b,c,cab=null,d;
		/*a= new nodo();
		System.out.println("Direccion "+a);
		a.dato=7;
		a.sgte=null;
		System.out.println("Direccion: "+a+" Dato: "+a.dato+ " Dir sgte: "+a.sgte);
		b=a;
		System.out.println("Direccion: "+b+" Dato: "+b.dato+ " Dir sgte: "+b.sgte);
		c=new nodo();
		c.dato=a.dato;
		c.sgte = a;
		System.out.println("Direccion: "+c+" Dato: "+c.dato+ " Dir sgte: "+c.sgte);*/
		
		
		//PARA crear una lista y recorrerla
		/*for (int i = 1; i <= 10; i++) { //
			d=new nodo();
			d.dato=i;
			d.sgte=cab;
			cab=d;
		}
		c=cab;
		while(c!=null){
			System.out.println("Direccion: "+c+" Dato: "+c.dato+" Dir sgte: "+c.sgte);
			c=c.sgte;
		}*/
		
		
		nodo cab = null;
		int opcion;
		do{
			System.out.println("1. add 2. list 3. sumatoria 4. maximo 5. minimo 6. dividir 7. salir");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				cab=add(cab);
				break;
			case 2:
				listado(cab);
				break;
			case 3:
				int s=sumatoria(cab);
				System.out.println(s);
				break;
			case 4:
				int max = maximo(cab);
				System.out.println(max);
				break;
			case 5:
				int min = minimo(cab);
				System.out.println(min);
				break;
			case 6:
				cab=dividir(cab);
				listado(cab);
				break;
				
			}
		}while(opcion!=7);
		
	}
	public static nodo add (nodo x){
		nodo aux= new nodo();
		aux.sgte=x;
		aux.dato=leer("dato?");
		x=aux;
		return aux;
	}
	public static void listado (nodo z){
		while(z!=null){
			System.out.println("Direccion: "+z+" Dato: "+z.dato+" Dir sgte: "+z.sgte);
			z=z.sgte;
		}
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
		
	}
	public static int sumatoria (nodo z){
		int sum=0;
		while(z!=null){
			sum+=z.dato;
			z=z.sgte;
		}
		return sum;
	}
	public static int maximo (nodo z){
		int sum=0;
		if (z!=null) {
			while(z!=null){
				if (sum<z.dato) {
					sum=z.dato;
				}
				z=z.sgte;
			}
			
		}else{
			System.out.println("No existe");
		}
		return sum;
		
	}
	public static int minimo (nodo z){
		int min=1000000;
		while(z!=null){
			if (min>z.dato) {
				min=z.dato;
			}
			z=z.sgte;
		}
		return min;
	}
	public static int contar (nodo z){
		int c=0;
		while(z!=null){
			c++;
			z=z.sgte;
		}
		return c;
	}
	public static nodo dividir (nodo z){
		System.out.println("\n\n");
		int x=contar(z);
		if(x%2==0){
			x/=2;
		}else{
			x=x/2+1;
		}
		for(int i=0;i<x;i++){
			z=z.sgte;
		}
		z.sgte=null;
		z=z.sgte;
		return z;
	}

}
