package com.example.drawenavigation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drawenavigation.Model.Contacts;
import com.example.drawenavigation.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterContacts extends BaseAdapter {
    Context context;
    List<Contacts> contactsList=null;
    ArrayList<Contacts> arraylist;
    int layout;

    public AdapterContacts(Context context, List<Contacts> contactsList, int layout) {
        this.context = context;
        this.contactsList = contactsList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return contactsList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(layout,null);
        //anh xa view
        TextView txtTitle=view.findViewById(R.id.title);
        TextView txtDes=view.findViewById(R.id.description);
        ImageView image=view.findViewById(R.id.image);
        //gan gia tri
        Contacts contacts=contactsList.get(i);
        txtTitle.setText(contacts.getTitle());
        txtDes.setText(contacts.getDescription());
        image.setImageResource(contacts.getImage());

        return view;
    }
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        contactsList.clear();
        if (charText.length() == 0) {
            contactsList.addAll(arraylist);
        } else {
            for (Contacts wp : arraylist) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    contactsList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
