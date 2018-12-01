package other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ws.design.flight_booking.R;

import java.util.ArrayList;

/**
 * Created by kuldeep on 01/02/18.
 */

public class Spinner_ClassAdapter extends ArrayAdapter<ItemData1> {

    int groupid;
    Context context;
    ArrayList<ItemData1> list;
    LayoutInflater inflater;

    public Spinner_ClassAdapter(Context context, int groupid, int id, ArrayList<ItemData1>
            list) {
        super(context, id, list);
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupid, parent, false);
        TextView textView = (TextView) itemView.findViewById(R.id.data);
        textView.setText(list.get(position).getText());

//        if (position == 0) {
//
//            imageView.setVisibility(View.VISIBLE);
//        }else {
//
//            imageView.setVisibility(View.GONE);
//        }


        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent) {
        return getView(position, convertView, parent);

    }
}
