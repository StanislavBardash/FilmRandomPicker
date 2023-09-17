package com.example.filmtask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    List<Movie> movies;
    Set<Integer> shown;
    int c = 0; int ind=0;

    TextView tvTitle;
    TextView tvGenre;
    TextView tvDirector;
    TextView tvCountry;
    TextView tvRating;

    TextView tvDescription;
    TextView tvLimit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.title);
        tvGenre = findViewById(R.id.genre);
        tvDirector = findViewById(R.id.director);
        tvCountry = findViewById(R.id.country);
        tvRating = findViewById(R.id.rating);
        tvDescription = findViewById(R.id.description);
        tvLimit = findViewById(R.id.limit);
        shown = new HashSet<>();
        loadFilms();

    }
    public void loadFilms(){
        InputStream stream = null;
        try {
            stream = getAssets().open("movies.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        movies = gson.fromJson(reader, Movies.class).getData();
    }
    public void renderFilm(Movie movie){
        makeFilmVisible();
        tvTitle.setText(String.format("%s(%d)", movie.getTitle(), movie.getYear()));
        tvGenre.setText("Жанр: " + movie.getGenre());
        tvDirector.setText("Режиссёр: " + movie.getDirector());
        tvCountry.setText("Страна: " + movie.getCountry());
        tvRating.setText("Оценка(Кинопоиск): " + String.valueOf(movie.getScore()));
        tvDescription.setText("Описание:\n" + movie.getDescription());

    }
    public void makeFilmVisible(){
        tvTitle.setVisibility(View.VISIBLE);
        tvGenre.setVisibility(View.VISIBLE);
        tvDirector.setVisibility(View.VISIBLE);
        tvCountry.setVisibility(View.VISIBLE);
        tvRating.setVisibility(View.VISIBLE);
        tvDescription.setVisibility(View.VISIBLE);

    }
    public void makeFilmInvisible(){
        tvTitle.setVisibility(View.INVISIBLE);
        tvGenre.setVisibility(View.INVISIBLE);
        tvDirector.setVisibility(View.INVISIBLE);
        tvCountry.setVisibility(View.INVISIBLE);
        tvRating.setVisibility(View.INVISIBLE);
        tvDescription.setVisibility(View.INVISIBLE);

    }
    public void onClick(View view) {
        if(c >= movies.size()){
            makeFilmInvisible();
            tvLimit.setVisibility(View.VISIBLE);
            tvLimit.setText("Вы всё посмотрели");
            return;
        }
        Random r = new Random();
        ind = r.nextInt(movies.size());
        while(shown.contains(ind)){
            ind = r.nextInt(movies.size());
        }
        shown.add(ind);
        c+=1;
        Movie randomMovie = movies.get(ind);
        renderFilm(randomMovie);

    }
}