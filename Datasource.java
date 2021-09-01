package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "movies.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\Databases\\"+DB_NAME;

    public static final String TABLE_MOVIES = "Movies";
    public static final String COLUMN_MOVIE_NAME ="Movie_Name";
    public static final String COLUMN_MOVIE_ACTOR = "Actor";
    public static final String COLUMN_MOVIE_ACTRESS ="Actress";
    public static final String COLUMN_MOVIE_DIRECTOR = "Director";
    public static final String COLUMN_MOVIE_RELEASE_YEAR = "Year_Of_Release";

    //SELECT Movies.Movie_Name FROM Movies WHERE Movies.Actor
    public static final String QUERY_MOVIES_BY_ACTOR_NAME = "SELECT " + TABLE_MOVIES+"."+COLUMN_MOVIE_NAME+" FROM " +
            TABLE_MOVIES+" WHERE "+ TABLE_MOVIES+"."+COLUMN_MOVIE_ACTOR+" = \"";


    public List<String> queryMoviesByActorName (String  movieName){
        StringBuilder sb = new StringBuilder(QUERY_MOVIES_BY_ACTOR_NAME);
        sb.append(movieName);
        sb.append("\"");
        System.out.println("SQL statement = "+sb.toString());

        try{
            Connection con = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sb.toString());

            List<String> movies = new ArrayList<>();
            while(result.next()){

                movies.add(result.getString(1));
            }
            return movies;

        }catch (SQLException e){
            System.out.println("Query failed "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
