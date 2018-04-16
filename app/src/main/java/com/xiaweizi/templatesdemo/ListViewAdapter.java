package com.xiaweizi.templatesdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.xiaweizi.templatesdemo.ListViewAdapter
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/04/16
 *     desc   :
 * </pre>
 */
public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<MyBean> mData;

    public ListViewAdapter(Context context) {
        this.mContext = context;
        mData = new ArrayList<>();
    }

    private @LayoutRes
    int getItemLayout() {
        return R.layout.layout_item;
    }

    public void setData(List<MyBean> data) {
        if (data != null) {
            mData = data;
            notifyDataSetChanged();
        }
    }

    public void addData(MyBean bean) {
        if (bean != null) {
            mData.add(bean);
            notifyDataSetChanged();
        }
    }

    public List<MyBean> getData() {
        return this.mData;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public MyBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(getItemLayout(), null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.bind(mData.get(position));
        return convertView;
    }

    static class ViewHolder {
        private TextView content;

        ViewHolder(View itemView) {
            content = itemView.findViewById(R.id.tv_content);
        }

        void bind(MyBean bean) {
            content.setText(bean.content);
        }
    }
}