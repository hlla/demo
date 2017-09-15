package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;

final class ds
  extends c
{
  String chatroomName;
  String desc;
  String designerName;
  String designerRediretctUrl;
  int designerUIN;
  String fFR;
  f.a fSK;
  String fUH;
  String fUI;
  String fZv;
  String gxt;
  String hjr;
  String iconUrl;
  int klJ;
  int pageType;
  int position;
  long rWf;
  int rWg;
  String secondUrl;
  int tid;
  String title;
  String userName;
  boolean vLb;
  String vLc;
  boolean vLd;
  boolean vLe;
  String vLf;
  boolean vLg;
  String vLh;
  Bundle vLi;
  boolean vvA;
  
  public ds()
  {
    GMTrace.i(2397128622080L, 17860);
    GMTrace.o(2397128622080L, 17860);
  }
  
  public ds(au paramau, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    GMTrace.i(2397262839808L, 17861);
    this.fTa = paramau;
    this.vvA = false;
    this.position = paramInt1;
    this.userName = paramString1;
    this.klJ = 10;
    this.vLb = false;
    this.title = paramString2;
    this.fUH = paramString3;
    this.fUI = paramString4;
    this.vLc = paramString5;
    this.designerUIN = paramInt2;
    this.designerName = paramString6;
    this.designerRediretctUrl = paramString7;
    this.gxt = paramString8;
    GMTrace.o(2397262839808L, 17861);
  }
  
  public ds(au paramau, String paramString, int paramInt)
  {
    this(paramString, paramInt);
    GMTrace.i(2398336581632L, 17869);
    this.fTa = paramau;
    GMTrace.o(2398336581632L, 17869);
  }
  
  public ds(au paramau, String paramString1, String paramString2)
  {
    GMTrace.i(2398739234816L, 17872);
    this.fTa = paramau;
    this.userName = paramString1;
    this.fTa = paramau;
    this.vLh = paramString2;
    this.klJ = 6;
    GMTrace.o(2398739234816L, 17872);
  }
  
  private ds(au paramau, boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    this(paramau, paramBoolean, paramInt1, paramString, paramInt2, false);
    GMTrace.i(2397933928448L, 17866);
    GMTrace.o(2397933928448L, 17866);
  }
  
  public ds(au paramau, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    this(paramau, paramBoolean, paramInt1, paramString, paramInt2);
    GMTrace.i(2398068146176L, 17867);
    GMTrace.o(2398068146176L, 17867);
  }
  
  private ds(au paramau, boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2)
  {
    this(paramau, paramBoolean1, paramInt1, paramString, paramInt2, false, null, null, null);
    GMTrace.i(2397799710720L, 17865);
    GMTrace.o(2397799710720L, 17865);
  }
  
  public ds(au paramau, boolean paramBoolean1, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean2, String paramString2, String paramString3, String paramString4)
  {
    this(paramau, paramBoolean1, paramInt1, paramString1, paramInt2, paramBoolean2, paramString2, paramString3, paramString4, null);
    GMTrace.i(2397665492992L, 17864);
    GMTrace.o(2397665492992L, 17864);
  }
  
  public ds(au paramau, boolean paramBoolean1, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramau, paramBoolean1, paramInt1, paramString1, paramInt2, paramBoolean2, paramString2, paramString3, paramString4, paramString5, null, null, false, false);
    GMTrace.i(2397531275264L, 17863);
    GMTrace.o(2397531275264L, 17863);
  }
  
  public ds(au paramau, boolean paramBoolean1, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
  {
    GMTrace.i(2397397057536L, 17862);
    this.fTa = paramau;
    this.vvA = paramBoolean1;
    this.position = paramInt1;
    this.userName = paramString1;
    this.klJ = paramInt2;
    this.vLb = paramBoolean2;
    this.title = paramString2;
    this.fUH = paramString3;
    this.fUI = paramString4;
    this.vLc = paramString5;
    this.fFR = paramString6;
    this.gxt = paramString7;
    this.vLd = paramBoolean3;
    this.vLe = paramBoolean4;
    GMTrace.o(2397397057536L, 17862);
  }
  
  public ds(au paramau, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this(paramau, paramBoolean, paramInt, paramString1, 0);
    GMTrace.i(2398202363904L, 17868);
    this.chatroomName = paramString2;
    GMTrace.o(2398202363904L, 17868);
  }
  
  private ds(String paramString, int paramInt)
  {
    GMTrace.i(2398470799360L, 17870);
    this.userName = paramString;
    this.klJ = paramInt;
    GMTrace.o(2398470799360L, 17870);
  }
  
  public ds(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(2398605017088L, 17871);
    this.userName = paramString1;
    this.klJ = paramInt;
    this.chatroomName = paramString2;
    GMTrace.o(2398605017088L, 17871);
  }
  
  public static ds TE(String paramString)
  {
    GMTrace.i(2398873452544L, 17873);
    ds localds = new ds();
    localds.klJ = 7;
    localds.gxt = paramString;
    GMTrace.o(2398873452544L, 17873);
    return localds;
  }
  
  public static ds a(au paramau, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(2399141888000L, 17875);
    ds localds = new ds();
    localds.fTa = paramau;
    localds.vvA = paramBoolean;
    localds.position = paramInt;
    localds.klJ = 0;
    localds.vLg = false;
    GMTrace.o(2399141888000L, 17875);
    return localds;
  }
  
  public static ds a(f.a parama, au paramau)
  {
    GMTrace.i(2399007670272L, 17874);
    ds localds = new ds();
    localds.fSK = parama;
    localds.fTa = paramau;
    GMTrace.o(2399007670272L, 17874);
    return localds;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */