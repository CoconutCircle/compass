package com.compass.compass.Controller;

import com.compass.compass.DTO.DestinationDto;
import com.compass.compass.Service.DestinationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/destination")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/add")
    public DestinationDto add(@RequestBody DestinationDto destinationDto){
        return destinationService.save(destinationDto);
    }

}
