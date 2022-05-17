package com.example.macqurarieinterns.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.macqurarieinterns.Model.Company;
import com.example.macqurarieinterns.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PendingCompanyAdapter extends RecyclerView.Adapter<PendingCompanyAdapter.PendingCompanyViewholder> {
    Context context;
    ArrayList<Company> list;
    public PendingCompanyAdapter(Context context, ArrayList<Company> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PendingCompanyViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(context)
                .inflate(R.layout.item_pending_company, parent, false);
        return new PendingCompanyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingCompanyViewholder holder, int position) {


//        Company company=list.get(position);
        String status = list.get(position).getStatus();




            String uname = list.get(position).getName();
            String companyImage = list.get(position).getC_imageURL();
            holder.company_name.setText(uname);

            if (companyImage.equals("default")) {
                holder.image.setImageResource(R.mipmap.ic_launcher);
            } else {
                try {
                    Picasso.get().load(companyImage).into(holder.image);
                } catch (Exception e) {

                }
            }
            try {
                Picasso.get().load(companyImage).placeholder(R.mipmap.ic_launcher).into(holder.image);
            } catch (Exception e) {

            }
            holder.confirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Company Name :"+uname+" is Confirmed", Toast.LENGTH_SHORT).show();
                }
            });
            holder.rejectBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Company Name :"+uname+" is Rejected", Toast.LENGTH_SHORT).show();
                }
            });





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class PendingCompanyViewholder
            extends RecyclerView.ViewHolder {
        TextView company_name,rejectBtn,confirmBtn;
        CircleImageView image;
        public PendingCompanyViewholder(@NonNull View itemView)
        {
            super(itemView);

            company_name = itemView.findViewById(R.id.company_name);
            image = itemView.findViewById(R.id.image);
            rejectBtn=itemView.findViewById(R.id.reject);
            confirmBtn=itemView.findViewById(R.id.confirm);

        }
    }
}