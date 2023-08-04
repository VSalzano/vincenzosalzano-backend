package com.gestionedispositivi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionedispositivi.models.Dispositivo;

public interface DispositivoRepository extends JpaRepository <Dispositivo, Long> {

}
