package com.example.eoin_a.meteorapp.Presentation.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Utils.DateFormatter;
import com.example.eoin_a.meteorapp.Presentation.Utils.StringFormatter;
import com.example.eoin_a.meteorapp.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eoin_a on 29/10/2016.
 *
 *
 */
public class MeteorRecviewAdpt extends RecyclerView.Adapter<MeteorRecviewAdpt.MeteorViewHolder> {

    private List<Meteor> meteorlist;
    private StringFormatter stringFormatter;
    private DateFormatter dateformatter;

    public MeteorRecviewAdpt(List<Meteor> meteorlist) {

        this.meteorlist = meteorlist;
        this.stringFormatter = new StringFormatter();
        this.dateformatter = new DateFormatter();
    }

    @Override
    public MeteorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meteor_row, parent, false);
        return new MeteorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MeteorViewHolder holder, int pos) {

        Meteor meteor = meteorlist.get(pos);

        holder.date.setText(dateformatter.shortenFormat(meteor.getYear()));
        holder.mass.setText(String.valueOf(meteor.getMass()));
        holder.location.setText(stringFormatter.abbreviateString(meteor.getName()));
        holder.squaretxt.setText(meteor.getName().substring(0,1));
    }

    @Override
    public int getItemCount() {
        return meteorlist.size();
    }

    public class MeteorViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.square_txt) TextView squaretxt;
        @BindView(R.id.nametxt) TextView location;
        @BindView(R.id.masstxt) TextView mass;
        @BindView(R.id.datetxt) TextView date;

        public MeteorViewHolder(View view) {

            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


