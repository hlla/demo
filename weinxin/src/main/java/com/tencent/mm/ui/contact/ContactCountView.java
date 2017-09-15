package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;

public class ContactCountView
  extends FrameLayout
{
  private int count;
  private View llc;
  private TextView mRh;
  int vUD;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1788719661056L, 13327);
    this.count = 0;
    this.visible = true;
    this.vUD = 1;
    init();
    GMTrace.o(1788719661056L, 13327);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1788585443328L, 13326);
    this.count = 0;
    this.visible = true;
    this.vUD = 1;
    init();
    GMTrace.o(1788585443328L, 13326);
  }
  
  private void init()
  {
    GMTrace.i(1788853878784L, 13328);
    inflate(getContext(), R.i.cZk, this);
    GMTrace.o(1788853878784L, 13328);
  }
  
  public final void bXE()
  {
    GMTrace.i(1789122314240L, 13330);
    String[] arrayOfString = o.hlg;
    if (this.vUD == 1)
    {
      ap.yY();
      this.count = c.wR().b(arrayOfString, new String[] { m.xL(), "weixin", "helper_entry", "filehelper" });
      v.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(this.count) });
      if (this.mRh != null)
      {
        if (this.vUD != 1) {
          break label200;
        }
        this.mRh.setText(getContext().getResources().getQuantityString(R.j.drW, this.count, new Object[] { Integer.valueOf(this.count) }));
      }
    }
    for (;;)
    {
      setVisible(this.visible);
      GMTrace.o(1789122314240L, 13330);
      return;
      ap.yY();
      this.count = c.wR().c(arrayOfString, new String[] { m.xL(), "weixin", "helper_entry", "filehelper" });
      break;
      label200:
      this.mRh.setText(getContext().getResources().getQuantityString(R.j.drV, this.count, new Object[] { Integer.valueOf(this.count) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1788988096512L, 13329);
    v.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.llc == null)
    {
      this.llc = ((FrameLayout)findViewById(R.h.bEL));
      this.mRh = ((TextView)findViewById(R.h.bEK));
    }
    bXE();
    super.onMeasure(paramInt1, paramInt2);
    GMTrace.o(1788988096512L, 13329);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    GMTrace.i(1789256531968L, 13331);
    this.visible = paramBoolean;
    View localView;
    if (this.llc != null)
    {
      localView = this.llc;
      if ((!paramBoolean) || (this.count <= 0)) {
        break label54;
      }
    }
    label54:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      GMTrace.o(1789256531968L, 13331);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/ContactCountView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */