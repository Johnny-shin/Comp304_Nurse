//package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;
//
//public class TestAdapter extends ArrayAdapter<Test> {
//
//    public TestAdapter(@NonNull Context context, int resource) {
//        super(context, resource);
//    }
//}
////
////public class AdapterPerson extends ArrayAdapter<Person> {
////    private Activity activity;
////    private ArrayList<Person> lPerson;
////    private static LayoutInflater inflater = null;
////
////    public AdapterPerson (Activity activity, int textViewResourceId,ArrayList<Person> _lPerson) {
////        super(activity, textViewResourceId, _lProducts);
////        try {
////            this.activity = activity;
////            this.lPerson = _lPerson;
////
////            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////
////        } catch (Exception e) {
////
////        }
////    }
////
////    public int getCount() {
////        return lPerson.size();
////    }
////
////    public Product getItem(Product position) {
////        return position;
////    }
////
////    public long getItemId(int position) {
////        return position;
////    }
////
////    public static class ViewHolder {
////        public TextView display_name;
////        public TextView display_number;
////
////    }
////
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View vi = convertView;
//        final RecyclerView.ViewHolder holder;
//        try {
//            if (convertView == null) {
//                vi = inflater.inflate(R.layout.yourlayout, null);
//                holder = new RecyclerView.ViewHolder();
//
//                holder.display_name = (TextView) vi.findViewById(R.id.display_name);
//                holder.display_number = (TextView) vi.findViewById(R.id.display_number);
//
//
//                vi.setTag(holder);
//            } else {
//                holder = (ViewHolder) vi.getTag();
//            }
//
//
//
//            holder.display_name.setText(lProducts.get(position).name);
//            holder.display_number.setText(lProducts.get(position).number);
//
//
//        } catch (Exception e) {
//
//
//        }
//        return vi;
//    }
//}