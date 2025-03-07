package com.eci.arep.arep_taller05.service;

import com.eci.arep.arep_taller05.model.Property;
import com.eci.arep.arep_taller05.repository.PropertyRepository;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property saveProperty(Property property) {
        if (property.getId() == null) {
            Long minAvailableId = getNextAvailableId();
            property.setId(minAvailableId);
        }
        return propertyRepository.save(property);
    }

    private Long getNextAvailableId() {
        List<Property> properties = propertyRepository.findAll();
        properties.sort(Comparator.comparing(Property::getId));
        long expectedId = 1;
        for (Property prop : properties) {
            if (!prop.getId().equals(expectedId)) {
                return expectedId;
            }
            expectedId++;
        }
        return expectedId; // Retorna el siguiente ID disponible
    }

    public Property updateProperty(Long id, Property property) {
        return propertyRepository.findById(id).map(existingProperty -> {
            existingProperty.setAddress(property.getAddress());
            existingProperty.setDescription(property.getDescription());
            existingProperty.setPhone(property.getPhone());
            existingProperty.setPrice(property.getPrice());
            existingProperty.setSize(property.getSize());
            return propertyRepository.saveAndFlush(existingProperty);
        }).orElseThrow(() -> new RuntimeException("La propiedad con ID " + id + " no existe."));
    }

    public void deleteProperty(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. La propiedad con ID " + id + " no existe.");
        }
        propertyRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return propertyRepository.existsById(id);
    }

    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }
}