package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static String Dg(String paramString)
  {
    GMTrace.i(723836207104L, 5393);
    String str = paramString.trim();
    boolean bool = str.startsWith("+");
    paramString = str;
    if (bool)
    {
      paramString = str;
      if (str.length() > 1) {
        paramString = str.substring(1, str.length());
      }
    }
    paramString = Pattern.compile("[^0-9]").matcher(paramString);
    if (bool) {}
    for (paramString = "+" + paramString.replaceAll("").trim();; paramString = paramString.replaceAll("").trim())
    {
      GMTrace.o(723836207104L, 5393);
      return paramString;
    }
  }
  
  public static boolean Lz(String paramString)
  {
    GMTrace.i(723701989376L, 5392);
    if (paramString.length() <= 0)
    {
      GMTrace.o(723701989376L, 5392);
      return false;
    }
    GMTrace.o(723701989376L, 5392);
    return true;
  }
  
  public static Bitmap a(String paramString, Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(724909948928L, 5401);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(724909948928L, 5401);
      return null;
    }
    paramContext = paramContext.getContentResolver();
    try
    {
      long l = Long.parseLong(paramString);
      paramContext = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), paramBoolean);
      if (paramContext == null)
      {
        GMTrace.o(724909948928L, 5401);
        return null;
      }
      Bitmap localBitmap = d.decodeStream(paramContext);
      paramContext = localBitmap;
      if (localBitmap != null) {
        paramContext = d.a(localBitmap, true, 4.0F);
      }
      GMTrace.o(724909948928L, 5401);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getAvatar, contactId:%s", new Object[] { paramString });
      GMTrace.o(724909948928L, 5401);
    }
    return null;
  }
  
  public static boolean b(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    GMTrace.i(725044166656L, 5402);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(725044166656L, 5402);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(725044166656L, 5402);
      return false;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getContentResolver();
        l = Long.parseLong(paramString);
        localContentValues = new ContentValues();
        paramString = String.format("%s=%d and %s='%s'", new Object[] { "raw_contact_id", Long.valueOf(l), "mimetype", "vnd.android.cursor.item/photo" });
        v.d("MicroMsg.AddressBookUtil", "where is %s", new Object[] { paramString });
        paramString = paramContext.query(ContactsContract.Data.CONTENT_URI, null, paramString, null, null);
      }
      catch (Exception paramString)
      {
        long l;
        ContentValues localContentValues;
        paramContext = null;
        continue;
        int i = -1;
        continue;
      }
      try
      {
        i = paramString.getColumnIndexOrThrow("_id");
        if (!paramString.moveToFirst()) {
          continue;
        }
        i = paramString.getInt(i);
        paramString.close();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("is_super_primary", Integer.valueOf(1));
        localContentValues.put("data15", paramArrayOfByte);
        localContentValues.put("mimetype", "vnd.android.cursor.item/photo");
        if (i < 0) {
          continue;
        }
        if (paramContext.update(ContactsContract.Data.CONTENT_URI, localContentValues, "_id = " + i, null) > 0)
        {
          GMTrace.o(725044166656L, 5402);
          return true;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramContext = paramString;
        paramString = paramArrayOfByte;
        v.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "", new Object[0]);
        if ((paramContext != null) && (!paramContext.isClosed())) {
          paramContext.close();
        }
        GMTrace.o(725044166656L, 5402);
        return false;
      }
    }
    GMTrace.o(725044166656L, 5402);
    return false;
    paramContext.insert(ContactsContract.Data.CONTENT_URI, localContentValues);
    GMTrace.o(725044166656L, 5402);
    return true;
  }
  
  public static String[] b(Context paramContext, Uri paramUri)
  {
    GMTrace.i(723970424832L, 5394);
    if (paramUri == null)
    {
      v.d("MicroMsg.AddressBookUtil", "uri == null");
      GMTrace.o(723970424832L, 5394);
      return null;
    }
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(723970424832L, 5394);
      return null;
    }
    Cursor localCursor1;
    label348:
    Object localObject;
    try
    {
      localCursor1 = paramContext.getContentResolver().query(paramUri, null, null, null, null);
      if ((localCursor1 != null) && (localCursor1.getCount() > 0))
      {
        localCursor1.moveToFirst();
        i = localCursor1.getColumnIndex("has_phone_number");
        if ((i <= 0) || (localCursor1.getInt(i) > 0)) {
          paramUri = localCursor1.getString(localCursor1.getColumnIndex("_id"));
        }
      }
    }
    catch (Exception paramUri)
    {
      try
      {
        int i;
        localCursor2 = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + paramUri, null, null);
        if ((localCursor2 != null) && (localCursor2.moveToFirst()))
        {
          str = null;
          for (paramContext = null;; paramContext = paramUri)
          {
            paramUri = paramContext;
            if (localCursor2.isAfterLast()) {
              break label441;
            }
            i = localCursor2.getColumnIndex("data1");
            int j = localCursor2.getColumnIndex("display_name");
            paramUri = localCursor2.getString(i);
            str = localCursor2.getString(j);
            v.d("MicroMsg.AddressBookUtil", "username : " + str);
            if (paramUri == null) {
              break label557;
            }
            v.d("MicroMsg.AddressBookUtil", "phoneNumber : " + paramUri);
            if (paramUri != null) {
              break;
            }
            paramUri = null;
            v.d("MicroMsg.AddressBookUtil", "phoneNumber : " + paramUri);
            if (!PhoneNumberUtils.isGlobalPhoneNumber(paramUri)) {
              break label552;
            }
            v.d("MicroMsg.AddressBookUtil", "phoneResult : " + paramUri);
            localCursor2.moveToNext();
          }
          paramUri = paramUri;
          v.printErrStackTrace("MicroMsg.AddressBookUtil", paramUri, "getContactsInfo1:", new Object[0]);
          localCursor1 = null;
        }
      }
      catch (Exception paramContext)
      {
        Cursor localCursor2;
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getContactsInfo2:", new Object[0]);
          localCursor2 = null;
          continue;
          localObject = paramUri.replaceAll("\\D", "");
          paramUri = (Uri)localObject;
          if (((String)localObject).startsWith("86")) {
            paramUri = ((String)localObject).substring(2);
          }
        }
        String str = null;
        paramUri = null;
        label441:
        paramContext = str;
        localObject = paramUri;
        if (localCursor2 != null)
        {
          paramContext = str;
          localObject = paramUri;
          if (!localCursor2.isClosed())
          {
            localCursor2.close();
            localObject = paramUri;
            paramContext = str;
          }
        }
      }
    }
    for (;;)
    {
      if ((localCursor1 != null) && (!localCursor1.isClosed())) {
        localCursor1.close();
      }
      if ((TextUtils.isEmpty(paramContext)) && (TextUtils.isEmpty((CharSequence)localObject)))
      {
        GMTrace.o(723970424832L, 5394);
        return null;
      }
      GMTrace.o(723970424832L, 5394);
      return new String[] { paramContext, localObject };
      label552:
      paramUri = paramContext;
      break;
      label557:
      paramUri = paramContext;
      break label348;
      paramContext = null;
      localObject = null;
    }
  }
  
  public static Uri bCd()
  {
    GMTrace.i(724775731200L, 5400);
    try
    {
      Uri localUri = ContactsContract.Contacts.CONTENT_URI;
      GMTrace.o(724775731200L, 5400);
      return localUri;
    }
    catch (Exception localException)
    {
      GMTrace.o(724775731200L, 5400);
    }
    return null;
  }
  
  public static List<String[]> dm(Context paramContext)
  {
    GMTrace.i(724104642560L, 5395);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(724104642560L, 5395);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        v.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        GMTrace.o(724104642560L, 5395);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[] { paramContext.getMessage() });
        v.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        paramContext = null;
      }
      try
      {
        if ((paramContext.getCount() > 0) && (paramContext.moveToFirst()))
        {
          boolean bool;
          do
          {
            localObject2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), localObject2, paramContext.getString(paramContext.getColumnIndex("data1")), paramContext.getString(paramContext.getColumnIndex("raw_contact_id")), String.valueOf(Long.valueOf(paramContext.getLong(paramContext.getColumnIndex("photo_id")))) });
            bool = paramContext.moveToNext();
          } while (bool);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[] { localException.getMessage() });
          v.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
      }
      GMTrace.o(724104642560L, 5395);
      return localLinkedList;
    }
  }
  
  public static List<String[]> dn(Context paramContext)
  {
    GMTrace.i(724238860288L, 5396);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(724238860288L, 5396);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        v.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
        GMTrace.o(724238860288L, 5396);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "", new Object[0]);
        v.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
        paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      }
      try
      {
        if ((paramContext.getCount() > 0) && (paramContext.moveToFirst()))
        {
          boolean bool;
          do
          {
            localObject2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), localObject2, paramContext.getString(paramContext.getColumnIndex("data1")), paramContext.getString(paramContext.getColumnIndex("raw_contact_id")) });
            bool = paramContext.moveToNext();
          } while (bool);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.AddressBookUtil", localException, "", new Object[0]);
          v.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
      }
      GMTrace.o(724238860288L, 5396);
      return localLinkedList;
    }
  }
  
  public static List<String[]> jdMethod_do(Context paramContext)
  {
    GMTrace.i(724373078016L, 5397);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(724373078016L, 5397);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject).query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);
      if (paramContext == null)
      {
        GMTrace.o(724373078016L, 5397);
        return localLinkedList;
      }
      if (paramContext.moveToFirst()) {
        do
        {
          localObject = paramContext.getString(paramContext.getColumnIndex("data1"));
          localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), paramContext.getString(paramContext.getColumnIndex("data4")), localObject, paramContext.getString(paramContext.getColumnIndex("raw_contact_id")), paramContext.getString(paramContext.getColumnIndex("photo_id")) });
        } while (paramContext.moveToNext());
      }
      paramContext.close();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.AddressBookUtil", paramContext, "getEmailInfo", new Object[0]);
      }
    }
    GMTrace.o(724373078016L, 5397);
    return localLinkedList;
  }
  
  /* Error */
  public static List<String> dp(Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 366
    //   3: sipush 5398
    //   6: invokestatic 14	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 315	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 316	java/util/LinkedList:<init>	()V
    //   16: astore 4
    //   18: aload_0
    //   19: invokevirtual 89	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: astore_2
    //   23: aload_0
    //   24: ldc -119
    //   26: invokestatic 143	com/tencent/mm/pluginsdk/i/a:aS	(Landroid/content/Context;Ljava/lang/String;)Z
    //   29: ifne +22 -> 51
    //   32: ldc 123
    //   34: ldc -111
    //   36: invokestatic 149	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc2_w 366
    //   42: sipush 5398
    //   45: invokestatic 69	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   48: aload 4
    //   50: areturn
    //   51: aload_2
    //   52: getstatic 263	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 185	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnonnull +35 -> 99
    //   67: aload_2
    //   68: astore_0
    //   69: ldc 123
    //   71: ldc_w 369
    //   74: invokestatic 149	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_2
    //   78: ifnull +9 -> 87
    //   81: aload_2
    //   82: invokeinterface 204 1 0
    //   87: ldc2_w 366
    //   90: sipush 5398
    //   93: invokestatic 69	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   96: aload 4
    //   98: areturn
    //   99: aload_2
    //   100: astore_0
    //   101: aload_2
    //   102: invokeinterface 197 1 0
    //   107: ifeq +41 -> 148
    //   110: aload_2
    //   111: astore_0
    //   112: aload 4
    //   114: aload_2
    //   115: aload_2
    //   116: ldc_w 270
    //   119: invokeinterface 256 2 0
    //   124: invokeinterface 260 2 0
    //   129: invokeinterface 341 2 0
    //   134: pop
    //   135: aload_2
    //   136: astore_0
    //   137: aload_2
    //   138: invokeinterface 286 1 0
    //   143: istore_1
    //   144: iload_1
    //   145: ifne -35 -> 110
    //   148: aload_2
    //   149: ifnull +9 -> 158
    //   152: aload_2
    //   153: invokeinterface 204 1 0
    //   158: ldc2_w 366
    //   161: sipush 5398
    //   164: invokestatic 69	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   167: aload 4
    //   169: areturn
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_0
    //   175: ldc 123
    //   177: ldc_w 371
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_3
    //   187: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 325	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_2
    //   195: astore_0
    //   196: ldc 123
    //   198: aload_3
    //   199: ldc 54
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 131	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload_2
    //   209: ifnull -51 -> 158
    //   212: aload_2
    //   213: invokeinterface 204 1 0
    //   218: goto -60 -> 158
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: ifnull +9 -> 234
    //   228: aload_0
    //   229: invokeinterface 204 1 0
    //   234: aload_2
    //   235: athrow
    //   236: astore_2
    //   237: goto -13 -> 224
    //   240: astore_3
    //   241: goto -68 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	Context
    //   143	2	1	bool	boolean
    //   22	191	2	localObject1	Object
    //   221	14	2	localObject2	Object
    //   236	1	2	localObject3	Object
    //   170	29	3	localException1	Exception
    //   240	1	3	localException2	Exception
    //   16	152	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   51	63	170	java/lang/Exception
    //   51	63	221	finally
    //   69	77	236	finally
    //   101	110	236	finally
    //   112	135	236	finally
    //   137	144	236	finally
    //   175	194	236	finally
    //   196	208	236	finally
    //   69	77	240	java/lang/Exception
    //   101	110	240	java/lang/Exception
    //   112	135	240	java/lang/Exception
    //   137	144	240	java/lang/Exception
  }
  
  public static String g(String paramString, Context paramContext)
  {
    GMTrace.i(724641513472L, 5399);
    if (!com.tencent.mm.pluginsdk.i.a.aS(paramContext, "android.permission.READ_CONTACTS"))
    {
      v.e("MicroMsg.AddressBookUtil", "no contact permission");
      GMTrace.o(724641513472L, 5399);
      return "";
    }
    try
    {
      paramString = paramContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[] { "display_name" }, "_id = ?", new String[] { paramString }, null);
      if (paramString == null)
      {
        GMTrace.o(724641513472L, 5399);
        return "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.AddressBookUtil", paramString, "getContactNameById:", new Object[0]);
        paramString = null;
      }
    }
    if (paramString.moveToFirst()) {}
    for (paramContext = paramString.getString(0);; paramContext = "")
    {
      paramString.close();
      GMTrace.o(724641513472L, 5399);
      return paramContext;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */