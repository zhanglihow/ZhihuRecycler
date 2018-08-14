package com.sikan.zhihurecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangli on 2018/8/13
 *
 * 模仿知乎的背景图片广告
 */
public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Data> mData = new ArrayList<>();

//    private boolean change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image);
        mRecyclerView = findViewById(R.id.recycler);

        initView();
        initData();

        mMyAdapter = new MyAdapter(mData);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    private void initView() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //用了个三方的分割条，更好的显示广告图片
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));

        //不需要判定显示隐藏Image了
//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);

//                boolean in=currentView();
////                isChange(in);
//                if(in){
//                    mImageView.setVisibility(View.VISIBLE);
//                }else{
//                    mImageView.setVisibility(View.GONE);
//                }
//            }
//        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            Data data = new Data();
            data.title = "这是第 " + i + " 条标题";
            data.msg = "这是第 " + i + " 条回答";
            mData.add(data);
        }
    }

//    /**
//     * 模拟不同的广告图片
//     *
//     * @param in
//     */
//    private void isChange(boolean in){
//        if(change==in){
//            return;
//        }
//        Random random=new Random();
//        mImageView.setImageDrawable(ContextCompat.getDrawable(this,imgs.get(random.nextInt(6))));
//        change=in;
//    }

    /**
     * 当 5 这个position 介于 firstVisibleItem 和 lastVisibleItem 之间
     * @return
     */
    public boolean currentView() {
        int firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
        int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();

        if(firstVisibleItem!=0 && firstVisibleItem %5 ==0 || lastVisibleItem%5==0 ){
            return true;
        }else if(isIn(firstVisibleItem,lastVisibleItem)){
            return true;
        }
        return false;
    }

    private boolean isIn(int a,int b){
        for(int i=a+1;i<b;i++){
            if(i%5==0){
                return true;
            }
        }
        return false;
    }

}
