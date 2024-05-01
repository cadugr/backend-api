package com.backend.infrastructure.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.backend.domain.services.PagamentoService;

@Service
public class PagamentoResponseErroConsumidor {
    
    @Autowired 
    private PagamentoService pagamentoService;

    @SuppressWarnings("rawtypes")
    @RabbitListener(queues = {"pagamento-response-erro-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        pagamentoService.erroPagamento (payload);
    }
}
