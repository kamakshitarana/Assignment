package com.example.androidassignmentitlabs.RecylerView.recylerView.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidassignmentitlabs.R;
import com.example.androidassignmentitlabs.RecylerView.recylerView.ItemClickListener;
import com.example.androidassignmentitlabs.RecylerView.recylerView.model.CharacterResponse;

import java.util.ArrayList;
import java.util.List;


public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<CharacterResponse> characters;
    public ItemClickListener clickListener;

    private Context context;

    public CharacterAdapter(Context context) {
        this.context = context;
        characters = new ArrayList<>();
    }

    public void setCharacters(List<CharacterResponse> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }


    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CharacterResponse character = characters.get(position);
        holder.characterName.setText(character.getName());
        holder.characterRealName.setText(character.getRealName());
        holder.characterTeam.setText(character.getTeam());
        holder.characterFirstAppearance.setText(character.getFirstAppearance());
        holder.characterCreatedBy.setText(character.getCreatedBy());
        holder.characterPublisher.setText(character.getPublisher());
        holder.characterImageUrl.setText(character.getImageUrl());
        holder.characterBio.setText(character.getBio());

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public List<CharacterResponse> getCharacters() {
        return characters;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView characterName;
        TextView characterRealName;
        TextView characterTeam;
        TextView characterFirstAppearance;
        TextView characterCreatedBy;
        TextView characterPublisher;
        TextView characterImageUrl;
        TextView characterBio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.characterName);
            characterRealName = itemView.findViewById(R.id.characterRealName);
            characterTeam = itemView.findViewById(R.id.characterTeam);
            characterFirstAppearance = itemView.findViewById(R.id.characterFirstAppearance);
            characterCreatedBy = itemView.findViewById(R.id.characterCreatedBy);
            characterPublisher = itemView.findViewById(R.id.characterPublisher);
            characterImageUrl = itemView.findViewById(R.id.characterImageUrl);
            characterBio = itemView.findViewById(R.id.characterBio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("CharacterAdapter", "Item clicked at position: " + getAdapterPosition());
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }

//    private void showPopup(String character) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        View popupView = LayoutInflater.from(context).inflate(R.layout.popup_layout, null);
//        TextView popupText = popupView.findViewById(R.id.popupText);
//        popupText.setText(character);
//
//        builder.setView(popupView)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//        Toast.makeText(context, character.get, Toast.LENGTH_SHORT).show();

//    }
}
