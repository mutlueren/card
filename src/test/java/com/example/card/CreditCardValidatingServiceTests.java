package com.example.card;

import com.example.card.service.CreditCardValidatingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreditCardValidatingServiceTests {

    @InjectMocks
    CreditCardValidatingService creditCardValidatingService;

    @Test
    void is_credit_card_valid() throws Exception {
        boolean valid = creditCardValidatingService.isCardValid("1111111111111111");
        assertFalse(valid);
    }
}
