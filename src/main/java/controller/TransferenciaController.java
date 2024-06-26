package controller;

import entity.Transferencia;
import org.springframework.web.bind.annotation.*;
import service.TransferenciaService;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public Transferencia agendarTransferencia(@RequestBody Transferencia transferencia) {
        return transferenciaService.agendarTransferencia(transferencia);
    }

    @GetMapping
    public List<Transferencia> listarTransferencias() {
        return transferenciaService.listarTransferencias();
    }
}
