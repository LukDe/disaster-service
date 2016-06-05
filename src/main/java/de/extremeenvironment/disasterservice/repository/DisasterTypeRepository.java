package de.extremeenvironment.disasterservice.repository;

import de.extremeenvironment.disasterservice.domain.DisasterType;

import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the DisasterType entity.
 */
@SuppressWarnings("unused")
public interface DisasterTypeRepository extends JpaRepository<DisasterType,Long> {

   Optional<DisasterType> findById(Long id);

    Optional<DisasterType> findByName(String name);

    @Override
    void delete(DisasterType disasterType);

}