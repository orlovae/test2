package com.test.alex.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.alex.test.model.Holder;
import java.util.List;

import static com.test.alex.test.Constant.MODEL;

/**
 * Created by alex on 14.08.17.
 */

public class RecyclerViewAdapter extends
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<Holder> list;
    private Holder holder;

    public RecyclerViewAdapter(Context context, List<Holder> list) {
            this.context = context;
            this.list = list;
        }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        //Вывод на экран имени каждого объекта
        holder = list.get(position);
        viewHolder.textView.setText((position + 1)+ ". " + holder.getSimpleName());
        Log.d("RecyclerViewAdapter", "position = " + position);

        //Передача в activity выбранного объекта
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TwoActivity.class);
                intent.putExtra(MODEL, list.get(position).getModel());
                Log.d("RecyclerViewAdapter", "item = " + list.get(position).getModel());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView){
            textView = (TextView)itemView.findViewById(R.id.text_view);
        }
    }
}
