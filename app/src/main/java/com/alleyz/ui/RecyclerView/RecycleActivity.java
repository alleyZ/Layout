package com.alleyz.ui.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mr on 2015/12/22.
 */
public class RecycleActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv=new RecyclerView(this);
        rv.setLayoutManager(new LinearLayoutManager(this));

        setContentView(rv);

        rv.setAdapter(new RecyclerView.Adapter() {
            class MyHolder extends RecyclerView.ViewHolder{
                private Button btn;
                public MyHolder(View itemView){
                    super(itemView);
                    btn=(Button)itemView;
                    btn.setAllCaps(false);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("_R","lalalalalalalalla");
                        }
                    });
                }

                public Button getBtn(){
                    return btn;
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyHolder(new Button(parent.getContext()));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyHolder mh=(MyHolder)holder;
                mh.getBtn().setText(data[position]);
            }

            @Override
            public int getItemCount() {
                return data.length;
            }
            String[] data=new String[]{
                    "btn-1","btn-2","btn-3","btn-4"
            };
        });


    }
}
