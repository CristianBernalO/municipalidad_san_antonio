package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Pago;
import com.example.municipalidad_san_antonio.repository.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    //Traer todos los pagos
    public List<Pago> findAll(){
        return pagoRepository.findAll();
    }

    //Traer por id

    public Pago findById(int id){
        return pagoRepository.findById(id);
    }





}
