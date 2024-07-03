package entities;

import java.time.LocalDate;

public class VendaIngresso {
	private static int TOTAL_INGRESSOS = 100;
	
	private String nomeCliente;
	private int idade;
	private String evento;
	private LocalDate dataEvento;
	private double valorIngresso;
	private int quantidadeIngresso;
	
	public VendaIngresso() {
		
	}

	public VendaIngresso(String nomeCliente, int idade, String evento, LocalDate dataEvento, double valorIngresso,
			int quantidadeIngresso) {
		validarCliente(idade);
		this.nomeCliente = nomeCliente;
		this.idade = idade;
		this.evento = evento;
		this.dataEvento = dataEvento;
		this.valorIngresso = valorIngresso;
		this.quantidadeIngresso = quantidadeIngresso;
	}
	
	private void validarCliente(int idade){
		if(idade < 18) {
			throw new IllegalArgumentException("O cliente precisa ter no Minimo 18 anos");
		}
	}
	
	private void validarDataEvento(LocalDate dataEvento) {
		if(dataEvento.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A data deve ser futura");
		}
	}
	
	public double calcularValorTotal() {
		if (this.getQuantidadeIngresso() > 5) {
			throw new IllegalArgumentException("A quantidade deve ser menor igual a cinco");
		}
		return this.getValorIngresso() * this.getQuantidadeIngresso();
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public double getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	public int getQuantidadeIngresso() {
		return quantidadeIngresso;
	}

	public void setQuantidadeIngresso(int quantidadeIngresso) {
		this.quantidadeIngresso = quantidadeIngresso;
	}
}
