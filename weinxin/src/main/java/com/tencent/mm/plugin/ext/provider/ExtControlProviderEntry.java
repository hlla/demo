package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher loR;
  private String[] loC;
  private int loD;
  private boolean loS;
  private Context loT;
  
  static
  {
    GMTrace.i(5728815284224L, 42683);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    loR = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    loR.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    loR.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    loR.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    loR.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    GMTrace.o(5728815284224L, 42683);
  }
  
  public ExtControlProviderEntry()
  {
    GMTrace.i(5727607324672L, 42674);
    this.loS = false;
    this.loC = null;
    this.loD = -1;
    GMTrace.o(5727607324672L, 42674);
  }
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    GMTrace.i(5727741542400L, 42675);
    this.loS = false;
    this.loC = null;
    this.loD = -1;
    this.loS = true;
    this.loC = paramArrayOfString;
    this.loD = paramInt;
    this.loT = paramContext;
    GMTrace.o(5727741542400L, 42675);
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    GMTrace.i(5728546848768L, 42681);
    v.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      bS(3, 3601);
      paramArrayOfString = ma(3601);
      GMTrace.o(5728546848768L, 42681);
      return paramArrayOfString;
    }
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      bS(3, 3602);
      paramArrayOfString = ma(3602);
      GMTrace.o(5728546848768L, 42681);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      bS(3, 3603);
      paramArrayOfString = ma(3603);
      GMTrace.o(5728546848768L, 42681);
      return paramArrayOfString;
    }
    int i;
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
    {
      i = 1;
      if (i == 0) {
        break label298;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = b.aqG().RY(paramArrayOfString);
        if ((paramArrayOfString == null) || (bf.mA(paramArrayOfString.field_openId)) || (bf.mA(paramArrayOfString.field_username)))
        {
          v.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          bS(3, 3604);
          paramArrayOfString = ma(3604);
          GMTrace.o(5728546848768L, 42681);
          return paramArrayOfString;
          i = 0;
          break;
        }
        ap.yY();
        paramArrayOfString = c.wR().Rb(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.gTG > 0) && (this.loT != null)) {
          break label364;
        }
        v.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        bS(3, 3605);
        paramArrayOfString = ma(3605);
        GMTrace.o(5728546848768L, 42681);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label298:
        v.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        z(5, 4, 12);
        paramArrayOfString = ma(12);
        GMTrace.o(5728546848768L, 42681);
        return paramArrayOfString;
      }
      ap.yY();
      paramArrayOfString = c.wR().ez(com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString));
    }
    label364:
    paramString = new Intent();
    paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.En_5b8fbb1e"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    this.loT.startActivity(paramString);
    z(4, 0, 1);
    paramArrayOfString = ma(1);
    GMTrace.o(5728546848768L, 42681);
    return paramArrayOfString;
  }
  
  private Cursor k(String[] paramArrayOfString)
  {
    GMTrace.i(5728412631040L, 42680);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      lZ(3);
      GMTrace.o(5728412631040L, 42680);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      lZ(3);
      GMTrace.o(5728412631040L, 42680);
      return null;
    }
    try
    {
      ap.yY();
      paramArrayOfString = c.wR().ez(com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.gTG <= 0) || (this.loT == null))
      {
        lZ(3);
        GMTrace.o(5728412631040L, 42680);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      v.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      lZ(3);
      GMTrace.o(5728412631040L, 42680);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.loT, "profile", ".ui.ContactInfoUI", localIntent);
    lZ(0);
    paramArrayOfString = ma(1);
    GMTrace.o(5728412631040L, 42680);
    return paramArrayOfString;
  }
  
  private Cursor l(String[] paramArrayOfString)
  {
    GMTrace.i(5728681066496L, 42682);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      lZ(3);
      GMTrace.o(5728681066496L, 42682);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      lZ(3);
      GMTrace.o(5728681066496L, 42682);
      return null;
    }
    long l;
    try
    {
      l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString);
      if (l <= 0L)
      {
        lZ(3);
        GMTrace.o(5728681066496L, 42682);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      v.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      lZ(3);
      GMTrace.o(5728681066496L, 42682);
      return null;
    }
    if (this.loT == null)
    {
      lZ(4);
      GMTrace.o(5728681066496L, 42682);
      return null;
    }
    paramArrayOfString = new Intent();
    paramArrayOfString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    paramArrayOfString.putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    paramArrayOfString.addCategory("android.intent.category.DEFAULT");
    paramArrayOfString.addFlags(268435456);
    this.loT.startActivity(paramArrayOfString);
    lZ(0);
    paramArrayOfString = ma(1);
    GMTrace.o(5728681066496L, 42682);
    return paramArrayOfString;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5728144195584L, 42678);
    GMTrace.o(5728144195584L, 42678);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(5727338889216L, 42672);
    GMTrace.o(5727338889216L, 42672);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(5728009977856L, 42677);
    GMTrace.o(5728009977856L, 42677);
    return null;
  }
  
  public boolean onCreate()
  {
    GMTrace.i(5727473106944L, 42673);
    GMTrace.o(5727473106944L, 42673);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(5727875760128L, 42676);
    v.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.loS);
    if (this.loS)
    {
      a(paramUri, this.loT, this.loD, this.loC);
      if (bf.mA(this.loL))
      {
        v.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        bS(3, 7);
        paramUri = ma(7);
        GMTrace.o(5727875760128L, 42676);
        return paramUri;
      }
      if (bf.mA(aqR()))
      {
        v.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        bS(3, 6);
        paramUri = ma(6);
        GMTrace.o(5727875760128L, 42676);
        return paramUri;
      }
      int i = aqS();
      if (i != 1)
      {
        v.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + i);
        bS(2, i);
        paramUri = ma(i);
        GMTrace.o(5727875760128L, 42676);
        return paramUri;
      }
    }
    else
    {
      this.loT = getContext();
      a(paramUri, this.loT, loR);
      if (paramUri == null)
      {
        lZ(3);
        GMTrace.o(5727875760128L, 42676);
        return null;
      }
      if ((bf.mA(this.loL)) || (bf.mA(aqR())))
      {
        lZ(3);
        paramUri = ma(3);
        GMTrace.o(5727875760128L, 42676);
        return paramUri;
      }
      if (!acE())
      {
        lZ(1);
        paramUri = this.jND;
        GMTrace.o(5727875760128L, 42676);
        return paramUri;
      }
      if (!bW(this.loT))
      {
        v.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        lZ(2);
        GMTrace.o(5727875760128L, 42676);
        return null;
      }
    }
    paramArrayOfString1 = bf.mz(paramUri.getQueryParameter("source"));
    if (!this.loS) {
      this.loD = loR.match(paramUri);
    }
    switch (this.loD)
    {
    default: 
      bS(3, 15);
      GMTrace.o(5727875760128L, 42676);
      return null;
    case 2: 
      paramUri = k(paramArrayOfString2);
      GMTrace.o(5727875760128L, 42676);
      return paramUri;
    case 3: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
      GMTrace.o(5727875760128L, 42676);
      return paramUri;
    case 4: 
      if (this.loT == null)
      {
        lZ(4);
        GMTrace.o(5727875760128L, 42676);
        return null;
      }
      paramUri = new Intent();
      paramUri.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramUri.addFlags(268435456);
      this.loT.startActivity(paramUri);
      lZ(0);
      paramUri = ma(1);
      GMTrace.o(5727875760128L, 42676);
      return paramUri;
    case 5: 
      paramUri = l(paramArrayOfString2);
      GMTrace.o(5727875760128L, 42676);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      lZ(3);
      GMTrace.o(5727875760128L, 42676);
      return null;
    }
    if (this.loT == null)
    {
      lZ(4);
      GMTrace.o(5727875760128L, 42676);
      return null;
    }
    paramArrayOfString1 = new Intent();
    paramArrayOfString1.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    paramArrayOfString1.setAction("android.intent.action.SEND");
    paramArrayOfString1.addCategory("android.intent.category.DEFAULT");
    paramArrayOfString1.addFlags(268435456);
    if (paramArrayOfString2[1] == null) {}
    for (paramUri = "";; paramUri = paramArrayOfString2[1])
    {
      paramArrayOfString1.putExtra("android.intent.extra.TEXT", paramUri);
      if ((paramArrayOfString2[0] != null) && (paramArrayOfString2[0].trim().length() > 0)) {
        paramArrayOfString1.putExtra("android.intent.extra.STREAM", Uri.parse(paramArrayOfString2[0]));
      }
      paramArrayOfString1.putExtra("Ksnsupload_empty_img", true);
      paramArrayOfString1.setType("image/*");
      this.loT.startActivity(paramArrayOfString1);
      lZ(0);
      paramUri = ma(1);
      GMTrace.o(5727875760128L, 42676);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5728278413312L, 42679);
    GMTrace.o(5728278413312L, 42679);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */