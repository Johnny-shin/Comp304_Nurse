package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patients;
    private static LayoutInflater layoutInflater = null;
    private ItemClickListener mClickListener;

    public PatientAdapter(@NonNull Context context, @NonNull List<Patient> patients) {
        layoutInflater = LayoutInflater.from(context);
        this.patients = patients;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_item, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Patient temp = patients.get(position);
        holder.tvPatientId.setText(temp.getPatientId()+"");
        holder.tvPatientName.setText(temp.getLastname() + " " + temp.getLastname());
        holder.tvRoom.setText(temp.getRoom());
        holder.tvDepartment.setText(temp.getDepartment());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public Patient getItem(int position) {
        return patients.get(position);
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvPatientId;
        public TextView tvPatientName;
        public TextView tvRoom;
        public TextView tvDepartment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPatientId = itemView.findViewById(R.id.tvPatientId);
            tvPatientName = itemView.findViewById(R.id.tvPatientName);
            tvRoom = itemView.findViewById(R.id.tvRoom);
            tvDepartment = itemView.findViewById(R.id.tvDepartment);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(view.getContext(), "position : " + patients.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
//            patients.get(getLayoutPosition());
        }
    }


}

//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View vi = convertView;
//        final ViewHolder holder;
//        try {
//            if (convertView == null) {
//                vi = layoutInflater.inflate(R.layout.patient_item, null, true);
//                holder = new ViewHolder();
//
//                holder.tvPatientId = (TextView) vi.findViewById(R.id.tvPatientId);
//                holder.tvPatientName = (TextView) vi.findViewById(R.id.tvPatientName);
//                holder.tvRoom = (TextView) vi.findViewById(R.id.tvRoom);
//                holder.tvDepartment = (TextView) vi.findViewById(R.id.tvDepartment);
//
//
//                vi.setTag(holder);
//            } else {
//                holder = (ViewHolder) vi.getTag();
//            }
//            holder.tvPatientId.setText(patients.get(position).getPatientId());
//            holder.tvPatientName.setText(patients.get(position).getLastname() + " " + patients.get(position).getLastname());
//            holder.tvRoom.setText(patients.get(position).getRoom());
//            holder.tvDepartment.setText(patients.get(position).getDepartment());
//
//        } catch (Exception e) {
//            Log.w("myTag", e.getMessage());
//        }
//        return vi;
//    }



//}


