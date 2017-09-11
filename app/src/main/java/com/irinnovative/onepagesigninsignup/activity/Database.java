package com.irinnovative.onepagesigninsignup.activity;

/**
 * Created by Code Tribe on 2017/09/02.
 */

import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.database.sqlite.SQLiteOpenHelper;

import com.irinnovative.onepagesigninsignup.pojo.Sos;

public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    private static final String TABLE_SOS ="contact";
    private static final String COLUMN_ID = "column_id";
    private static final String COLUMN_SOS_CONTACT_ONE = "contact_one";
    private static final String COLUMN_SOS_CONTACT_TWO ="contact_two";
    private static final String COLUMN_SOS_CONTACT_THREE ="contact_three";

    private static final String COLUMN_SOS_CONTACT_MESSAGE ="contact_message";

    private static final String DATABASE_NAME = "contact.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_CONTACT ="create table "
            + TABLE_SOS
            +"  ("+ COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_SOS_CONTACT_ONE + " text not null, "
            + COLUMN_SOS_CONTACT_TWO + " text not null, "
            + COLUMN_SOS_CONTACT_THREE + " text not null, "
            + COLUMN_SOS_CONTACT_MESSAGE + " text not null);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(DATABASE_CREATE_CONTACT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("drop table if exists "+ TABLE_SOS);
        onCreate(db);
    }
    public long addPerson(Sos sos)
    {
        long id = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SOS_CONTACT_ONE, sos.getContact1());
        cv.put(COLUMN_SOS_CONTACT_TWO, sos.getContact2());
        cv.put(COLUMN_SOS_CONTACT_THREE, sos.getContact3());
        cv.put(COLUMN_SOS_CONTACT_MESSAGE, sos.getMessage());

        id= db.insert(TABLE_SOS,null,cv);

        return id;
    }


    /*
    public List<Person> getAllPeopleByName(String name)
    {
        List<Person> people = new ArrayList<Person>();

        String select_query = "select * from " + TABLE_PERSON+ " where " + COLUMN_NAME + " like ?";
        String args[] ={name};

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, args);

        if(cursor.moveToFirst())
        {
            do
            {
                Person person = new Person();
                person.setId(cursor.getLong(0));
                person.setName(cursor.getString(1));
                person.setSurname(cursor.getString(2));

                people.add(person);
            }while (cursor.moveToNext());


        }
        return people;
    }
    public List<Person> getAllPeopleBySurname(String surname)
    {
        List<Person> people = new ArrayList<Person>();

        String select_query = "select * from " + TABLE_PERSON + " where "+ COLUMN_SURNAME + " like ?";
        String args[] = {surname};

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, args);

        if(cursor.moveToFirst())
        {
            do
            {
                Person person = new Person();
                person.setId(cursor.getLong(0));
                person.setName(cursor.getString(1));
                person.setSurname(cursor.getString(2));

                people.add(person);
            }while (cursor.moveToNext());


        }
        return people;
    }
*/
    public void deletePerson(long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String ids[] = {String.valueOf(id)};
        db.delete(TABLE_SOS, COLUMN_ID + " = ?", ids);
    }
    public void updatePerson(Sos sos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SOS_CONTACT_ONE, sos.getContact1());
        cv.put(COLUMN_SOS_CONTACT_TWO, sos.getContact2());
        cv.put(COLUMN_SOS_CONTACT_THREE, sos.getContact3());
        cv.put(COLUMN_SOS_CONTACT_MESSAGE, sos.getMessage());

        String ids[] = {String.valueOf(sos.getSos_id())};

        db.update(TABLE_SOS, cv, COLUMN_ID + " = ? ", ids);
    }

}

