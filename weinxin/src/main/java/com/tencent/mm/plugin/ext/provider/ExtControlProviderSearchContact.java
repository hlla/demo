package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.ext.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bh;
import com.tencent.mm.u.o;
import com.tencent.mm.x.n;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> jzO;
  private static final String[] lpt;
  private Cursor lpx;
  
  static
  {
    int i = 0;
    GMTrace.i(5736734130176L, 42742);
    lpt = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    jzO = new ArrayList();
    String[] arrayOfString = o.hlg;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      jzO.add(str);
      i += 1;
    }
    jzO.add("officialaccounts");
    jzO.add("helper_entry");
    GMTrace.o(5736734130176L, 42742);
  }
  
  public ExtControlProviderSearchContact()
  {
    GMTrace.i(5735526170624L, 42733);
    this.lpx = null;
    GMTrace.o(5735526170624L, 42733);
  }
  
  public static Cursor d(Cursor paramCursor)
  {
    GMTrace.i(5735928823808L, 42736);
    d locald = new d(lpt, (byte)0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          i += 1;
          localObject1 = new x();
          ((x)localObject1).b(paramCursor);
          if (!o.dH(((af)localObject1).field_username))
          {
            localObject2 = n.Bz().b(((af)localObject1).field_username, true, 0);
            ByteArrayOutputStream localByteArrayOutputStream = null;
            if (localObject2 != null)
            {
              localByteArrayOutputStream = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
              ap.yY();
              localObject2 = com.tencent.mm.u.c.wT().bn(((af)localObject1).field_username, 1);
              if ((localObject2 == null) || (localObject2.length != 1)) {
                break label324;
              }
              String str1 = com.tencent.mm.plugin.ext.a.a.bK((int)((com.tencent.mm.j.a)localObject1).gTG);
              String str2 = ((x)localObject1).tL();
              if (localByteArrayOutputStream != null) {
                break label316;
              }
              localByteArrayOutputStream = null;
              if (localObject2[0].field_type != 1) {
                break label407;
              }
              localObject1 = localObject2[0].field_content;
              locald.addRow(new Object[] { str1, str2, localByteArrayOutputStream, localObject1, com.tencent.mm.plugin.ext.a.a.bK(localObject2[0].field_msgId), Integer.valueOf(b.H(localObject2[0])) });
            }
          }
          else
          {
            if ((paramCursor.moveToNext()) && (i < 15)) {
              break label404;
            }
          }
        }
        else
        {
          paramCursor.close();
          GMTrace.o(5735928823808L, 42736);
          return locald;
        }
        v.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        continue;
        arrayOfByte = localException.toByteArray();
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
        if (paramCursor != null) {
          paramCursor.close();
        }
        locald.close();
        GMTrace.o(5735928823808L, 42736);
        return null;
      }
      label316:
      continue;
      label324:
      v.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
      Object localObject2 = com.tencent.mm.plugin.ext.a.a.bK((int)((com.tencent.mm.j.a)localObject1).gTG);
      Object localObject1 = ((x)localObject1).tL();
      if (arrayOfByte == null) {}
      for (byte[] arrayOfByte = null;; arrayOfByte = arrayOfByte.toByteArray())
      {
        locald.addRow(new Object[] { localObject2, localObject1, arrayOfByte, "", "0", Integer.valueOf(0) });
        break;
      }
      label404:
      continue;
      label407:
      localObject1 = "";
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5736331476992L, 42739);
    GMTrace.o(5736331476992L, 42739);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(5736063041536L, 42737);
    GMTrace.o(5736063041536L, 42737);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(5736197259264L, 42738);
    GMTrace.o(5736197259264L, 42738);
    return null;
  }
  
  public boolean onCreate()
  {
    GMTrace.i(5735660388352L, 42734);
    GMTrace.o(5735660388352L, 42734);
    return true;
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(5735794606080L, 42735);
    v.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      lZ(3);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    if ((bf.mA(this.loL)) || (bf.mA(aqR())))
    {
      lZ(3);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    if (!acE())
    {
      lZ(1);
      paramUri = this.jND;
      GMTrace.o(5735794606080L, 42735);
      return paramUri;
    }
    if (!bW(getContext()))
    {
      v.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      lZ(2);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      v.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      lZ(3);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (bf.mA(paramUri))
    {
      v.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      lZ(3);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    paramUri = ap.yY().hkt.a(paramUri, "@micromsg.no.verify.biz.qq.com", null, jzO, false, false, false, 1, null);
    if (paramUri == null)
    {
      v.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      lZ(3);
      GMTrace.o(5735794606080L, 42735);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.f.a.a();
    paramArrayOfString1.b(4000L, new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5737002565632L, 42744);
        ExtControlProviderSearchContact.a(ExtControlProviderSearchContact.this, ExtControlProviderSearchContact.d(paramUri));
        paramArrayOfString1.countDown();
        GMTrace.o(5737002565632L, 42744);
      }
    });
    if (this.lpx != null) {
      lZ(0);
    }
    for (;;)
    {
      paramUri = this.lpx;
      GMTrace.o(5735794606080L, 42735);
      return paramUri;
      lZ(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5736465694720L, 42740);
    GMTrace.o(5736465694720L, 42740);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/provider/ExtControlProviderSearchContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */