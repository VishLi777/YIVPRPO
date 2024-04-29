package com.example.demo.Pr7;

import com.example.demo.Pr7.dto.CardDto;
import com.example.demo.Pr7.dto.TransactionRqDto;

import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private Map<String, Card> cards;

    public Service(Bank bank) {
        this.cards = bank.getCards();
    }

    public String getBalance(String cardNumber){
        return Optional.ofNullable(cards.get(cardNumber))
                .map(Card::getAmount)
                .map(Object::toString)
                .orElse("Card doesn't exist");
    }

    public String createTransaction(TransactionRqDto transactionRqDto) {
        CardDto fromCardDto = transactionRqDto.getFromCard();
        CardDto toCardDto = transactionRqDto.getToCard();
        String fromCardNumber = fromCardDto.getNumber();
        String toCardNumber = toCardDto.getNumber();
        if(fromCardNumber == null || toCardNumber == null)
            return "Card number is empty";

        Card fromCard = cards.get(fromCardNumber);
        if (fromCard == null)
            return "Card " + fromCardNumber + "doesn't exist";

        Card toCard = cards.get(toCardNumber);
        if (toCard == null)
            return "Card " + fromCardNumber + "doesn't exist";

        if (!fromCard.getCvv().equals(fromCardDto.getCvv()))
            return "Incorrect CVV";

        if (fromCard.getAmount() < transactionRqDto.getSum())
            return "Insufficient funds";

        createOperation(fromCard, toCard, transactionRqDto.getSum());

        return "Ok";
    }

    private synchronized void createOperation(Card fromCard, Card toCard, Long sum) {
        fromCard.setAmount(fromCard.getAmount() - sum);
        toCard.setAmount(toCard.getAmount() + sum);
    }
}
