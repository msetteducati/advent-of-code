package com.msetteducati.y2023.d7;

import com.msetteducati.model.PuzzleSolution;

import java.util.List;

public class CamelCards implements PuzzleSolution {

    /**
     * Your all-expenses-paid trip turns out to be a one-way, five-minute ride in an airship. (At least it's a cool airship!) It drops you off at the edge of a vast desert and descends back to Island Island.
     * <br><br>
     * "Did you bring the parts?"
     * <br><br>
     * You turn around to see an Elf completely covered in white clothing, wearing goggles, and riding a large camel.
     * <br><br>
     * "Did you bring the parts?" she asks again, louder this time. You aren't sure what parts she's looking for; you're here to figure out why the sand stopped.
     * <br><br>
     * "The parts! For the sand, yes! Come with me; I will show you." She beckons you onto the camel.
     * <br><br>
     * After riding a bit across the sands of Desert Island, you can see what look like very large rocks covering half of the horizon. The Elf explains that the rocks are all along the part of Desert Island that is directly above Island Island, making it hard to even get there. Normally, they use big machines to move the rocks and filter the sand, but the machines have broken down because Desert Island recently stopped receiving the parts they need to fix the machines.
     * <br><br>
     * You've already assumed it'll be your job to figure out why the parts stopped when she asks if you can help. You agree automatically.
     * <br><br>
     * Because the journey will take a few days, she offers to teach you the game of Camel Cards. Camel Cards is sort of similar to poker except it's designed to be easier to play while riding a camel.
     * <br><br>
     * In Camel Cards, you get a list of hands, and your goal is to order them based on the strength of each hand. A hand consists of five cards labeled one of A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2. The relative strength of each card follows this order, where A is the highest and 2 is the lowest.
     * <br><br>
     * Every hand is exactly one type. From strongest to weakest, they are:
     * <ul>
     * <li>Five of a kind, where all five cards have the same label: AAAAA</li>
     * <li>Four of a kind, where four cards have the same label and one card has a different label: AA8AA</li>
     * <li>Full house, where three cards have the same label, and the remaining two cards share a different label: 23332</li>
     * <li>Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98</li>
     * <li>Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432</li>
     * <li>One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4</li>
     * <li>High card, where all cards' labels are distinct: 23456</li>
     *</ul>
     * Hands are primarily ordered based on type; for example, every full house is stronger than any three of a kind.
     * <br><br>
     * If two hands have the same type, a second ordering rule takes effect. Start by comparing the first card in each hand. If these cards are different, the hand with the stronger first card is considered stronger. If the first card in each hand have the same label, however, then move on to considering the second card in each hand. If they differ, the hand with the higher second card wins; otherwise, continue with the third card in each hand, then the fourth, then the fifth.
     * <br><br>
     * So, 33332 and 2AAAA are both four of a kind hands, but 33332 is stronger because its first card is stronger. Similarly, 77888 and 77788 are both a full house, but 77888 is stronger because its third card is stronger (and both hands have the same first and second card).
     * <br><br>
     * To play Camel Cards, you are given a list of hands and their corresponding bid (your puzzle input). For example:
     * <pre>
     * 32T3K 765
     * T55J5 684
     * KK677 28
     * KTJJT 220
     * QQQJA 483
     * </pre>
     * This example shows five hands; each hand is followed by its bid amount. Each hand wins an amount equal to its bid multiplied by its rank, where the weakest hand gets rank 1, the second-weakest hand gets rank 2, and so on up to the strongest hand. Because there are five hands in this example, the strongest hand will have rank 5 and its bid will be multiplied by 5.
     * <br><br>
     * So, the first step is to put the hands in order of strength:
     * <ul>
     * <li>32T3K is the only one pair and the other hands are all a stronger type, so it gets rank 1.</li>
     * <li>KK677 and KTJJT are both two pair. Their first cards both have the same label, but the second card of KK677 is stronger (K vs T), so KTJJT gets rank 2 and KK677 gets rank 3.</li>
     * <li>T55J5 and QQQJA are both three of a kind. QQQJA has a stronger first card, so it gets rank 5 and T55J5 gets rank 4.</li>
     * </ul>
     * Now, you can determine the total winnings of this set of hands by adding up the result of multiplying each hand's bid with its rank (765 * 1 + 220 * 2 + 28 * 3 + 684 * 4 + 483 * 5). So the total winnings in this example are 6440.
     * <br><br>
     * Find the rank of every hand in your set. What are the total winnings?
     * @param input
     * @return
     */
    public long part1(List<String> input) {
        return Game.fromInput(input)
                .getTotalWinnings();
    }

    /**
     * To make things a little more interesting, the Elf introduces one additional rule. Now, J cards are jokers - wildcards that can act like whatever card would make the hand the strongest type possible.
     * <br><br>
     * To balance this, J cards are now the weakest individual cards, weaker even than 2. The other cards stay in the same order: A, K, Q, T, 9, 8, 7, 6, 5, 4, 3, 2, J.
     * <br><br>
     * J cards can pretend to be whatever card is best for the purpose of determining hand type; for example, QJJQ2 is now considered four of a kind. However, for the purpose of breaking ties between two hands of the same type, J is always treated as J, not the card it's pretending to be: JKKK2 is weaker than QQQQ2 because J is weaker than Q.
     * <br><br>
     * Now, the above example goes very differently:
     * <pre>
     * 32T3K 765
     * T55J5 684
     * KK677 28
     * KTJJT 220
     * QQQJA 483
     * </pre>
     * <ul>
     * <li>32T3K is still the only one pair; it doesn't contain any jokers, so its strength doesn't increase.</li>
     * <li>KK677 is now the only two pair, making it the second-weakest hand.</li>
     * <li>T55J5, KTJJT, and QQQJA are now all four of a kind! T55J5 gets rank 3, QQQJA gets rank 4, and KTJJT gets rank 5.</li>
     * </ul>
     * With the new joker rule, the total winnings in this example are 5905.
     * <br><br>
     * Using the new joker rule, find the rank of every hand in your set. What are the new total winnings?
     * @param input
     * @return
     */
    public long part2(List<String> input) {
        return Game.fromInputPart2(input)
                .getTotalWinnings();
    }
}
