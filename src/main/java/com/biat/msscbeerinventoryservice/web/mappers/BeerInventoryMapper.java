package com.biat.msscbeerinventoryservice.web.mappers;

import com.biat.msscbeerinventoryservice.web.model.BeerInventoryDto;
import com.biat.msscbeerinventoryservice.domain.BeerInventory;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {
    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
