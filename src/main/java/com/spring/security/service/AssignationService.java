package com.spring.security.service;

import com.spring.security.mapper.EmployeeMapper;
import com.spring.security.model.Employee;
import com.spring.security.model.Inventory;
import com.spring.security.repository.EmployeeRepository;
import com.spring.security.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AssignationService {

        @Autowired
        private EmployeeRepository empleadoRepository;

        @Autowired
        private InventoryRepository articuloRepository;

        @Transactional
        public void asignarArticuloAEmpleado(Long empleadoId, Long articuloId) {
            Employee empleado = empleadoRepository.findById(empleadoId)
                    .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + empleadoId));

            Inventory articulo = articuloRepository.findById(articuloId)
                    .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado con ID: " + articuloId));

            // Verificar si hay suficiente cantidad disponible del artículo
            if (articulo.getQuantity() > 0) {
                empleado.getInventory().add(articulo);
                articulo.setQuantity(articulo.getQuantity() - 1);

                // Guardar cambios en la base de datos
                empleadoRepository.save(empleado);
                articuloRepository.save(articulo);
            } else {
                throw new IllegalArgumentException("No hay suficiente cantidad disponible del artículo.");
            }
        }

    @Transactional
    public void eliminarAsignacion(Long empleadoId, Long articuloId) {
        Employee empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + empleadoId));

        Inventory articulo = articuloRepository.findById(articuloId)
                .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado con ID: " + articuloId));

        // Verificar si el artículo está asignado al empleado
        if (empleado.getInventory().contains(articulo)) {
            empleado.getInventory().remove(articulo);
            articulo.setQuantity(articulo.getQuantity() + 1);

            // Guardar cambios en la base de datos
            empleadoRepository.save(empleado);
            articuloRepository.save(articulo);
        } else {
            throw new IllegalArgumentException("El artículo no está asignado al empleado.");
        }
    }
    }

