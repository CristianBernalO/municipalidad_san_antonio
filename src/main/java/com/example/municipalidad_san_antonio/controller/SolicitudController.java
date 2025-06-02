package com.example.municipalidad_san_antonio.controller;

import com.example.municipalidad_san_antonio.model.Documento;
import com.example.municipalidad_san_antonio.model.PermisoConstruccion;
import com.example.municipalidad_san_antonio.model.RevisorTecnico;
import com.example.municipalidad_san_antonio.model.Solicitud;
import com.example.municipalidad_san_antonio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private PermisoConstruccionService permisoConstruccionService;
    @Autowired
    private SeguimientoService seguimientoService;

    //GESTION SOLICITUDES
    //Crear nueva solicitud de permiso.
    @PostMapping("/api/v1/solicitudes")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud) {
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
    //GESTION DOCUMENTAL
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
        List<Documento> documento = documentoService.findByIdDocumento(idDocumento);
        if (documento == null || documentos == null) {
            return ResponseEntity.status(404).body("Documento o solicitud no encontrada");
        }
        documentoService.delete(idDocumento);
        return ResponseEntity.status(200).body("Documento eliminado");
    }
    //REVISIONES TECNICAS
    //Revisiones pendientes
    @GetMapping("/api/v1/revisiones/pendientes")
    public ResponseEntity<?> findAllRevisionsPendientes(String estadoSolicitud) {
        if (!estadoSolicitud.equalsIgnoreCase("Pendiente revision tecnica")) {
            return ResponseEntity.status(404).body("Solicitudes no encontradas");
        }
        List<Solicitud> solicitudesPendientes = solicitudService.findAllByEstadoSolicitud(estadoSolicitud);
        return ResponseEntity.status(200).body(solicitudesPendientes);
    }
    //Registrar observaciones
    @PostMapping("/api/v1/revisiones/{id}/observaciones")
    public ResponseEntity<?> saveObservaciones(@RequestBody Solicitud solicitud, @PathVariable Integer id) {
        if (solicitud == null) {
            return ResponseEntity.status(404).body("Solicitud no encontrada");
        }
        solicitud.setIdSolicitud(id);
        solicitudService.save(solicitud);
        return ResponseEntity.status(201).body("Solicitud guardada");
    }
    //Aprobar la solicitud
    @PostMapping("/api/v1/revisiones/{id}/observaciones")
    public ResponseEntity<?> aprovarSolicitud(@RequestBody Solicitud solicitud, @PathVariable Integer id) {
        if (solicitud == null) {
            return ResponseEntity.status(404).body("Solicitud no encontrada");
        }
        solicitud.setIdSolicitud(id);
        solicitud.setEstadoSolicitud("Pendiente aprobacion tecnica");
        solicitudService.save(solicitud);
        return ResponseEntity.status(201).body("Solicitud aprobada");
    }
    //VALIDACION Y RESOLUCION
    //listar informes tecnicos pendientes
    @GetMapping("/api/v1/resoluciones/pendientes")
    public ResponseEntity<?> findAllInformesPendientes(@RequestBody String estadoSolicitud) {
        if (!estadoSolicitud.equalsIgnoreCase("Pendiente aprobacion tecnica")) {
            return ResponseEntity.status(404).body("Solicitudes no encontradas");
        }
        List<Solicitud> solicitudesPendientes = solicitudService.findAllByEstadoSolicitud(estadoSolicitud);
        return ResponseEntity.status(200).body(solicitudesPendientes);
    }
    //firmar y validar solicitud
    @PostMapping("/api/v1/resoluciones/{id}/firmar")
    public ResponseEntity<?> updateValidarSolicitud(@RequestBody Solicitud solicitud, @PathVariable Integer idSolicitud) {
        if (!solicitud.getEstadoSolicitud().equalsIgnoreCase("Pendiente aprobacion tecnica")) {
            return ResponseEntity.status(404).body("Solicitudes no encontradas");
        }
        solicitud.setIdSolicitud(idSolicitud);
        solicitud.setSolicitudAceptada(true);
        solicitudService.save(solicitud);
        return ResponseEntity.status(200).body("Solicitud firmada");
    }
    //Descargar Resolucion
    @GetMapping("/api/v1/resoluciones/{id}/descargar")
    public ResponseEntity<?> descargarResultadoSolicitud(@PathVariable Integer idSolicitud) {
        Solicitud solicitud = solicitudService.findById(idSolicitud);
        PermisoConstruccion permisoConstruccion = permisoConstruccionService.findById(idSolicitud);
        if (solicitud == null) {
            return ResponseEntity.status(404).body("Solicitudes no encontradas");
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("solicitud", solicitud);
        respuesta.put("permisoConstruccion", permisoConstruccion);

        return ResponseEntity.status(200).body(respuesta);
    }
    //SEGUIMIENTO CIUDADANO
    //obtener estado de la solicitud
    @GetMapping("/api/v1/seguimiento/{id}")
    public ResponseEntity<?> findByIdSolicitud(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(seguimientoService.getSeguimiento(id));
    }
}
