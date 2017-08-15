package com.test.alex.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.alex.test.model.Event;
import com.test.alex.test.model.Holder;
import com.test.alex.test.model.Move;
import com.test.alex.test.model.Notice;

import java.util.List;

import static com.test.alex.test.MainActivity.EVENT;
import static com.test.alex.test.MainActivity.MOVE;
import static com.test.alex.test.MainActivity.NOTICE;

/**
 * Created by alex on 14.08.17.
 */

public class RecyclerViewAdapter extends
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
        private Context context;
        private List<Holder> list;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //Вывод на экран имени каждого объекта
        String typeObject = list.get(position).getType();
        switch (typeObject) {
            case EVENT:
                Event event = (Event)(list.get(position).getObject());
                holder.textView.setText(EVENT + " " + event.getName());
                break;
            case MOVE:
                Move move = (Move)(list.get(position).getObject());
                holder.textView.setText(MOVE + " " + move.getToPlace());
                break;
            case NOTICE:
                Notice notice = (Notice)(list.get(position).getObject());
                holder.textView.setText(NOTICE + " " + notice.getGate());
                break;
        }

        //Передача в activity выбранного объекта
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(context, TwoActivity.class);
                String typeObject = list.get(position).getType();
                switch (typeObject) {
                    case EVENT:
                        Event event = (Event)(list.get(position).getObject());
                        bundle.putParcelable(EVENT, event);
                        intent.putExtras(bundle);
                        holder.textView.setText(EVENT + event.getName());
                        break;
                    case MOVE:
                        Move move = (Move)(list.get(position).getObject());
                        bundle.putParcelable(MOVE, move);
                        intent.putExtras(bundle);
                        holder.textView.setText(MOVE + move.getToPlace());
                        break;
                    case NOTICE:
                        Notice notice = (Notice)(list.get(position).getObject());
                        bundle.putParcelable(NOTICE, notice);
                        intent.putExtras(bundle);
                        holder.textView.setText(NOTICE + notice.getGate());
                        break;
                }
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
