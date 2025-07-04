package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.ReporteAuditoria;
import com.example.municipalidad_san_antonio.repository.ReporteAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteAuditoriaService {
    @Autowired
    private ReporteAuditoriaRepository reporteAuditoriaRepository;

    public ReporteAuditoria guardar(ReporteAuditoria reporteAuditoria) {
        return reporteAuditoriaRepository.save(reporteAuditoria);
    }

    public List<ReporteAuditoria> listar() {
        return reporteAuditoriaRepository.findAll();
    }
} 