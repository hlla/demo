package com.example.testbreakpoint;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Dao {
    private DBHelper dbHelper;

    public Dao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public boolean isHasInfors(String urlstr) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String sql = "select count(*)  from download_info where url=?";
        Cursor cursor = database.rawQuery(sql, new String[]{urlstr});
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count == 0;
    }

    public void saveInfos(List<DownloadInfo> infos) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        for (DownloadInfo info : infos) {
            String sql = "insert into download_info(thread_id,start_pos, end_pos,compelete_size," +
                    "url) values (?,?,?,?,?)";
            Object[] bindArgs = {info.getThreadId(), info.getStartPos(),
                    info.getEndPos(), info.getCompeleteSize(), info.getUrl()};
            database.execSQL(sql, bindArgs);
        }
    }

    public List<DownloadInfo> getInfos(String urlstr) {
        List<DownloadInfo> list = new ArrayList<DownloadInfo>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String sql = "select thread_id, start_pos, end_pos,compelete_size,url from download_info " +
                "where url=?";
        Cursor cursor = database.rawQuery(sql, new String[]{urlstr});
        while (cursor.moveToNext()) {
            DownloadInfo info = new DownloadInfo(cursor.getInt(0),
                    cursor.getInt(1), cursor.getInt(2), cursor.getInt(3),
                    cursor.getString(4));
            list.add(info);
        }
        cursor.close();
        return list;
    }

    public void updataInfos(int threadId, int compeleteSize, String urlstr) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String sql = "update download_info set compelete_size=? where thread_id=? and url=?";
        Object[] bindArgs = {compeleteSize, threadId, urlstr};
        database.execSQL(sql, bindArgs);
    }

    public void closeDb() {
        dbHelper.close();
    }

    public void delete(String url) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.delete("download_info", "url=?", new String[]{url});
        database.close();
    }
}