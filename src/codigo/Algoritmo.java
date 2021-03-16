package codigo;

public class Algoritmo {

	private int seqStart, seqEnd, resultado;
	private int[] secuencia = {1, 2, 3, 4, 5}; 
		
	public Algoritmo() {
		
		resultado = maxSubsequenceSum(secuencia);
		imprimirResultado();
	}
	
	public static void main(String[] args) {
		
		new Algoritmo();
	}
	
	private int maxSubsequenceSum(int[] a) {
		
		int maxSum= 0;
		
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
	
	private void imprimirResultado() {
		
		System.out.println("El número de la secuencia máximo es: " + seqStart);
		System.out.println("El número de la secuencia mínimo es: " + seqEnd);
		System.out.println("El resultado es: " + resultado);
	}
}
