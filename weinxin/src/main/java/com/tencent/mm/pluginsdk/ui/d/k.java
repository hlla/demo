package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.v;

public final class k
  implements View.OnTouchListener
{
  private static boolean DEBUG;
  private static int sSj;
  public static int wE;
  String iCm;
  private l sSf;
  private boolean sSg;
  private View sSh;
  public boolean sSi;
  private Context sSk;
  private ad sSl;
  private b sSm;
  private a sSn;
  public View view;
  
  static
  {
    GMTrace.i(1205946286080L, 8985);
    DEBUG = false;
    wE = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    sSj = i;
    if (i > wE * 2) {
      sSj -= wE;
    }
    v.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(sSj) });
    GMTrace.o(1205946286080L, 8985);
  }
  
  public k()
  {
    GMTrace.i(1204604108800L, 8975);
    this.sSf = null;
    this.sSg = false;
    this.sSh = null;
    this.sSi = false;
    this.sSk = null;
    this.sSl = new ad(Looper.getMainLooper());
    this.sSm = new b();
    this.sSn = new a();
    GMTrace.o(1204604108800L, 8975);
  }
  
  public k(Context paramContext)
  {
    GMTrace.i(1204738326528L, 8976);
    this.sSf = null;
    this.sSg = false;
    this.sSh = null;
    this.sSi = false;
    this.sSk = null;
    this.sSl = new ad(Looper.getMainLooper());
    this.sSm = new b();
    this.sSn = new a();
    this.sSk = paramContext;
    GMTrace.o(1204738326528L, 8976);
  }
  
  private void F(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1205006761984L, 8978);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      aEw();
    }
    GMTrace.o(1205006761984L, 8978);
  }
  
  public final void aEw()
  {
    GMTrace.i(1205140979712L, 8979);
    if (this.sSf != null)
    {
      this.sSf.nHh = false;
      this.sSf.setContext(null);
      this.sSh.invalidate();
      this.sSh = null;
      this.sSf = null;
    }
    GMTrace.o(1205140979712L, 8979);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GMTrace.i(1204872544256L, 8977);
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView)))
    {
      GMTrace.o(1204872544256L, 8977);
      return false;
    }
    int i;
    int j;
    if (paramMotionEvent.getAction() == 0)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      paramView.setTag(a.d.cJn, new int[] { i, j });
    }
    this.view = paramView;
    Layout localLayout;
    CharSequence localCharSequence;
    MotionEvent localMotionEvent;
    Object localObject;
    int k;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localCharSequence = ((TextView)paramView).getText();
      if (DEBUG) {
        v.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + new ag().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.sSi) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (((localCharSequence instanceof Spanned)) && (localLayout != null))
      {
        localObject = (Spanned)localCharSequence;
        i = localMotionEvent.getAction();
        paramView.invalidate();
        if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
          break label853;
        }
        j = (int)localMotionEvent.getX();
        i = (int)localMotionEvent.getY();
        if (!(paramView instanceof StaticTextView)) {
          break label469;
        }
        if (j >= ((StaticTextView)paramView).vT())
        {
          k = localLayout.getWidth();
          if (j <= ((StaticTextView)paramView).vT() + k) {
            break label428;
          }
        }
        F(localMotionEvent);
      }
    }
    label428:
    label469:
    label589:
    label853:
    label939:
    label1071:
    label1332:
    label1380:
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        v.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: false" + " " + new ag().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.sSi) });
      }
      GMTrace.o(1204872544256L, 8977);
      return false;
      localLayout = ((StaticTextView)paramView).wb();
      localCharSequence = ((StaticTextView)paramView).getText();
      break;
      if (i >= ((StaticTextView)paramView).vU())
      {
        k = localLayout.getHeight();
        if (i <= ((StaticTextView)paramView).vU() + k) {}
      }
      else
      {
        F(localMotionEvent);
        continue;
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            F(localMotionEvent);
            continue;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            F(localMotionEvent);
            continue;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        k = paramView.getScrollX();
        j = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i + paramView.getScrollY()), j + k);
        i = j;
        if ((paramView instanceof TextView))
        {
          i = j;
          if (j < ((Spanned)localObject).length()) {
            i = j + 1;
          }
        }
        j = localMotionEvent.getAction();
        localObject = (l[])((Spanned)localObject).getSpans(i, i, l.class);
        i = localObject.length - 1;
        if (DEBUG) {
          v.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.sSf + " " + new ag().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.sSi) });
        }
        if (localObject.length == 0) {
          break label1332;
        }
        if (j != 1) {
          break label1071;
        }
        this.sSl.removeCallbacks(this.sSm);
        this.sSl.removeCallbacks(this.sSn);
        if (!this.sSi) {
          break label939;
        }
        aEw();
        this.sSi = false;
        paramView.setClickable(this.sSg);
        if (DEBUG) {
          v.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
      }
      for (;;)
      {
        if (!DEBUG) {
          break label1380;
        }
        v.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).vT();
          i -= ((StaticTextView)paramView).vU();
          break label589;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label589;
        this.sSi = false;
        if (this.sSf != null)
        {
          localObject = this.sSf;
          ((l)localObject).iCm = this.iCm;
          if (((l)localObject).sSq != null) {
            ((l)localObject).sSq.iCm = ((l)localObject).iCm;
          }
          if (this.sSk != null) {
            this.sSf.setContext(this.sSk);
          }
          this.sSf.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.sSg);
          aEw();
          if (!DEBUG) {
            break;
          }
          v.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          break;
          v.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (sSj > 0)) {
            xK(0);
          }
          if (j == 0) {
            this.sSg = paramView.isClickable();
          }
          aEw();
          this.sSf = localObject[i];
          this.sSh = paramView;
          localObject[i].setContext(null);
          localObject[i].nHh = true;
          localObject[i].mEnable = true;
          paramView.invalidate();
          if (this.sSi)
          {
            localObject[i].nHh = false;
            localObject[i].mEnable = false;
            paramView.setClickable(this.sSg);
            if (DEBUG) {
              v.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + localMotionEvent.getAction());
            }
          }
          else if (DEBUG)
          {
            v.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + localMotionEvent.getAction());
          }
        }
        else if (j == 3)
        {
          this.sSl.removeCallbacks(this.sSm);
          this.sSl.removeCallbacks(this.sSn);
          paramView.setClickable(this.sSg);
          aEw();
          if (DEBUG)
          {
            v.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
            continue;
            aEw();
          }
        }
        else
        {
          if (j == 1) {
            this.sSi = false;
          }
          if (DEBUG) {
            v.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
        }
      }
    }
  }
  
  public final void xK(int paramInt)
  {
    GMTrace.i(1205275197440L, 8980);
    if (this.view != null) {
      this.sSl.postDelayed(this.sSn, sSj - paramInt);
    }
    GMTrace.o(1205275197440L, 8980);
  }
  
  final class a
    implements Runnable
  {
    a()
    {
      GMTrace.i(1207691116544L, 8998);
      GMTrace.o(1207691116544L, 8998);
    }
    
    public final void run()
    {
      GMTrace.i(1207825334272L, 8999);
      if ((k.this.view != null) && (k.this.view.isPressed()))
      {
        v.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
        k.this.sSi = true;
        k.this.aEw();
      }
      GMTrace.o(1207825334272L, 8999);
    }
  }
  
  private final class b
    implements Runnable
  {
    public b()
    {
      GMTrace.i(1211046559744L, 9023);
      GMTrace.o(1211046559744L, 9023);
    }
    
    public final void run()
    {
      GMTrace.i(1211180777472L, 9024);
      k.this.xK(k.wE);
      GMTrace.o(1211180777472L, 9024);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */