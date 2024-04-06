package com.elabda3.eldaya7een.NewsDetailsPackage.SqliteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.elabda3.eldaya7een.model.NewsDataModel;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by ebda3-mint on 10/8/17.
 */

public class SqliteHelperDB extends SQLiteOpenHelper {

    public static String dataBaseName="wasamaDB";
    public static String tableName="favouritTable";

    public static String titleColumn="title";
    public static String photoColumn="photo";
    public static String dateColumn="date";
    public static String urlColumn="url";
    public static String nidColumn="nid";
    public static String numComments="numComments";
    public static String numViews="numViews";


    public SqliteHelperDB(Context context) {
        super(context, dataBaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table "+ tableName + "("+ nidColumn +" text, "+titleColumn+" text, " + dateColumn +" text, " +urlColumn+" text, "+photoColumn+" text, "+ numComments +" integer, " + numViews+" integer )"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(sqLiteDatabase);
    }

    public boolean insertNews(String title , String nid , String date ,String url , String photo , int comments ,int views){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(titleColumn,title);
        contentValues.put(dateColumn,date);
        contentValues.put(urlColumn,url);
        contentValues.put(photoColumn,photo);
        contentValues.put(nidColumn,nid);
        contentValues.put(numComments,comments);
        contentValues.put(numViews,views);

        Long row=sqLiteDatabase.insert(tableName,null,contentValues);

        if(row == -1 ) {

            return false;

        }else {

            return true;

        }

    }

    public List<NewsDataModel> getFavourits(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        List<NewsDataModel> list =new ArrayList<>();

        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+tableName , null);
        boolean dataExist = cursor.moveToFirst();

        if(dataExist) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(titleColumn));
                String nid = cursor.getString(cursor.getColumnIndex(nidColumn));
                String date = cursor.getString(cursor.getColumnIndex(dateColumn));
                String url = cursor.getString(cursor.getColumnIndex(urlColumn));
                String photo = cursor.getString(cursor.getColumnIndex(photoColumn));
                int comments = cursor.getInt(cursor.getColumnIndex(numComments));
                int views = cursor.getInt(cursor.getColumnIndex(numViews));


                NewsDataModel newsDataModel = new NewsDataModel();
                newsDataModel.setNewsid(nid);
                newsDataModel.setTitle(title);
                newsDataModel.setDate(date);
                newsDataModel.setUrl(url);
                newsDataModel.setPhoto(photo);
                newsDataModel.setNumberOfComments(comments);
                newsDataModel.setViews(views);

                list.add(newsDataModel);

            } while (cursor.moveToNext());
        }


        return list;

    }

    public boolean isFavourit(String nid){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery
                ("select * from "+tableName +" where "+nidColumn +"= "+nid , null);

        if( cursor != null) {
            boolean exist = cursor.moveToFirst();

            if (exist) {
                return true;
            } else {
                return false;
            }
        }else{
            return  false;
        }

    }

    public boolean removeNews(String nid){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        int deleted=sqLiteDatabase.delete(tableName,nidColumn +"= ?",new String []  {nid});

            if (deleted != 0) {
                return true;
            } else {
                return false;
            }

    }


    public boolean updateNewsNumViewandComments(String nid , String views , String comments){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(numViews,views);
        contentValues.put(numComments,comments);


        int row=sqLiteDatabase.update(tableName , contentValues , nidColumn +"= ?",new String []  {nid} );

        if(row != -1){

            return true;

        }else {

            return  false;
        }
    }
}
