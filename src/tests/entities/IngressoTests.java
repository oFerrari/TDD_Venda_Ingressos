package tests.entities;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.VendaIngresso;

public class IngressoTests {
	@Test
	public void VendaDeIngressoDeveriaCriarObjetoComDadosCorretosQuandoDadosValidos(){
		VendaIngresso vi = new VendaIngresso("Andrei Ferrari",22,"Palestra sobre carro véi",LocalDate.of(2025, 2, 12),15.0,2);
		Assertions.assertTrue(vi.equals(vi));
	}
	
	@Test
	public void VendaDeIngressoDeveriaLancarIllegalArgumentExceptionQuandoClienteMenorIdade(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			VendaIngresso vi = new VendaIngresso("Andrei Ferrari",17,"Palestra sobre carro véi",LocalDate.of(2030, 2, 12),15.0,2);
		});
	}
	
	@Test
	public void VendaDeIngressoDeveriaLancarIllegalArgumentExceptionQuandoQuandoDataNaoFutura(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			VendaIngresso vi = new VendaIngresso("Andrei Ferrari",17,"Palestra sobre carro véi",LocalDate.of(2000, 2, 12),15.0,2);
		});
	}
	
	@Test
	public void VendaDeIngressoDeveriaRealizarVendaQuandoValorInformadoIgualCompra() {
		VendaIngresso vi = new VendaIngresso("Andrei Ferrari",18,"Palestra sobre carro véi",LocalDate.of(2024, 8, 12),15.0,2);
		Assertions.assertEquals(30, vi.calcularValorTotal());
	}
	
	@Test
	public void VendaDeIngressoDeveriaRealizarVendaQuandoQuantidadeDeIngressoMenorIgualCinco() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			VendaIngresso vi = new VendaIngresso("Andrei Ferrari",18,"Palestra sobre carro véi",LocalDate.of(2024, 8, 12),15.0,7);
			vi.calcularValorTotal();
		});
	}
} 
