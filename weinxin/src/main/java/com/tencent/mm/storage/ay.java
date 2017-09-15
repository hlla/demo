package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class ay
{
  int fRM;
  public String name;
  int status;
  public a uIU;
  public int uIV;
  
  public ay()
  {
    GMTrace.i(13307016642560L, 99145);
    this.fRM = 135;
    this.name = "";
    this.uIU = null;
    this.uIU = null;
    this.name = "";
    this.status = 0;
    this.uIV = 0;
    GMTrace.o(13307016642560L, 99145);
  }
  
  public ay(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(13307150860288L, 99146);
    this.fRM = 135;
    this.name = "";
    this.uIU = null;
    this.uIU = new a(paramString);
    this.name = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.status = (i | 0x2);
      this.uIV = paramInt;
      GMTrace.o(13307150860288L, 99146);
      return;
    }
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13307687731200L, 99150);
    if ((this.fRM & 0x2) != 0)
    {
      this.name = paramCursor.getString(1);
      if (this.uIU == null) {
        this.uIU = new a(this.name);
      }
    }
    if ((this.fRM & 0x4) != 0) {
      this.status = paramCursor.getInt(2);
    }
    if ((this.fRM & 0x80) != 0) {
      this.uIV = paramCursor.getInt(7);
    }
    GMTrace.o(13307687731200L, 99150);
  }
  
  public final boolean bMI()
  {
    GMTrace.i(13307553513472L, 99149);
    if ((this.status & 0x2) != 0)
    {
      GMTrace.o(13307553513472L, 99149);
      return true;
    }
    GMTrace.o(13307553513472L, 99149);
    return false;
  }
  
  public final void fc(boolean paramBoolean)
  {
    GMTrace.i(13307285078016L, 99147);
    if (paramBoolean)
    {
      int j = this.status;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.status = (i | j);
        GMTrace.o(13307285078016L, 99147);
        return;
      }
    }
    this.status &= 0xFFFFFFFE;
    GMTrace.o(13307285078016L, 99147);
  }
  
  public final boolean isEnable()
  {
    GMTrace.i(13307419295744L, 99148);
    if ((this.status & 0x1) != 0)
    {
      GMTrace.o(13307419295744L, 99148);
      return true;
    }
    GMTrace.o(13307419295744L, 99148);
    return false;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13307821948928L, 99151);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("name", this.name);
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.fRM & 0x80) != 0) {
      localContentValues.put("int_reserved1", Integer.valueOf(this.uIV));
    }
    GMTrace.o(13307821948928L, 99151);
    return localContentValues;
  }
  
  public static final class a
  {
    private String fRV;
    private String fZZ;
    
    public a(String paramString)
    {
      GMTrace.i(13303795417088L, 99121);
      int i = paramString.indexOf("@");
      if (i >= 0)
      {
        this.fRV = paramString.substring(0, i);
        this.fZZ = paramString.substring(i);
        GMTrace.o(13303795417088L, 99121);
        return;
      }
      this.fRV = paramString;
      this.fZZ = "";
      GMTrace.o(13303795417088L, 99121);
    }
    
    public final String RT(String paramString)
    {
      GMTrace.i(13303929634816L, 99122);
      if (this.fZZ != null)
      {
        paramString = this.fZZ;
        GMTrace.o(13303929634816L, 99122);
        return paramString;
      }
      GMTrace.o(13303929634816L, 99122);
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */