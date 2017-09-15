package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.widget.MMEditText;

class cy
  implements View.OnLongClickListener
{
  public int jZe;
  public int jZf;
  private View.OnCreateContextMenuListener oJh;
  public En_5b8fbb1e.a vAn;
  public View vwl;
  
  public cy(View.OnCreateContextMenuListener paramOnCreateContextMenuListener, En_5b8fbb1e.a parama)
  {
    GMTrace.i(2308813357056L, 17202);
    this.vAn = parama;
    this.oJh = paramOnCreateContextMenuListener;
    GMTrace.o(2308813357056L, 17202);
  }
  
  public boolean onLongClick(View paramView)
  {
    GMTrace.i(2308947574784L, 17203);
    Object localObject1;
    if ((paramView.getTag() instanceof ds))
    {
      ds localds = (ds)paramView.getTag();
      int i = this.vAn.nvG.nto.getSelectionStart();
      if (localds.klJ == 1)
      {
        if (!this.vAn.vHl)
        {
          v.w("MicroMsg.ChattingListLongClickListener", "ChattingUI disable Touch NOW!!!");
          GMTrace.o(2308947574784L, 17203);
          return true;
        }
        if (localds.userName.equals(m.xL()))
        {
          GMTrace.o(2308947574784L, 17203);
          return true;
        }
        if (this.vAn.nvG.sJc)
        {
          v.i("MicroMsg.ChattingListLongClickListener", "ChatFooter VoiceInputPanel Show NOW!!!");
          GMTrace.o(2308947574784L, 17203);
          return true;
        }
        Object localObject2;
        if ((o.dH(this.vAn.bTW())) || (this.vAn.vHe))
        {
          g.oSF.i(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
          ap.yY();
          localObject1 = c.xa().fV(localds.chatroomName);
          if (this.vAn.vHe)
          {
            localObject1 = this.vAn.eK(localds.userName);
            localObject2 = new StringBuffer(this.vAn.nvG.bFm());
            ((StringBuffer)localObject2).insert(i, "@" + (String)localObject1 + ' ');
            this.vAn.nvG.p(((StringBuffer)localObject2).toString(), i + ((String)localObject1).length() + 2, true);
            this.vAn.nvG.X(localds.chatroomName, localds.userName, (String)localObject1);
            this.vAn.vHl = false;
            this.vAn.nvG.ab(1, true);
            paramView.postDelayed(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2199560126464L, 16388);
                cy.this.vAn.vHl = true;
                GMTrace.o(2199560126464L, 16388);
              }
            }, 2000L);
          }
        }
        while ((!o.eU(this.vAn.bTW())) || (this.vAn.bTW().contains("@"))) {
          for (;;)
          {
            GMTrace.o(2308947574784L, 17203);
            return true;
            localObject2 = AtSomeoneUI.a((q)localObject1, localds.userName);
            localObject1 = localObject2;
            if (u.mA((String)localObject2)) {
              localObject1 = n.eI(localds.userName);
            }
          }
        }
        g.oSF.i(10976, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
        if ((this.vAn.sLe) && (!this.vAn.vHe)) {}
        for (localObject1 = this.vAn.eK(localds.userName);; localObject1 = n.eI(localds.userName))
        {
          localObject2 = new StringBuffer(this.vAn.nvG.bFm());
          ((StringBuffer)localObject2).insert(i, (String)localObject1);
          this.vAn.nvG.p(((StringBuffer)localObject2).toString(), ((String)localObject1).length() + i, true);
          this.vAn.vHl = false;
          this.vAn.nvG.ab(1, true);
          paramView.postDelayed(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2316866420736L, 17262);
              cy.this.vAn.vHl = true;
              GMTrace.o(2316866420736L, 17262);
            }
          }, 2000L);
          break;
        }
      }
      if (localds.klJ == 9)
      {
        GMTrace.o(2308947574784L, 17203);
        return true;
      }
    }
    if ((paramView.getTag(R.h.cJn) instanceof int[]))
    {
      localObject1 = (int[])paramView.getTag(R.h.cJn);
      this.vAn.i(paramView, localObject1[0], localObject1[1]);
    }
    for (;;)
    {
      GMTrace.o(2308947574784L, 17203);
      return true;
      if (((this.jZe == 0) && (this.jZf == 0)) || (!this.vwl.equals(paramView))) {
        paramView.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            GMTrace.i(14664360525824L, 109258);
            cy.this.jZe = ((int)paramAnonymousMotionEvent.getRawX());
            cy.this.jZf = ((int)paramAnonymousMotionEvent.getRawY());
            cy.this.vwl = paramAnonymousView;
            GMTrace.o(14664360525824L, 109258);
            return false;
          }
        });
      } else {
        this.vAn.i(paramView, this.jZe, this.jZf);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */