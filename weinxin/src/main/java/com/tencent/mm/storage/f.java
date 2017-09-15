package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public final class f
  implements a<String>
{
  public String field_alias;
  public String field_conRemark;
  public int field_deleteFlag;
  public byte[] field_lvbuff;
  public String field_nickname;
  public String field_remarkDesc;
  public int field_showHead;
  public String field_signature;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public long gTG;
  public CharSequence uxg;
  
  public f()
  {
    GMTrace.i(1536658767872L, 11449);
    GMTrace.o(1536658767872L, 11449);
  }
  
  private void bKB()
  {
    GMTrace.i(1536927203328L, 11451);
    if (this.field_lvbuff == null)
    {
      GMTrace.o(1536927203328L, 11451);
      return;
    }
    try
    {
      if (this.field_lvbuff != null)
      {
        i = this.field_lvbuff.length;
        if (i != 0) {}
      }
      else
      {
        GMTrace.o(1536927203328L, 11451);
        return;
      }
      s locals = new s();
      int i = locals.bh(this.field_lvbuff);
      if (i != 0)
      {
        GMTrace.o(1536927203328L, 11451);
        return;
      }
      locals.ym(4);
      locals.ym(4);
      locals.bIv();
      locals.ym(8);
      locals.ym(4);
      locals.bIv();
      locals.bIv();
      locals.ym(4);
      locals.ym(4);
      locals.bIv();
      locals.bIv();
      locals.ym(4);
      locals.ym(4);
      this.field_signature = locals.getString();
      locals.bIv();
      locals.bIv();
      locals.bIv();
      locals.ym(4);
      locals.ym(4);
      locals.bIv();
      locals.ym(4);
      locals.bIv();
      locals.bIv();
      locals.ym(4);
      locals.ym(4);
      if (!locals.bIw()) {
        this.field_remarkDesc = locals.getString();
      }
      this.field_lvbuff = null;
      GMTrace.o(1536927203328L, 11451);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.AddressUIContact", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(1536927203328L, 11451);
    }
  }
  
  public final void M(int paramInt, long paramLong)
  {
    GMTrace.i(1537329856512L, 11454);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1537329856512L, 11454);
      return;
      this.field_verifyFlag = ((int)paramLong);
      GMTrace.o(1537329856512L, 11454);
      return;
      this.field_showHead = ((int)paramLong);
      GMTrace.o(1537329856512L, 11454);
      return;
      this.field_weiboFlag = ((int)paramLong);
      GMTrace.o(1537329856512L, 11454);
      return;
      this.gTG = paramLong;
      GMTrace.o(1537329856512L, 11454);
      return;
      this.field_deleteFlag = ((int)paramLong);
    }
  }
  
  public final void ay(int paramInt, String paramString)
  {
    GMTrace.i(1537598291968L, 11456);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1537598291968L, 11456);
      return;
      this.field_username = paramString;
      GMTrace.o(1537598291968L, 11456);
      return;
      this.field_nickname = paramString;
      GMTrace.o(1537598291968L, 11456);
      return;
      this.field_alias = paramString;
      GMTrace.o(1537598291968L, 11456);
      return;
      this.field_conRemark = paramString;
    }
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(1536792985600L, 11450);
    this.field_username = paramCursor.getString(0);
    this.field_nickname = paramCursor.getString(1);
    this.field_alias = paramCursor.getString(2);
    this.field_conRemark = paramCursor.getString(3);
    this.field_verifyFlag = paramCursor.getInt(4);
    this.field_showHead = paramCursor.getInt(5);
    this.field_weiboFlag = paramCursor.getInt(6);
    this.gTG = paramCursor.getLong(7);
    this.field_deleteFlag = paramCursor.getInt(8);
    this.field_lvbuff = paramCursor.getBlob(9);
    bKB();
    GMTrace.o(1536792985600L, 11450);
  }
  
  public final void bKC()
  {
    GMTrace.i(1537732509696L, 11457);
    bKB();
    GMTrace.o(1537732509696L, 11457);
  }
  
  public final void m(int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(1537061421056L, 11452);
    if (paramInt == 9) {
      this.field_lvbuff = paramArrayOfByte;
    }
    GMTrace.o(1537061421056L, 11452);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */