package com.backend.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.dto.PagamentoDTO;
import com.backend.infrastructure.producer.PagamentoRequestProdutor;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PagamentoService {

  @Autowired
  private PagamentoRequestProdutor produtor;

  public String solicitarPagamento(PagamentoDTO pagamento) {
    try {
      produtor.integrarPagamento(pagamento);
    } catch (JsonProcessingException e) {
      return "Erro ao processar o pagamento";
    }
    
    return "Seu pagamento está sendo processado...";
  }

  public void sucessoPagamento(String payload) {
    System.out.println("O pagamento foi confirmado: " + payload);
  }

  public void erroPagamento(String payload) {
    System.err.println("Erro ao processar pagamento " + payload);
  }
  
}
