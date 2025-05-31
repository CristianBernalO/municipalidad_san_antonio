package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Documento;
import com.example.municipalidad_san_antonio.model.RevisorTecnico;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.DocumentoService;
import com.example.municipalidad_san_antonio.service.RevisorTecnicoService;
import com.example.municipalidad_san_antonio.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private RevisorTecnicoService revisorTecnicoService;
    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/api/v1/solicitudes")
    public ResponseEntity<?>findAllSolicitud() {return ResponseEntity.status(200).body(solicitudService.findAll());}

    @GetMapping("/api/v1/solicitudes/{id}")
    public ResponseEntity<?> findSolicitudeById(@PathVariable int id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud == null) {
            return ResponseEntity.status(404).body("Solicitud no encontrada");
        }
        return ResponseEntity.status(200).body(solicitudService.findById(id));
    }

    @GetMapping("/api/v1/solicitudes/listar")
    public ResponseEntity<?>findAllSolicituds(){
        List<Solicitud> solicitudes = solicitudService.findAll();
        return ResponseEntity.status(200).body(solicitudes);
    }

    @PostMapping("/api/v1/solicitudes/")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud, @PathVariable Integer id) {
        return ResponseEntity.status(201).body(solicitudService.save(solicitud));
    }

    @DeleteMapping("/api/v1/borrarsolicitud/{id}")
    public ResponseEntity<?> borrarSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud == null) {
            return ResponseEntity.status(404).build();
        }
        solicitudService.deleteSolicitud(id);
        return ResponseEntity.status(200).body("Solicitud eliminada");
    }

    @PostMapping("/api/v1/solicitudes/{id}/documentos")
    public ResponseEntity<?> addDocumento(@PathVariable int id, @RequestBody Documento documento) {
        Documento nuevoDocumento = documentoService.save(documento);

        return ResponseEntity.status(201).body(nuevoDocumento);
    }

    @GetMapping("/api/v1/solicitudes/{id}/documentos")
    public ResponseEntity<?> findDocumentoById() {
        List<Documento> documentos = documentoService.findAll();
        return ResponseEntity.status(200).body(documentos);
    }

    @DeleteMapping("/api/v1/solicitudes/{id}/documentos/{docId}")
    public ResponseEntity<?> deleteDocumento(@PathVariable Integer id, @PathVariable Integer docId) {
        Documento documento = documentoService.findById(docId);
        if (documento == null) {
            return ResponseEntity.status(404).build();
        }
        documentoService.delete(id);
        return ResponseEntity.status(200).body("Documento eliminado");
    }

    @GetMapping("/api/v1/revisiones/pendientes")
    public ResponseEntity<?> findAllRevisionsPendientes() {
        List<RevisorTecnico> revision = revisorTecnicoService.findAll();
        return ResponseEntity.status(200).body(revision);
    }


}
