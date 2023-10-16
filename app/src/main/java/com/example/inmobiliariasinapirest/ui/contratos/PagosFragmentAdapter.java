package com.example.inmobiliariasinapirest.ui.contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inmobiliariasinapirest.R;
import com.example.inmobiliariasinapirest.modelo.Pago;

import java.util.List;

public class PagosFragmentAdapter extends RecyclerView.Adapter<PagosFragmentAdapter.ViewHolder> {

    private Context context;
    private List<Pago> listaPagos;
    private LayoutInflater inflater;

    public PagosFragmentAdapter(Context context, List<Pago> listaPagos, LayoutInflater inflater) {
        this.context = context;
        this.listaPagos = listaPagos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View root = inflater.inflate(R.layout.pagos_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigoContrato.setText(listaPagos.get(position).getContrato().getIdContrato()+"");
        holder.importe.setText(listaPagos.get(position).getImporte()+"");
        holder.fechaPago.setText(listaPagos.get(position).getFechaDePago());
        holder.numeroPago.setText(listaPagos.get(position).getNumero()+"");
        holder.codigoPago.setText(listaPagos.get(position).getIdPago()+"");
    }

    @Override
    public int getItemCount() {
        return listaPagos.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView codigoPago;
        TextView numeroPago;
        TextView codigoContrato;
        TextView importe;
        TextView fechaPago;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigoPago = itemView.findViewById(R.id.tvCodigoPago);
            numeroPago = itemView.findViewById(R.id.tvNumeroPago);
            codigoContrato = itemView.findViewById(R.id.tvCodigoContrato);
            importe = itemView.findViewById(R.id.tvImporteContrato);
            fechaPago = itemView.findViewById(R.id.tvFechaPago);

        }
    }
}

