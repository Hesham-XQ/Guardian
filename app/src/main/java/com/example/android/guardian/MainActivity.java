package com.example.android.guardian;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {
    @BindView(R.id.empty_state_text)
    TextView noResultsView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.search_results)
    ListView newsSearchResultsListView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    static String baseUrl = "https://content.guardianapis.com/search?q= &use-date=published&page-size=50&order-by=newest&show-tags=contributor&show-fields=thumbnail,short-url&api-key=test";
    private ArrayList<News> newsArrayList = new ArrayList<News>();
    private NewsAdapter newsAdapter;
    private static LoaderManager loaderManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            noResultsView.setText(getString(R.string.wait));
            initializeLoaderAndAdapter();

        } else {
            noResultsView.setText(getString(R.string.no_internet_connection_message));
        }


        newsSearchResultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                News selectedArticle = newsAdapter.getItem(position);
                String ur = selectedArticle.getUrl();

                Uri newsUri = Uri.parse(ur);
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);
            }


//            // Handles the row being being clicked
//            @Override
//            public void onClick(View view) {
//                int position = getAdapterPosition();
//                News news = mNews.get(position);
//
//                // Get the Url from the current NewsItem
//                mURL = news.getWebURL();
//
//                // Convert the String URL into a URI object (to pass into the Intent constructor)
//                Uri newsURI = Uri.parse(mURL);
//                // Create new intent to view the article's URL
//                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsURI);
//                // Start the intent
//                context.startActivity(websiteIntent);
//            }

        });
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {

        return new newsLoader(this, baseUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newsItems) {
        if (newsItems != null && !newsItems.isEmpty()) {
            newsAdapter.addAll(newsItems);
            progressBar.setVisibility(View.GONE);
            noResultsView.setText("");

        } else {
            noResultsView.setText(getString(R.string.no_article));
            progressBar.setVisibility(View.GONE);
        }
        Log.v("MainActivity", "Loader completed operation!");
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        newsAdapter.clear();
    }

    public void initializeLoaderAndAdapter() {
        loaderManager = getLoaderManager();
        loaderManager.initLoader(1, null, this);
        newsAdapter = new NewsAdapter(this, new ArrayList<News>());
        newsSearchResultsListView.setAdapter(newsAdapter);
    }


    public void refresh() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        Log.v("MainActivity", "networkInfo: " + networkInfo);

        if (networkInfo != null && networkInfo.isConnected()) {
            noResultsView.setText(getString(R.string.refresh));
            progressBar.setVisibility(View.VISIBLE);

            if (newsAdapter != null) {
                newsAdapter.clearAll();
            }
            if (loaderManager != null) {
                loaderManager.restartLoader(1, null, this);
                swipeRefreshLayout.setRefreshing(false);
            } else {
                initializeLoaderAndAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }

        } else {

            if (newsAdapter != null) {
                newsAdapter.clearAll();
            }

            noResultsView.setText(getString(R.string.no_internet_connection_message));
            swipeRefreshLayout.setRefreshing(false);
        }

    }

}

