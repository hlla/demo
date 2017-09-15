package com.tencent.mm.modelsimple;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Profile;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class c
{
  @TargetApi(14)
  public static String ba(Context paramContext)
  {
    GMTrace.i(1358954496000L, 10125);
    v.i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
    if (paramContext == null)
    {
      v.e("MicroMsg.ContactsUtil", "context is null.");
      GMTrace.o(1358954496000L, 10125);
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    if (!a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.ContactsUtil", "no contact permission");
      GMTrace.o(1358954496000L, 10125);
      return null;
    }
    if (f.eo(14)) {
      v.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
    }
    for (;;)
    {
      try
      {
        localObject = localContentResolver.query(ContactsContract.Profile.CONTENT_URI, new String[] { "display_name" }, null, null, null);
        if (localObject == null) {
          break label319;
        }
        if (((Cursor)localObject).moveToFirst())
        {
          String str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("display_name"));
          v.i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", new Object[] { str1 });
          ((Cursor)localObject).close();
          localObject = str1;
          if (bf.mA(str1))
          {
            paramContext = z(paramContext, d.bj(paramContext));
            if (bf.mA(paramContext))
            {
              v.i("MicroMsg.ContactsUtil", "contactId is null.");
              GMTrace.o(1358954496000L, 10125);
              return null;
            }
          }
        }
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.ContactsUtil", localException, "", new Object[0]);
        v.d("MicroMsg.ContactsUtil", "query crashed");
        Object localObject = null;
        continue;
        paramContext = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "display_name" }, "contact_id=?", new String[] { paramContext }, null);
        localObject = localException;
        if (paramContext != null)
        {
          if (paramContext.moveToFirst())
          {
            str2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            v.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", new Object[] { str2 });
          }
          paramContext.close();
          localObject = str2;
        }
        GMTrace.o(1358954496000L, 10125);
        return (String)localObject;
      }
      String str2 = null;
      continue;
      label319:
      str2 = null;
    }
  }
  
  @TargetApi(14)
  public static Bitmap bb(Context paramContext)
  {
    GMTrace.i(1359088713728L, 10126);
    v.i("MicroMsg.ContactsUtil", "Get bitmap of a contacts record or profile.");
    if (paramContext == null)
    {
      v.e("MicroMsg.ContactsUtil", "context is null.");
      GMTrace.o(1359088713728L, 10126);
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject5 = null;
    if (!a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.ContactsUtil", "no contact permission");
      GMTrace.o(1359088713728L, 10126);
      return null;
    }
    Object localObject3 = null;
    Object localObject1 = localObject5;
    if (f.eo(14))
    {
      v.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
      try
      {
        localObject1 = localContentResolver.query(ContactsContract.Profile.CONTENT_URI, new String[] { "_id" }, null, null, null);
        localObject3 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject4 = localContentResolver.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[] { "data15", "data_sync1" }, "mimetype=?", new String[] { "vnd.android.cursor.item/photo" }, null);
          localObject1 = localObject5;
          if (localObject4 == null) {
            break label524;
          }
          if (!((Cursor)localObject4).moveToFirst()) {
            break label1051;
          }
          if ((!al.isWifi(paramContext)) && (!al.is3G(paramContext)) && (!al.is4G(paramContext))) {
            break label433;
          }
          v.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject1 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("data_sync1"));
          v.i("MicroMsg.ContactsUtil", "get sync avatar url : [%s]", new Object[] { localObject1 });
          if (bf.mA((String)localObject1)) {
            break label433;
          }
          i = ((String)localObject1).lastIndexOf("https:");
          v.i("MicroMsg.ContactsUtil", "check is exist https download url :[%d]", new Object[] { Integer.valueOf(i) });
          if (i < 0) {
            break label433;
          }
          localObject3 = ((String)localObject1).substring(i);
          localObject1 = kz((String)localObject3);
          v.i("MicroMsg.ContactsUtil", "Get image from google sync account in profile,url:[%s]", new Object[] { localObject3 });
          localObject3 = localObject1;
          if (localObject1 == null) {
            break label436;
          }
          localObject3 = localObject1;
          if (((Bitmap)localObject1).isRecycled()) {
            break label436;
          }
          ((Cursor)localObject4).close();
          GMTrace.o(1359088713728L, 10126);
          return (Bitmap)localObject1;
          localException1 = localException1;
          v.printErrStackTrace("MicroMsg.ContactsUtil", localException1, "", new Object[0]);
          v.d("MicroMsg.ContactsUtil", "query crashed");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.ContactsUtil", localException2, "", new Object[0]);
            v.d("MicroMsg.ContactsUtil", "query crashed");
            localObject4 = localObject3;
          }
          localObject3 = null;
          i = ((Cursor)localObject4).getColumnIndex("data15");
          localObject2 = localObject3;
          if (i == -1) {
            break label517;
          }
          localObject5 = ((Cursor)localObject4).getBlob(i);
          v.i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", new Object[] { Boolean.valueOf(bf.bm((byte[])localObject5)) });
          localObject2 = localObject3;
          if (bf.bm((byte[])localObject5)) {
            break label517;
          }
          v.i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
          localObject2 = BitmapFactory.decodeByteArray((byte[])localObject5, 0, localObject5.length);
        }
      }
      localObject1 = localObject5;
      if (localObject3 != null)
      {
        if (((Cursor)localObject3).getCount() <= 0) {
          break label577;
        }
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      label433:
      label436:
      label517:
      ((Cursor)localObject4).close();
      for (;;)
      {
        label524:
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {
            break label891;
          }
        }
        localObject5 = z(paramContext, d.bj(paramContext));
        if (!bf.mA((String)localObject5)) {
          break;
        }
        v.i("MicroMsg.ContactsUtil", "contactId is null.");
        GMTrace.o(1359088713728L, 10126);
        return null;
        label577:
        ((Cursor)localObject3).close();
        localObject2 = localObject5;
      }
      Object localObject4 = localContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "photo_id", "raw_contact_id" }, "contact_id=?", new String[] { localObject5 }, null);
      localObject3 = localObject2;
      Cursor localCursor;
      if (localObject4 != null)
      {
        localObject3 = localObject2;
        if (((Cursor)localObject4).moveToFirst())
        {
          if ((!al.isWifi(paramContext)) && (!al.is3G(paramContext)))
          {
            localObject3 = localObject2;
            if (!al.is4G(paramContext)) {
              break label910;
            }
          }
          v.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject3 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("raw_contact_id"));
          localCursor = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "data15", "data_sync1" }, "mimetype=? AND raw_contact_id=?", new String[] { "vnd.android.cursor.item/photo", localObject3 }, null);
          localObject3 = localObject2;
          if (localCursor == null) {
            break label910;
          }
          localObject3 = localObject2;
          if (localCursor.moveToFirst())
          {
            i = localCursor.getColumnIndex("data_sync1");
            localObject3 = localObject2;
            if (i != -1)
            {
              String str = localCursor.getString(i);
              localObject3 = localObject2;
              if (!bf.mA(str))
              {
                i = str.lastIndexOf("https:");
                localObject3 = localObject2;
                if (i >= 0)
                {
                  str = str.substring(i);
                  localObject2 = kz(str);
                  localObject3 = localObject2;
                  if (localObject2 != null)
                  {
                    localObject3 = localObject2;
                    if (!((Bitmap)localObject2).isRecycled())
                    {
                      v.i("MicroMsg.ContactsUtil", "Get image from google sync account in contacts,url:[%s]", new Object[] { str });
                      localCursor.close();
                      localObject3 = localObject2;
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          label884:
          ((Cursor)localObject4).close();
        }
      }
      else
      {
        label891:
        GMTrace.o(1359088713728L, 10126);
        return (Bitmap)localObject3;
      }
      localCursor.close();
      label910:
      v.i("MicroMsg.ContactsUtil", "Get bitmap from contacts icon.");
      int i = ((Cursor)localObject4).getColumnIndex("photo_id");
      long l;
      if (i != -1)
      {
        l = ((Cursor)localObject4).getLong(i);
        v.i("MicroMsg.ContactsUtil", "Have got photoId,photoId is " + l);
      }
      for (;;)
      {
        if (l > 0L)
        {
          localObject3 = BitmapFactory.decodeStream(ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, bf.getLong((String)localObject5, 0L))));
          localObject2 = localObject3;
          if (localObject3 == null) {
            break label1026;
          }
          localObject2 = localObject3;
          if (((Bitmap)localObject3).isRecycled()) {
            break label1026;
          }
          v.i("MicroMsg.ContactsUtil", "Get image from contacts through google account.");
          break label884;
        }
        localObject2 = localObject3;
        label1026:
        if (!((Cursor)localObject4).moveToNext())
        {
          localObject3 = localObject2;
          break label884;
        }
        break;
        l = 0L;
      }
      label1051:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  private static Bitmap kz(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 291
    //   3: sipush 10127
    //   6: invokestatic 19	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc 21
    //   11: ldc_w 294
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: aastore
    //   22: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   29: ifeq +22 -> 51
    //   32: ldc 21
    //   34: ldc_w 296
    //   37: invokestatic 33	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc2_w 291
    //   43: sipush 10127
    //   46: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: invokevirtual 299	java/lang/String:trim	()Ljava/lang/String;
    //   55: astore 9
    //   57: aload 9
    //   59: ldc -74
    //   61: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifne +22 -> 86
    //   67: ldc 21
    //   69: ldc_w 304
    //   72: invokestatic 33	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc2_w 291
    //   78: sipush 10127
    //   81: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   84: aconst_null
    //   85: areturn
    //   86: new 306	java/io/ByteArrayOutputStream
    //   89: dup
    //   90: invokespecial 308	java/io/ByteArrayOutputStream:<init>	()V
    //   93: astore 8
    //   95: aconst_null
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_3
    //   101: aconst_null
    //   102: astore 7
    //   104: aconst_null
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload 9
    //   112: invokestatic 314	com/tencent/mm/network/b:mj	(Ljava/lang/String;)Lcom/tencent/mm/network/u;
    //   115: astore 4
    //   117: aload 4
    //   119: astore_3
    //   120: aload_3
    //   121: astore 4
    //   123: aload 7
    //   125: astore_0
    //   126: aload_3
    //   127: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   130: invokevirtual 326	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnonnull +97 -> 232
    //   138: aload_2
    //   139: astore 5
    //   141: aload_3
    //   142: astore 4
    //   144: aload_2
    //   145: astore_0
    //   146: aload_2
    //   147: astore 6
    //   149: ldc 21
    //   151: ldc_w 328
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload 9
    //   162: aastore
    //   163: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_3
    //   167: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   170: invokevirtual 333	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 336	java/io/InputStream:close	()V
    //   181: aload 8
    //   183: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   186: ldc2_w 291
    //   189: sipush 10127
    //   192: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_0
    //   198: ldc 21
    //   200: ldc_w 339
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_0
    //   210: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   213: aastore
    //   214: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: ldc 21
    //   219: aload_0
    //   220: ldc 118
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -43 -> 186
    //   232: aload_2
    //   233: astore 5
    //   235: aload_3
    //   236: astore 4
    //   238: aload_2
    //   239: astore_0
    //   240: aload_2
    //   241: astore 6
    //   243: sipush 1024
    //   246: newarray <illegal type>
    //   248: astore 7
    //   250: aload_2
    //   251: astore 5
    //   253: aload_3
    //   254: astore 4
    //   256: aload_2
    //   257: astore_0
    //   258: aload_2
    //   259: astore 6
    //   261: aload_2
    //   262: aload 7
    //   264: invokevirtual 346	java/io/InputStream:read	([B)I
    //   267: istore_1
    //   268: iload_1
    //   269: iconst_m1
    //   270: if_icmpeq +117 -> 387
    //   273: aload_2
    //   274: astore 5
    //   276: aload_3
    //   277: astore 4
    //   279: aload_2
    //   280: astore_0
    //   281: aload_2
    //   282: astore 6
    //   284: aload 8
    //   286: aload 7
    //   288: iconst_0
    //   289: iload_1
    //   290: invokevirtual 350	java/io/ByteArrayOutputStream:write	([BII)V
    //   293: goto -43 -> 250
    //   296: astore 6
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 5
    //   302: astore_2
    //   303: aload_0
    //   304: astore 5
    //   306: aload_3
    //   307: astore 4
    //   309: aload_2
    //   310: astore_0
    //   311: ldc 21
    //   313: ldc_w 352
    //   316: iconst_1
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload 6
    //   324: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   327: aastore
    //   328: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_3
    //   332: astore 4
    //   334: aload_2
    //   335: astore_0
    //   336: ldc 21
    //   338: aload 6
    //   340: ldc 118
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_3
    //   350: ifnull +10 -> 360
    //   353: aload_3
    //   354: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   357: invokevirtual 333	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   360: aload_2
    //   361: ifnull +7 -> 368
    //   364: aload_2
    //   365: invokevirtual 336	java/io/InputStream:close	()V
    //   368: aload 8
    //   370: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   373: aload 5
    //   375: astore_0
    //   376: ldc2_w 291
    //   379: sipush 10127
    //   382: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   385: aload_0
    //   386: areturn
    //   387: aload_2
    //   388: astore 5
    //   390: aload_3
    //   391: astore 4
    //   393: aload_2
    //   394: astore_0
    //   395: aload_2
    //   396: astore 6
    //   398: aload 8
    //   400: invokevirtual 356	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   403: invokestatic 362	com/tencent/mm/sdk/platformtools/d:bd	([B)Landroid/graphics/Bitmap;
    //   406: astore 7
    //   408: aload 7
    //   410: astore 5
    //   412: aload_3
    //   413: astore 4
    //   415: aload_2
    //   416: astore_0
    //   417: aload 8
    //   419: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   422: aload_3
    //   423: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   426: invokevirtual 333	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   429: aload 5
    //   431: astore_0
    //   432: aload_2
    //   433: ifnull -57 -> 376
    //   436: aload_2
    //   437: invokevirtual 336	java/io/InputStream:close	()V
    //   440: aload 5
    //   442: astore_0
    //   443: goto -67 -> 376
    //   446: astore_0
    //   447: ldc 21
    //   449: ldc_w 339
    //   452: iconst_1
    //   453: anewarray 4	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload_0
    //   459: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   462: aastore
    //   463: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: ldc 21
    //   468: aload_0
    //   469: ldc 118
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload 5
    //   480: astore_0
    //   481: goto -105 -> 376
    //   484: astore_0
    //   485: ldc 21
    //   487: ldc_w 339
    //   490: iconst_1
    //   491: anewarray 4	java/lang/Object
    //   494: dup
    //   495: iconst_0
    //   496: aload_0
    //   497: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   500: aastore
    //   501: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: ldc 21
    //   506: aload_0
    //   507: ldc 118
    //   509: iconst_0
    //   510: anewarray 4	java/lang/Object
    //   513: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: aload 5
    //   518: astore_0
    //   519: goto -143 -> 376
    //   522: astore 7
    //   524: aconst_null
    //   525: astore_3
    //   526: aconst_null
    //   527: astore 5
    //   529: aload_0
    //   530: astore_2
    //   531: aload_3
    //   532: astore 4
    //   534: aload_2
    //   535: astore_0
    //   536: ldc 21
    //   538: ldc_w 364
    //   541: iconst_1
    //   542: anewarray 4	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: aload 7
    //   549: invokevirtual 365	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: aastore
    //   553: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: aload_3
    //   557: astore 4
    //   559: aload_2
    //   560: astore_0
    //   561: ldc 21
    //   563: aload 7
    //   565: ldc 118
    //   567: iconst_0
    //   568: anewarray 4	java/lang/Object
    //   571: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: aload_3
    //   575: ifnull +10 -> 585
    //   578: aload_3
    //   579: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   582: invokevirtual 333	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   585: aload_2
    //   586: ifnull +7 -> 593
    //   589: aload_2
    //   590: invokevirtual 336	java/io/InputStream:close	()V
    //   593: aload 8
    //   595: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   598: aload 5
    //   600: astore_0
    //   601: goto -225 -> 376
    //   604: astore_0
    //   605: ldc 21
    //   607: ldc_w 339
    //   610: iconst_1
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: aload_0
    //   617: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   620: aastore
    //   621: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   624: ldc 21
    //   626: aload_0
    //   627: ldc 118
    //   629: iconst_0
    //   630: anewarray 4	java/lang/Object
    //   633: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: aload 5
    //   638: astore_0
    //   639: goto -263 -> 376
    //   642: astore_2
    //   643: aconst_null
    //   644: astore 4
    //   646: aload_3
    //   647: astore_0
    //   648: aload 4
    //   650: ifnull +11 -> 661
    //   653: aload 4
    //   655: getfield 320	com/tencent/mm/network/u:ieI	Ljavax/net/ssl/HttpsURLConnection;
    //   658: invokevirtual 333	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   661: aload_0
    //   662: ifnull +7 -> 669
    //   665: aload_0
    //   666: invokevirtual 336	java/io/InputStream:close	()V
    //   669: aload 8
    //   671: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   674: aload_2
    //   675: athrow
    //   676: astore_0
    //   677: ldc 21
    //   679: ldc_w 339
    //   682: iconst_1
    //   683: anewarray 4	java/lang/Object
    //   686: dup
    //   687: iconst_0
    //   688: aload_0
    //   689: invokevirtual 342	java/io/IOException:getMessage	()Ljava/lang/String;
    //   692: aastore
    //   693: invokestatic 330	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   696: ldc 21
    //   698: aload_0
    //   699: ldc 118
    //   701: iconst_0
    //   702: anewarray 4	java/lang/Object
    //   705: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: goto -34 -> 674
    //   711: astore_2
    //   712: goto -64 -> 648
    //   715: astore 7
    //   717: aconst_null
    //   718: astore 5
    //   720: aload 6
    //   722: astore_2
    //   723: goto -192 -> 531
    //   726: astore 7
    //   728: goto -197 -> 531
    //   731: astore 6
    //   733: aconst_null
    //   734: astore_3
    //   735: aconst_null
    //   736: astore 5
    //   738: goto -432 -> 306
    //   741: astore 6
    //   743: goto -437 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	paramString	String
    //   267	23	1	i	int
    //   96	494	2	localObject1	Object
    //   642	33	2	localObject2	Object
    //   711	1	2	localObject3	Object
    //   722	1	2	localObject4	Object
    //   100	635	3	localObject5	Object
    //   115	539	4	localObject6	Object
    //   108	629	5	localObject7	Object
    //   105	178	6	localObject8	Object
    //   296	43	6	localIOException1	java.io.IOException
    //   396	325	6	localObject9	Object
    //   731	1	6	localIOException2	java.io.IOException
    //   741	1	6	localIOException3	java.io.IOException
    //   102	307	7	localObject10	Object
    //   522	42	7	localException1	Exception
    //   715	1	7	localException2	Exception
    //   726	1	7	localException3	Exception
    //   93	577	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   55	106	9	str	String
    // Exception table:
    //   from	to	target	type
    //   166	173	197	java/io/IOException
    //   177	181	197	java/io/IOException
    //   181	186	197	java/io/IOException
    //   126	134	296	java/io/IOException
    //   149	166	296	java/io/IOException
    //   243	250	296	java/io/IOException
    //   261	268	296	java/io/IOException
    //   284	293	296	java/io/IOException
    //   398	408	296	java/io/IOException
    //   422	429	446	java/io/IOException
    //   436	440	446	java/io/IOException
    //   353	360	484	java/io/IOException
    //   364	368	484	java/io/IOException
    //   368	373	484	java/io/IOException
    //   110	117	522	java/lang/Exception
    //   578	585	604	java/io/IOException
    //   589	593	604	java/io/IOException
    //   593	598	604	java/io/IOException
    //   110	117	642	finally
    //   653	661	676	java/io/IOException
    //   665	669	676	java/io/IOException
    //   669	674	676	java/io/IOException
    //   126	134	711	finally
    //   149	166	711	finally
    //   243	250	711	finally
    //   261	268	711	finally
    //   284	293	711	finally
    //   311	331	711	finally
    //   336	349	711	finally
    //   398	408	711	finally
    //   417	422	711	finally
    //   536	556	711	finally
    //   561	574	711	finally
    //   126	134	715	java/lang/Exception
    //   149	166	715	java/lang/Exception
    //   243	250	715	java/lang/Exception
    //   261	268	715	java/lang/Exception
    //   284	293	715	java/lang/Exception
    //   398	408	715	java/lang/Exception
    //   417	422	726	java/lang/Exception
    //   110	117	731	java/io/IOException
    //   417	422	741	java/io/IOException
  }
  
  /* Error */
  @TargetApi(14)
  public static String y(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 367
    //   3: sipush 10123
    //   6: invokestatic 19	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc 21
    //   11: ldc_w 370
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aastore
    //   22: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: ifnonnull +22 -> 48
    //   29: ldc 21
    //   31: ldc_w 372
    //   34: invokestatic 33	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc2_w 367
    //   40: sipush 10123
    //   43: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload_0
    //   49: ldc_w 374
    //   52: invokevirtual 378	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   55: checkcast 380	android/telephony/TelephonyManager
    //   58: astore 6
    //   60: aconst_null
    //   61: astore_1
    //   62: aload 6
    //   64: invokevirtual 383	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: astore_1
    //   72: aload 6
    //   74: invokevirtual 386	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   84: ifeq +1052 -> 1136
    //   87: aload 6
    //   89: invokevirtual 389	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: astore 5
    //   96: aload_1
    //   97: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   100: ifeq +11 -> 111
    //   103: invokestatic 395	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   106: invokevirtual 398	java/util/Locale:getCountry	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: astore 7
    //   115: aload 4
    //   117: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   120: ifne +151 -> 271
    //   123: aload 4
    //   125: invokevirtual 299	java/lang/String:trim	()Ljava/lang/String;
    //   128: astore_0
    //   129: aload_0
    //   130: aload 7
    //   132: invokestatic 404	com/tencent/mm/sdk/platformtools/am:ey	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_1
    //   136: ldc 21
    //   138: ldc_w 406
    //   141: iconst_3
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_1
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: aload 7
    //   157: aastore
    //   158: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_1
    //   162: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   165: ifne +968 -> 1133
    //   168: aload_1
    //   169: invokevirtual 409	java/lang/String:length	()I
    //   172: istore_3
    //   173: aload_0
    //   174: ldc_w 411
    //   177: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   180: ifeq +86 -> 266
    //   183: iconst_1
    //   184: istore_2
    //   185: aload_0
    //   186: iload_2
    //   187: iload_3
    //   188: iadd
    //   189: invokevirtual 196	java/lang/String:substring	(I)Ljava/lang/String;
    //   192: astore_0
    //   193: ldc 21
    //   195: ldc_w 413
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: aastore
    //   206: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: ldc 21
    //   211: ldc_w 415
    //   214: invokestatic 28	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc2_w 367
    //   220: sipush 10123
    //   223: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   226: aload_0
    //   227: areturn
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 6
    //   233: aload_1
    //   234: astore 4
    //   236: aload 6
    //   238: astore_1
    //   239: ldc 21
    //   241: aload 5
    //   243: ldc 118
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: ldc 21
    //   254: ldc_w 417
    //   257: invokestatic 33	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_1
    //   261: astore 7
    //   263: goto -148 -> 115
    //   266: iconst_0
    //   267: istore_2
    //   268: goto -83 -> 185
    //   271: aload_0
    //   272: ldc 44
    //   274: invokestatic 50	com/tencent/mm/pluginsdk/i/a:aS	(Landroid/content/Context;Ljava/lang/String;)Z
    //   277: ifne +21 -> 298
    //   280: ldc 21
    //   282: ldc 52
    //   284: invokestatic 33	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: ldc2_w 367
    //   290: sipush 10123
    //   293: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   296: aconst_null
    //   297: areturn
    //   298: aload_0
    //   299: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   302: astore 9
    //   304: aconst_null
    //   305: astore 5
    //   307: aconst_null
    //   308: astore 6
    //   310: aconst_null
    //   311: astore 8
    //   313: aload 8
    //   315: astore_1
    //   316: bipush 14
    //   318: invokestatic 420	com/tencent/mm/compatible/util/f:ep	(I)Z
    //   321: ifne +270 -> 591
    //   324: ldc 21
    //   326: ldc_w 422
    //   329: invokestatic 28	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 9
    //   334: getstatic 66	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   337: iconst_1
    //   338: anewarray 68	java/lang/String
    //   341: dup
    //   342: iconst_0
    //   343: ldc_w 424
    //   346: aastore
    //   347: aconst_null
    //   348: aconst_null
    //   349: aconst_null
    //   350: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   353: astore_1
    //   354: aload_1
    //   355: ifnull +773 -> 1128
    //   358: aload_1
    //   359: invokeinterface 82 1 0
    //   364: ifeq +764 -> 1128
    //   367: aload_1
    //   368: ldc_w 424
    //   371: invokeinterface 86 2 0
    //   376: istore_2
    //   377: iload_2
    //   378: iconst_m1
    //   379: if_icmpeq +749 -> 1128
    //   382: aload_1
    //   383: iload_2
    //   384: invokeinterface 428 2 0
    //   389: istore_2
    //   390: ldc 21
    //   392: new 249	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 430
    //   399: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: iload_2
    //   403: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 28	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_1
    //   413: astore 4
    //   415: aload 4
    //   417: ifnull +20 -> 437
    //   420: aload 4
    //   422: invokeinterface 436 1 0
    //   427: ifne +10 -> 437
    //   430: aload 4
    //   432: invokeinterface 99 1 0
    //   437: aload 8
    //   439: astore_1
    //   440: iload_2
    //   441: ifle +150 -> 591
    //   444: aload 9
    //   446: getstatic 66	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   449: ldc -106
    //   451: invokestatic 156	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   454: iconst_1
    //   455: anewarray 68	java/lang/String
    //   458: dup
    //   459: iconst_0
    //   460: ldc_w 438
    //   463: aastore
    //   464: ldc -94
    //   466: iconst_1
    //   467: anewarray 68	java/lang/String
    //   470: dup
    //   471: iconst_0
    //   472: ldc_w 440
    //   475: aastore
    //   476: aconst_null
    //   477: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   480: astore_1
    //   481: aload_1
    //   482: ifnull +640 -> 1122
    //   485: aload 6
    //   487: astore 5
    //   489: aload_1
    //   490: invokeinterface 82 1 0
    //   495: ifeq +621 -> 1116
    //   498: aload 6
    //   500: astore 5
    //   502: aload_1
    //   503: ldc_w 438
    //   506: invokeinterface 86 2 0
    //   511: istore_2
    //   512: iload_2
    //   513: iconst_m1
    //   514: if_icmpeq +602 -> 1116
    //   517: aload 6
    //   519: astore 5
    //   521: aload_1
    //   522: iload_2
    //   523: invokeinterface 90 2 0
    //   528: astore 4
    //   530: aload 4
    //   532: astore 5
    //   534: ldc 21
    //   536: ldc_w 442
    //   539: iconst_1
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload 4
    //   547: aastore
    //   548: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aload_1
    //   552: invokeinterface 99 1 0
    //   557: aload_1
    //   558: astore 5
    //   560: aload 4
    //   562: astore_1
    //   563: aload 5
    //   565: ifnull +26 -> 591
    //   568: aload 4
    //   570: astore_1
    //   571: aload 5
    //   573: invokeinterface 436 1 0
    //   578: ifne +13 -> 591
    //   581: aload 5
    //   583: invokeinterface 99 1 0
    //   588: aload 4
    //   590: astore_1
    //   591: aload_1
    //   592: astore 4
    //   594: aload_1
    //   595: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   598: ifeq +224 -> 822
    //   601: aload_0
    //   602: aload_0
    //   603: invokestatic 110	com/tencent/mm/modelsimple/d:bj	(Landroid/content/Context;)Ljava/lang/String;
    //   606: invokestatic 114	com/tencent/mm/modelsimple/c:z	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   609: astore_0
    //   610: aload_1
    //   611: astore 4
    //   613: aload_0
    //   614: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   617: ifne +205 -> 822
    //   620: aload 9
    //   622: getstatic 266	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   625: iconst_1
    //   626: anewarray 68	java/lang/String
    //   629: dup
    //   630: iconst_0
    //   631: ldc_w 424
    //   634: aastore
    //   635: ldc_w 444
    //   638: iconst_1
    //   639: anewarray 68	java/lang/String
    //   642: dup
    //   643: iconst_0
    //   644: aload_0
    //   645: aastore
    //   646: aconst_null
    //   647: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   650: astore 4
    //   652: aload 4
    //   654: ifnull +457 -> 1111
    //   657: aload 4
    //   659: invokeinterface 82 1 0
    //   664: ifeq +442 -> 1106
    //   667: aload 4
    //   669: aload 4
    //   671: ldc_w 424
    //   674: invokeinterface 86 2 0
    //   679: invokeinterface 428 2 0
    //   684: istore_2
    //   685: aload 4
    //   687: invokeinterface 99 1 0
    //   692: ldc 21
    //   694: new 249	java/lang/StringBuilder
    //   697: dup
    //   698: ldc_w 430
    //   701: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   704: iload_2
    //   705: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 28	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_1
    //   715: astore 4
    //   717: iload_2
    //   718: ifle +104 -> 822
    //   721: aload 9
    //   723: getstatic 233	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   726: iconst_2
    //   727: anewarray 68	java/lang/String
    //   730: dup
    //   731: iconst_0
    //   732: ldc_w 438
    //   735: aastore
    //   736: dup
    //   737: iconst_1
    //   738: ldc_w 446
    //   741: aastore
    //   742: ldc_w 448
    //   745: iconst_1
    //   746: anewarray 68	java/lang/String
    //   749: dup
    //   750: iconst_0
    //   751: aload_0
    //   752: aastore
    //   753: aconst_null
    //   754: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   757: astore_0
    //   758: aload_1
    //   759: astore 4
    //   761: aload_0
    //   762: ifnull +60 -> 822
    //   765: aload_0
    //   766: invokeinterface 82 1 0
    //   771: ifeq +42 -> 813
    //   774: aload_0
    //   775: aload_0
    //   776: ldc_w 438
    //   779: invokeinterface 86 2 0
    //   784: invokeinterface 90 2 0
    //   789: astore_1
    //   790: aload_1
    //   791: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   794: ifne +227 -> 1021
    //   797: ldc 21
    //   799: ldc_w 450
    //   802: iconst_1
    //   803: anewarray 4	java/lang/Object
    //   806: dup
    //   807: iconst_0
    //   808: aload_1
    //   809: aastore
    //   810: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   813: aload_0
    //   814: invokeinterface 99 1 0
    //   819: aload_1
    //   820: astore 4
    //   822: aload 4
    //   824: astore_1
    //   825: aload 4
    //   827: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   830: ifne +113 -> 943
    //   833: aload 4
    //   835: aload 7
    //   837: invokestatic 404	com/tencent/mm/sdk/platformtools/am:ey	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   840: astore 5
    //   842: ldc 21
    //   844: ldc_w 452
    //   847: iconst_3
    //   848: anewarray 4	java/lang/Object
    //   851: dup
    //   852: iconst_0
    //   853: aload 4
    //   855: aastore
    //   856: dup
    //   857: iconst_1
    //   858: aload 5
    //   860: aastore
    //   861: dup
    //   862: iconst_2
    //   863: aload 7
    //   865: aastore
    //   866: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   869: aload 4
    //   871: astore_1
    //   872: aload 5
    //   874: invokestatic 105	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   877: ifne +50 -> 927
    //   880: aload 4
    //   882: ldc_w 411
    //   885: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   888: ifeq +145 -> 1033
    //   891: new 249	java/lang/StringBuilder
    //   894: dup
    //   895: ldc_w 411
    //   898: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   901: aload 5
    //   903: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: astore_0
    //   910: aload 4
    //   912: astore_1
    //   913: aload_0
    //   914: ifnull +13 -> 927
    //   917: aload 4
    //   919: aload_0
    //   920: invokevirtual 409	java/lang/String:length	()I
    //   923: invokevirtual 196	java/lang/String:substring	(I)Ljava/lang/String;
    //   926: astore_1
    //   927: ldc 21
    //   929: ldc_w 457
    //   932: iconst_1
    //   933: anewarray 4	java/lang/Object
    //   936: dup
    //   937: iconst_0
    //   938: aload_1
    //   939: aastore
    //   940: invokestatic 95	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   943: ldc2_w 367
    //   946: sipush 10123
    //   949: invokestatic 36	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   952: aload_1
    //   953: areturn
    //   954: astore 4
    //   956: iconst_0
    //   957: istore_2
    //   958: aconst_null
    //   959: astore_1
    //   960: ldc 21
    //   962: aload 4
    //   964: ldc 118
    //   966: iconst_0
    //   967: anewarray 4	java/lang/Object
    //   970: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   973: ldc 21
    //   975: ldc 124
    //   977: invokestatic 127	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   980: aload_1
    //   981: astore 4
    //   983: goto -568 -> 415
    //   986: astore 6
    //   988: aload 5
    //   990: astore_1
    //   991: ldc 21
    //   993: aload 6
    //   995: ldc 118
    //   997: iconst_0
    //   998: anewarray 4	java/lang/Object
    //   1001: invokestatic 122	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1004: ldc 21
    //   1006: ldc 124
    //   1008: invokestatic 127	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload 4
    //   1013: astore 5
    //   1015: aload_1
    //   1016: astore 4
    //   1018: goto -458 -> 560
    //   1021: aload_0
    //   1022: invokeinterface 288 1 0
    //   1027: ifne -253 -> 774
    //   1030: goto -217 -> 813
    //   1033: aload 5
    //   1035: astore_0
    //   1036: aload 4
    //   1038: aload 5
    //   1040: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1043: ifne -133 -> 910
    //   1046: aconst_null
    //   1047: astore_0
    //   1048: goto -138 -> 910
    //   1051: astore 6
    //   1053: aload_1
    //   1054: astore 4
    //   1056: aload 5
    //   1058: astore_1
    //   1059: goto -68 -> 991
    //   1062: astore 6
    //   1064: aload 4
    //   1066: astore 5
    //   1068: aload_1
    //   1069: astore 4
    //   1071: aload 5
    //   1073: astore_1
    //   1074: goto -83 -> 991
    //   1077: astore 4
    //   1079: iconst_0
    //   1080: istore_2
    //   1081: goto -121 -> 960
    //   1084: astore 4
    //   1086: goto -126 -> 960
    //   1089: astore 6
    //   1091: aload 5
    //   1093: astore_1
    //   1094: aload 6
    //   1096: astore 5
    //   1098: goto -859 -> 239
    //   1101: astore 5
    //   1103: goto -864 -> 239
    //   1106: iconst_0
    //   1107: istore_2
    //   1108: goto -423 -> 685
    //   1111: iconst_0
    //   1112: istore_2
    //   1113: goto -421 -> 692
    //   1116: aconst_null
    //   1117: astore 4
    //   1119: goto -568 -> 551
    //   1122: aconst_null
    //   1123: astore 4
    //   1125: goto -568 -> 557
    //   1128: iconst_0
    //   1129: istore_2
    //   1130: goto -740 -> 390
    //   1133: goto -924 -> 209
    //   1136: aload 5
    //   1138: astore_1
    //   1139: goto -1046 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	paramContext	Context
    //   0	1142	1	paramString	String
    //   184	946	2	i	int
    //   172	17	3	j	int
    //   67	851	4	localObject1	Object
    //   954	9	4	localException1	Exception
    //   981	89	4	str1	String
    //   1077	1	4	localException2	Exception
    //   1084	1	4	localException3	Exception
    //   1117	7	4	localObject2	Object
    //   77	35	5	str2	String
    //   228	14	5	localException4	Exception
    //   305	792	5	localObject3	Object
    //   1101	36	5	localException5	Exception
    //   58	460	6	localTelephonyManager	android.telephony.TelephonyManager
    //   986	8	6	localException6	Exception
    //   1051	1	6	localException7	Exception
    //   1062	1	6	localException8	Exception
    //   1089	6	6	localException9	Exception
    //   113	751	7	str3	String
    //   311	127	8	localObject4	Object
    //   302	420	9	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   62	69	228	java/lang/Exception
    //   72	79	228	java/lang/Exception
    //   332	354	954	java/lang/Exception
    //   444	481	986	java/lang/Exception
    //   489	498	1051	java/lang/Exception
    //   502	512	1051	java/lang/Exception
    //   521	530	1051	java/lang/Exception
    //   534	551	1051	java/lang/Exception
    //   551	557	1062	java/lang/Exception
    //   358	377	1077	java/lang/Exception
    //   382	390	1077	java/lang/Exception
    //   390	412	1084	java/lang/Exception
    //   79	93	1089	java/lang/Exception
    //   96	111	1101	java/lang/Exception
  }
  
  private static String z(Context paramContext, String paramString)
  {
    Object localObject = null;
    GMTrace.i(1358820278272L, 10124);
    v.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", new Object[] { paramString });
    if (paramContext == null)
    {
      v.e("MicroMsg.ContactsUtil", "context is null.");
      GMTrace.o(1358820278272L, 10124);
      return null;
    }
    if (bf.mA(paramString))
    {
      v.i("MicroMsg.ContactsUtil", "email is null.");
      GMTrace.o(1358820278272L, 10124);
      return null;
    }
    for (;;)
    {
      try
      {
        localCursor = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "contact_id", "data1" }, "data1=?", new String[] { paramString }, null);
        if (localCursor == null) {
          continue;
        }
        bool = localCursor.moveToFirst();
        if (!bool) {
          continue;
        }
        paramString = (String)localObject;
      }
      catch (Exception paramString)
      {
        Cursor localCursor;
        boolean bool;
        paramContext = null;
        v.printErrStackTrace("MicroMsg.ContactsUtil", paramString, "getContactIdByEmail error", new Object[0]);
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
      }
      try
      {
        paramContext = localCursor.getString(localCursor.getColumnIndex("contact_id"));
        paramString = paramContext;
        if (!bf.mA(paramContext))
        {
          paramString = paramContext;
          v.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", new Object[] { paramContext });
        }
      }
      catch (Exception localException)
      {
        paramContext = paramString;
        paramString = localException;
        continue;
      }
      try
      {
        localCursor.close();
        GMTrace.o(1358820278272L, 10124);
        return paramContext;
      }
      catch (Exception paramString)
      {
        continue;
      }
      paramString = paramContext;
      bool = localCursor.moveToNext();
      paramString = paramContext;
      if (bool) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */