package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class p
  extends i<o>
  implements f.a
{
  public static final String[] gUn;
  public e gUp;
  public m hBd;
  
  static
  {
    GMTrace.i(4451599384576L, 33167);
    gUn = new String[] { i.a(o.gTF, "GoogleFriend") };
    GMTrace.o(4451599384576L, 33167);
  }
  
  public p(e parame)
  {
    super(parame, o.gTF, "GoogleFriend", null);
    GMTrace.i(4449988771840L, 33155);
    this.hBd = new m()
    {
      protected final boolean Fd()
      {
        GMTrace.i(4422474137600L, 32950);
        if ((p.this.gUp == null) || (p.this.gUp.bKd()))
        {
          if (p.this.gUp == null) {}
          for (Object localObject = "null";; localObject = Boolean.valueOf(p.this.gUp.bKd()))
          {
            v.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", new Object[] { localObject });
            GMTrace.o(4422474137600L, 32950);
            return false;
          }
        }
        GMTrace.o(4422474137600L, 32950);
        return true;
      }
    };
    this.gUp = parame;
    GMTrace.o(4449988771840L, 33155);
  }
  
  private boolean a(o paramo)
  {
    GMTrace.i(4450391425024L, 33158);
    if (paramo == null)
    {
      GMTrace.o(4450391425024L, 33158);
      return false;
    }
    paramo = paramo.pv();
    if ((int)this.gUp.insert("GoogleFriend", "googleitemid", paramo) > 0)
    {
      GMTrace.o(4450391425024L, 33158);
      return true;
    }
    GMTrace.o(4450391425024L, 33158);
    return false;
  }
  
  public final int a(f paramf)
  {
    GMTrace.i(4450257207296L, 33157);
    if (paramf != null) {
      this.gUp = paramf;
    }
    GMTrace.o(4450257207296L, 33157);
    return 0;
  }
  
  public final boolean b(o paramo)
  {
    GMTrace.i(4450794078208L, 33161);
    Object localObject = paramo.field_googleitemid;
    localObject = "SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bf.my((String)localObject) + "\"";
    localObject = this.gUp.a((String)localObject, null, 2);
    boolean bool = ((Cursor)localObject).moveToFirst();
    ((Cursor)localObject).close();
    if (!bool)
    {
      bool = a(paramo);
      GMTrace.o(4450794078208L, 33161);
      return bool;
    }
    localObject = paramo.pv();
    int i = this.gUp.update("GoogleFriend", (ContentValues)localObject, "googleitemid=?", new String[] { paramo.field_googleitemid });
    if (i > 0) {
      doNotify();
    }
    if (i > 0)
    {
      GMTrace.o(4450794078208L, 33161);
      return true;
    }
    GMTrace.o(4450794078208L, 33161);
    return false;
  }
  
  public final void clear()
  {
    GMTrace.i(4451196731392L, 33164);
    this.gUp.eE("GoogleFriend", " delete from GoogleFriend");
    this.hBd.b(5, this.hBd, "");
    GMTrace.o(4451196731392L, 33164);
  }
  
  public final boolean f(ArrayList<o> paramArrayList)
  {
    int i = 0;
    GMTrace.i(4450525642752L, 33159);
    if (paramArrayList.size() <= 0)
    {
      v.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
      GMTrace.o(4450525642752L, 33159);
      return false;
    }
    g localg;
    long l;
    if ((this.gUp instanceof g))
    {
      localg = (g)this.gUp;
      l = localg.cs(Thread.currentThread().getId());
      v.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        a((o)paramArrayList.get(i));
        i += 1;
      }
      else
      {
        if (localg != null)
        {
          localg.aD(l);
          v.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.hBd.b(2, this.hBd, "");
        GMTrace.o(4450525642752L, 33159);
        return true;
        localg = null;
        l = -1L;
      }
    }
  }
  
  public final String getTableName()
  {
    GMTrace.i(4450122989568L, 33156);
    GMTrace.o(4450122989568L, 33156);
    return "GoogleFriend";
  }
  
  public final Cursor jj(String paramString)
  {
    GMTrace.i(4450659860480L, 33160);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googleid='" + paramString + "'");
      localStringBuilder.append(" ) ");
    }
    paramString = this.gUp.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + localStringBuilder, null);
    GMTrace.o(4450659860480L, 33160);
    return paramString;
  }
  
  public final boolean x(String paramString, int paramInt)
  {
    GMTrace.i(4450928295936L, 33162);
    paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' WHERE googleitemid='" + paramString + "'";
    boolean bool = this.gUp.eE("GoogleFriend", paramString);
    GMTrace.o(4450928295936L, 33162);
    return bool;
  }
  
  public final boolean y(String paramString, int paramInt)
  {
    GMTrace.i(4451062513664L, 33163);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "UPDATE GoogleFriend SET googlecgistatus='" + paramInt + "' , status='0" + "' WHERE username='" + paramString + "'";
      boolean bool = this.gUp.eE("GoogleFriend", paramString);
      GMTrace.o(4451062513664L, 33163);
      return bool;
    }
    GMTrace.o(4451062513664L, 33163);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */