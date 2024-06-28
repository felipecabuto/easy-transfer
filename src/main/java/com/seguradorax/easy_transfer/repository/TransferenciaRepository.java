package com.seguradorax.easy_transfer.repository;

import com.seguradorax.easy_transfer.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}