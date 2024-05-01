package com.backend.infrastructure.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.backend.domain.services.PagamentoService;

@Service
public class PagamentoResponseSucessoConsumidor {
  
    @Autowired 
    private PagamentoService pagamentoService;

    @SuppressWarnings("rawtypes")
    @RabbitListener(queues = {"pagamento-response-sucesso-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        pagamentoService.sucessoPagamento(payload);
    }
}
