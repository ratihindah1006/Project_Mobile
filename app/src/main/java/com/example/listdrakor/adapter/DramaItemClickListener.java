package com.example.listdrakor.adapter;

import android.widget.ImageView;

import com.example.listdrakor.models.Drama;

public interface DramaItemClickListener {

    void onDramaClick(Drama drama, ImageView dramaImageView);
}
