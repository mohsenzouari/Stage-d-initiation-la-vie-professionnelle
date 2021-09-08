package com.example.proplusnetv2_03;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter_Tiers extends RecyclerView.Adapter<MyAdapter_Tiers.CustomViewHolder> {

    private List<Tiers> dataList;

    public MyAdapter_Tiers(List<Tiers> dataList){

        this.dataList = dataList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {


        public final View myView;

        TextView IdTiers,CodeTiers,NomSociété,Activité;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            IdTiers = myView.findViewById(R.id.txt_IdTiers);
            CodeTiers = myView.findViewById(R.id.txt_CodeTiers);
            NomSociété = myView.findViewById(R.id.txt_NomSociété);
            Activité = myView.findViewById(R.id.txt_Activité);

        }
    }



    @Override

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout_tiers, parent, false);
        return new CustomViewHolder(view);
    }

    @Override

    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.IdTiers.setText("IdTiers : "+dataList.get(position).getIdTiers());
        holder.CodeTiers.setText("CodeTiers : "+dataList.get(position).getCodeTiers());
        holder.NomSociété.setText("NomSociété : "+dataList.get(position).getNomSociété());
        holder.Activité.setText("Activité : "+dataList.get(position).getActivité());



    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }



    //Filtrage
    public void filterList(List<Tiers> filteredList) {
        dataList = filteredList;
        notifyDataSetChanged();
    }
}
