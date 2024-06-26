package service;

import entity.Transferencia;
import org.springframework.stereotype.Service;
import repository.TransferenciaRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        transferencia.setDataAgendamento(LocalDate.now());
        transferencia.setTaxa(calcularTaxa(transferencia));
        return transferenciaRepository.save(transferencia);
    }

    public double calcularTaxa(Transferencia transferencia) {
        long diasEntre = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());

        if (transferencia.getValor() <= 1000) {
            return calcularTaxaTipoA(transferencia);
        } else if (transferencia.getValor() <= 2000) {
            return calcularTaxaTipoB(transferencia);
        } else {
            return calcularTaxaTipoC(diasEntre, transferencia);
        }
    }

    private double calcularTaxaTipoA(Transferencia transferencia) {
        if (transferencia.getDataAgendamento().isEqual(transferencia.getDataTransferencia())) {
            return 3 + 0.03 * transferencia.getValor();
        } else {
            throw new IllegalArgumentException("Data inválida para transação Tipo A");
        }
    }

    private double calcularTaxaTipoB(Transferencia transferencia) {
        long diasEntre = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
        if (diasEntre <= 10) {
            return 12;
        } else {
            throw new IllegalArgumentException("Data inválida para transação Tipo B");
        }
    }

    private double calcularTaxaTipoC(long diasEntre, Transferencia transferencia) {
        if (diasEntre > 30) {
            return 0.017 * transferencia.getValor();
        } else if (diasEntre > 20) {
            return 0.047 * transferencia.getValor();
        } else if (diasEntre > 10) {
            return 0.069 * transferencia.getValor();
        } else {
            return 0.082 * transferencia.getValor();
        }
    }
}