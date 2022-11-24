package com.evaluasi7m.evaluasi_kelompok7_mobile;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private String[] movie_title;
    private String[] movie_desc;
    private TypedArray movie_poster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movielist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_movie);
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie list = movielist.get(i);
                Intent intent = new Intent(ListMovie.this, DetailLaundry.class);
                intent.putExtra("title", list.getTitle());
                intent.putExtra("desc", list.getDesc());
                intent.putExtra("poster", list.getPoster());
                startActivity(intent);
            }
        });

    }
    private void prepare() {
        movie_title =
                getResources().getStringArray(R.array.movie_title);
        movie_desc =
                getResources().getStringArray(R.array.movie_desc);
        movie_poster =
                getResources().obtainTypedArray(R.array.movie_poster);
    }
    private void addItem() {
        movielist = new ArrayList<>();
        for (int i = 0; i < movie_title.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(movie_poster.getResourceId(i, -1));
            movie.setTitle(movie_title[i]);
            movie.setDesc(movie_desc[i]);
            movielist.add(movie);
        }
        adapter.setMovies(movielist);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Search Film..");
        return true;
    }
}