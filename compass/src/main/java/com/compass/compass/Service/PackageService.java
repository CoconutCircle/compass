package com.compass.compass.Service;

import com.compass.compass.DTO.PackageDto;

public interface PackageService
{
    public PackageDto save(PackageDto packageDto);

    public PackageDto findBy(Long id);

    public PackageDto Delete(Long id);
}
