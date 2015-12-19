package com.zhangdesheng.fragmentpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/19.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView newsTilteListView;

    private List<News> newsList;

    private NewsAdapter adapter;


    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(activity, R.layout.news_items, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTilteListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTilteListView.setAdapter(adapter);
        newsTilteListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
        News news = newsList.get(position);
        NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(news.getTitle(), news.getContent());
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("这是第一条新闻  巴拉巴拉扒拉扒拉扒拉扒拉扒拉扒拉扒拉扒拉扒拉扒拉吧");
        news1.setContent("第一条新闻里面讲些什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？" +
                "什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？" +
                "什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？" +
                "什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？" +
                "什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？什么呢？");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("这一条就正经点！                                                      ");
        news2.setContent("正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点" +
                "正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点" +
                "正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点" +
                "正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点" +
                "正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点正经点");
        newsList.add(news2);
        return newsList;
    }
}
