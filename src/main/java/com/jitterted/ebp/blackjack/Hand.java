package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<Card>();

    @Deprecated // scaffolding
    public List<Card> getCards() {
        return cards;
    }

    void drawCardFrom(Deck deck) {
        getCards().add(deck.draw());
    }

    int value() {
        int handValue = getCards()
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        boolean hasAce = getCards()
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue < 11) {
            handValue += 10;
        }

        return handValue;
    }

    Card faceUpCard() {
        return getCards().get(0);
    }

    void display() {
        System.out.println(getCards().stream()
                                     .map(Card::display)
                                     .collect(Collectors.joining(
                                             ansi().cursorUp(6).cursorRight(1).toString())));
    }
}