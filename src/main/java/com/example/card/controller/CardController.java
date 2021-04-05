package com.example.card.controller;

import com.example.card.service.CreditCardMaskingService;
import com.example.card.service.CreditCardValidatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    CreditCardValidatingService creditCardValidatingService;

    @Autowired
    CreditCardMaskingService creditCardMaskingService;

    @RequestMapping("/isGivenCardValid")
    public String isGivenCardValid(@RequestParam("cardNumber") String cardNumber) throws Exception {
        if(creditCardValidatingService.isCardValid(cardNumber)){
            return "Valid Card Number";
        }
        return "Invalid Card Number";
    }

    @RequestMapping("/maskingGivenCard")
    public String maskingGivenCard(@RequestParam("cardNumber") String cardNumber)throws Exception {
        String maskedCard = creditCardMaskingService.maskingCard(cardNumber);
        if(maskedCard != null){
            return maskedCard;
        }
        return "Given card number is invalid!";
    }
}
