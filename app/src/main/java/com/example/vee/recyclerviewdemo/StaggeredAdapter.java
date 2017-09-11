package com.example.vee.recyclerviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder> {

    private Context mContext;
    private List<DataBean> mDatas;

    public StaggeredAdapter(Context context, List<DataBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public StaggeredAdapter.StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ViewHolder创建时回调
        View view = View.inflate(mContext, R.layout.item_staggered, null);
        return new StaggeredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaggeredAdapter.StaggeredViewHolder holder, int position) {
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

    public class StaggeredViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public StaggeredViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.staggered_item_iv_icon);
            mTextView = (TextView) itemView.findViewById(R.id.staggered_item_tv_dsc);
        }


        public void setData(DataBean bean) {

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;//长宽为原来的1/2 所以压缩为原来的1/4
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), bean.icon, options);

            //设置数据的方法
//            mImageView.setImageResource(bean.icon);
            mImageView.setImageBitmap(bitmap);
            mTextView.setText(bean.name);
        }
    }
}
