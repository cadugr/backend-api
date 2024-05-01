package com.backend.infrastructure.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.dto.PagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PagamentoRequestProdutor {

  @Autowired
  private AmqpTemplate amqpTemplate;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public void integrarPagamento(PagamentoDTO pagamento) throws JsonProcessingException {
    String pagamentoJson = objectMapper.writeValueAsString(pagamento);
    amqpTemplate.convertAndSend(
              "pagamento-request-exchange",
            "pagamento-request-rout-key", 
                        pagamentoJson);
  }
  
}
