package com.example.eoin_a.meteorapp.Presentation.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

/**
 * Created by eoin_a on 29/10/2016.
 */
public class MeteorRecviewAdpt extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Meteor> meteorlist;


    public MeteorRecviewAdpt(List<Meteor> meteorlist)
    {
        this.meteorlist = meteorlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate view. return holder etc.
        //return new MeteorViewHolder()
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int pos) {
        //bind elements to the view
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class MeteorViewHolder extends RecyclerView.ViewHolder
    {
        private TextView location;
        private TextView mass;

        public MeteorViewHolder(View itemView) {
            super(itemView);
        }
    }
}
