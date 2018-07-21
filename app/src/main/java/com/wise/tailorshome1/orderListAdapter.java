package com.wise.tailorshome1;

/**
 * Created by harsh on 7/18/2018.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by harsh on 7/18/2018.
 */

public class orderListAdapter extends BaseAdapter {
    private Context mcontext;
    private List<ordersGetterSetter> morders;

    public orderListAdapter(Context mcontext, List<ordersGetterSetter> morders) {
        this.mcontext = mcontext;
        this.morders = morders;
    }

    @Override
    public int getCount() {
        return morders.size();
    }

    @Override
    public Object getItem(int position) {
        return morders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(mcontext, R.layout.display_orders, null);
        TextView oid = v.findViewById(R.id.oid);
        TextView odate = v.findViewById(R.id.odate);
        TextView otime = v.findViewById(R.id.otime);

        oid.append(morders.get(position).getOid());
        odate.append(morders.get(position).getOdate());
        otime.append(morders.get(position).getOtime().substring(0, 8));
        v.setTag(morders.get(position).getOid());
        return v;
    }
}