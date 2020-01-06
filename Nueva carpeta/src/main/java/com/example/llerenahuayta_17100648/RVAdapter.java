package com.example.llerenahuayta_17100648;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LibreriaViewHolder> {

    List<Transaccion> libreriatTransaccions;
    public RVAdapter(List<Transaccion> libreriatTransaccions){
        this.libreriatTransaccions =libreriatTransaccions;
    }

    @NonNull
    @Override
    public LibreriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaccion,parent,false);
        LibreriaViewHolder lvh = new LibreriaViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LibreriaViewHolder holder, int position) {
        holder.tvID.setText(String.valueOf(libreriatTransaccions.get(position).getCodigo()));
        holder.tvEnvio.setText(String.valueOf(libreriatTransaccions.get(position).getEnvia()));
        holder.tvRecibe.setText(String.valueOf(libreriatTransaccions.get(position).getRecibe()));
        holder.tvMonedaCambio.setText(String.valueOf(libreriatTransaccions.get(position).getMonedaTipocambio()));
        holder.tvvalorTipoCambio.setText(String.valueOf(libreriatTransaccions.get(position).getValorTipoCambio()));
        holder.tvEstado.setText(String.valueOf(libreriatTransaccions.get(position).getEstado()));
        holder.tvFecha.setText(libreriatTransaccions.get(position).getFechaCreacion());
    }

    @Override
    public int getItemCount() {
        return libreriatTransaccions.size();
    }

    public class LibreriaViewHolder extends RecyclerView.ViewHolder {
        TextView tvID,tvEnvio,tvRecibe,tvMonedaCambio,tvvalorTipoCambio,tvEstado,tvFecha;

        public LibreriaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID=itemView.findViewById(R.id.tvID);
            tvEnvio=itemView.findViewById(R.id.tvEnvio);
            tvRecibe=itemView.findViewById(R.id.tvRecibe);
            tvMonedaCambio=itemView.findViewById(R.id.tvMonedaCambio);
            tvvalorTipoCambio=itemView.findViewById(R.id.tvValorTipoCambio);
            tvEstado=itemView.findViewById(R.id.tvEstado);
            tvFecha=itemView.findViewById(R.id.tvFecha);

        }
    }
}
