package listas;

import java.util.Scanner;

public class ej1 {
	public static class nodo{
		int dato;
		nodo sgte;
	}

	public static void main(String[] args) {
		nodo cab = null;
		int opcion;
		do{
			System.out.println("1. añadir a la cabecera \n2.añadir a la cola\n3.listado \n"
					+ "4. agregar al centro \n5.agregar en la posicion x \n6. agregar antes del nodo que tiene dato x \n7. agregar despues del NODO QUE TIENE DATO X \n8.salir");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				cab=addcab(cab);
				break;
			case 2:
				addcola(cab);
				break;
			case 3:
				listado(cab);
				break;
			case 4:
				addcentro(cab);
				break;
			case 5:
				cab=addx(cab,leer("posicion?"));
				break;
			case 6:
				cab=addantesn(cab, leer("dato?"));
				break;
			case 7:
				cab=adddespsn(cab,leer("dato?"));
				
			}
		}while(opcion!=8);
		
	}
	public static nodo addcab (nodo x){
		nodo aux= new nodo();
		aux.sgte=x;
		aux.dato=leer("dato?");
		x=aux;
		return aux;
	}
	public static void addcola (nodo x){
		nodo c;
		nodo nuevo=new nodo();
		nuevo.dato=leer("dato?");
		nuevo.sgte=null;
		if (x==null) {
			x=nuevo;
		}else{
			c=x;
			while(c.sgte!=null){
				c=c.sgte;
			}
			c.sgte=nuevo;
		}	
	}
	public static void addcentro (nodo x){
		int n= contar(x);
		if(n>=2){
			nodo nuevo=new nodo();
			nuevo.dato=leer("dato?");
			nodo c;
			c=x;
			for(int i=1;i<n/2;i++){
				c=c.sgte;
			}
			nuevo.sgte=c.sgte;
			c.sgte=nuevo;
		}
		else{
			System.out.println("No se puede añadir al centro");
		}
		
		
	}
	public static nodo addx (nodo x,int n){
		int y = contar(x);
		nodo c;
		if(n<=y){
			nodo nuevo=new nodo();
			nuevo.dato=leer("dato?");
			if(n==1){
				nuevo.sgte=x;
				x=nuevo;
			}else{
				c=x;
				for(int i=1;i<n-1;i++){
					c=c.sgte;
				}
				nuevo.sgte=c.sgte;
				c.sgte=nuevo;
			}
		}else{
			System.out.println("No existe esa posicion en la lista");
		}
		return x;
		
		
	}
	public static nodo addantesn (nodo cab,int n){
		nodo q,x,t=null;
		boolean band=true;
		q=cab;
		do{
			if(q.sgte!=null){
				t=q;q=q.sgte;
			}
			else{
				band=false;
			}
		}while(q.dato!=n&&band==true);
		if(band){
			x=new nodo();
			x.dato=leer("dato nuevo?");
			if(cab==q){
				x.sgte=cab;
				cab=x;
			}else{
				t.sgte=x;
				x.sgte=q;
			}
		}
		return cab;
		
	}
	public static nodo adddespsn (nodo x,int n){
		nodo c;
		if(x==null){
			System.out.println("no existe lista");
		}else{
			if(x.dato==n){
				nodo nuevo = new nodo();
				nuevo.dato=leer("dato?");
				nuevo.sgte=x.sgte;
				x.sgte=nuevo;
			}else{
				c=x;
				while(c.sgte!=null){
					if(c.dato==n){
						nodo nuevo = new nodo();
						nuevo.dato=leer("dato?");
						nuevo.sgte=c.sgte;
						c.sgte=nuevo;
					}
					c=c.sgte;
				}
			}
		}
		return x;
		
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
	
	public static int contar (nodo z){
		int c=0;
		while(z!=null){
			c++;
			z=z.sgte;
		}
		return c;
	}
	

}