package recursao;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetodosRecursivos {

	MetodosRecursivos() {}

	public int calcularSomaArray(int[] array) {
		return calcularSomaArrayRecursivo(array, 0);
	}
		private int calcularSomaArrayRecursivo(int[] array,int indice){
			if(indice < array.length){
				return array[indice] + calcularSomaArrayRecursivo(array,indice+1);
			} else{
				return 0;
			}
	}
	public long calcularFatorial(int n) {
		long result = 1;
		if(n == 1 || n==0 ) {
			System.out.println(result);
			return result;
		} else {
			result = n * calcularFatorial(n - 1);
			System.out.println(result);
			return result;
		}
	}


	public int calcularFibonacci(int n) {
		int result = 1;

		if(n==1 || n==2 ){
			System.out.println(result);
			return result;
		} else{
			result = calcularFibonacci(n-1) + calcularFibonacci(n -2);
			System.out.println(result);
			return result;
		}
	}

	public int countNotNull(Object[] array) {
		return countNotNullRecursivo(array,0);
	}
		private int countNotNullRecursivo(Object[] array, int indice){
		if(indice < array.length ){
			if ((array[indice] != null)) {
				return 1 + countNotNullRecursivo(array,indice+1);
			} else {
				return countNotNullRecursivo(array,indice+1);
			}
		} else {
			return 0;
		}
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		if(expoente == 0){
			return result;
		} else {
			return 2 * potenciaDe2(expoente-1);
		}

	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		if(n == 1){
			return termoInicial;
		}else {
			return razao + progressaoAritmetica(termoInicial,razao,n-1);
		}
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		if(n == 1){
			return termoInicial;
		}else {
			return razao*progressaoGeometrica(termoInicial,razao,n-1);
		}

	}
	
	
}
