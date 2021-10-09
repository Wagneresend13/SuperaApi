package com.example.supera.api.resposta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RespostaCarrinho extends Resposta{
	
	@JsonInclude(Include.NON_NULL)
	private Double valorFrete;
	

	@JsonInclude(Include.NON_NULL)
	private Double valorTotal;



	public Double getValorFrete() {
		return valorFrete;
	}



	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}



	public Double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	

}
