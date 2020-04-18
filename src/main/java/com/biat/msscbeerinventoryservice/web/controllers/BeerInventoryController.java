package com.biat.msscbeerinventoryservice.web.controllers;

import com.biat.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import com.biat.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import com.biat.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class BeerInventoryController {

    @Autowired
    BeerInventoryRepository beerInventoryRepository;
    @Autowired
    BeerInventoryMapper beerInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {
        log.info("Finding Inventory for beerId:" + beerId);
        System.out.println("Finding Inventory for beerId:" + beerId);

        return beerInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
