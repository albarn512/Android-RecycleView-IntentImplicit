package com.example.recycleview_withintent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewHolder> {

    private Context context;
    private ArrayList<KontakModel> kontakList;

    public KontakAdapter(Context context){
        this.context = context;
    }

    public ArrayList<KontakModel> getKontakList(){
        return kontakList;
    }

    public void setKontakList(ArrayList<KontakModel> kontakList){
        this.kontakList = kontakList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list_kontak,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getKontakList().get(i).getThumb()).into(viewHolder.ivItemKontak);
        viewHolder.tvItemNama.setText(getKontakList().get(i).getNama());

        viewHolder.btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,KontakDetail.class);


                intent.putExtra("img_url", getKontakList().get(i).getThumb());
                intent.putExtra("nama",getKontakList().get(i).getNama());
                intent.putExtra("deskripsi",getKontakList().get(i).getDes());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                String kontakName = "Kontak : "+getKontakList().get(i).getNama();
                intent.putExtra(Intent.EXTRA_TEXT,kontakName);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getKontakList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemKontak;
        TextView tvItemNama;
        Button btnLihat,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemKontak = itemView.findViewById(R.id.iv_itemkontak);
            tvItemNama = itemView.findViewById(R.id.tv_item_nama);
            btnLihat = itemView.findViewById(R.id.btn_lihat);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}