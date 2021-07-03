package com.orozbek.data;

public class Card <CardContent> {
    private int id;
    private boolean isFaceUp;
    private boolean isMatch;
    private CardContent content;

    public Card(int id, boolean isFaceUp, boolean isMatch, CardContent content) {
        this.id = id;
        this.isFaceUp = isFaceUp;
        this.isMatch = isMatch;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public CardContent getContent() {
        return content;
    }

    public void setContent(CardContent content) {
        this.content = content;
    }
}