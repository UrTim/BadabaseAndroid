package com.example.badabaseandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private Context ctx;
    private List<Users> usersList;

    public UsersAdapter(Context ctx, List<Users> usersList) {
        this.ctx = ctx;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.card_layout,null);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        Users user = usersList.get(position);

        holder.textViewF.setText(user.getFirstName());
        holder.textViewL.setText(user.getLastName());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView textViewF, textViewL;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewF = (TextView) itemView.findViewById(R.id.textviewF);
            textViewL = (TextView) itemView.findViewById(R.id.textviewL);
        }
    }

    public void updateList(List<Users> newList){
        usersList = new ArrayList<>();
        usersList.addAll(newList);
        notifyDataSetChanged();

    }
}
