package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.x.d.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b
  implements a.a, d.a
{
  private String gVb;
  private int hOQ;
  public String jgK;
  public ProgressDialog kGl;
  public x kUK;
  public Context mContext;
  private a sKs;
  public com.tencent.mm.ui.base.h sKt;
  public e sKu;
  private boolean sKv;
  
  public b(Context paramContext, String paramString1, int paramInt, a parama, String paramString2)
  {
    this(paramContext, paramString1, paramInt, parama, true, paramString2);
    GMTrace.i(935765999616L, 6972);
    GMTrace.o(935765999616L, 6972);
  }
  
  public b(Context paramContext, String paramString1, int paramInt, a parama, boolean paramBoolean, String paramString2)
  {
    GMTrace.i(935900217344L, 6973);
    this.sKu = null;
    this.sKv = true;
    this.mContext = paramContext;
    this.jgK = paramString1;
    this.hOQ = paramInt;
    this.sKs = parama;
    this.sKv = paramBoolean;
    this.gVb = paramString2;
    GMTrace.o(935900217344L, 6973);
  }
  
  public b(Context paramContext, String paramString, a parama)
  {
    this(paramContext, paramString, 0, parama, true, "");
    GMTrace.i(935631781888L, 6971);
    GMTrace.o(935631781888L, 6971);
  }
  
  private void MJ(String paramString)
  {
    GMTrace.i(936571305984L, 6978);
    v.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[] { paramString });
    if (this.sKu == null) {
      this.sKu = new e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
        {
          GMTrace.i(965293899776L, 7192);
          if (b.this.kGl != null) {
            b.this.kGl.dismiss();
          }
          if (b.this.sKu != null) {
            ap.vd().b(106, b.this.sKu);
          }
          if (b.this.kGl == null)
          {
            v.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
            b.this.ey(0);
            GMTrace.o(965293899776L, 7192);
            return;
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            v.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            b.this.ey(-1);
            GMTrace.o(965293899776L, 7192);
            return;
          }
          if (b.this.mContext == null)
          {
            v.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
            b.this.ey(-1);
            GMTrace.o(965293899776L, 7192);
            return;
          }
          if (((b.this.mContext instanceof Activity)) && (((Activity)b.this.mContext).isFinishing()))
          {
            v.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
            b.this.ey(-1);
            GMTrace.o(965293899776L, 7192);
            return;
          }
          paramAnonymousString = ((aa)paramAnonymousk).Jy();
          paramAnonymousk = com.tencent.mm.platformtools.n.a(paramAnonymousString.trH);
          if (bf.mA(paramAnonymousk))
          {
            v.e("MicroMsg.AddContactDialog", "searchContact, user is null");
            g.bk(b.this.mContext, b.this.mContext.getResources().getString(R.l.fnu));
            b.this.ey(-1);
            GMTrace.o(965293899776L, 7192);
            return;
          }
          if ((b.this.jgK == null) || (!b.this.jgK.equals(paramAnonymousk))) {
            v.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { b.this.jgK, paramAnonymousk });
          }
          b localb = b.this;
          ap.yY();
          localb.kUK = c.wR().Rb(paramAnonymousk);
          if ((b.this.kUK == null) || ((int)b.this.kUK.gTG == 0))
          {
            v.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramAnonymousk + ", try get by alias");
            localb = b.this;
            ap.yY();
            localb.kUK = c.wR().QY(paramAnonymousk);
            if ((b.this.kUK == null) || ((int)b.this.kUK.gTG == 0))
            {
              v.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
              b.this.kUK = new x(paramAnonymousk);
              b.this.kUK.bO(paramAnonymousString.hAq);
              b.this.kUK.bR(com.tencent.mm.platformtools.n.a(paramAnonymousString.tJy));
              b.this.kUK.bS(com.tencent.mm.platformtools.n.a(paramAnonymousString.trx));
              b.this.kUK.bT(com.tencent.mm.platformtools.n.a(paramAnonymousString.jdField_try));
              b.this.kUK.di(paramAnonymousString.hAl);
              b.this.kUK.ck(RegionCodeDecoder.ab(paramAnonymousString.hAu, paramAnonymousString.hAm, paramAnonymousString.hAn));
              b.this.kUK.ce(paramAnonymousString.hAo);
              b.this.kUK.de(paramAnonymousString.tLd);
              b.this.kUK.cj(paramAnonymousString.tLe);
              b.this.kUK.dd(paramAnonymousString.tLh);
              b.this.kUK.bU(paramAnonymousString.tLg);
              b.this.kUK.ci(paramAnonymousString.tLf);
            }
          }
          for (;;)
          {
            b.this.M(b.this.kUK);
            GMTrace.o(965293899776L, 7192);
            return;
            v.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramAnonymousk });
          }
        }
      };
    }
    ap.vd().a(106, this.sKu);
    paramString = new aa(paramString);
    ap.vd().a(paramString, 0);
    GMTrace.o(936571305984L, 6978);
  }
  
  public final void M(final x paramx)
  {
    GMTrace.i(936168652800L, 6975);
    if (paramx == null)
    {
      v.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
      ey(-1);
      GMTrace.o(936168652800L, 6975);
      return;
    }
    Object localObject1 = this.mContext.getString(R.l.fnt);
    Bitmap localBitmap = com.tencent.mm.x.b.a(paramx.field_username, false, -1);
    if (localBitmap == null) {
      com.tencent.mm.x.n.Bl().a(this);
    }
    if ((localBitmap != null) && (paramx.bKU())) {
      localBitmap = com.tencent.mm.sdk.platformtools.d.a(localBitmap, false, localBitmap.getWidth() / 2);
    }
    for (;;)
    {
      String str = paramx.field_nickname;
      this.sKt = null;
      l locall;
      int i;
      if ((this.mContext instanceof MMActivity))
      {
        if (!this.sKv)
        {
          N(paramx);
          GMTrace.o(936168652800L, 6975);
          return;
        }
        locall = ((MMActivity)this.mContext).uRf;
        i = R.l.dXu;
        paramx.bKU();
        localObject2 = new k.a()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            GMTrace.i(946771853312L, 7054);
            if (paramAnonymousBoolean) {
              b.this.N(paramx);
            }
            for (;;)
            {
              b.this.sKt.dismiss();
              GMTrace.o(946771853312L, 7054);
              return;
              b.this.ey(0);
            }
          }
        };
        if (((localObject1 == null) || (((String)localObject1).length() == 0)) && ((str == null) || (str.length() == 0)))
        {
          v.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
          paramx = null;
          this.sKt = paramx;
        }
      }
      else
      {
        if (this.sKt == null)
        {
          v.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
          ey(-1);
        }
        GMTrace.o(936168652800L, 6975);
        return;
      }
      paramx = d.O(locall.uRz, R.i.cZf);
      h.a locala = new h.a(locall.uRz);
      locala.kH(false);
      locala.kI(false);
      d.l(paramx, false);
      d.a(locall, locala, (k.a)localObject2, paramx, locall.uRz.getResources().getString(i));
      Object localObject2 = (TextView)paramx.findViewById(R.h.bEy);
      ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.d.h.b(locall.uRz, (CharSequence)localObject1, ((TextView)localObject2).getTextSize()));
      localObject1 = (TextView)paramx.findViewById(R.h.bEv);
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.d.h.b(locall.uRz, str, ((TextView)localObject1).getTextSize()));
      if ("".length() == 0)
      {
        paramx.findViewById(R.h.bEs).setVisibility(8);
        label387:
        localObject1 = (ImageView)paramx.findViewById(R.h.bEx);
        if (localObject1 != null)
        {
          if ((localBitmap == null) || (localBitmap.isRecycled())) {
            break label465;
          }
          ((ImageView)localObject1).setImageBitmap(localBitmap);
          d.a(locala, localBitmap);
        }
      }
      for (;;)
      {
        locala.db(paramx);
        paramx = locala.WD();
        paramx.show();
        break;
        ((TextView)paramx.findViewById(R.h.bEs)).setText("");
        break label387;
        label465:
        ((ImageView)localObject1).setVisibility(4);
      }
    }
  }
  
  public final void N(x paramx)
  {
    GMTrace.i(936302870528L, 6976);
    if (this.kGl != null) {
      this.kGl.dismiss();
    }
    Object localObject = this.mContext;
    this.mContext.getString(R.l.dIG);
    this.kGl = g.a((Context)localObject, this.mContext.getString(R.l.fnv), true, null);
    localObject = new a(this.mContext, this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.hOQ));
    ((a)localObject).a(paramx.field_username, localLinkedList, this.gVb);
    GMTrace.o(936302870528L, 6976);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    GMTrace.i(936705523712L, 6979);
    if (this.kGl != null) {
      this.kGl.dismiss();
    }
    if (paramBoolean1)
    {
      this.kUK.tc();
      ap.yY();
      c.wR().a(this.kUK.field_username, this.kUK);
      g.bk(this.mContext, this.mContext.getResources().getString(R.l.fny));
      ey(1);
      GMTrace.o(936705523712L, 6979);
      return;
    }
    ey(-1);
    GMTrace.o(936705523712L, 6979);
  }
  
  public final void ey(int paramInt)
  {
    GMTrace.i(936839741440L, 6980);
    if (this.sKs != null) {
      this.sKs.oX(paramInt);
    }
    GMTrace.o(936839741440L, 6980);
  }
  
  public final void ho(String paramString)
  {
    int j = 1;
    GMTrace.i(936437088256L, 6977);
    if (this.kUK != null)
    {
      int i;
      if ((this.kUK.field_username != null) && (this.kUK.field_username.equals(paramString)))
      {
        i = 1;
        if ((this.kUK.pA() == null) || (!this.kUK.pA().equals(paramString))) {
          break label91;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          break label124;
        }
        GMTrace.o(936437088256L, 6977);
        return;
        i = 0;
        break;
        label91:
        j = 0;
      }
    }
    if ((this.jgK == null) || (!this.jgK.equals(paramString)))
    {
      GMTrace.o(936437088256L, 6977);
      return;
    }
    label124:
    if ((this.sKt == null) || (!this.sKt.isShowing()))
    {
      GMTrace.o(936437088256L, 6977);
      return;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(959522537472L, 7149);
        ImageView localImageView = (ImageView)b.this.sKt.getContentView().findViewById(R.h.bEx);
        if (localImageView != null)
        {
          Bitmap localBitmap2 = com.tencent.mm.x.b.a(b.this.kUK.field_username, false, -1);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 != null)
          {
            localBitmap1 = localBitmap2;
            if (b.this.kUK.bKU()) {
              localBitmap1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap2, false, localBitmap2.getWidth() / 2);
            }
          }
          if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
          {
            localImageView.setImageBitmap(localBitmap1);
            localImageView.setVisibility(0);
          }
        }
        GMTrace.o(959522537472L, 7149);
      }
    });
    GMTrace.o(936437088256L, 6977);
  }
  
  public final void show()
  {
    GMTrace.i(936034435072L, 6974);
    ap.yY();
    this.kUK = c.wR().Rb(this.jgK);
    if ((this.kUK != null) && ((int)this.kUK.gTG <= 0))
    {
      v.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[] { this.jgK });
      ap.yY();
      this.kUK = c.wR().QY(this.jgK);
    }
    if ((this.kUK != null) && ((int)this.kUK.gTG > 0))
    {
      v.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
      if (this.kUK == null)
      {
        v.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
        ey(-1);
        GMTrace.o(936034435072L, 6974);
        return;
      }
      localObject1 = this.kUK.field_username;
      if (!this.kUK.bKU())
      {
        if (w.DH().hO((String)localObject1).CB())
        {
          localObject2 = this.mContext;
          this.mContext.getString(R.l.dIG);
          this.kGl = g.a((Context)localObject2, this.mContext.getString(R.l.fnv), true, null);
          MJ((String)localObject1);
          GMTrace.o(936034435072L, 6974);
          return;
        }
        Object localObject2 = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bep);
        l locall;
        k.a local5;
        View localView;
        if ((this.mContext instanceof MMActivity))
        {
          locall = ((MMActivity)this.mContext).uRf;
          localObject3 = this.mContext.getResources().getString(R.l.fnA);
          local5 = new k.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              GMTrace.i(946503417856L, 7052);
              v.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
              b.this.ey(-1);
              GMTrace.o(946503417856L, 7052);
            }
          };
          localView = d.O(locall.uRz, R.i.cZg);
          localObject1 = d.cL(localView);
          d.a(localView, local5, (o)localObject1);
          if (!bf.mA((String)localObject3)) {
            break label355;
          }
          v.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
          localObject1 = null;
          if (localObject1 == null)
          {
            v.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
            ey(-1);
          }
        }
        GMTrace.o(936034435072L, 6974);
        return;
        label355:
        Object localObject4 = (TextView)localView.findViewById(R.h.bEv);
        ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.d.h.b(locall.uRz, (CharSequence)localObject3, ((TextView)localObject4).getTextSize()));
        Object localObject3 = (Button)localView.findViewById(R.h.bEo);
        localObject4 = (ImageView)localView.findViewById(R.h.bEx);
        if (localObject4 != null)
        {
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break label472;
          }
          ((ImageView)localObject4).setImageBitmap((Bitmap)localObject2);
          ((o)localObject1).setOnDismissListener(new d.6((Bitmap)localObject2));
        }
        for (;;)
        {
          ((Button)localObject3).setOnClickListener(new d.10(local5, localView, (o)localObject1));
          d.a(locall, (o)localObject1);
          break;
          label472:
          ((ImageView)localObject4).setVisibility(8);
        }
      }
      if (com.tencent.mm.j.a.ez(this.kUK.field_type))
      {
        g.bk(this.mContext, this.mContext.getResources().getString(R.l.fny));
        ey(-2);
        GMTrace.o(936034435072L, 6974);
        return;
      }
      M(this.kUK);
      GMTrace.o(936034435072L, 6974);
      return;
    }
    Object localObject1 = this.mContext;
    this.mContext.getString(R.l.dIG);
    this.kGl = g.a((Context)localObject1, this.mContext.getString(R.l.fnv), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(934960693248L, 6966);
        if (b.this.kGl != null)
        {
          b.this.kGl.dismiss();
          b.this.kGl = null;
        }
        GMTrace.o(934960693248L, 6966);
      }
    });
    MJ(this.jgK);
    GMTrace.o(936034435072L, 6974);
  }
  
  public static abstract interface a
  {
    public abstract void oX(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */