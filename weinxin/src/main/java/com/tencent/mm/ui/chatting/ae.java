package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ae
{
  private x fOB;
  public boolean vvA;
  public En_5b8fbb1e.a vzE;
  public cv vzF;
  ChatFooter vzG;
  ChatFooterCustom vzH;
  private boolean vzI;
  long[] vzJ;
  
  public ae(En_5b8fbb1e.a parama, cv paramcv, ChatFooter paramChatFooter, ChatFooterCustom paramChatFooterCustom, x paramx, boolean paramBoolean, long[] paramArrayOfLong)
  {
    GMTrace.i(2179024814080L, 16235);
    this.vzI = false;
    this.vzJ = null;
    this.vzE = parama;
    this.vzG = paramChatFooter;
    this.vzH = paramChatFooterCustom;
    this.vzF = paramcv;
    this.fOB = paramx;
    this.vvA = paramBoolean;
    this.vzJ = paramArrayOfLong;
    this.vzE.uRf.bPV();
    parama = this.vzE;
    paramcv = this.vzE.getString(R.l.dOI);
    paramChatFooter = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2169226919936L, 16162);
        paramAnonymousMenuItem = new Intent();
        Object localObject2 = ae.this.vzF.vDC;
        if (localObject2 != null)
        {
          Object localObject1 = new ArrayList();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject2).next();
            if (localLong != null) {
              ((List)localObject1).add(localLong);
            }
          }
          localObject2 = new long[((List)localObject1).size()];
          localObject1 = ((List)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2[i] = ((Long)((Iterator)localObject1).next()).longValue();
            i += 1;
          }
          paramAnonymousMenuItem.putExtra("k_outside_expose_proof_item_list", (long[])localObject2);
          ae.this.vzE.bOZ().setResult(-1, paramAnonymousMenuItem);
        }
        for (;;)
        {
          paramAnonymousMenuItem.putExtra("k_is_group_chat", ae.this.vvA);
          ae.this.vzE.finish();
          GMTrace.o(2169226919936L, 16162);
          return false;
          ae.this.vzE.bOZ().setResult(0, paramAnonymousMenuItem);
        }
      }
    };
    int i = l.b.uSj;
    parama.uRf.a(2, paramcv, paramChatFooter, null, i);
    this.vzF.vDM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2245596807168L, 16731);
        ae.this.vzF.eG(((Long)paramAnonymousView.getTag()).longValue());
        GMTrace.o(2245596807168L, 16731);
      }
    };
    GMTrace.o(2179024814080L, 16235);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */