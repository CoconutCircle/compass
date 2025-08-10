package com.compass.compass.Controller;

import com.compass.compass.DTO.PackageDto;
import com.compass.compass.Service.PackageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/package")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping("/add")
    public PackageDto save(@RequestBody PackageDto packageDto){
        return packageService.save(packageDto);
    }

    @DeleteMapping("/delete/{id}")
    public PackageDto delete(@PathVariable Long id) {
        return packageService.Delete(id);
    }
}
