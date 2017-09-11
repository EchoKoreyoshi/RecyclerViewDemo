package com.example.vee.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 项目名： RecyclerViewDemo
 * 创建者： vee
 * 时  间： 2017/9/6 12:03
 * 描  述： TODO
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<DataBean> mDatas;

    public ListAdapter(Context context, List<DataBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ViewHolder创建时回调
        View view = View.inflate(mContext, R.layout.item_list, null);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListViewHolder holder, int position) {
        //ViewHolder绑定数据时回调
        DataBean bean = mDatas.get(position);
        holder.setData(bean);
    }

    @Override
    public int getItemCount() {
        if (mDatas != null)
            return mDatas.size();
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public ListViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.list_item_iv_icon);
            mTextView = (TextView) itemView.findViewById(R.id.list_item_tv_dsc);
        }


        public void setData(DataBean bean) {
            //设置数据的方法
            mImageView.setImageResource(bean.icon);
            mTextView.setText(bean.name);
        }
    }
}
