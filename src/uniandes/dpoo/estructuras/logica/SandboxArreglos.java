package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] newList = new int[arregloEnteros.length];
    	
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		newList[i] = arregloEnteros[i];
    	} 
    	return newList;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] newList = new String[arregloCadenas.length];
    	
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		newList[i] = arregloCadenas[i];
    	} 
    	return newList;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] newList = new int[arregloEnteros.length + 1];
    	newList[arregloEnteros.length] = entero;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		newList[i] = arregloEnteros[i];
    	}
    	arregloEnteros = newList;
    	
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     * 
     */
    public void agregarCadena( String cadena )
    {
    	String[] newList = new String[arregloCadenas.length + 1];
    	newList[arregloCadenas.length] = cadena;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		newList[i] = arregloCadenas[i];
    	}

    	arregloCadenas = newList;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	

    	int lon = contarApariciones(valor);
    	int[] res = new int[arregloEnteros.length - lon];
    	int retro = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (valor == arregloEnteros[i]) {
    			retro++;
    		}
    		else {
    			res[i-retro] =  arregloEnteros[i];
    		}
    	}
    	 arregloEnteros = res;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int lon = contarApariciones(cadena);
    	String[] res = new String[arregloCadenas.length - lon];
    	int retro = 0;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (cadena.equals(arregloCadenas[i])) {
    			retro++;
    		}
    		else {
    			res[i-retro] =  arregloCadenas[i];
    		}
    	}
    	arregloCadenas = res;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int[] newList = new int[arregloEnteros.length + 1];
    	if (posicion >= arregloEnteros.length) {
    		this.agregarEntero( entero );
    		return;
    	}
    	else if(posicion <= 0) {
    		newList[0] = entero;
    		for (int i = 0; i < arregloEnteros.length; i++) {
        		newList[i+1] = arregloEnteros[i];
        	}
    		arregloEnteros = newList;
    		return;
    	}
    	newList[posicion] = entero;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (posicion > i) {
    			newList[i] = arregloEnteros[i];
    		}
    		else if(posicion < i) {
    			newList[i+1] = arregloEnteros[i];
    		}
    	}
    	newList[posicion +1] = arregloEnteros[posicion];
    	arregloEnteros = newList;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {

    	int[] newList = new int[arregloEnteros.length - 1];
    	if (posicion >= arregloEnteros.length || posicion < 0) {
    		return;
    	}
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (posicion > i) {
    			newList[i] = arregloEnteros[i];
    		}
    		else if(posicion < i) {
    			newList[i-1] = arregloEnteros[i];
    		}
    	}
    	arregloEnteros = newList;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {

    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if(arregloEnteros[i] < 0) {
    			arregloEnteros[i] = arregloEnteros[i]*(-1);
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
            	for (int j = i+1; j < arregloEnteros.length; j++) {
            		if (arregloEnteros[i] > arregloEnteros[j]) {
                		int guardar = arregloEnteros[j];
                		arregloEnteros[j] = arregloEnteros[i];
                		arregloEnteros[i] = guardar;
            		}
            	}
    	}
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
		for (int i = 0; i < arregloCadenas.length; i++) {
			for (int j = i + 1; j < arregloCadenas.length; j++) {
				if (arregloCadenas[i].compareTo(arregloCadenas[j])> 0) {
					String guardar = arregloCadenas[i];
					arregloCadenas[i] = arregloCadenas[j];
					arregloCadenas[j] = guardar;
				}
			}
		}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int res = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (valor == arregloEnteros[i]) {
    			res++;
    		}
    	}
    	return res;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int res = 0;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (cadena.equalsIgnoreCase(arregloCadenas[i])) {
    			res++;
    		}
    	}
    	return res;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int[] res = new int[]{};
    	
       	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (valor == arregloEnteros[i]) {
    			int[] newList = new int[res.length + 1];
    	    	newList[res.length] = i;
    	    	for (int j = 0; j < res.length; j++) {
    	    		newList[j] = res[j];
    	    	}
    	    	res = newList;
    		}
    	}
       	return res;
       	
       	
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
    		return new int[]{};
    	}
    	int[] res = new int[2];
    	
    	
    	int min = arregloEnteros[0];
    	int max = arregloEnteros[1];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i]> max){
    			max = arregloEnteros[i];
    		}
    		else if (arregloEnteros[i]< min) {
    			min = arregloEnteros[i];
    		}
    	}
    	res[0]= min;
    	res[1] = max;
    	return res;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
    	for (int i = 0; i < arregloEnteros.length; i++) {
        	if (res.get(arregloEnteros[i]) == null) {
        		res.put(arregloEnteros[i], 1);
        	}
        	else {
        		res.put(arregloEnteros[i], 1 + res.get(arregloEnteros[i]));
        	}
    	}
        return res;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int a = 0;
    	HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
    	for (int i = 0; i < arregloEnteros.length; i++) {
        	if (res.get(arregloEnteros[i]) == null) {
        		res.put(arregloEnteros[i], 1);
        	}
        	else {
        		if(res.get(arregloEnteros[i]) == 1) {
        			a++;
        		}
        		res.put(arregloEnteros[i], 1 + res.get(arregloEnteros[i]));
        	}
    	}
    	return a;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {
    		return false;
    	}
     	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] != otroArreglo[i]) {
    			return false;
    		}
    	}
     	return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (otroArreglo.length != arregloEnteros.length) {
    		return false;
    	}
    	
    	HashMap<Integer, Integer> hash1 = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> hash2 = new HashMap<Integer, Integer>();
    	for (int i = 0; i < arregloEnteros.length; i++) {
        	if (hash1.get(arregloEnteros[i]) == null) {
        		hash1.put(arregloEnteros[i], 1);
        	}
        	else {

        		hash1.put(arregloEnteros[i], 1 + hash1.get(arregloEnteros[i]));
        	}
        	if (hash2.get(otroArreglo[i]) == null) {
        		hash2.put(otroArreglo[i], 1);
        	}
        	else {

        		hash2.put(otroArreglo[i], 1 + hash2.get(otroArreglo[i]));
        	}
    	}
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (hash1.get(arregloEnteros[i]) != hash2.get(arregloEnteros[i])) {
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] res = new int[cantidad];
    	for (int i = 2; i < res.length; i++) {
    		double a = Math.random();

        	res[i] = (int)( a * (maximo - minimo ) + minimo);
    		
    	}
    	arregloEnteros = res;

    }

}
