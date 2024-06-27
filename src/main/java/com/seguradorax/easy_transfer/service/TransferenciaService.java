package service;

import entity.Transferencia;
import org.springframework.stereotype.Service;
import repository.TransferenciaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        transferencia.setDataAgendamento(LocalDate.now());
        calcularTaxa(transferencia);
        return transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return transferenciaRepository.findAll();
    }

    private void calcularTaxa(Transferencia transferencia) {
        long diasDiferenca = transferencia.getDataTransferencia().toEpochDay() - transferencia.getDataAgendamento().toEpochDay();

        if (diasDiferenca < 0) {
            throw new IllegalArgumentException("Data inválida para transação Tipo A");
        }

        if (diasDiferenca == 0) {
            transferencia.setTaxa(3 + 0.03 * transferencia.getValor());
        } else if (diasDiferenca <= 10) {
            transferencia.setTaxa(12);
        } else if (diasDiferenca <= 20) {
            transferencia.setTaxa(0.082 * transferencia.getValor());
        } else if (diasDiferenca <= 30) {
            transferencia.setTaxa(0.069 * transferencia.getValor());
        } else if (diasDiferenca <= 40) {
            transferencia.setTaxa(0.047 * transferencia.getValor());
        } else {
            transferencia.setTaxa(0.017 * transferencia.getValor());
        }
    }
}