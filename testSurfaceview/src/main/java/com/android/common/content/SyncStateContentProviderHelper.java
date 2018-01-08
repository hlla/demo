package com.android.common.content;

import android.accounts.Account;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

public class SyncStateContentProviderHelper
{
  private static final String[] ACCOUNT_PROJECTION = { "account_name", "account_type" };
  private static long DB_VERSION = 1L;
  public static final String PATH = "syncstate";
  private static final String QUERY_COUNT_SYNC_STATE_ROWS = "SELECT count(*) FROM _sync_state WHERE _id=?";
  private static final String SELECT_BY_ACCOUNT = "account_name=? AND account_type=?";
  private static final String SYNC_STATE_META_TABLE = "_sync_state_metadata";
  private static final String SYNC_STATE_META_VERSION_COLUMN = "version";
  private static final String SYNC_STATE_TABLE = "_sync_state";
  
  private static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? == null)
      {
        if (paramT != null) {}
      }
      else {
        while ((paramT != null) && (?.equals(paramT))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS _sync_state");
    paramSQLiteDatabase.execSQL("CREATE TABLE _sync_state (_id INTEGER PRIMARY KEY,account_name TEXT NOT NULL,account_type TEXT NOT NULL,data TEXT,UNIQUE(account_name, account_type));");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS _sync_state_metadata");
    paramSQLiteDatabase.execSQL("CREATE TABLE _sync_state_metadata (version INTEGER);");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("version", Long.valueOf(DB_VERSION));
    paramSQLiteDatabase.insert("_sync_state_metadata", "version", localContentValues);
  }
  
  public int delete(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    return paramSQLiteDatabase.delete("_sync_state", paramString, paramArrayOfString);
  }
  
  public long insert(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    return paramSQLiteDatabase.replace("_sync_state", "account_name", paramContentValues);
  }
  
  public void onAccountsChanged(SQLiteDatabase paramSQLiteDatabase, Account[] paramArrayOfAccount)
  {
    Cursor localCursor = paramSQLiteDatabase.query("_sync_state", ACCOUNT_PROJECTION, null, null, null, null, null);
    try
    {
      while (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(0);
        String str2 = localCursor.getString(1);
        if (!contains(paramArrayOfAccount, new Account(str1, str2))) {
          paramSQLiteDatabase.delete("_sync_state", "account_name=? AND account_type=?", new String[] { str1, str2 });
        }
      }
      return;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public void onDatabaseOpened(SQLiteDatabase paramSQLiteDatabase)
  {
    if (DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT version FROM _sync_state_metadata", null) != DB_VERSION) {
      createDatabase(paramSQLiteDatabase);
    }
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return paramSQLiteDatabase.query("_sync_state", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(SQLiteDatabase paramSQLiteDatabase, long paramLong, Object paramObject)
  {
    if (DatabaseUtils.longForQuery(paramSQLiteDatabase, "SELECT count(*) FROM _sync_state WHERE _id=?", new String[] { Long.toString(paramLong) }) < 1L) {
      return 0;
    }
    paramSQLiteDatabase.execSQL("UPDATE _sync_state SET data=? WHERE _id=" + paramLong, new Object[] { paramObject });
    return 1;
  }
  
  public int update(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return paramSQLiteDatabase.update("_sync_state", paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/content/SyncStateContentProviderHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */