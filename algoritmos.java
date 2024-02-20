
package algoritmosEsenciales; // El paquete no está añadido al trabajo, hace falta una rama que la incluya

public class AlgoritmosEsencialesADA {
	
	
	public AlgoritmosEsencialesADA() {}
	
	
	// Al comienzo del algoritmo:	fin = V.length - 1		ini = 0
	// Recibo dos listas de igual tamaño y ordenadas
	public int medianaDosVectores(int[] V1,int iniA,int finA, int[] V2, int iniB, int finB) { 
		int res = -1;
		
		if(finA - iniA + 1== 1) {			//Comenzamos los casos generales, el primer caso es de las listas son de longitud 1
			if(V1[iniA] < V2[iniB]) {
				res = V1[iniA];
			}else {
				res = V2[iniB];
			}
		}else if (finA - iniA + 1 == 2){	// Listas de longitud 2
			
			if(V1[finA] < V2[finB]) {
				res = V1[finA];
			}else if(V1[iniA] > V2[finB]){
				res = V2[finB];
				}else {
					if(V1[iniA] > V2[iniB]) {
						res = V1[iniA];
					}else {
						res = V2[iniB];
					}
				}			// Terminan los casos generales
			}else{			// Casos para más de 2 elementos por listas			
		
		int mitadA = (finA + iniA) / 2;
		int mitadB = (finB + iniB) / 2;
		
		if(V1[mitadA] == V2[mitadB]) {
			res = V1[mitadA];
			}else if(V1[mitadA] < V2[mitadB]) {
				res = medianaDosVectores(V1, mitadA, finA, V2,iniB, mitadB);
				}else {
					res = medianaDosVectores(V1, mitadA, finA ,V2,iniB, mitadB);
					}
			}
		return res;
	}
	
	// inf = posición primer valor lista		sup = posición último valor lista
	public int busquedaBinaria(int[] lista, int inf, int sup, int x) {				// Devuelve la posción en la lista del valor x
		int res = -1;
		if(inf <= sup) {	
		int medio = (sup + inf)/2;
		if(lista[medio] == x) {
			res = medio;
			}else if(lista[medio] > x){
				res = busquedaBinaria(lista, inf, medio-1, x);
				}else {
					res = busquedaBinaria(lista, medio + 1 , sup, x);
				}
			}
		
		return res;
	}
	
	// Al comianzo del algoritmo:		ini = 0		fin = lista.length - 1
	public int[] quickSort(int[] lista, int ini,int fin) {
		if(ini < fin ) {
			int pivote = partir(lista,ini,fin);				// 
			quickSort(lista, ini, pivote -1 );
			quickSort(lista, pivote +1, fin);
		}
		return lista;
	}
	
	private int partir(int[]lista, int inf, int sup) {
		int pivote = lista[inf]; 
		int i = inf+1; 
		int j = sup;
		do {
			while((i<=j) && (lista[i] <= pivote)){
				i++; 
				}
			while((i<=j) && (lista[j] > pivote)){
				j--; 
				}
		if (i<j) {
			intercambia(lista,i,j); }
		}while (i <= j); 
			intercambia(lista,inf,j);
			for(int z = 0; z < lista.length;++z) {
				System.out.print(lista[z] + " / ");
			}
			System.out.println("Partir es: " + j);
		return j;
	}
	
	private void intercambia(int[]lista,int i,int j) {
		int aux = lista[i];
		lista[i] = lista[j];
		lista[j] = aux;
	}
	
	// Termina QuickSort
	
	
	public int coeficientesBinomiales(int n, int k ) {				// Precondición n > k > 0
																	// C(n,k) = n! / (k! * (n-k)!)
		int[][] tabla = new int[n+1][];
		for(int i = 0; i<= n;++i) {
			for(int f = 0; f <= i; ++f) {
				
				tabla[i] = new int[i+1]; // De esta manera ahorramos memoria, creando solo el número de columnas especificas para cada filas
					
				if( i == 0 || i == f) {								// Casos bases
					tabla[i][f] = 1;
				}else {												// Casos generales
					tabla[i][f] = tabla[i-1][f-1] + tabla[i-1][f];
				}
				
			}
		}
		return tabla[n][k];
	}
	
	public void optimización() {			// Tamaño total, lista objetos con cada tamaño
		
	}
	
}
