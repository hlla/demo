package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;

public final class an
{
  public static final an uHP;
  public static final an uHQ;
  public static final an uHR;
  public static final an uHS;
  public static final an uHT;
  public static final an uHU;
  public static final an uHV;
  public static final an uHW;
  public static final an uHX;
  public static final an uHY;
  public static final an uHZ;
  public int cId;
  public String tag;
  
  static
  {
    GMTrace.i(1535853461504L, 11443);
    uHP = new an("timeline");
    uHQ = new an("album_friend");
    uHR = new an("album_self");
    uHS = new an("album_stranger");
    uHT = new an("profile_friend");
    uHU = new an("profile_stranger");
    uHV = new an("comment");
    uHW = new an("comment_detail");
    uHX = new an("other");
    uHY = new an("snssight");
    uHZ = new an("fts");
    GMTrace.o(1535853461504L, 11443);
  }
  
  public an(String paramString)
  {
    GMTrace.i(1535182372864L, 11438);
    this.tag = "";
    this.cId = 0;
    this.tag = paramString;
    GMTrace.o(1535182372864L, 11438);
  }
  
  public static an a(an paraman, int paramInt)
  {
    GMTrace.i(1535450808320L, 11440);
    paraman = new an(paraman.tag);
    paraman.cId = paramInt;
    GMTrace.o(1535450808320L, 11440);
    return paraman;
  }
  
  public static an bLH()
  {
    GMTrace.i(1534511284224L, 11433);
    an localan = new an("timeline");
    GMTrace.o(1534511284224L, 11433);
    return localan;
  }
  
  public static an bLI()
  {
    GMTrace.i(1534645501952L, 11434);
    an localan = new an("album_friend");
    GMTrace.o(1534645501952L, 11434);
    return localan;
  }
  
  public static an bLJ()
  {
    GMTrace.i(1534779719680L, 11435);
    an localan = new an("album_self");
    GMTrace.o(1534779719680L, 11435);
    return localan;
  }
  
  public static an bLK()
  {
    GMTrace.i(1534913937408L, 11436);
    an localan = new an("album_stranger");
    GMTrace.o(1534913937408L, 11436);
    return localan;
  }
  
  public static an bLL()
  {
    GMTrace.i(1535048155136L, 11437);
    an localan = new an("snssight");
    GMTrace.o(1535048155136L, 11437);
    return localan;
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(1535585026048L, 11441);
    if ((paramObject instanceof an))
    {
      bool = ((an)paramObject).tag.equals(this.tag);
      GMTrace.o(1535585026048L, 11441);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    GMTrace.o(1535585026048L, 11441);
    return bool;
  }
  
  public final String toString()
  {
    GMTrace.i(1535719243776L, 11442);
    String str = this.tag + "@" + this.cId;
    GMTrace.o(1535719243776L, 11442);
    return str;
  }
  
  public final an yz(int paramInt)
  {
    GMTrace.i(1535316590592L, 11439);
    this.cId = paramInt;
    GMTrace.o(1535316590592L, 11439);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */