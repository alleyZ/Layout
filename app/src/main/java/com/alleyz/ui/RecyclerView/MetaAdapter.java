package com.alleyz.ui.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/22.
 */
public class MetaAdapter extends RecyclerView.Adapter {

    class MetaHolder extends RecyclerView.ViewHolder{
        private TextView tvName,tvSex,tvAge;
        public MetaHolder(View root) {
            super(root);
            tvName=(TextView)root.findViewById(R.id.tvName);
            tvAge = (TextView) root.findViewById(R.id.tvAge);
            tvSex = (TextView) root.findViewById(R.id.tvSex);
        }
        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvSex() {
            return tvSex;
        }

        public TextView getTvAge() {
            return tvAge;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MetaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_adapter,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MetaHolder mh=(MetaHolder) holder;
        mh.getTvAge().setText(mds[position].getAge());
        mh.getTvName().setText(mds[position].getName());
        mh.getTvSex().setText(mds[position].getSex());
    }

    @Override
    public int getItemCount() {
        return mds.length;
    }
    private MetaData[] mds=getData();

    public MetaData[] getData(){
        MetaData[] mds=new MetaData[45];
        for(int i=0;i<45;i++){
            mds[i]=new MetaData("alleyz"+i,"m"+1,"2"+i);
        }
        return mds;
    }
}
