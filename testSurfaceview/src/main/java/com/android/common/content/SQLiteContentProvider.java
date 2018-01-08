package com.android.common.content;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import java.util.ArrayList;

public abstract class SQLiteContentProvider
  extends ContentProvider
  implements SQLiteTransactionListener
{
  private static final int MAX_OPERATIONS_PER_YIELD_POINT = 500;
  private static final int SLEEP_AFTER_YIELD_DELAY = 4000;
  private static final String TAG = "SQLiteContentProvider";
  private final ThreadLocal<Boolean> mApplyingBatch = new ThreadLocal();
  protected SQLiteDatabase mDb;
  private volatile boolean mNotifyChange;
  private SQLiteOpenHelper mOpenHelper;
  
  private boolean applyingBatch()
  {
    return (this.mApplyingBatch.get() != null) && (((Boolean)this.mApplyingBatch.get()).booleanValue());
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    int j = 0;
    int i = 0;
    this.mDb = this.mOpenHelper.getWritableDatabase();
    this.mDb.beginTransactionWithListener(this);
    ContentProviderResult[] arrayOfContentProviderResult;
    for (;;)
    {
      int k;
      int n;
      try
      {
        this.mApplyingBatch.set(Boolean.valueOf(true));
        int i1 = paramArrayList.size();
        arrayOfContentProviderResult = new ContentProviderResult[i1];
        k = 0;
        if (k >= i1) {
          break;
        }
        n = i + 1;
        if (n > getMaxOperationsPerYield()) {
          throw new OperationApplicationException("Too many content provider operations between yield points. The maximum number of operations per yield point is 500", j);
        }
      }
      finally
      {
        this.mApplyingBatch.set(Boolean.valueOf(false));
        this.mDb.endTransaction();
        onEndTransaction();
      }
      ContentProviderOperation localContentProviderOperation = (ContentProviderOperation)paramArrayList.get(k);
      i = n;
      int m = j;
      if (k > 0)
      {
        i = n;
        m = j;
        if (localContentProviderOperation.isYieldAllowed())
        {
          n = 0;
          boolean bool = this.mNotifyChange;
          i = n;
          m = j;
          if (this.mDb.yieldIfContendedSafely(4000L))
          {
            this.mDb = this.mOpenHelper.getWritableDatabase();
            this.mNotifyChange = bool;
            m = j + 1;
            i = n;
          }
        }
      }
      arrayOfContentProviderResult[k] = localContentProviderOperation.apply(this, arrayOfContentProviderResult, k);
      k += 1;
      j = m;
    }
    this.mDb.setTransactionSuccessful();
    this.mApplyingBatch.set(Boolean.valueOf(false));
    this.mDb.endTransaction();
    onEndTransaction();
    return arrayOfContentProviderResult;
  }
  
  protected void beforeTransactionCommit() {}
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int j = paramArrayOfContentValues.length;
    this.mDb = this.mOpenHelper.getWritableDatabase();
    this.mDb.beginTransactionWithListener(this);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        if (insertInTransaction(paramUri, paramArrayOfContentValues[i]) != null) {
          this.mNotifyChange = true;
        }
        boolean bool = this.mNotifyChange;
        SQLiteDatabase localSQLiteDatabase = this.mDb;
        this.mDb.yieldIfContendedSafely();
        this.mDb = localSQLiteDatabase;
        this.mNotifyChange = bool;
        i += 1;
      }
      finally
      {
        this.mDb.endTransaction();
      }
    }
    this.mDb.setTransactionSuccessful();
    this.mDb.endTransaction();
    onEndTransaction();
    return j;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!applyingBatch())
    {
      this.mDb = this.mOpenHelper.getWritableDatabase();
      this.mDb.beginTransactionWithListener(this);
    }
    int j;
    do
    {
      try
      {
        i = deleteInTransaction(paramUri, paramString, paramArrayOfString);
        if (i > 0) {
          this.mNotifyChange = true;
        }
        this.mDb.setTransactionSuccessful();
        this.mDb.endTransaction();
        onEndTransaction();
        return i;
      }
      finally
      {
        this.mDb.endTransaction();
      }
      j = deleteInTransaction(paramUri, paramString, paramArrayOfString);
      int i = j;
    } while (j <= 0);
    this.mNotifyChange = true;
    return j;
  }
  
  protected abstract int deleteInTransaction(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  public SQLiteOpenHelper getDatabaseHelper()
  {
    return this.mOpenHelper;
  }
  
  protected abstract SQLiteOpenHelper getDatabaseHelper(Context paramContext);
  
  public int getMaxOperationsPerYield()
  {
    return 500;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (!applyingBatch())
    {
      this.mDb = this.mOpenHelper.getWritableDatabase();
      this.mDb.beginTransactionWithListener(this);
    }
    do
    {
      try
      {
        paramUri = insertInTransaction(paramUri, paramContentValues);
        if (paramUri != null) {
          this.mNotifyChange = true;
        }
        this.mDb.setTransactionSuccessful();
        this.mDb.endTransaction();
        onEndTransaction();
        return paramUri;
      }
      finally
      {
        this.mDb.endTransaction();
      }
      paramContentValues = insertInTransaction(paramUri, paramContentValues);
      paramUri = paramContentValues;
    } while (paramContentValues == null);
    this.mNotifyChange = true;
    return paramContentValues;
  }
  
  protected abstract Uri insertInTransaction(Uri paramUri, ContentValues paramContentValues);
  
  protected abstract void notifyChange();
  
  public void onBegin()
  {
    onBeginTransaction();
  }
  
  protected void onBeginTransaction() {}
  
  public void onCommit()
  {
    beforeTransactionCommit();
  }
  
  public boolean onCreate()
  {
    this.mOpenHelper = getDatabaseHelper(getContext());
    return true;
  }
  
  protected void onEndTransaction()
  {
    if (this.mNotifyChange)
    {
      this.mNotifyChange = false;
      notifyChange();
    }
  }
  
  public void onRollback() {}
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!applyingBatch())
    {
      this.mDb = this.mOpenHelper.getWritableDatabase();
      this.mDb.beginTransactionWithListener(this);
    }
    int j;
    do
    {
      try
      {
        i = updateInTransaction(paramUri, paramContentValues, paramString, paramArrayOfString);
        if (i > 0) {
          this.mNotifyChange = true;
        }
        this.mDb.setTransactionSuccessful();
        this.mDb.endTransaction();
        onEndTransaction();
        return i;
      }
      finally
      {
        this.mDb.endTransaction();
      }
      j = updateInTransaction(paramUri, paramContentValues, paramString, paramArrayOfString);
      int i = j;
    } while (j <= 0);
    this.mNotifyChange = true;
    return j;
  }
  
  protected abstract int updateInTransaction(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/content/SQLiteContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */