package com.orozbek.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.orozbek.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.onCardClick {

    private EmojiAdapter adapter;
    private RecyclerView recyclerView;
    private EmojiGame game = new EmojiGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRv();
    }

    private void initRv() {
        adapter = new EmojiAdapter();
        adapter.addItems(game.getCards(),this::onItemClick);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Card<String> card) {
        game.choose(card);
        for (int i = 0; i < game.getCards().size(); i++) {
            if (game.getCards().get(i).isMatch()){
                game.getCards().get(i).setFaceUp(true);
            }
        }
        adapter.notifyDataSetChanged();
    }
}