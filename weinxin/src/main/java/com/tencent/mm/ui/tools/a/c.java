package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.h.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  private String jpC;
  public int jsw;
  public boolean wnj;
  public WeakReference<EditText> wnk;
  private int wnl;
  private int wnm;
  private ArrayList<InputFilter> wnn;
  public a wno;
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    GMTrace.i(2033935450112L, 15154);
    this.wnj = true;
    this.wnk = paramWeakReference;
    this.jsw = h.a.wkA;
    this.wnj = false;
    GMTrace.o(2033935450112L, 15154);
  }
  
  public static c d(EditText paramEditText)
  {
    GMTrace.i(2034069667840L, 15155);
    paramEditText = new c(new WeakReference(paramEditText));
    GMTrace.o(2034069667840L, 15155);
    return paramEditText;
  }
  
  public final c Cc(int paramInt)
  {
    GMTrace.i(2034338103296L, 15157);
    this.wnm = 0;
    this.wnl = paramInt;
    GMTrace.o(2034338103296L, 15157);
    return this;
  }
  
  protected final int UX()
  {
    GMTrace.i(2034606538752L, 15159);
    if (bf.mA(this.jpC))
    {
      if (this.wnk == null)
      {
        GMTrace.o(2034606538752L, 15159);
        return 1;
      }
      this.jpC = ((EditText)this.wnk.get()).getText().toString().trim();
    }
    int j = h.cY(this.jpC, this.jsw);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      v.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      GMTrace.o(2034606538752L, 15159);
      return 2;
    }
    if (j < this.wnm)
    {
      GMTrace.o(2034606538752L, 15159);
      return 1;
    }
    if (j > this.wnl)
    {
      GMTrace.o(2034606538752L, 15159);
      return 2;
    }
    GMTrace.o(2034606538752L, 15159);
    return 0;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(2034472321024L, 15158);
    this.wno = parama;
    bGe();
    GMTrace.o(2034472321024L, 15158);
  }
  
  protected final void bGe()
  {
    GMTrace.i(2034740756480L, 15160);
    Object localObject;
    if (!this.wnj)
    {
      if (this.wnk == null)
      {
        v.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        GMTrace.o(2034740756480L, 15160);
        return;
      }
      if (bf.bV(this.wnn))
      {
        localObject = bz(this.wnl, this.jsw);
        ((EditText)this.wnk.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.wno != null)
    {
      switch (UX())
      {
      }
    }
    for (;;)
    {
      GMTrace.o(2034740756480L, 15160);
      return;
      this.wnn.add(bz(this.wnl, this.jsw));
      localObject = (InputFilter[])this.wnn.toArray(new InputFilter[this.wnn.size()]);
      ((EditText)this.wnk.get()).setFilters((InputFilter[])localObject);
      break;
      this.wno.rk(this.jpC);
      GMTrace.o(2034740756480L, 15160);
      return;
      this.wno.YH();
      GMTrace.o(2034740756480L, 15160);
      return;
      this.wno.Yj();
    }
  }
  
  public h bz(int paramInt1, int paramInt2)
  {
    GMTrace.i(2034874974208L, 15161);
    h localh = new h(paramInt1, paramInt2);
    GMTrace.o(2034874974208L, 15161);
    return localh;
  }
  
  public final c em(int paramInt1, int paramInt2)
  {
    GMTrace.i(2034203885568L, 15156);
    this.wnm = paramInt1;
    this.wnl = paramInt2;
    GMTrace.o(2034203885568L, 15156);
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void YH();
    
    public abstract void Yj();
    
    public abstract void rk(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */