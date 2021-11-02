package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.request.AddUpdateBasketRequest;
import com.kodluyoruz.weekFourHomework.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @GetMapping("{userId}")
    public BasketDto getBasket(@PathVariable Integer userId){
        return basketService.getBasket(userId);
    }

    @PutMapping("{userId}")
    public BasketDto updateBasket(@PathVariable Integer userId,@RequestBody AddUpdateBasketRequest basketRequest){
        return basketService.putBasket(userId,basketRequest);
    }

    @PatchMapping("{userId}")
    public BasketDto addBasket(@PathVariable Integer userId,@RequestBody AddUpdateBasketRequest addRequest){
        return basketService.addBasket(userId,addRequest);

    }

    @DeleteMapping("{userId}")
    public BasketDto removeBasket(@PathVariable Integer userId,@RequestBody AddUpdateBasketRequest removeRequest){
        return basketService.removeItemFromBasket(userId,removeRequest);

    }




}
