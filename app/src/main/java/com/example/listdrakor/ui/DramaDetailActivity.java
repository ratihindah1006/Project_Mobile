package com.example.listdrakor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listdrakor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DramaDetailActivity extends AppCompatActivity {

    private ImageView DramaThumbnailImg, DramaCoverImg;
    private TextView tv_title, tv_deskripsi;
    private FloatingActionButton play_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama_detail);

        String dramaTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        DramaThumbnailImg = findViewById(R.id.detail_drama_img);
        DramaThumbnailImg.setImageResource(imageResourceId);

        iniView();

    }

    void iniView(){
        play_fab = findViewById(R.id.play_fab);
        String dramaTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        DramaThumbnailImg = findViewById(R.id.detail_drama_img);
        DramaThumbnailImg.setImageResource(imageResourceId);
        Glide.with(this).load(imageResourceId).into(DramaThumbnailImg);
        DramaCoverImg = findViewById(R.id.detail_drama_cover);
        Glide.with(this).load(imageCover).into(DramaCoverImg);
        tv_title = findViewById(R.id.detail_drama_title);
        tv_title.setText(dramaTitle);
        getSupportActionBar().setTitle(dramaTitle);
        tv_deskripsi = findViewById(R.id.detail_drama_desc);
        //setup animasi
        DramaCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }
}