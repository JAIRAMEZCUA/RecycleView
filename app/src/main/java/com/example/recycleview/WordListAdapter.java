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

    //View Holder es una vista de todo evento del fragment
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



    //Un bind view es para pasarla a todos los elementos o datos al recycle
    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Usuario user = usuarios.get(position);
        String titulo  = user.getId()+"|\t"+user.getName()+"|\t"+user.getEmail();
        holder.txv.setText(titulo);
    }


    //es para pasar el tamaño o numero de elementos
    @Override
    public int getItemCount() {
        return usuarios.size();
    }



    //esta clase es para insertar todos los elemntos del row o hijo
    class MiViewHolder extends RecyclerView.ViewHolder{
        TextView txv;
        public MiViewHolder(View itemView){
            super(itemView);
            txv = itemView.findViewById(R.id.txV);
        }
    }
}
