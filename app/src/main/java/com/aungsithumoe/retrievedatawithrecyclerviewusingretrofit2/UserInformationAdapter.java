package com.aungsithumoe.retrievedatawithrecyclerviewusingretrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class UserInformationAdapter extends RecyclerView.Adapter<UserInformationAdapter.UserInformationViewHolder> {
    Context context;
    List<Users> users = new ArrayList<>();

    public UserInformationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserInformationAdapter.UserInformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserInformationViewHolder(LayoutInflater.from(context).inflate(R.layout.user_info_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserInformationAdapter.UserInformationViewHolder holder, int position) {
        Users user = users.get(position);
    holder.txtUserName.setText(user.getUsername());
        Glide.with(context)
                .load(user.getPhoto())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgUserPhoto);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserInformationViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUserPhoto;
        TextView txtUserName;
        public UserInformationViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserPhoto = itemView.findViewById(R.id.imgUserPhoto);
            txtUserName = itemView.findViewById(R.id.txt_user_name);
        }
    }

    public void addUserList(List<Users> usersList)
    {
        users .addAll(usersList);
        notifyDataSetChanged();
    }
}
