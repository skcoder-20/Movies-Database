package com.company;

import java.sql.*;

import java.util.List;

public class Main {
    public static final String DB_NAME = "movies.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:E:\\Databases\\"+DB_NAME;

    public static final String TABLE_MOVIES = "Movies";
    public static final String COLUMN_MOVIE_NAME ="Movie_Name";
    public static final String COLUMN_MOVIE_ACTOR = "Actor";
    public static final String COLUMN_MOVIE_ACTRESS ="Actress";
    public static final String COLUMN_MOVIE_DIRECTOR = "Director";
    public static final String COLUMN_MOVIE_RELEASE_YEAR = "Year_Of_Release";





    public static void main(String[] args) {
        Datasource datasource = new Datasource();

        try{
            Connection con = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = con.createStatement();
            statement.execute("DROP TABLE IF EXISTS "+ TABLE_MOVIES);
            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_MOVIES+ "("+COLUMN_MOVIE_NAME+" TEXT, " +COLUMN_MOVIE_ACTOR+ " TEXT, "+
                                     COLUMN_MOVIE_ACTRESS + " TEXT, "+ COLUMN_MOVIE_DIRECTOR+ " TEXT, "+ COLUMN_MOVIE_RELEASE_YEAR +" INTEGER "+")");

            //statement.execute("DELETE  FROM "+ TABLE_MOVIES);
            insertMoivesDetails(statement,"Jab Tak Hai Jaan","Shah Rukh Khan","katrina kaif & anushka Sharma ","Yash chopra",2012);
            insertMoivesDetails(statement,"Raaes","Shah Rukh Khan","Mahira khan","Rahul Dholakia",2017);
            insertMoivesDetails(statement,"Baadhsah","Shah Rukh Khan","Twinkle khanna","Abbas Burmawalla & Mustan Burmawalla",1999);
            insertMoivesDetails(statement,"Holiday","Akshay Kumar","Sonakshi Sinha ","A.R.Murugadoss",2014);
            insertMoivesDetails(statement,"Bhool Bhulaiyaa","Akshay Kumar","Vidya Dalan","Priyadarshan ",2007);
            insertMoivesDetails(statement,"The Intern","Robert De Niro  ","Anne Hathaway ","Nancy Meyers",2015);
            insertMoivesDetails(statement,"Edge Of tommorrow","Tom Cruise","Emily Blunt","Doug Liman",2014);
            insertMoivesDetails(statement,"Oblivion","Tom Cruise","Olga Kurylenko","Joseph Kosinski",2013);
            insertMoivesDetails(statement,"Avatar","Sam Worthington","Zoe Saldana","James Cameron",2009);
            insertMoivesDetails(statement,"Logan","Hugh Jackman","Dafne keen","James Mangold",2017);
            insertMoivesDetails(statement,"The Greatest Showman","Hugh jackman","zendaya","michael Gracey",2017);
            insertMoivesDetails(statement,"We Are Your Friends","Zac Efron","Emily ratajkowski","Max Joseph",2015);
            insertMoivesDetails(statement,"The Lucky One","Zac Efron ","Taylor Schilling","Scott Hicks",2012);
            insertMoivesDetails(statement,"The Pursuit Of Happyness","Will Smith","Thandiwe Newton","Gabriele Muccino",2006);
            insertMoivesDetails(statement,"I Am Legend","Will Smith","Alice Braga ","Francis Lawrence",2007);
            insertMoivesDetails(statement,"Jungle Cruise","Dwyane Johnson","Emily Blunt ","Jaume Collect-Serra",2021);
            insertMoivesDetails(statement,"Rampage","Dwyane Johnson","Naomie Harris ","Brad Peyton",2018);



            System.out.println("Movie name     |"+ "   Actor    |"+"     Actress      |"+"     Director     |"+"    Year Of Release   \n ----------------------------------------------------------------------------------------- ");

            statement.execute("SELECT * FROM "+ TABLE_MOVIES);
            ResultSet result = statement.getResultSet();
            while(result.next()){
                System.out.println(result.getString(COLUMN_MOVIE_NAME)+" | "+ result.getString(COLUMN_MOVIE_ACTOR) + " | "+ result.getString(COLUMN_MOVIE_ACTRESS) +" | "
                                       + result.getString(COLUMN_MOVIE_DIRECTOR) + " | "+ result.getInt(COLUMN_MOVIE_RELEASE_YEAR)+"\n");


            }

            System.out.println("--------------------------------------------------------------------------------");
            List<String > MovieByActor = datasource.queryMoviesByActorName("Tom Cruise");
            System.out.println();
            for(String movie : MovieByActor){
                System.out.println(movie);
               }



            result.close();
            statement.close();
            con.close();



        }catch(SQLException e){
             System.out.println("somethingwent wrong "+ e.getMessage());
             e.printStackTrace();

        }


    }
    private static void insertMoivesDetails(Statement statement, String name ,String actor, String actress, String director, int YOR) throws SQLException {
        statement.execute("INSERT INTO "+TABLE_MOVIES +
                            "("+COLUMN_MOVIE_NAME+", "+COLUMN_MOVIE_ACTOR+", "+
                              COLUMN_MOVIE_ACTRESS+ ","+COLUMN_MOVIE_DIRECTOR+", "+COLUMN_MOVIE_RELEASE_YEAR+") "+"VALUES('"+name +"', '"+actor+"', '"+actress +"', '"+director+"',"+YOR+")");

    }

}










