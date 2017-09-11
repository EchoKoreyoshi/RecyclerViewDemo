package com.example.vee.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DATAS mDATAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "请不要乱点！", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mDATAS = new DATAS();
        loadListDatas(false, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.list_normal) {
            //标准展示 加载数据
            loadListDatas(false, true);
            return true;
        } else if (id == R.id.list_vertical_reverse) {
            //垂直反向显示
            loadListDatas(true, true);
            return true;
        } else if (id == R.id.list_horizontal) {
            //水平显示
            loadListDatas(false, false);
        } else if (id == R.id.list_horizontal_reverse) {
            //水平反向
            loadListDatas(true, false);
        } else if (id == R.id.grid_normal) {
            loadGridDatas(false, false);
        } else if (id == R.id.grid_vertical_reverse) {
            loadGridDatas(true, false);
        } else if (id == R.id.grid_horizontal) {
            loadGridDatas(false, true);
        } else if (id == R.id.grid_horizontal_reverse) {
            loadGridDatas(true, true);
        } else if (id == R.id.staggered_normal) {
            loadStaggeredDatas(false, false);
        } else if (id == R.id.staggered_horizontal) {
            loadStaggeredDatas(false, true);
        } else if (id == R.id.staggered_horizontal_reverse) {
            loadStaggeredDatas(true, true);
        } else if (id == R.id.staggered_vertical_reverse) {
            loadStaggeredDatas(true, false);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * list显示
     *
     * @param reverse
     * @param vertical
     */
    private void loadListDatas(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < mDATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = mDATAS.ICONS[i];
            bean.name = "图片" + i;
            datas.add(bean);
        }

        //设置布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置反向
        linearLayoutManager.setReverseLayout(reverse);
        //设置水平
        linearLayoutManager.setOrientation(vertical ? linearLayoutManager.VERTICAL : linearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        mRecyclerView.setAdapter(new ListAdapter(this, datas));
    }

    /**
     * grid显示
     */
    private void loadGridDatas(boolean reverse, boolean horizontal) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < mDATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = mDATAS.ICONS[i];
            bean.name = "图片" + i;
            datas.add(bean);
        }
        //设置布局管理
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //反向
        gridLayoutManager.setReverseLayout(reverse);
        //水平
        gridLayoutManager.setOrientation(horizontal ? gridLayoutManager.HORIZONTAL : gridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new GridAdapter(this, datas));
    }

    private void loadStaggeredDatas(boolean reverse, boolean horizontal) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < mDATAS.PIC.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = mDATAS.PIC[i];
            bean.name = "图片" + i;
            datas.add(bean);
        }
        StaggeredGridLayoutManager staggeredLayoutManager = new StaggeredGridLayoutManager(3, horizontal ? StaggeredGridLayoutManager.HORIZONTAL : StaggeredGridLayoutManager.VERTICAL);
        //设置反向
        staggeredLayoutManager.setReverseLayout(reverse);
        mRecyclerView.setLayoutManager(staggeredLayoutManager);
        mRecyclerView.setAdapter(new StaggeredAdapter(this, datas));
    }
}
