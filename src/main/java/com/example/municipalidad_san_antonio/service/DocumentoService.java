package com.example.municipalidad_san_antonio.service;

import com.example.municipalidad_san_antonio.model.Documento;
import com.example.municipalidad_san_antonio.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@Transactional
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    //Traer todos los documentos
    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    ;

    //traer por id
    public Documento findById(Integer id) {
        return documentoRepository.findById(id).orElse(null);
    }

    //Borrar por id
    public void delete(Integer id) {
        documentoRepository.deleteById(id);
    }

    //traer por tipoDocumento
    public List<Documento> findByTipoDocumento(String tipoDocumento) {
        return documentoRepository.findByTipoDocumento(tipoDocumento);
    }


    //guardando un Documento
    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }








}
