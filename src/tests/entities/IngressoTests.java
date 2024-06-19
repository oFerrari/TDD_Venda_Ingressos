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
} 
