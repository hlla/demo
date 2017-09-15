package com.tencent.mm.e.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.snackbar.b.c;

public final class cb
  extends b
{
  public a fFr;
  public b fFs;
  
  public cb()
  {
    this((byte)0);
    GMTrace.i(4363418337280L, 32510);
    GMTrace.o(4363418337280L, 32510);
  }
  
  private cb(byte paramByte)
  {
    GMTrace.i(4363552555008L, 32511);
    this.fFr = new a();
    this.fFs = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4363552555008L, 32511);
  }
  
  public static final class a
  {
    public Activity activity;
    public String desc;
    public b.c fFA;
    public String fFj;
    public ru fFt;
    public sd fFu;
    public int fFv;
    public String fFw;
    public int fFx;
    public int fFy;
    public DialogInterface.OnClickListener fFz;
    public Fragment ov;
    public String title;
    public int type;
    
    public a()
    {
      GMTrace.i(4278458515456L, 31877);
      this.type = 0;
      this.fFv = 0;
      this.fFx = 0;
      this.fFy = 0;
      GMTrace.o(4278458515456L, 31877);
    }
  }
  
  public static final class b
  {
    public int ret;
    
    public b()
    {
      GMTrace.i(4345835814912L, 32379);
      this.ret = 0;
      GMTrace.o(4345835814912L, 32379);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */