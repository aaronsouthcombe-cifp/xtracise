package com.xtracise;

import com.xtracise.models.Exercici;
import com.xtracise.models.Usuari;
import com.xtracise.models.Workout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Provides database access methods for retrieving and manipulating data
 * within the XTRACISE corporate fitness management system.
 *
 * @author Mike
 */
public class DataAccess {

    /**
     * Establishes and returns a Connection to the SQL Server database. 
     * Uses parameters from the application's properties file.
     *
     * @return A Connection object to the configured database.
     */
    private static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            String connectionStringAzureSQLServer = "jdbc:sqlserver://simulapsqlserver.database.windows.net:1433;database=simulapdb25;user=simulapdbadmin@simulapsqlserver;password=Pwd1234.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(connectionStringAzureSQLServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Retrieves a user record from the database based on email.
     *
     * @param email The user's email address.
     * @return      A Usuari object corresponding to the matching record.
     */
    public static Usuari getUser(String email) {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            user = new Usuari();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Retrieves all users who are not instructors from the Usuaris table.
     *
     * @return An ArrayList of Usuari objects.
     */
    public static ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Retrieves all users assigned to a given instructor.
     *
     * @param idInstructor The instructor's database ID.
     * @return             An ArrayList of Usuari objects.
     */
    public static ArrayList<Usuari> getAllUsersByInstructor(int idInstructor) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idInstructor);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Retrieves all workouts for a specified user.
     *
     * @param user The user whose workouts are requested.
     * @return     An ArrayList of Workout objects for the given user.
     */
    public static ArrayList<Workout> getWorkoutsPerUser(Usuari user) {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT Workouts.Id, Workouts.ForDate, Workouts.UserId, Workouts.Comments"
                + " FROM Workouts"
                + " WHERE Workouts.UserId=?"
                + " ORDER BY Workouts.ForDate";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Workout workout = new Workout();
                workout.setId(resultSet.getInt("Id"));
                workout.setForDate(resultSet.getString("ForDate"));
                workout.setIdUsuari(resultSet.getInt("UserId"));

                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    /**
     * Retrieves all exercises associated with a given workout.
     *
     * @param workout The workout whose exercises are requested.
     * @return        An ArrayList of Exercici objects.
     */
    public static ArrayList<Exercici> getExercicisPerWorkout(Workout workout) {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT ExercicisWorkouts.IdExercici,"
                + " Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM ExercicisWorkouts INNER JOIN Exercicis ON ExercicisWorkouts.IdExercici=Exercicis.Id"
                + " WHERE ExercicisWorkouts.IdWorkout=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, workout.getId());
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("IdExercici"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Retrieves all exercises available in the system.
     *
     * @return An ArrayList of Exercici objects.
     */
    public static ArrayList<Exercici> getAllExercicis() {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT Id, Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM Exercicis";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("Id"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Registers a new user in the database.
     *
     * @param u The Usuari object containing necessary user information.
     * @return  The generated primary key (ID) for the new user record.
     */
    public static int registerUser(Usuari u) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Instructor)"
                + " VALUES (?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.isInstructor());

            int newUserId = insertStatement.executeUpdate();
            return newUserId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Inserts a workout and its exercises into the database.
     *
     * @param w         The Workout object to insert.
     * @param exercicis The list of exercises associated with the workout.
     */
    public static void insertWorkout(Workout w, ArrayList<Exercici> exercicis) {
        // The following should be done in a SQL transaction
        int newWorkoutId = insertToWorkoutTable(w);
        insertExercisesPerWorkout(newWorkoutId, exercicis);
    }

    /**
     * Inserts a Workout record into the database and returns its generated key.
     *
     * @param w The Workout object to be persisted.
     * @return  The new workout's ID.
     */
    private static int insertToWorkoutTable(Workout w) {
        String sql = "INSERT INTO dbo.Workouts (ForDate, UserId, Comments)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            insertStatement.setString(1, w.getForDate());
            insertStatement.setInt(2, w.getIdUsuari());
            insertStatement.setString(3, w.getComments());

            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();
                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Inserts multiple exercises for a given workout.
     *
     * @param wId       The ID of the workout.
     * @param exercicis The list of exercises to be assigned to the workout.
     * @return          Number of exercises inserted, or 0 on failure.
     */
    private static int insertExercisesPerWorkout(int wId, ArrayList<Exercici> exercicis) {
        for(Exercici e: exercicis) {
            int rowsAffected = insertExerciciPerWorkout(wId, e);
            if (rowsAffected != 1) {
                return 0;
            }
        }
        return exercicis.size();
    }

    /**
     * Inserts a single exercise-workout relationship record.
     *
     * @param wId The ID of the workout.
     * @param e   The Exercici object to be linked with the workout.
     * @return    Number of rows affected by the insert operation.
     */
    private static int insertExerciciPerWorkout(int wId, Exercici e) {
        String sql = "INSERT INTO dbo.ExercicisWorkouts (IdWorkout, IdExercici)"
                + " VALUES (?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setInt(1, wId);
            insertStatement.setInt(2, e.getId());
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Deletes a workout and its associated records from the database.
     *
     * @param workoutId The ID of the workout to delete.
     * @throws SQLException if any error occurs during the transaction.
     */
    public static void deleteWorkout(int workoutId) throws SQLException {
        String sqlDeleteReviews = "DELETE r FROM Review r " +
                                 "INNER JOIN Intents i ON r.IdIntent = i.Id " +
                                 "INNER JOIN ExercicisWorkouts ew ON i.IdExerciciWorkout = ew.Id " +
                                 "WHERE ew.IdWorkout = ?";

        String sqlDeleteIntents = "DELETE i FROM Intents i " +
                                 "INNER JOIN ExercicisWorkouts ew ON i.IdExerciciWorkout = ew.Id " +
                                 "WHERE ew.IdWorkout = ?";

        String sqlDeleteExercicisWorkouts = "DELETE FROM ExercicisWorkouts WHERE IdWorkout = ?";
        String sqlDeleteWorkout = "DELETE FROM Workouts WHERE Id = ?";
        Connection conn = getConnection();

        try (
             PreparedStatement stmtReviews = conn.prepareStatement(sqlDeleteReviews);
             PreparedStatement stmtIntents = conn.prepareStatement(sqlDeleteIntents);
             PreparedStatement stmtExercicis = conn.prepareStatement(sqlDeleteExercicisWorkouts);
             PreparedStatement stmtWorkout = conn.prepareStatement(sqlDeleteWorkout)) {

            conn.setAutoCommit(false);

            // 1. Delete Reviews
            stmtReviews.setInt(1, workoutId);
            stmtReviews.executeUpdate();

            // 2. Delete Intents
            stmtIntents.setInt(1, workoutId);
            stmtIntents.executeUpdate();

            // 3. Delete ExercicisWorkouts
            stmtExercicis.setInt(1, workoutId);
            stmtExercicis.executeUpdate();

            // 4. Delete Workout
            stmtWorkout.setInt(1, workoutId);
            stmtWorkout.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}
