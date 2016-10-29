package com.example.eoin_a.meteorapp.Presentation.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eoin_a on 29/10/2016.
 */
public class MeteorRecviewAdpt extends RecyclerView.Adapter<MeteorRecviewAdpt.MeteorViewHolder> {

    private List<Meteor> meteorlist;

    public MeteorRecviewAdpt(List<Meteor> meteorlist) {

        this.meteorlist = meteorlist;
    }

    @Override
    public MeteorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meteor_row, parent, false);
        return new MeteorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeteorViewHolder holder, int pos) {

        Meteor meteor = meteorlist.get(pos);

        holder.date.setText(meteor.getYear());
        holder.mass.setText(String.valueOf(meteor.getMass()));
        holder.location.setText(meteor.getName());
    }

    @Override
    public int getItemCount() {
        return meteorlist.size();
    }

    public class MeteorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nametxt) TextView location;
        @BindView(R.id.masstxt) TextView mass;
        @BindView(R.id.datetxt) TextView date;

        public MeteorViewHolder(View view) {

            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


