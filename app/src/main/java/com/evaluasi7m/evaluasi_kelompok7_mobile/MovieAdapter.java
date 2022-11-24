package com.evaluasi7m.evaluasi_kelompok7_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    public MovieAdapter(Context context){
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {return movies.size();}

    @Override
    public Object getItem(int i) {return movies.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_laundry,
                    viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movies = (Movie) getItem(i);
        viewHolder.bind(movies);
        return view;
    }
    private class ViewHolder{
        private TextView txtTitle;
        private TextView txtDesc;
        private ImageView imgPoster;

        ViewHolder(View view){
            txtTitle = view.findViewById(R.id.txt_title);
            txtDesc = view.findViewById(R.id.txt_desc);
            imgPoster = view.findViewById(R.id.img_poster);
        }
        void bind(Movie movies){
            txtTitle.setText(movies.getTitle());
            txtDesc.setText(movies.getDesc());
            imgPoster.setImageResource (movies.getPoster());
        }
    }
}
