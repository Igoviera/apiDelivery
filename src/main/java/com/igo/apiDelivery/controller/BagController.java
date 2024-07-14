package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.dto.BagDTO;
import com.igo.apiDelivery.dto.ItemDTO;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Bag;
import com.igo.apiDelivery.model.Item;
import com.igo.apiDelivery.repository.BagRepository;
import com.igo.apiDelivery.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food/bags")
public class BagController {

    private final BagService bagService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Item insertItemBag(@RequestBody ItemDTO itemDTO){
        return bagService.inserItem(itemDTO);
    }

    @GetMapping("/{id}")
    public BagDTO getBagDetails(@PathVariable Long id) {
       return bagService.getBagDatails(id);
    }

//    @GetMapping("/{id}")
//    public Bag findBag(@PathVariable("id") Long id){
//        return bagService.findBag(id);
//    }

    @PatchMapping("/closedBag/{bagId}")
    public Bag closedBag(@PathVariable("bagId") Long bagId, @RequestParam("paymentMethod") int paymentMethod){
        return bagService.closedBag(bagId, paymentMethod);
    }
}
