package com.compass.compass.Repository;

import com.compass.compass.ENTITY.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    @Query("""
           SELECT d FROM Destination d
           WHERE d.country = :country
             AND d.city = :city
             AND (:state IS NULL OR d.state = :state)
           """)
    public Destination searchDestination(@Param("country") String country,
                                      @Param("state") String state,
                                      @Param("city") String city);

}
