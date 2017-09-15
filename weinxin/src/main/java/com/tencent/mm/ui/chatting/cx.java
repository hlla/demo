package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;
import com.tencent.mm.ui.widget.celltextview.CellTextView;

final class cx
  implements MMTextView.b
{
  public ad handler;
  public o iuy;
  private ScrollView lhj;
  long oHl;
  public boolean qUy;
  public boolean qUz;
  public int rZb;
  private View.OnTouchListener uVm;
  private En_5b8fbb1e.a vAn;
  private MMTextView vDV;
  private TextView vDW;
  private final int vDX;
  private int vDY;
  public int vDZ;
  
  public cx(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2187480530944L, 16298);
    this.vAn = null;
    this.iuy = null;
    this.vDV = null;
    this.vDW = null;
    this.lhj = null;
    this.oHl = 0L;
    this.vDX = 3;
    this.vDY = 0;
    this.rZb = 0;
    this.vDZ = 0;
    this.qUy = false;
    this.qUz = false;
    this.handler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2154731405312L, 16054);
        paramAnonymousMessage = (View)paramAnonymousMessage.obj;
        if (cx.this.rZb != paramAnonymousMessage.getScrollY())
        {
          cx.this.qUy = true;
          cx.this.handler.sendMessageDelayed(cx.this.handler.obtainMessage(0, paramAnonymousMessage), 5L);
          cx.this.rZb = paramAnonymousMessage.getScrollY();
          GMTrace.o(2154731405312L, 16054);
          return;
        }
        cx.this.qUy = false;
        GMTrace.o(2154731405312L, 16054);
      }
    };
    this.uVm = null;
    this.vAn = parama;
    GMTrace.o(2187480530944L, 16298);
  }
  
  public final boolean dq(View paramView)
  {
    GMTrace.i(16267457069056L, 121202);
    if ((paramView.getTag() instanceof ds))
    {
      ds localds = (ds)paramView.getTag();
      if ((localds.klJ == 0) && (((paramView instanceof TextView)) || ((paramView instanceof CellTextView))) && (localds.fTa != null) && (this.vAn != null))
      {
        Object localObject1 = this.vAn;
        if (this.iuy == null)
        {
          localObject1 = View.inflate(((q)localObject1).uRf.uRz, R.i.cXR, null);
          this.lhj = ((ScrollView)((View)localObject1).findViewById(R.h.bSg));
          this.vDV = ((MMTextView)((View)localObject1).findViewById(R.h.bSh));
          this.vDW = ((TextView)((View)localObject1).findViewById(R.h.bSi));
          this.uVm = new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              GMTrace.i(2316329549824L, 17258);
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                cx.this.oHl = u.NB();
                cx.this.rZb = paramAnonymousView.getScrollY();
                cx.this.vDZ = cx.this.rZb;
                cx.this.handler.removeMessages(0);
                if (cx.this.qUy) {
                  cx.this.qUy = false;
                }
              }
              for (cx.this.qUz = true;; cx.this.qUz = false)
              {
                do
                {
                  GMTrace.o(2316329549824L, 17258);
                  return false;
                } while ((paramAnonymousMotionEvent.getAction() == 2) || ((paramAnonymousMotionEvent.getAction() != 3) && (paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 4)));
                if (Math.abs(cx.this.vDZ - paramAnonymousView.getScrollY()) > 3) {
                  cx.this.handler.sendMessage(cx.this.handler.obtainMessage(0, paramAnonymousView));
                }
                paramAnonymousMotionEvent = cx.this;
                if ((u.NB() - paramAnonymousMotionEvent.oHl < 800L) && (Math.abs(cx.this.vDZ - paramAnonymousView.getScrollY()) <= 3) && (!cx.this.qUz) && (cx.this.iuy != null) && (cx.this.iuy.isShowing()))
                {
                  cx.this.handler.removeMessages(0);
                  cx.this.reset();
                  cx.this.iuy.dismiss();
                }
              }
            }
          };
          this.lhj.setOnTouchListener(this.uVm);
          ((View)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(2365990109184L, 17628);
              if ((cx.this.iuy != null) && (cx.this.iuy.isShowing()))
              {
                cx.this.reset();
                cx.this.iuy.dismiss();
              }
              GMTrace.o(2365990109184L, 17628);
            }
          });
          this.iuy = new o((View)localObject1, -1, -1, true);
          this.iuy.setAnimationStyle(R.m.fop);
          this.iuy.update();
          this.iuy.setBackgroundDrawable(new ColorDrawable(16777215));
          this.iuy.setOnDismissListener(new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              GMTrace.i(2519535190016L, 18772);
              GMTrace.o(2519535190016L, 18772);
            }
          });
        }
        if ((this.iuy != null) && (!this.iuy.isShowing()))
        {
          this.lhj.scrollTo(0, 0);
          localObject1 = "";
          if (!(paramView instanceof TextView)) {
            break label557;
          }
          localObject1 = ((TextView)paramView).getText();
        }
        for (;;)
        {
          Object localObject2 = localObject1;
          if ((localObject1 instanceof SpannableString))
          {
            TextView localTextView = this.vDW;
            localObject2 = localObject1;
            if ((localObject1 instanceof SpannableString))
            {
              localTextView.setText(((SpannableString)localObject1).toString());
              h.d(localTextView, 1);
              localObject2 = localTextView.getText();
            }
            b.hTV.x(localds.fTa);
          }
          this.vAn.aqY();
          this.vDV.setText((CharSequence)localObject2);
          this.vDV.setTextIsSelectable(true);
          this.iuy.showAtLocation(paramView.getRootView(), 17, 0, 0);
          this.iuy.setFocusable(true);
          this.iuy.setTouchable(true);
          this.iuy.setBackgroundDrawable(new ColorDrawable(16777215));
          this.iuy.setOutsideTouchable(true);
          paramView = new a();
          paramView.vEc = new cx.a.a()
          {
            private ClickableSpan vEb;
            
            public final void a(MotionEvent paramAnonymousMotionEvent, Spannable paramAnonymousSpannable, ClickableSpan paramAnonymousClickableSpan)
            {
              GMTrace.i(2375519567872L, 17699);
              int i = paramAnonymousMotionEvent.getAction();
              if (i == 0)
              {
                if (paramAnonymousClickableSpan != null)
                {
                  if ((aa.getContext() != null) && (aa.getContext().getResources() != null)) {
                    paramAnonymousSpannable.setSpan(new BackgroundColorSpan(aa.getContext().getResources().getColor(R.e.aUC)), paramAnonymousSpannable.getSpanStart(paramAnonymousClickableSpan), paramAnonymousSpannable.getSpanEnd(paramAnonymousClickableSpan), 33);
                  }
                  this.vEb = paramAnonymousClickableSpan;
                  GMTrace.o(2375519567872L, 17699);
                }
              }
              else if (i == 1)
              {
                if (paramAnonymousClickableSpan != null)
                {
                  paramAnonymousSpannable.setSpan(new BackgroundColorSpan(-1), paramAnonymousSpannable.getSpanStart(paramAnonymousClickableSpan), paramAnonymousSpannable.getSpanEnd(paramAnonymousClickableSpan), 33);
                  GMTrace.o(2375519567872L, 17699);
                }
              }
              else if ((i == 3) && (this.vEb != null)) {
                paramAnonymousSpannable.setSpan(new BackgroundColorSpan(-1), paramAnonymousSpannable.getSpanStart(this.vEb), paramAnonymousSpannable.getSpanEnd(this.vEb), 33);
              }
              GMTrace.o(2375519567872L, 17699);
            }
          };
          this.vDV.setMovementMethod(paramView);
          this.vDV.setFocusable(false);
          this.vDV.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(2195936247808L, 16361);
              if ((cx.this.iuy != null) && (cx.this.iuy.isShowing())) {
                cx.this.iuy.dismiss();
              }
              GMTrace.o(2195936247808L, 16361);
            }
          });
          this.iuy.update();
          if (localds.fTa.bLP()) {
            g.oSF.i(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          GMTrace.o(16267457069056L, 121202);
          return true;
          label557:
          if ((paramView instanceof CellTextView)) {
            localObject1 = ((CellTextView)paramView).caI();
          }
        }
      }
    }
    GMTrace.o(16267457069056L, 121202);
    return false;
  }
  
  public final void reset()
  {
    GMTrace.i(16014590869504L, 119318);
    this.rZb = 0;
    this.vDZ = 0;
    this.qUy = false;
    this.qUz = false;
    this.handler.removeMessages(0);
    GMTrace.o(16014590869504L, 119318);
  }
  
  public static final class a
    extends LinkMovementMethod
  {
    a vEc;
    
    public a()
    {
      GMTrace.i(2130035343360L, 15870);
      GMTrace.o(2130035343360L, 15870);
    }
    
    public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2130169561088L, 15871);
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 0))
      {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramTextView.getTotalPaddingLeft();
        int n = paramTextView.getTotalPaddingTop();
        int i1 = paramTextView.getScrollX();
        int i2 = paramTextView.getScrollY();
        Object localObject = paramTextView.getLayout();
        j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
        localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
        if (localObject.length != 0)
        {
          if (this.vEc != null) {
            this.vEc.a(paramMotionEvent, paramSpannable, localObject[0]);
          }
          if (i == 1) {
            localObject[0].onClick(paramTextView);
          }
          for (;;)
          {
            GMTrace.o(2130169561088L, 15871);
            return true;
            if (i == 0) {
              Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
            }
          }
        }
        Selection.removeSelection(paramSpannable);
      }
      for (;;)
      {
        boolean bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        GMTrace.o(2130169561088L, 15871);
        return bool;
        if (this.vEc != null) {
          this.vEc.a(paramMotionEvent, paramSpannable, null);
        }
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(MotionEvent paramMotionEvent, Spannable paramSpannable, ClickableSpan paramClickableSpan);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */