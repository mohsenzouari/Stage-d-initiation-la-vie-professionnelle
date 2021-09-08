package com.example.t5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetrofitRessource> dataList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(List<RetrofitRessource> dataList){

        this.dataList = dataList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {


        public final View myView;

        TextView textUser,textUser2,textUser3,textUser4;

        CustomViewHolder(View itemView , final OnItemClickListener listener) {
            super(itemView);
            myView = itemView;

            textUser = myView.findViewById(R.id.txt_employee_name);
            textUser2 = myView.findViewById(R.id.txt_employee_email);
            textUser3 = myView.findViewById(R.id.txt_employee_phone);
            textUser4 = myView.findViewById(R.id.txt_ressource_commande_N);







                itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }

    }

    @Override

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view, mListener);
    }

    @Override

    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText("Description de la ressource : "+dataList.get(position).getDescription());
        holder.textUser2.setText("Nom du fichier : "+dataList.get(position).getNomFichier());
        holder.textUser3.setText("Extension du fichier : "+dataList.get(position).getExtFichier());
        holder.textUser4.setText("Numéro de commande : "+dataList.get(position).getIdObjet());



    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void filterList(List<RetrofitRessource> filteredList) {
        dataList = filteredList;
        notifyDataSetChanged();
    }

}
