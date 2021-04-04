package com.example.card.service;

import org.springframework.stereotype.Service;

@Service
public class CreditCardValidatingService {

    // Return true if the card number is valid
    public boolean isCardValid(String cardNumber) throws Exception
    {
        if(cardNumber == null || cardNumber.isEmpty()){
            return false;
        }
        long convertedCardNumber = Long.parseLong(cardNumber);

        return (getSize(convertedCardNumber) >= 13 &&
                getSize(convertedCardNumber) <= 16) &&
                (prefixMatched(convertedCardNumber, 4) ||
                        prefixMatched(convertedCardNumber, 5) ||
                        prefixMatched(convertedCardNumber, 37) ||
                        prefixMatched(convertedCardNumber, 6)) &&
                ((sumOfDoubleEvenPlace(convertedCardNumber) +
                        sumOfOddPlace(convertedCardNumber)) % 10 == 0);
    }

    public int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return this number if it is a single digit, otherwise, return the sum of the two digits
    public int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    public int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for number
    public boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d
    public int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }

    public long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }
}
