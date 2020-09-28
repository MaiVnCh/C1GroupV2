package com.example.c1groupv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.example.c1groupv2.model.ItemTeilADetails;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String DB_NAME = "C1GroupV2Sept23.db";
    private static final String PATH_DB = Environment.getDataDirectory().getPath() + "/data/com.example.c1groupv2/database/" + DB_NAME;
    private static final String TAGG = DatabaseManager.class.getSimpleName();
    private Context context;

    private SQLiteDatabase sqLiteDatabase;

    private DatabaseManager(Context context) {
        this.context = context;
        copyDatabase();
    }


    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context){
        if (databaseManager == null){
         databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }


    public void copyDatabase(){
        try {
            InputStream inputStream = context.getAssets().open("database/" + DB_NAME);

            File file = new File(PATH_DB);
            if (file.exists()){
                return;
            }
            file.getParentFile().mkdirs();
            file.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(file);

            byte b[] = new byte[1024];

            int currentByte = inputStream.read(b);
            while (currentByte != -1){
                outputStream.write(b, 0, currentByte);
                currentByte = inputStream.read(b);
            }

            inputStream.close();
            outputStream.close();
            Log.d(TAGG, "Copy database successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openDatabase(){
        if (sqLiteDatabase== null || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = SQLiteDatabase.openDatabase(PATH_DB, null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

    private void closeDatabase(){
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()){
            sqLiteDatabase.close();
        }
    }


    public ArrayList<ItemTeilADetails> getAllUbungen( String teil, int lesson){
        ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();
        openDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM UbungenTeilALesson1 WHERE TeilType = ? AND LessonId = ?", new String[] {teil, String.valueOf(lesson)});
        if (cursor!=null){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                int idUbung = cursor.getInt(cursor.getColumnIndex("Id"));
                String teilType = cursor.getString(cursor.getColumnIndex("TeilType"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String theme = cursor.getString(cursor.getColumnIndex("Theme"));
                String instruction = cursor.getString(cursor.getColumnIndex("Instruction"));
                String example = cursor.getString(cursor.getColumnIndex("Example"));
                String content = cursor.getString(cursor.getColumnIndex("Content"));
                String answer = cursor.getString(cursor.getColumnIndex("Answer"));
                String lessonId = cursor.getString(cursor.getColumnIndex("LessonId"));


                ItemTeilADetails itemTeilADetails = new ItemTeilADetails(idUbung,teilType, number,theme, instruction, example,content,answer,lessonId);
                aDetailsArrayList.add(itemTeilADetails);
                cursor.moveToNext();
            }
            return aDetailsArrayList;
        }
        return null;
    }

    public ArrayList<ItemTeilADetails> getAllUbungenA(){
        ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();
        openDatabase();
        String sqlQuery = "SELECT * FROM UbungenTeilALesson1 WHERE TeilType = 'Teil A' ";
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if (cursor!=null){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                int idUbung = cursor.getInt(cursor.getColumnIndex("Id"));
                String teilType = cursor.getString(cursor.getColumnIndex("TeilType"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String theme = cursor.getString(cursor.getColumnIndex("Theme"));
                String instruction = cursor.getString(cursor.getColumnIndex("Instruction"));
                String example = cursor.getString(cursor.getColumnIndex("Example"));
                String content = cursor.getString(cursor.getColumnIndex("Content"));
                String answer = cursor.getString(cursor.getColumnIndex("Answer"));
                String lessonId = cursor.getString(cursor.getColumnIndex("LessonId"));


                ItemTeilADetails itemTeilADetails = new ItemTeilADetails(idUbung,teilType, number,theme, instruction, example,content,answer,lessonId);
                aDetailsArrayList.add(itemTeilADetails);
                cursor.moveToNext();
            }
            return aDetailsArrayList;
        }
        return null;
    }


    public ArrayList<ItemTeilADetails> getAllUbungenC(){
        ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();
        openDatabase();
        String sqlQuery = "SELECT * FROM UbungenTeilALesson1 WHERE TeilType = 'Teil C' ";
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if (cursor!=null){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                int idUbung = cursor.getInt(cursor.getColumnIndex("Id"));
                String teilType = cursor.getString(cursor.getColumnIndex("TeilType"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String theme = cursor.getString(cursor.getColumnIndex("Theme"));
                String instruction = cursor.getString(cursor.getColumnIndex("Instruction"));
                String example = cursor.getString(cursor.getColumnIndex("Example"));
                String content = cursor.getString(cursor.getColumnIndex("Content"));
                String answer = cursor.getString(cursor.getColumnIndex("Answer"));
                String lessonId = cursor.getString(cursor.getColumnIndex("LessonId"));


                ItemTeilADetails itemTeilADetails = new ItemTeilADetails(idUbung,teilType, number,theme, instruction, example,content,answer,lessonId);
                aDetailsArrayList.add(itemTeilADetails);
                cursor.moveToNext();
            }
            return aDetailsArrayList;
        }
        return null;
    }
    public ArrayList<ItemTeilADetails> getAllUbungenD(){
        ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();
        openDatabase();
        String sqlQuery = "SELECT * FROM UbungenTeilALesson1 WHERE TeilType = 'Teil D' ";
        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
        if (cursor!=null){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                int idUbung = cursor.getInt(cursor.getColumnIndex("Id"));
                String teilType = cursor.getString(cursor.getColumnIndex("TeilType"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String theme = cursor.getString(cursor.getColumnIndex("Theme"));
                String instruction = cursor.getString(cursor.getColumnIndex("Instruction"));
                String example = cursor.getString(cursor.getColumnIndex("Example"));
                String content = cursor.getString(cursor.getColumnIndex("Content"));
                String answer = cursor.getString(cursor.getColumnIndex("Answer"));
                String lessonId = cursor.getString(cursor.getColumnIndex("LessonId"));


                ItemTeilADetails itemTeilADetails = new ItemTeilADetails(idUbung,teilType, number,theme, instruction, example,content,answer,lessonId);
                aDetailsArrayList.add(itemTeilADetails);
                cursor.moveToNext();
            }
            return aDetailsArrayList;
        }
        return null;
    }

}
