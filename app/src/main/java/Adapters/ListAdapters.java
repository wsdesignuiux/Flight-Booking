package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ws.design.flight_booking.R;

import java.util.ArrayList;

import Models.PojoClass;

/**
 * Created by kuldeep on 31/01/18.
 */

public class ListAdapters extends RecyclerView.Adapter<ListAdapters.ViewHolder> {

    private Context context;
    private ArrayList<PojoClass> pojoClassArrayList;

    public ListAdapters(Context context, ArrayList<PojoClass> pojoClassArrayList) {
        this.context = context;
        this.pojoClassArrayList = pojoClassArrayList;
    }
    @Override
    public ListAdapters.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapters.ViewHolder holder, int position) {

        holder.text_airline.setText(pojoClassArrayList.get(position).getText_airline());
        holder.text_timeschedule.setText(pojoClassArrayList.get(position).getText_timeschedule());
        holder.text_time.setText(pojoClassArrayList.get(position).getText_time());
        holder.logo.setImageResource(pojoClassArrayList.get(position).getLogo());

    }

    @Override
    public int getItemCount()  {
        return pojoClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_airline,text_timeschedule,text_time;
        ImageView logo;


        public ViewHolder(View view) {
            super(view);

            text_airline =  view.findViewById(R.id.text_airline);
            text_timeschedule =  view.findViewById(R.id.text_timeschedule);
            text_time =  view.findViewById(R.id.text_time);
            logo = view.findViewById(R.id.logo);
        }
    }
}
