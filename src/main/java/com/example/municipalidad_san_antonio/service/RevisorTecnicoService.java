package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.repository.RevisorTecnicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RevisorTecnicoService {

    @Autowired
    private RevisorTecnicoRepository revisorTecnicoRepository;
}
