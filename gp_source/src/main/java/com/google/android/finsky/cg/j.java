package com.google.android.finsky.cg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.finsky.utils.FinskyLog;

final class j
  extends SQLiteOpenHelper
{
  public j(Context paramContext, String paramString)
  {
    super(paramContext, g.a(paramString), null, 34);
  }
  
  private final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE appstate");
      onCreate(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        FinskyLog.c("Unable to drop table: %s", new Object[] { localSQLException });
      }
    }
  }
  
  @SuppressLint({"SQLiteString"})
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE appstate (package_name STRING, auto_update INTEGER, desired_version INTEGER, download_uri STRING, delivery_data BLOB, delivery_data_timestamp_ms INTEGER,installer_state INTEGER, first_download_ms INTEGER, referrer STRING, account STRING, title STRING,flags INTEGER, continue_url STRING, last_notified_version INTEGER, last_update_timestamp_ms INTEGER, account_for_update STRING, auto_acquire_tags STRING, external_referrer_timestamp_ms INTEGER, persistent_flags INTEGER, permissions_version INTEGER, delivery_token STRING,completed_split_ids STRING, active_split_id STRING, request_id STRING,managed_configuration_token BLOB, total_completed_bytes_downloaded INTEGER,app_details BLOB, install_client_event_id INTEGER,last_client_event_id INTEGER, requesting_package_name STRING,update_discovered_timestamp_ms INTEGER, install_logging_context BLOB, logging_context BLOB, install_request_timestamp_ms INTEGER, desired_derived_apk_id INTEGER, notification_intent STRING, auto_update_flow_policy BLOB, install_reason STRING, sandbox_version INTEGER,requested_modules TEXT, install_request_data BLOB, active_accelerator_index INTEGER,PRIMARY KEY (package_name))");
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    FinskyLog.a("Downgrading InstallerDataStore from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a(paramSQLiteDatabase);
  }
  
  @SuppressLint({"SQLiteString"})
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      a(paramSQLiteDatabase);
      return;
    case 7: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN continue_url STRING");
    case 8: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN delivery_data_timestamp_ms INTEGER");
    case 9: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN last_notified_version INTEGER");
    case 10: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN last_update_timestamp_ms INTEGER");
    case 11: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN account_for_update STRING");
    case 12: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN auto_acquire_tags STRING");
    case 13: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN external_referrer_timestamp_ms INTEGER");
    case 14: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN persistent_flags INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN permissions_version INTEGER");
    case 15: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN delivery_token STRING");
    case 16: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN completed_split_ids STRING");
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN active_split_id STRING");
    case 17: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN request_id STRING");
    case 18: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN managed_configuration_token BLOB");
    case 19: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN total_completed_bytes_downloaded INTEGER");
    case 20: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN app_details BLOB");
    case 21: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN install_client_event_id INTEGER");
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN last_client_event_id INTEGER");
    case 22: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN requesting_package_name STRING");
    case 23: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN update_discovered_timestamp_ms INTEGER");
    case 24: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN install_logging_context BLOB");
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN logging_context BLOB");
    case 25: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN install_request_timestamp_ms INTEGER");
    case 26: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN desired_derived_apk_id INTEGER");
    case 27: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN notification_intent STRING");
    case 28: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN auto_update_flow_policy BLOB");
    case 29: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN install_reason STRING");
    case 30: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN sandbox_version INTEGER default 1");
    case 31: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN requested_modules TEXT");
    case 32: 
      paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN install_request_data BLOB");
    }
    paramSQLiteDatabase.execSQL("ALTER TABLE appstate ADD COLUMN active_accelerator_index INTEGER");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */