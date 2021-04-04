package com.example.card;

import com.example.card.service.CreditCardMaskingService;
import com.example.card.service.CreditCardValidatingService;
import org.assertj.core.error.ShouldBeAfterYear;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditCardMaskingServiceTests {
    @InjectMocks
    CreditCardMaskingService creditCardMaskingService;

    @Mock
    CreditCardValidatingService creditCardValidatingService;

    @Test
    void is_credit_card_masked() throws Exception {
        String creditCard = "2222222222222222";
        String expectedMaskedCreditCard = "22222222****2222";

        when(creditCardValidatingService.isCardValid(creditCard)).thenReturn(true);

        String maskingCard = creditCardMaskingService.maskingCard(creditCard);

        System.out.println(maskingCard);
        assertNotNull(maskingCard);
        assertEquals(expectedMaskedCreditCard, maskingCard);
    }

}
