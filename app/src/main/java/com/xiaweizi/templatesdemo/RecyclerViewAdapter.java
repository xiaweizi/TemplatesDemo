package com.xiaweizi.templatesdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.xiaweizi.templatesdemo.RecyclerViewAdapter
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/04/16
 *     desc   :
 * </pre>
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<MyBean> mData;

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList<>();
    }

    private @LayoutRes
    int getItemLayout() {
        return R.layout.layout_item;
    }

    public void setData(List<MyBean> data) {
        if (data != null) {
            this.mData = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getItemLayout(), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView content;
        ViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.tv_content);
        }

        void bind(MyBean bean) {
            content.setText(bean.content);
        }
    }
}