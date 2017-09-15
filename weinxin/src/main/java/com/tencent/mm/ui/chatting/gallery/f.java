package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.LinkedList;

public final class f
{
  private aq hvL;
  protected com.tencent.mm.a.f<String, Bitmap> mfs;
  public boolean mfv;
  public LinkedList<String> ta;
  protected HashMap<String, Long> vPF;
  private int xV;
  
  public f()
  {
    GMTrace.i(2408671346688L, 17946);
    this.mfs = new com.tencent.mm.a.f(4, new f.b() {});
    this.vPF = new HashMap();
    this.ta = new LinkedList();
    this.hvL = new aq(1, "chatting-image-gallery-preload-loader");
    this.mfv = false;
    this.xV = 0;
    GMTrace.o(2408671346688L, 17946);
  }
  
  public final void ayP()
  {
    GMTrace.i(2408805564416L, 17947);
    this.mfs.a(new com.tencent.mm.a.f.a() {});
    GMTrace.o(2408805564416L, 17947);
  }
  
  private static final class a
  {
    public static f vPH;
    
    static
    {
      GMTrace.i(2444775915520L, 18215);
      vPH = new f();
      GMTrace.o(2444775915520L, 18215);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */