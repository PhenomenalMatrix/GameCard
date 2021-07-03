package com.orozbek.ui;

import com.orozbek.data.Card;
import com.orozbek.data.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {

    private Game<String> game;

    public EmojiGame(){
        List<String> content = new ArrayList<>();
        content.add("\uD83E\uDDDF\u200D♂️");//4
        content.add("\uD83E\uDDDC");//4
        content.add("\uD83C\uDF55");//4
        content.add("\uD83C\uDF69");
        content.add("\uD83C\uDF4E");//4
        content.add("\uD83C\uDF40");
        game = new Game<>(content);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }

}
