package com.example.listdrakor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdrakor.R;
import com.example.listdrakor.models.Drama;

import java.util.List;

public class DramaAdapter extends RecyclerView.Adapter<DramaAdapter.MyViewHolder> {

    Context context;
    List<Drama> mData;
    DramaItemClickListener dramaItemClickListener;

    public DramaAdapter(Context context, List<Drama> mData, DramaItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        dramaItemClickListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_drama, viewGroup, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.TvTitle.setText(mData.get(i).getTitle());
        myViewHolder.ImgDrama.setImageResource(mData.get(i).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView TvTitle;
        private ImageView ImgDrama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TvTitle = itemView.findViewById(R.id.item_drama_title);
            ImgDrama = itemView.findViewById(R.id.item_drama_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dramaItemClickListener.onDramaClick(mData.get(getAdapterPosition()), ImgDrama);
                }
            });
        }
    }
}
