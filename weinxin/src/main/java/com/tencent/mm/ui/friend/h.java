package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;

public final class h
  implements e
{
  private Context context;
  private ProgressDialog kng;
  public a wfI;
  
  public h(Context paramContext, a parama)
  {
    GMTrace.i(2797097451520L, 20840);
    this.context = paramContext;
    this.wfI = parama;
    GMTrace.o(2797097451520L, 20840);
  }
  
  public final void Ud(final String paramString)
  {
    GMTrace.i(2797365886976L, 20842);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new b((ArrayList)localObject);
    ap.vd().a(paramString, 0);
    localObject = this.context;
    this.context.getString(R.l.esW);
    this.kng = g.a((Context)localObject, this.context.getString(R.l.esU), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2808908611584L, 20928);
        ap.vd().c(paramString);
        h.this.wfI.lz(false);
        GMTrace.o(2808908611584L, 20928);
      }
    });
    GMTrace.o(2797365886976L, 20842);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2797500104704L, 20843);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    v.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if (paramk.getType() != 489)
    {
      GMTrace.o(2797500104704L, 20843);
      return;
    }
    if (this.kng != null)
    {
      this.kng.dismiss();
      this.kng = null;
    }
    ap.vd().b(489, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      v.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
      g.a(this.context, R.l.esT, R.l.dIG, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2824343650304L, 21043);
          h.this.wfI.lz(true);
          GMTrace.o(2824343650304L, 21043);
        }
      });
      GMTrace.o(2797500104704L, 20843);
      return;
    }
    v.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
    this.wfI.lz(false);
    GMTrace.o(2797500104704L, 20843);
  }
  
  final void j(Cursor paramCursor)
  {
    GMTrace.i(2797231669248L, 20841);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    final ArrayList localArrayList3 = new ArrayList();
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      int j = paramCursor.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = new o();
        ((o)localObject).b(paramCursor);
        localArrayList1.add(((o)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = this.context;
    Object localObject = this.context.getResources().getString(R.l.epM);
    this.context.getResources().getString(R.l.dGk);
    g.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new g.d()
    {
      public final void bN(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(2808237522944L, 20923);
        if (paramAnonymousInt2 != -1) {
          h.this.Ud(((o)localArrayList3.get(paramAnonymousInt2)).field_googlegmail);
        }
        GMTrace.o(2808237522944L, 20923);
      }
    });
    GMTrace.o(2797231669248L, 20841);
  }
  
  public static abstract interface a
  {
    public abstract void lz(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */