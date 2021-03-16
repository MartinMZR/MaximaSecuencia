package codigo;

public class Algoritmo {

	private int seqStart, seqEnd, resultado;
	private int[] secuencia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
								27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}; 
		
	public Algoritmo() {
		
		//resultado = maxSubsequenceSumCubico(secuencia);
		//resultado = maxSubsequenceSumCuadratico(secuencia);
		resultado = maxSubsequenceSumLineal(secuencia);
		imprimirResultado();
	}
	
	public static void main(String[] args) {
		
		new Algoritmo();
	}
	
	/**
	 * Algoritmo cúbico de suma máxima de subsecuencia contigua.
	 * seqStart y seqEnd representan la mejor secuencia actual.
	 * @param a Secuencia de entrada
	 * @return resutado de la suma
	 */
	private int maxSubsequenceSumCubico(int[] a) {
		
		int maxSum = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = i; j < a.length; j++) {
				
				int thisSum = 0;
				
				for(int k = i; k <= j; k++) {
					
					thisSum += a[k];
					
					if(thisSum > maxSum) {
						
						maxSum = thisSum;
						seqStart = i;
						seqEnd = j;
					}
				}				
			}			
		}
		
		return maxSum;
	}
	
	/**
	 * Algoritmo cuadrático de suma máxima de subsecuencia contigua.
	 * seqStart y seqEnd representan la mejor secuencia actual.
	 * @param a Secuencia de entrada
	 * @return resutado de la suma
	 */
	private int maxSubsequenceSumCuadratico(int[] a) {
		
		int maxSum = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			int thisSum = 0;
			
			for(int j = i; j < a.length; i++) {
				
				thisSum += a[j];
				
				if(thisSum > maxSum) {
					
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}
		}		
		
		return maxSum;
	}
	
	/**
	 * Algoritmo lineal de suma máxima de subsecuencia contigua.
	 * seqStart y seqEnd representan la mejor secuencia actual.
	 * @param a Secuencia de entrada
	 * @return resutado de la suma
	 */
	private int maxSubsequenceSumLineal(int[] a) {
		
		int maxSum = 0;
		int thisSum = 0;
		
		for(int i = 0, j = 0; j < a.length; j++) {
			
			thisSum += a[j];
			
			if(thisSum > maxSum) {
				
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			} else if(thisSum < 0) {
				
				i = j + 1;
				thisSum = 0;
			}
		}	
		
		return maxSum;
	}
	
	
	
	private void imprimirResultado() {
		
		System.out.println("El número de la secuencia máximo es: " + seqStart);
		System.out.println("El número de la secuencia mínimo es: " + seqEnd);
		System.out.println("El resultado es: " + resultado);
	}
}
