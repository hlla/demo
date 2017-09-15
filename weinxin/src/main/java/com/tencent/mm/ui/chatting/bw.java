package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.d;
import java.util.LinkedList;

final class bw
  implements bz.a
{
  bw()
  {
    GMTrace.i(2513361174528L, 18726);
    GMTrace.o(2513361174528L, 18726);
  }
  
  public final void a(ag.a parama, final int paramInt, final En_5b8fbb1e.a parama1, final au paramau)
  {
    GMTrace.i(2513495392256L, 18727);
    final bz.b localb = (bz.b)parama;
    int i = localb.stp.getContext().getResources().getColor(R.e.aUA);
    int j = localb.stp.getContext().getResources().getColor(R.e.aUB);
    final com.tencent.mm.an.a locala = paramau.bMt();
    if (locala == null) {
      localb.mgy.setVisibility(8);
    }
    for (;;)
    {
      localb.stp.invalidate();
      GMTrace.o(2513495392256L, 18727);
      return;
      localb.mgy.setVisibility(0);
      localb.stp.setText(h.b(localb.stp.getContext(), bf.mz(locala.hMG), localb.stp.getTextSize()));
      localb.stp.setMovementMethod(new a());
      Object localObject;
      int k;
      if ((locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) || (locala.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
      {
        i = localb.stp.getContext().getResources().getColor(R.e.aUd);
        j = localb.stp.getContext().getResources().getColor(R.e.aTb);
        if (!paramau.bMp())
        {
          parama = Spannable.Factory.getInstance().newSpannable("    " + localb.stp.getText());
          localObject = localb.stp.getContext().getResources().getDrawable(R.k.dxl);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          d locald = new d((Drawable)localObject);
          locald.wsv = ((int)((((Drawable)localObject).getIntrinsicHeight() - localb.stp.getTextSize() + com.tencent.mm.bg.a.fromDPToPix(localb.stp.getContext(), 2)) / 2.0F));
          parama.setSpan(locald, 0, 3, 33);
          k = 4;
        }
      }
      for (;;)
      {
        final int m = 0;
        while (m < locala.hMI.size())
        {
          localObject = new b();
          ((b)localObject).vCh = new c(i, j)
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(2387464945664L, 17788);
              v.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { locala });
              parama1.a(localb.mgy, paramau, locala, m);
              GMTrace.o(2387464945664L, 17788);
            }
          };
          ((b)localObject).start = ((Integer)locala.hMJ.get(m)).intValue();
          ((b)localObject).end = ((Integer)locala.hMK.get(m)).intValue();
          parama.setSpan(((b)localObject).vCh, ((b)localObject).start + k, ((b)localObject).end + k, 33);
          m += 1;
        }
        i = localb.stp.getContext().getResources().getColor(R.e.aUd);
        j = localb.stp.getContext().getResources().getColor(R.e.aTb);
        parama = Spannable.Factory.getInstance().newSpannable(localb.stp.getText());
        k = 0;
        continue;
        parama = Spannable.Factory.getInstance().newSpannable(localb.stp.getText());
        k = 0;
      }
      localb.stp.setText(parama);
      localb.stp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2520877367296L, 18782);
          v.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
          GMTrace.o(2520877367296L, 18782);
        }
      });
    }
  }
  
  static final class a
    extends LinkMovementMethod
  {
    private bw.c vCg;
    
    a()
    {
      GMTrace.i(2297539067904L, 17118);
      GMTrace.o(2297539067904L, 17118);
    }
    
    private static bw.c a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2297807503360L, 17120);
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      paramTextView = paramTextView.getLayout();
      i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
      paramTextView = (bw.c[])paramSpannable.getSpans(i, i, bw.c.class);
      if (paramTextView.length > 0) {}
      for (paramTextView = paramTextView[0];; paramTextView = null)
      {
        GMTrace.o(2297807503360L, 17120);
        return paramTextView;
      }
    }
    
    public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2297673285632L, 17119);
      if (paramMotionEvent.getAction() == 0)
      {
        this.vCg = a(paramTextView, paramSpannable, paramMotionEvent);
        if (this.vCg != null)
        {
          this.vCg.vCi = true;
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.vCg), paramSpannable.getSpanEnd(this.vCg));
        }
      }
      for (;;)
      {
        GMTrace.o(2297673285632L, 17119);
        return true;
        if (paramMotionEvent.getAction() == 2)
        {
          paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
          if ((this.vCg != null) && (paramTextView != this.vCg))
          {
            this.vCg.vCi = false;
            this.vCg = null;
            Selection.removeSelection(paramSpannable);
          }
        }
        else
        {
          if (this.vCg != null)
          {
            this.vCg.vCi = false;
            super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
          }
          this.vCg = null;
          Selection.removeSelection(paramSpannable);
        }
      }
    }
  }
  
  static final class b
  {
    public int end;
    public int start;
    public ClickableSpan vCh;
    
    b()
    {
      GMTrace.i(2218350608384L, 16528);
      GMTrace.o(2218350608384L, 16528);
    }
  }
  
  static abstract class c
    extends ClickableSpan
  {
    boolean vCi;
    private int vCj;
    private int vCk;
    
    public c(int paramInt1, int paramInt2)
    {
      GMTrace.i(2255797354496L, 16807);
      this.vCj = paramInt1;
      this.vCk = paramInt2;
      GMTrace.o(2255797354496L, 16807);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      GMTrace.i(2255931572224L, 16808);
      super.updateDrawState(paramTextPaint);
      if (this.vCi) {}
      for (int i = this.vCk;; i = this.vCj)
      {
        paramTextPaint.setColor(i);
        paramTextPaint.setUnderlineText(false);
        GMTrace.o(2255931572224L, 16808);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */