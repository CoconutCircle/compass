package com.compass.compass.Repository;

import com.compass.compass.ENTITY.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRespository extends JpaRepository<Package, Long> {
}
