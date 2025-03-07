package com.eci.arep.arep_taller05.controller;

import com.eci.arep.arep_taller05.model.Property;
import com.eci.arep.arep_taller05.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.getPropertyById(id);
        return property.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/property")
    public Optional<Property> getProperty(@RequestParam Long id) {
        return propertyService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@Valid @RequestBody Property property) {
        Property savedProperty = propertyService.saveProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProperty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @Valid @RequestBody Property property) {
        if (!propertyService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Property updatedProperty = propertyService.updateProperty(id, property);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
