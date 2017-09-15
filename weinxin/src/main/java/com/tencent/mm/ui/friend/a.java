package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  public a wev;
  
  public a(Context paramContext, a parama)
  {
    GMTrace.i(2821256642560L, 21020);
    this.context = paramContext;
    this.wev = parama;
    GMTrace.o(2821256642560L, 21020);
  }
  
  public static void X(x paramx)
  {
    GMTrace.i(16019154272256L, 119352);
    x localx = paramx;
    if ((int)paramx.gTG == 0)
    {
      ap.yY();
      c.wR().S(paramx);
      if (bf.mA(paramx.field_username))
      {
        GMTrace.o(16019154272256L, 119352);
        return;
      }
      ap.yY();
      localx = c.wR().Rb(paramx.field_username);
    }
    if ((int)localx.gTG <= 0)
    {
      v.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
      GMTrace.o(16019154272256L, 119352);
      return;
    }
    o.p(localx);
    GMTrace.o(16019154272256L, 119352);
  }
  
  public final void onClick(final View paramView)
  {
    GMTrace.i(2821390860288L, 21021);
    final Object localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).orm;
    final int j = ((b)localObject).position;
    ap.yY();
    localObject = c.wR().Rb(paramView);
    if (bf.mA(((af)localObject).field_username)) {
      ((x)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
      {
        GMTrace.i(2805284732928L, 20901);
        if (paramAnonymousBoolean1)
        {
          a.X(localObject);
          a.this.wev.Ub(paramView);
          GMTrace.o(2805284732928L, 20901);
          return;
        }
        a.this.wev.ba(paramView, paramAnonymousBoolean2);
        GMTrace.o(2805284732928L, 20901);
      }
    });
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).c(paramView, localLinkedList);
    GMTrace.o(2821390860288L, 21021);
  }
  
  public static abstract interface a
  {
    public abstract void Ub(String paramString);
    
    public abstract void ba(String paramString, boolean paramBoolean);
  }
  
  public static final class b
  {
    public int orm;
    public int position;
    public String username;
    
    public b()
    {
      GMTrace.i(2804479426560L, 20895);
      GMTrace.o(2804479426560L, 20895);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */