package com.seguradorax.easy_transfer;

import entity.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.TransferenciaRepository;
import service.TransferenciaService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TransferenciaServiceTest {

    @InjectMocks
    private TransferenciaService transferenciaService;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAgendarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem("123456");
        transferencia.setContaDestino("654321");
        transferencia.setValor(100.00);
        transferencia.setDataTransferencia(LocalDate.of(2024, 6, 30));
        transferencia.setDataAgendamento(LocalDate.now());

        when(transferenciaRepository.save(transferencia)).thenReturn(transferencia);

        Transferencia result = transferenciaService.agendarTransferencia(transferencia);
        assertEquals(transferencia, result);
    }

    @Test
    void testListarTransferencias() {
        Transferencia transferencia1 = new Transferencia();
        transferencia1.setContaOrigem("123456");
        transferencia1.setContaDestino("654321");
        transferencia1.setValor(100.00);
        transferencia1.setDataTransferencia(LocalDate.of(2024, 6, 30));
        transferencia1.setDataAgendamento(LocalDate.now());

        Transferencia transferencia2 = new Transferencia();
        transferencia2.setContaOrigem("987654");
        transferencia2.setContaDestino("321321");
        transferencia2.setValor(200.00);
        transferencia2.setDataTransferencia(LocalDate.of(2024, 7, 1));
        transferencia2.setDataAgendamento(LocalDate.now());

        List<Transferencia> transferencias = Arrays.asList(transferencia1, transferencia2);
        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        List<Transferencia> result = transferenciaService.listarTransferencias();
        assertEquals(2, result.size());
        assertEquals(transferencia1, result.get(0));
        assertEquals(transferencia2, result.get(1));
    }
}