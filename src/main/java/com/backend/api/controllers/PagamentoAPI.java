package com.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.api.dto.PagamentoDTO;
import com.backend.domain.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {

  @Autowired
  private PagamentoService pagamentoService;

  @PostMapping
  public String processar(@RequestBody PagamentoDTO request) {
    return pagamentoService.solicitarPagamento(request);
  }
  
}
