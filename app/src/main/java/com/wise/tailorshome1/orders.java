package com.wise.tailorshome1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class orders extends AppCompatActivity {
    TextView noorders;
    Context context = this;
    private ListView orderlist;
    private orderListAdapter adapter;
    private List<ordersGetterSetter> morders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        noorders = findViewById(R.id.noorders);
        noorders.setVisibility(View.INVISIBLE);
        setIntent(((Global) context.getApplicationContext()).getemail());
    }


    public void setIntent(String EMAIL) {
        orderlist = findViewById(R.id.orderslist);
        morders = new ArrayList<>();
        try {
            java.sql.Connection con = database_connection.CONN();
            if (con == null) {
                Toast.makeText(this, "check internet connection", Toast.LENGTH_LONG).show();
            } else {
                String query = "select * from dbo.Tailors where email='" + EMAIL + "' order by orderid desc;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (!rs.next()) {
                    noorders.setVisibility(View.VISIBLE);
                } else {
                    while (rs.next()) {
                        morders.add(new ordersGetterSetter(rs.getString(1), rs.getString(7), rs.getString(8)));
                    }
                }
            }
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
            Toast.makeText(this, "data not found", Toast.LENGTH_LONG).show();

        }
        adapter = new orderListAdapter(getApplicationContext(), morders);
        orderlist.setAdapter(adapter);

    }

   /* protected class AsyncCreateUser extends
            AsyncTask<UserDetailsTable, Void, Void> {

        @Override
        protected Void doInBackground(UserDetailsTable... params) {

            RestAPI api = new RestAPI();
            try {
                if (!isNetworkStatusAvialable(getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                } else {
                    api.yourorders(EMAIL);
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncCreateUser", e.getMessage());

            }
            return null;
        }

    }*/

}
