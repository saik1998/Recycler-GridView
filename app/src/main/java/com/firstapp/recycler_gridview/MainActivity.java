package com.firstapp.recycler_gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firstapp.recycler_gridview.Adapter.GridAdapter;
import com.firstapp.recycler_gridview.Interface.OnItemClick;
import com.firstapp.recycler_gridview.Model.GridPojo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView;
    //ArrayList arrayList;
    List<GridPojo> arrayList=new ArrayList<>();
    private Object GridPojo;
    private Object ArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyler_view);
        recyclerView.setHasFixedSize(true);


        arrayList=new ArrayList();
        arrayList.add(new GridPojo(R.drawable.img_1,"Kia"));
        arrayList.add(new GridPojo(R.drawable.img_2,"Skoda"));
        arrayList.add(new GridPojo(R.drawable.img_3,"Benz"));
        arrayList.add(new GridPojo(R.drawable.img_4,"HONDA"));
        arrayList.add(new GridPojo(R.drawable.img_5,"Audi"));
        arrayList.add(new GridPojo(R.drawable.img_6,"Skoda"));
        arrayList.add(new GridPojo(R.drawable.img_7,"Kia"));


        GridAdapter gridAdapter=new GridAdapter(getApplicationContext(),GridPojo,arrayList);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);


        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gridAdapter);





    }

    @Override
    public void onCLick(int i) {

        Toast.makeText(this, "Selected "+arrayList.get(i), Toast.LENGTH_SHORT).show();

    }
}