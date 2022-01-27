package theHuxley;
import java.util.Scanner;
//Program by: Almir Alves de Souza Cruz
//26/01/2022
public class Problem2169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		Lista l = new Lista();
		boolean repeticao = true;
		
		//laço de repetição controlado pela variavel repeticao
		while(repeticao) {
			
			char acao = input.next().charAt(0);
			
			//caso digite s encerra o laço e juntamente com ele o programa
			if(acao == 's') {
				repeticao = false;
				
			}else {
				//caso digite p executa a funcao de imprimir a Lista
				if(acao == 'p') {
					
					l.printLista();
				//caso digite a ou r pedirá pra ler um numero inteiro em seguida	
				}else if(acao == 'a' || acao == 'r') {
					
					int x = input.nextInt();
					//após ler o inteiro decide se será inserido ou removido
					//da Lista
					if(acao == 'a') {
						l.addPedido(x);
					}else {
						
						l.remover(x);
					}
					
					
				}
				
				
				
			}
			
			
		}
		
		
		
		
		input.close();
	}
	
	public static class Lista{
		
		private int valor;
		private Lista prox;
		
		public Lista() {
			//inicia a listaa com o valor -1 indicando que a lista está vazia
			this.valor = -1;
			this.prox = null;
			
		}
		
		//add inteiro na lista, que representa o pedido do cliente especificado no problema do The Huxley
		public void addPedido(int x) {
			
			if(this.valor < 0) {
				
				this.valor = x;
				this.prox = new Lista();
				
			}else {
				
				this.prox.addPedido(x);
				
			}
			
			
		}
		
		//remove o valor digitado da lista
		public void remover(int x) {
			
			if(this.valor >= 0) {
				
				if(this.valor == x) {
					
					this.valor = this.prox.valor;
					this.prox = this.prox.prox;
					System.out.println("removido");
					
					
				}else {
					
					this.prox.remover(x);
				}
				
				
			}else {
				//Se o valor não estiver na lista imprime falha
				System.out.println("falha");
				
			}
			
			
		}
		
		//Imprime todos os valores da lista separados por espaço
		//Não há espaço após o ultimo valor
		public void printLista() {
			
			if(this.valor <  0) {
				
				System.out.println("vazia");
				
			}else {
				
				if(this.prox.valor > -1) {
				
					System.out.print(this.valor+" ");
					this.prox.printLista();
				}else {
					
					System.out.println(this.valor);
				}
				
			}
			
		}
		
	}

}
