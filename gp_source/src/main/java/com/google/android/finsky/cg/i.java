package com.google.android.finsky.cg;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.utils.FinskyLog;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.g;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

public final class i
  implements b
{
  private static final String[] a = { "package_name", "auto_update", "desired_version", "download_uri", "delivery_data", "delivery_data_timestamp_ms", "installer_state", "first_download_ms", "referrer", "account", "title", "flags", "continue_url", "last_notified_version", "last_update_timestamp_ms", "account_for_update", "auto_acquire_tags", "external_referrer_timestamp_ms", "persistent_flags", "permissions_version", "delivery_token", "completed_split_ids", "active_split_id", "request_id", "managed_configuration_token", "total_completed_bytes_downloaded", "app_details", "install_client_event_id", "last_client_event_id", "requesting_package_name", "update_discovered_timestamp_ms", "install_logging_context", "logging_context", "install_request_timestamp_ms", "desired_derived_apk_id", "notification_intent", "auto_update_flow_policy", "install_reason", "sandbox_version", "requested_modules", "install_request_data", "active_accelerator_index" };
  private final j b;
  
  public i(Context paramContext, String paramString)
  {
    this.b = new j(paramContext, paramString);
  }
  
  private static c a(Cursor paramCursor)
  {
    String str1 = paramCursor.getString(0);
    int i;
    if (!paramCursor.isNull(1)) {
      i = paramCursor.getInt(1);
    }
    for (;;)
    {
      int j;
      label45:
      int k;
      label65:
      int m;
      if (!paramCursor.isNull(2))
      {
        j = paramCursor.getInt(2);
        if (!paramCursor.isNull(38))
        {
          k = paramCursor.getInt(38);
          if (!paramCursor.isNull(13))
          {
            m = paramCursor.getInt(13);
            label86:
            if (paramCursor.isNull(4)) {}
          }
        }
      }
      try
      {
        locala = com.google.wireless.android.finsky.b.a.a(paramCursor.getBlob(4));
        l1 = paramCursor.getLong(5);
        i1 = paramCursor.getInt(6);
        str2 = paramCursor.getString(3);
        l2 = paramCursor.getLong(7);
        str3 = paramCursor.getString(8);
        str4 = paramCursor.getString(9);
        str5 = paramCursor.getString(10);
        i2 = paramCursor.getInt(11);
        str6 = paramCursor.getString(12);
        l3 = paramCursor.getLong(14);
        str7 = paramCursor.getString(15);
        l4 = paramCursor.getLong(17);
        i3 = paramCursor.getInt(18);
        i4 = paramCursor.getInt(19);
        str8 = paramCursor.getString(20);
        if (!paramCursor.isNull(21))
        {
          localObject1 = paramCursor.getString(21);
          arrayOfString = com.google.android.finsky.utils.j.a((String)localObject1);
          str9 = paramCursor.getString(22);
          str10 = paramCursor.getString(23);
          arrayOfByte = paramCursor.getBlob(24);
          l5 = paramCursor.getLong(25);
          if (paramCursor.isNull(26)) {}
        }
      }
      catch (InvalidProtocolBufferNanoException localURISyntaxException)
      {
        try
        {
          localo = o.a(paramCursor.getBlob(26));
          l6 = paramCursor.getLong(27);
          l7 = paramCursor.getLong(28);
          str11 = paramCursor.getString(29);
          l8 = paramCursor.getLong(30);
        }
        catch (InvalidProtocolBufferNanoException localURISyntaxException)
        {
          try
          {
            if (!paramCursor.isNull(31)) {
              localObject1 = com.google.android.finsky.e.a.a.a(paramCursor.getBlob(31));
            }
          }
          catch (InvalidProtocolBufferNanoException localURISyntaxException)
          {
            try
            {
              if (!paramCursor.isNull(32))
              {
                localObject4 = com.google.android.finsky.e.a.a.a(paramCursor.getBlob(32));
                localObject6 = localObject1;
                localObject1 = localObject4;
                localObject4 = localObject6;
                localObject8 = localObject4;
                if (localObject4 == null) {
                  localObject8 = new com.google.android.finsky.e.a.a();
                }
                localObject9 = localObject1;
                if (localObject1 == null) {
                  localObject9 = new com.google.android.finsky.e.a.a();
                }
                l9 = paramCursor.getLong(33);
                if (!paramCursor.isNull(34))
                {
                  n = paramCursor.getInt(34);
                  if (!paramCursor.isNull(35)) {
                    localObject4 = paramCursor.getString(35);
                  }
                }
              }
            }
            catch (InvalidProtocolBufferNanoException localURISyntaxException)
            {
              try
              {
                localObject1 = Intent.parseUri((String)localObject4, 1);
                localObject4 = paramCursor.getString(37);
                localObject10 = localObject4;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  localObject10 = "unknown";
                }
                if (!paramCursor.isNull(39))
                {
                  localObject6 = com.google.android.finsky.utils.j.a(paramCursor.getString(39));
                  localObject4 = localObject6;
                  if (localObject6.length == 0) {
                    localObject4 = null;
                  }
                  if (paramCursor.isNull(40)) {}
                }
              }
              catch (URISyntaxException localURISyntaxException)
              {
                try
                {
                  Object localObject6;
                  for (;;)
                  {
                    long l1;
                    int i1;
                    String str2;
                    long l2;
                    String str3;
                    String str4;
                    String str5;
                    int i2;
                    String str6;
                    long l3;
                    String str7;
                    long l4;
                    int i3;
                    int i4;
                    String str8;
                    String[] arrayOfString;
                    String str9;
                    String str10;
                    byte[] arrayOfByte;
                    long l5;
                    long l6;
                    long l7;
                    String str11;
                    long l8;
                    Object localObject8;
                    Object localObject9;
                    long l9;
                    Object localObject10;
                    for (localObject6 = com.google.android.finsky.installer.b.a.d.a(paramCursor.getBlob(40));; localObject6 = null)
                    {
                      localObject1 = new c(str1, i, j, k, m, locala, l1, i1, str2, l2, str3, str6, str4, str5, i2, l3, str7, l4, i3, i4, str8, arrayOfString, str9, str10, arrayOfByte, l5, localo, l6, l7, str11, l8, (com.google.android.finsky.e.a.a)localObject8, (com.google.android.finsky.e.a.a)localObject9, l9, n, (Intent)localObject1, (String)localObject10, (String[])localObject4, (com.google.android.finsky.installer.b.a.d)localObject6, paramCursor.getInt(41));
                      i = ((c)localObject1).s;
                      k = ((c)localObject1).H;
                      n = ((c)localObject1).G;
                      if ((i & 0x40) != 0)
                      {
                        j = 1;
                        i &= 0xFFFFFFBF;
                        k |= 0x1;
                      }
                      for (;;)
                      {
                        m = i;
                        if ((i & 0x100) != 0)
                        {
                          m = i & 0xFEFF;
                          j = 1;
                          n = 1;
                        }
                        paramCursor = (Cursor)localObject1;
                        if (j != 0)
                        {
                          paramCursor = new d(((c)localObject1).F);
                          paramCursor.f(m);
                          paramCursor.g(k);
                          paramCursor.h(n);
                          paramCursor = paramCursor.a;
                        }
                        return paramCursor;
                        j = 0;
                      }
                    }
                    Object localObject4 = null;
                    continue;
                    Object localObject1 = null;
                    continue;
                    int n = 0;
                    continue;
                    localObject4 = null;
                    continue;
                    localObject1 = null;
                    continue;
                    o localo = null;
                    continue;
                    localObject1 = null;
                    continue;
                    com.google.wireless.android.finsky.b.a locala = null;
                    continue;
                    m = -1;
                    break label86;
                    k = 1;
                    break label65;
                    j = -1;
                    break label45;
                    i = 0;
                    break;
                    localInvalidProtocolBufferNanoException1 = localInvalidProtocolBufferNanoException1;
                    FinskyLog.c("Couldn't parse blob as AndroidAppDeliveryData: %s", new Object[] { localInvalidProtocolBufferNanoException1 });
                    locala = null;
                    continue;
                    localInvalidProtocolBufferNanoException2 = localInvalidProtocolBufferNanoException2;
                    FinskyLog.c("Couldn't parse blob as AppDetails: %s", new Object[] { localInvalidProtocolBufferNanoException2 });
                    localo = null;
                  }
                  localInvalidProtocolBufferNanoException3 = localInvalidProtocolBufferNanoException3;
                  Object localObject2 = null;
                  for (;;)
                  {
                    FinskyLog.b(localInvalidProtocolBufferNanoException3, "Error while parsing LoggingContextState proto", new Object[0]);
                    localObject6 = null;
                    Object localObject5 = localObject2;
                    localObject2 = localObject6;
                    break;
                    localInvalidProtocolBufferNanoException4 = localInvalidProtocolBufferNanoException4;
                  }
                  localURISyntaxException = localURISyntaxException;
                  FinskyLog.c("Could not parse string as WebAPK notification intent: %s", new Object[] { FinskyLog.a(localInvalidProtocolBufferNanoException4) });
                  Object localObject3 = null;
                }
                catch (InvalidProtocolBufferNanoException localInvalidProtocolBufferNanoException5)
                {
                  for (;;)
                  {
                    FinskyLog.b(localInvalidProtocolBufferNanoException5, "Error while parsing InstallRequestData proto", new Object[0]);
                    Object localObject7 = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public final c a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/google/android/finsky/cg/i:b	Lcom/google/android/finsky/cg/j;
    //   6: invokevirtual 242	com/google/android/finsky/cg/j:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: ldc -12
    //   11: getstatic 100	com/google/android/finsky/cg/i:a	[Ljava/lang/String;
    //   14: ldc -10
    //   16: iconst_1
    //   17: anewarray 14	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 252	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface 256 1 0
    //   37: iconst_1
    //   38: if_icmpne +25 -> 63
    //   41: aload_2
    //   42: invokeinterface 260 1 0
    //   47: pop
    //   48: aload_2
    //   49: invokestatic 262	com/google/android/finsky/cg/i:a	(Landroid/database/Cursor;)Lcom/google/android/finsky/cg/c;
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 265 1 0
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aload_2
    //   64: invokeinterface 265 1 0
    //   69: aconst_null
    //   70: astore_1
    //   71: goto -12 -> 59
    //   74: astore_1
    //   75: aload_2
    //   76: invokeinterface 265 1 0
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	i
    //   0	88	1	paramString	String
    //   30	46	2	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   31	53	74	finally
    //   2	31	83	finally
    //   53	59	83	finally
    //   63	69	83	finally
    //   75	83	83	finally
  }
  
  public final Collection a()
  {
    try
    {
      localCursor = this.b.getWritableDatabase().query("appstate", a, null, null, null, null, null);
      localArrayList = new ArrayList(localCursor.getCount());
    }
    finally
    {
      try
      {
        Cursor localCursor;
        ArrayList localArrayList;
        while (localCursor.moveToNext()) {
          localArrayList.add(a(localCursor));
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    ((Cursor)localObject).close();
    return localCollection;
  }
  
  public final void a(c paramc)
  {
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("package_name", paramc.F);
        localContentValues.put("auto_update", Integer.valueOf(paramc.f));
        localContentValues.put("desired_version", Integer.valueOf(paramc.n));
        localContentValues.put("sandbox_version", Integer.valueOf(paramc.m));
        localContentValues.put("download_uri", paramc.o);
        Object localObject = paramc.i;
        if (localObject == null) {
          break label566;
        }
        localContentValues.put("delivery_data", g.a((g)localObject));
        localContentValues.put("delivery_data_timestamp_ms", Long.valueOf(paramc.j));
        localContentValues.put("installer_state", Integer.valueOf(paramc.y));
        localContentValues.put("first_download_ms", Long.valueOf(paramc.r));
        localContentValues.put("referrer", paramc.p);
        localContentValues.put("account", paramc.b);
        localContentValues.put("title", paramc.L);
        localContentValues.put("flags", Integer.valueOf(paramc.s));
        localContentValues.put("continue_url", paramc.h);
        localContentValues.put("last_notified_version", Integer.valueOf(paramc.A));
        localContentValues.put("last_update_timestamp_ms", Long.valueOf(paramc.B));
        localContentValues.put("account_for_update", paramc.a);
        localContentValues.put("external_referrer_timestamp_ms", Long.valueOf(paramc.q));
        localContentValues.put("persistent_flags", Integer.valueOf(paramc.H));
        localContentValues.put("permissions_version", Integer.valueOf(paramc.G));
        localContentValues.put("delivery_token", paramc.k);
        localContentValues.put("completed_split_ids", com.google.android.finsky.utils.j.a(paramc.a()));
        localContentValues.put("active_split_id", paramc.d);
        localContentValues.put("request_id", paramc.I);
        localContentValues.put("managed_configuration_token", paramc.D);
        localContentValues.put("total_completed_bytes_downloaded", Long.valueOf(paramc.M));
        localObject = paramc.e;
        if (localObject == null) {
          break label557;
        }
        localContentValues.put("app_details", g.a((g)localObject));
        localContentValues.put("install_client_event_id", Long.valueOf(paramc.t));
        localContentValues.put("last_client_event_id", Long.valueOf(paramc.z));
        localContentValues.put("requesting_package_name", paramc.K);
        localContentValues.put("update_discovered_timestamp_ms", Long.valueOf(paramc.N));
        localContentValues.put("install_logging_context", g.a(paramc.d()));
        localContentValues.put("logging_context", g.a(paramc.e()));
        localContentValues.put("install_request_timestamp_ms", Long.valueOf(paramc.x));
        localContentValues.put("desired_derived_apk_id", Integer.valueOf(paramc.l));
        localContentValues.put("install_reason", paramc.v);
        localObject = paramc.E;
        if (localObject != null)
        {
          localContentValues.put("notification_intent", ((Intent)localObject).toUri(1));
          localContentValues.put("requested_modules", com.google.android.finsky.utils.j.a(paramc.J));
          localObject = paramc.w;
          if (localObject != null)
          {
            localContentValues.put("install_request_data", g.a((g)localObject));
            localContentValues.put("active_accelerator_index", Integer.valueOf(paramc.c));
            this.b.getWritableDatabase().replace("appstate", null, localContentValues);
            return;
          }
          localContentValues.putNull("install_request_data");
          continue;
        }
        localContentValues.putNull("notification_intent");
      }
      finally {}
      continue;
      label557:
      localContentValues.putNull("app_details");
      continue;
      label566:
      localContentValues.putNull("delivery_data");
    }
  }
  
  public final void a(f paramf)
  {
    try
    {
      if (this.b.getWritableDatabase().update("appstate", paramf.a, "package_name = ?", new String[] { paramf.b }) == 0) {
        this.b.getWritableDatabase().insert("appstate", null, paramf.a);
      }
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).e(paramInt).a(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, o paramo)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(paramo).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, com.google.wireless.android.finsky.b.a parama, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(parama, paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).b(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(paramArrayOfByte).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, String[] paramArrayOfString)
  {
    try
    {
      a(d.a(a(paramString), paramString).a(paramArrayOfString).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).b(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).b(paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).e(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void c(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).d(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void c(String paramString, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).c(paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).f(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void d(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).f(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).d(paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).g(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void e(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).g(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(String paramString, long paramLong)
  {
    try
    {
      a(d.a(a(paramString), paramString).e(paramLong).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(String paramString1, String paramString2)
  {
    try
    {
      a(d.a(a(paramString1), paramString1).h(paramString2).a);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void f(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).h(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void g(String paramString, int paramInt)
  {
    try
    {
      a(d.a(a(paramString), paramString).j(paramInt).a);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */