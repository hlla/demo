
package example.com.testutls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestDBHelper extends SQLiteOpenHelper {
    public static final String FIELD_SOUCE_ID = "souce_id";
    public static final String ID = "id";
    public static final String FIELD_THUMBURL = "thumbUrl";
    public static final String FIELD_LIVE_WP_DOWN_URL = "live_wp_down_url";
    public static final String FIELD_ORIENTATION = "orientation";
    private static String TAG = "WallpaperProvider";
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_TEST = "test";
    private static Object lock = new Object();

    public TestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TEST + " (" +
                "id INTEGER PRIMARY KEY," +
                FIELD_SOUCE_ID + " INTEGER," +
                FIELD_THUMBURL + " TEXT," +
                FIELD_ORIENTATION + " INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            switch (oldVersion) {
                case 1:
                    //数据库升级，添加动态壁纸下载路径字段
                    db.execSQL("ALTER TABLE " + TABLE_TEST + " ADD COLUMN " +
                            FIELD_LIVE_WP_DOWN_URL + " TEXT DEFAULT ''");
                    break;
                case 2:
                    //数据库升级，添加壁纸宽屏窄屏判断
                    db.execSQL("ALTER TABLE " + TABLE_TEST + " ADD COLUMN " + FIELD_ORIENTATION +
                            " TEXT DEFAULT " + "(hhh)");
                    break;
                default:
            }
        }
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        synchronized (lock) {
            SQLiteDatabase db = getWritableDatabase();
            return db.delete(table, whereClause, whereArgs);
        }
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        synchronized (lock) {
            SQLiteDatabase db = getWritableDatabase();
            return db.rawQuery(sql, selectionArgs);
        }
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        synchronized (lock) {
            SQLiteDatabase db = getWritableDatabase();
            return db.insert(table, nullColumnHack, values);
        }
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        synchronized (lock) {
            SQLiteDatabase db = getWritableDatabase();
            return db.update(table, values, whereClause, whereArgs);
        }
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy, String limit) {
        synchronized (lock) {
            SQLiteDatabase db = getReadableDatabase();
            return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy,
                    limit);
        }
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        synchronized (lock) {
            SQLiteDatabase db = getReadableDatabase();
            return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        }
    }
}
