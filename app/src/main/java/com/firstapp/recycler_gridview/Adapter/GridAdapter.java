package com.firstapp.recycler_gridview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firstapp.recycler_gridview.Interface.OnItemClick;
import com.firstapp.recycler_gridview.Model.GridPojo;
import com.firstapp.recycler_gridview.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridHolder> {

    Context context;
    List<GridPojo> gridPojoList=new ArrayList<>();
    LayoutInflater layoutInflater;
    OnItemClick onItemClick;


    public GridAdapter(Context context, Object gridPojo, List<GridPojo> gridPojoList){
        this.context=context;
        this.onItemClick=onItemClick;
        this.gridPojoList=gridPojoList;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid_view,parent,false);
        return new GridHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHolder holder, int position) {
        GridPojo gridPojo=gridPojoList.get(position);
        holder.textView.setText(gridPojoList.get(position).getName());
        holder.imageView.setImageResource(gridPojoList.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return gridPojoList.size();
    }

    public class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.Image_name);
            textView=itemView.findViewById(R.id.Text_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Selected Data"+gridPojoList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
