package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit IRRELEVANT_SUIT = Suit.CLUBS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = createHand("A", "9");

        assertThat(hand.value())
                .isEqualTo(11 + 9);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = createHand("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    @Test
    void handWithOneAceAndOtherCardsValuedAt10ThenAceIsValuedAt11() {
        Hand hand = createHand("A", "K");

        assertThat(hand.value())
                .isEqualTo(11 + 10); // EVIDENT DATA
    }

    @Test
    void handWithOneAceAndOtherCardsEqualTo12AceIsValuedAt1() {
        Hand hand = createHand("A", "8", "4");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 4);
    }


    private Hand createHand(String... ranks) {
        List<Card> cards = new ArrayList<>();
        for (String rank : ranks) {
            cards.add(new Card(IRRELEVANT_SUIT, rank));
        }
        return Hand.createHandForTest(cards);
    }
}
