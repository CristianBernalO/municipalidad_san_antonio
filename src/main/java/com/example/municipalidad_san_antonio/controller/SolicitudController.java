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

    //Crear nueva solicitud de permiso.
    @PostMapping("/api/v1/solicitudes")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud, @PathVariable Integer id) {
        solicitudService.save(solicitud);
        return ResponseEntity.status(201).body("Solicitud guardada");
    }
    //Obtener detalles de una solicitud por su ID. Incluye estado actual y observaciones.
    @GetMapping("/api/v1/solicitudes/{id}")
    public ResponseEntity<?> findSolicitudeById(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud == null) {
            return ResponseEntity.status(404).body("Solicitud no encontrada");
        }
        return ResponseEntity.status(200).body(solicitud);
    }
    //Listar todas las solicitudes realizadas.
    @GetMapping("/api/v1/solicitudes")
    public ResponseEntity<?>findAllSolicitudes(){
        return ResponseEntity.status(200).body(solicitudService.findAll());
    }
    //Actualizar una solicitud
    @PutMapping("/api/v1/solicitudes/{id}")
    public ResponseEntity<?> updateSolicitud(@RequestBody Solicitud solicitud, @PathVariable Integer id) {
        return ResponseEntity.status(200).body(solicitudService.actualizarSolicitud(id, solicitud));
    }
    //Borrar una solicitud
    @DeleteMapping("/api/v1/borrarsolicitud/{id}")
    public ResponseEntity<?> borrarSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud == null) {
            return ResponseEntity.status(404).build();
        }
        solicitudService.deleteSolicitud(id);
        return ResponseEntity.status(200).body("Solicitud eliminada");
    }

    //Agregar documento por id de solicitud
    @PostMapping("/api/v1/solicitudes/{id}/documentos")
    public ResponseEntity<?> addDocumento(@PathVariable Integer id, @RequestBody Documento documento) {
        documentoService.save(documento);
        return ResponseEntity.status(200).body("documento guardado");
    }

    //buscar todos los documentos de una solicitud
    @GetMapping("/api/v1/solicitudes/{id}/documentos")
    public ResponseEntity<?> findDocumentoById(Integer idSolicitud) {
        return ResponseEntity.status(200).body(documentoService.findByIdSolicitud(idSolicitud));
    }

    //Borrar un documento
    @DeleteMapping("/api/v1/solicitudes/{id}/documentos/{docId}")
    public ResponseEntity<?> deleteDocumento(@PathVariable Integer idSolicitud, @PathVariable Integer idDocumento) {
        List<Documento> documentos = documentoService.findByIdSolicitud(idSolicitud);
        Documento documento = documentoService.findById(idDocumento);
        if (documento == null || documentos == null) {
            return ResponseEntity.status(404).body("Documento o solicitud no encontrada");
        }
        documentoService.delete(idDocumento);
        return ResponseEntity.status(200).body("Documento eliminado");
    }

    //
    @GetMapping("/api/v1/revisiones/pendientes")
    public ResponseEntity<?> findAllRevisionsPendientes() {
        List<RevisorTecnico> revision = revisorTecnicoService.findAll();
        return ResponseEntity.status(200).body(revision);
    }


}
