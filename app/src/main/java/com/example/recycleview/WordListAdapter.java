package com.example.recycleview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.MiViewHolder> {
    Context context;
    ArrayList<Usuario> usuarios;

    public WordListAdapter(Context context, ArrayList<Usuario> titulos) {
        this.context = context;
        this.usuarios = titulos;
    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Usuario user = usuarios.get(position);
        String titulo  = user.getId()+"|\t"+user.getName()+"|\t"+user.getEmail();
        holder.txv.setText(titulo);
    }

    /*@Override
    public void onBindViewHolder(@NonNull WordListAdapter holder, int position) {

    }*/

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    class MiViewHolder extends RecyclerView.ViewHolder{
        TextView txv;
        public MiViewHolder(View itemView){
            super(itemView);
            txv = itemView.findViewById(R.id.txV);
        }
    }
}
