package com.example.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardMaskingService {

    @Autowired
    CreditCardValidatingService creditCardValidatingService;

    public String maskingCard(String cardNumber) throws Exception{

        if(cardNumber == null || cardNumber.equals("") || cardNumber.isEmpty() || cardNumber.length()!=16){
            return null;
        }

        if(!creditCardValidatingService.isCardValid(cardNumber)){
            return null;
        }

        int start = 8;
        int end = 12;

        if(start < 0)
            start = 0;

        if( end > cardNumber.length() )
            end = cardNumber.length();

        int maskLength = end - start;

        if(maskLength == 0)
            return cardNumber;

        StringBuilder sbMaskString = new StringBuilder(maskLength);

        for(int i = 0; i < maskLength; i++){
            sbMaskString.append('*');
        }

        return cardNumber.substring(0, start)
                + sbMaskString.toString()
                + cardNumber.substring(start + maskLength);
    }
}
