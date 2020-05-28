package com.example.hp.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.myapplication.R;

import java.util.List;
import java.util.Map;


public class daibanjiAdapter extends BaseAdapter implements OnClickListener  {
    private List<Map<String,Object>> list;
    private Context mContext;
    private InnerItemOnclickListener mListener;


    public daibanjiAdapter(List<Map<String,Object>> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;

        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daibanji,
                    null);
        } else {
            convertView = convertView;
            mHolder = (ViewHolder) convertView.getTag();  //重新获得ViewHolder
        }
        mHolder = new ViewHolder();
        mHolder.title = (TextView) convertView.findViewById(R.id.Title);
        mHolder.show = (ImageView) convertView.findViewById(R.id.show);
        convertView.setTag(mHolder);  //将ViewHolder存储在View中
        mHolder.show.setOnClickListener(this);
        mHolder.show.setTag(position);

        mHolder.title.setText(list.get(position).get("title").toString());
        mHolder.show.setImageResource(R.drawable.show);
        return convertView;
    }


    class ViewHolder {
        TextView title;
        ImageView show;
    }

    public interface InnerItemOnclickListener {
        void itemClick(View v);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }

    @Override
    public void onClick(View v) {
        mListener.itemClick(v);
    }

}
