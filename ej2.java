package listas;

import java.util.Scanner;

import listas.ej1.nodo;

public class ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nodo cab=null;
		int op;
		do{
			System.out.println("1.Insertar nodo\n2.listar\n3.salir");
			op=leer("su opcion: ");
			switch(op){
			case 1:
				cab=add(cab);
				break;
			case 2:
				listado(cab);
				break;
			}
		}while(op!=3);
	}
	public static nodo add(nodo cab){
		nodo nuevo = new nodo();
		nuevo.dato=leer("dato?");
		boolean insertado=false;
		if(cab==null){
			nuevo.sgte=null;
			cab=nuevo;
		}else{
			if(nuevo.dato<cab.dato){
				nuevo.sgte=cab;
				cab=nuevo;
			}else{
				nodo c=cab;
				while(c.sgte!=null){
					if(c.sgte.dato>nuevo.dato){
						nuevo.sgte=c.sgte;
						c.sgte=nuevo;
						insertado=true;
						break;
					}
					c=c.sgte;
				}
				if(!insertado){
					nuevo.sgte=null;
					c.sgte=nuevo;
				}
			}
		}
		return cab;
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
		
	}
	public static void listado (nodo z){
		while(z!=null){
			System.out.println("Direccion: "+z+" Dato: "+z.dato+" Dir sgte: "+z.sgte);
			z=z.sgte;
		}
	}
}
