package com.tencent.mm.ui.friend;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hh.b;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.hi.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i
  extends ContentObserver
  implements e
{
  private String fOz;
  private boolean hte;
  private Context mContext;
  private int progress;
  private ContentResolver pwX;
  private boolean pwY;
  private boolean pwZ;
  private String[] pxc;
  private s uYL;
  private ProgressBar uYl;
  private h uYm;
  private ad uYn;
  private String vcw;
  private final a wfL;
  private com.tencent.mm.modelfriend.t wfM;
  private com.tencent.mm.modelfriend.t wfN;
  private s wfO;
  private String wfP;
  private boolean wfQ;
  private View wfR;
  private String wfS;
  public boolean wfT;
  private int wfU;
  
  public i(int paramInt, Context paramContext, a parama)
  {
    super(ad.fetchFreeHandler());
    GMTrace.i(2788104863744L, 20773);
    this.pwY = false;
    this.pwZ = false;
    this.hte = false;
    this.progress = 0;
    this.uYm = null;
    this.wfQ = false;
    this.wfS = null;
    this.wfT = true;
    this.uYn = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2830651883520L, 21090);
        if (((i.a(i.this) != null) && (!i.a(i.this).isShowing())) || (i.b(i.this)))
        {
          GMTrace.o(2830651883520L, 21090);
          return;
        }
        i.a(i.this, i.c(i.this) + 1);
        i.d(i.this).setProgress(i.c(i.this));
        if (i.c(i.this) < i.d(i.this).getMax() - 2)
        {
          sendEmptyMessageDelayed(0, 1000L);
          GMTrace.o(2830651883520L, 21090);
          return;
        }
        i.e(i.this);
        i.d(i.this).setIndeterminate(true);
        if (!i.f(i.this))
        {
          if (i.a(i.this) != null) {
            i.a(i.this).dismiss();
          }
          i.g(i.this);
        }
        GMTrace.o(2830651883520L, 21090);
      }
    };
    this.wfU = paramInt;
    this.wfQ = false;
    this.mContext = paramContext;
    this.pxc = this.mContext.getResources().getStringArray(R.c.aSp);
    this.wfR = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.dll, null);
    this.uYl = ((ProgressBar)this.wfR.findViewById(R.h.cth));
    this.wfL = parama;
    GMTrace.o(2788104863744L, 20773);
  }
  
  private boolean aF(int paramInt, String paramString)
  {
    boolean bool2 = true;
    GMTrace.i(2788507516928L, 20776);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      GMTrace.o(2788507516928L, 20776);
      return bool1;
      Toast.makeText(this.mContext, R.l.dGM, 0).show();
      bool1 = bool2;
      continue;
      Toast.makeText(this.mContext, R.l.dNq, 0).show();
      bool1 = bool2;
      continue;
      v.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
      this.hte = true;
      if ((b.wfX == this.wfU) || (this.wfU == b.wfY))
      {
        ap.yY();
        c.vr().set(4097, "");
        ap.yY();
        c.vr().set(6, this.fOz);
        this.mContext.getApplicationContext();
        com.tencent.mm.modelfriend.a.EM();
      }
      zx(1);
      Toast.makeText(this.mContext, R.l.dNn, 0).show();
      bool1 = bool2;
      continue;
      paramString = com.tencent.mm.f.a.dn(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        paramString.a(this.mContext, null, null);
        bool1 = bool2;
        continue;
        Toast.makeText(this.mContext, R.l.dNp, 0).show();
        bool1 = bool2;
        continue;
        if (this.wfU == b.wfW)
        {
          zx(3);
          bool1 = bool2;
        }
        else
        {
          g.a(this.mContext, R.l.dNo, R.l.btk, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2816693239808L, 20986);
              GMTrace.o(2816693239808L, 20986);
            }
          });
          bool1 = bool2;
          continue;
          Toast.makeText(this.mContext, R.l.dNs, 0).show();
          bool1 = bool2;
          continue;
          g.a(this.mContext, R.l.dNr, R.l.dIG, null);
          bool1 = bool2;
          continue;
          if (!this.wfQ) {
            break;
          }
          zx(6);
          bool1 = bool2;
          continue;
          g.a(this.mContext, R.l.dNm, R.l.dIG, null);
          bool1 = bool2;
        }
      }
    }
  }
  
  private String bYM()
  {
    GMTrace.i(2789312823296L, 20782);
    String str = "( ";
    int i = 0;
    if (i < this.pxc.length)
    {
      if (i == this.pxc.length - 1) {}
      for (str = str + " body like \"%" + this.pxc[i] + "%\" ) ";; str = str + "body like \"%" + this.pxc[i] + "%\" or ")
      {
        i += 1;
        break;
      }
    }
    str = str + " and date > " + (System.currentTimeMillis() - 300000L) + " ";
    v.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
    GMTrace.o(2789312823296L, 20782);
    return str;
  }
  
  private void j(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2788910170112L, 20779);
    switch (((com.tencent.mm.modelfriend.t)paramk).AJ())
    {
    default: 
      GMTrace.o(2788910170112L, 20779);
      return;
    }
    if (((((com.tencent.mm.modelfriend.t)paramk).AJ() == 2) || (((com.tencent.mm.modelfriend.t)paramk).AJ() == 19)) && (this.uYm != null)) {
      this.uYm.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((((com.tencent.mm.modelfriend.t)paramk).AJ() == 2) || (((com.tencent.mm.modelfriend.t)paramk).AJ() == 19))
      {
        if (this.wfT)
        {
          this.mContext.getApplicationContext();
          com.tencent.mm.modelfriend.a.EM();
        }
        zx(1);
        GMTrace.o(2788910170112L, 20779);
        return;
      }
      if ((((com.tencent.mm.modelfriend.t)paramk).AJ() == 1) || (((com.tencent.mm.modelfriend.t)paramk).AJ() == 18))
      {
        v.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fOz);
        GMTrace.o(2788910170112L, 20779);
        return;
      }
    }
    if (aF(paramInt2, paramString))
    {
      if (this.uYm != null) {
        this.uYm.dismiss();
      }
      this.hte = true;
      GMTrace.o(2788910170112L, 20779);
      return;
    }
    if (((com.tencent.mm.modelfriend.t)paramk).AJ() == 2)
    {
      if (this.uYm != null) {
        this.uYm.dismiss();
      }
      this.hte = true;
      zx(2);
      GMTrace.o(2788910170112L, 20779);
      return;
    }
    this.hte = true;
    if (this.uYm != null) {
      this.uYm.dismiss();
    }
    paramString = com.tencent.mm.f.a.dn(paramString);
    if (paramString != null)
    {
      paramString.a(this.mContext, null, null);
      GMTrace.o(2788910170112L, 20779);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2788910170112L, 20779);
  }
  
  private void zx(int paramInt)
  {
    GMTrace.i(2788641734656L, 20777);
    if ((this.wfU == b.wfX) || (this.wfU == b.wfY)) {
      ap.vd().a(132, this);
    }
    for (;;)
    {
      if (this.wfL != null) {
        this.wfL.zx(paramInt);
      }
      GMTrace.o(2788641734656L, 20777);
      return;
      ap.vd().a(145, this);
    }
  }
  
  public final void Ue(String paramString)
  {
    GMTrace.i(2788239081472L, 20774);
    int i;
    if ((this.wfU == b.wfX) || (this.wfU == b.wfY))
    {
      ap.vd().a(132, this);
      this.fOz = paramString;
      this.pwY = false;
      this.pwZ = false;
      this.wfP = "";
      this.hte = false;
      if ((this.wfU != b.wfX) && (this.wfU != b.wfY)) {
        break label219;
      }
      i = 1;
      if (this.wfU == b.wfY) {
        i = 18;
      }
      this.wfN = new com.tencent.mm.modelfriend.t(this.fOz, i, "", 0, "");
      ap.vd().a(this.wfN, 0);
      if (this.uYm != null) {
        break label272;
      }
      this.uYm = g.a(this.mContext, false, this.mContext.getString(R.l.dNU), this.wfR, "", "", null, null);
    }
    for (;;)
    {
      this.progress = 0;
      this.uYl.setIndeterminate(false);
      this.uYn.sendEmptyMessage(1000);
      GMTrace.o(2788239081472L, 20774);
      return;
      ap.vd().a(145, this);
      break;
      label219:
      paramString = this.fOz;
      if (this.wfQ) {}
      for (i = 8;; i = 5)
      {
        this.uYL = new s(paramString, i, "", 0, "");
        ap.vd().a(this.uYL, 0);
        break;
      }
      label272:
      this.uYm.show();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2788775952384L, 20778);
    v.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((!paramk.equals(this.wfM)) && (!paramk.equals(this.wfN)) && (!paramk.equals(this.wfO)) && (!paramk.equals(this.uYL)))
    {
      v.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    if (this.hte)
    {
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      v.d("MicroMsg.SmsBindMobileObserver", "error net");
      if (this.uYm != null) {
        this.uYm.dismiss();
      }
      zx(4);
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    if ((b.wfX == this.wfU) && (paramk.getType() == 132))
    {
      j(paramInt1, paramInt2, paramString, paramk);
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    if ((b.wfY == this.wfU) && (paramk.getType() == 132))
    {
      j(paramInt1, paramInt2, paramString, paramk);
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    if ((b.wfW == this.wfU) && (paramk.getType() == 145))
    {
      switch (((s)paramk).AJ())
      {
      case 7: 
      default: 
        GMTrace.o(2788775952384L, 20778);
        return;
      }
      if (((((s)paramk).AJ() == 6) || (((s)paramk).AJ() == 9)) && (this.uYm != null)) {
        this.uYm.dismiss();
      }
      int i = ((m.b)((s)paramk).htc.zg()).sYb.tic;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt2 == -35) && (i == 1)))
      {
        if (((s)paramk).AJ() == 6)
        {
          this.wfS = ((s)paramk).Fv();
          v.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.wfS);
          zx(1);
          GMTrace.o(2788775952384L, 20778);
          return;
        }
        if (((s)paramk).AJ() == 9)
        {
          this.wfS = ((s)paramk).Fv();
          v.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.wfS);
          ((s)paramk).getUsername();
          ((s)paramk).Fu();
          GMTrace.o(2788775952384L, 20778);
          return;
        }
        if ((((s)paramk).AJ() == 5) || (((s)paramk).AJ() == 8))
        {
          v.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.fOz);
          if ((((s)paramk).AJ() == 5) && (paramInt2 == -35) && (i == 1))
          {
            this.wfQ = true;
            zx(5);
          }
          GMTrace.o(2788775952384L, 20778);
          return;
        }
      }
      if ((((s)paramk).AJ() == 6) || (((s)paramk).AJ() == 9))
      {
        if (this.uYm != null) {
          this.uYm.dismiss();
        }
        this.hte = true;
        zx(2);
        GMTrace.o(2788775952384L, 20778);
        return;
      }
      if (aF(paramInt2, paramString))
      {
        if (this.uYm != null) {
          this.uYm.dismiss();
        }
        this.hte = true;
        GMTrace.o(2788775952384L, 20778);
        return;
      }
      this.hte = true;
      if (this.uYm != null) {
        this.uYm.dismiss();
      }
      Toast.makeText(this.mContext, this.mContext.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2788775952384L, 20778);
      return;
    }
    Assert.assertTrue("code path should not be here!", false);
    GMTrace.o(2788775952384L, 20778);
  }
  
  public final void bRc()
  {
    GMTrace.i(2789178605568L, 20781);
    v.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.wfP);
    if ((this.pwY) || (this.hte) || (this.pwZ))
    {
      GMTrace.o(2789178605568L, 20781);
      return;
    }
    Object localObject1 = Uri.parse("content://sms/inbox");
    this.pwX = this.mContext.getContentResolver();
    Object localObject3 = bYM();
    if ((localObject3 == null) || (((String)localObject3).equals("")))
    {
      GMTrace.o(2789178605568L, 20781);
      return;
    }
    Object localObject2;
    try
    {
      localObject1 = this.pwX.query((Uri)localObject1, new String[] { "body", "_id", "date" }, (String)localObject3, null, null);
      if (localObject1 == null)
      {
        GMTrace.o(2789178605568L, 20781);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
        v.printErrStackTrace("MicroMsg.SmsBindMobileObserver", localException, "", new Object[0]);
        localObject2 = null;
      }
      i = -1;
      long l1 = 0L;
      while (((Cursor)localObject2).moveToNext())
      {
        long l2 = ((Cursor)localObject2).getLong(2);
        if (l2 > l1)
        {
          i = ((Cursor)localObject2).getPosition();
          l1 = l2;
        }
      }
      this.vcw = null;
      if (i < 0) {
        break label473;
      }
    }
    this.pwZ = true;
    ((Cursor)localObject2).moveToPosition(i);
    localObject3 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("body"));
    localObject3 = Pattern.compile("\\d{4,8}").matcher((CharSequence)localObject3);
    if (((Matcher)localObject3).find()) {}
    for (localObject3 = ((Matcher)localObject3).group();; localObject3 = null)
    {
      this.vcw = ((String)localObject3);
      if (this.uYm != null) {
        this.uYm.setCancelable(true);
      }
      if ((this.wfU != b.wfX) && (this.wfU != b.wfY)) {
        break;
      }
      localObject3 = new hh();
      ((hh)localObject3).fMz.context = this.mContext;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject3);
      localObject3 = ((hh)localObject3).fMA.fMB;
      Object localObject4 = new hi();
      com.tencent.mm.sdk.b.a.uql.m((b)localObject4);
      localObject4 = ((hi)localObject4).fMC.fMD;
      i = 2;
      if (this.wfU == b.wfY) {
        i = 19;
      }
      this.wfM = new com.tencent.mm.modelfriend.t(this.fOz, i, this.vcw, "", (String)localObject3, (String)localObject4);
      ap.vd().a(this.wfM, 0);
      label473:
      ((Cursor)localObject2).close();
      GMTrace.o(2789178605568L, 20781);
      return;
    }
    localObject3 = this.fOz;
    if (this.wfQ) {}
    for (int i = 9;; i = 6)
    {
      this.wfO = new s((String)localObject3, i, this.vcw, 0, "");
      ap.vd().a(this.wfO, 0);
      break;
    }
  }
  
  public final void onChange(boolean paramBoolean)
  {
    GMTrace.i(2789044387840L, 20780);
    super.onChange(paramBoolean);
    if ((this.mContext instanceof Activity))
    {
      paramBoolean = com.tencent.mm.pluginsdk.i.a.a((Activity)this.mContext, "android.permission.READ_SMS", 128, "", "");
      v.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(paramBoolean), bf.bJP(), this.mContext });
      if (!paramBoolean)
      {
        GMTrace.o(2789044387840L, 20780);
        return;
      }
    }
    bRc();
    GMTrace.o(2789044387840L, 20780);
  }
  
  public final void recycle()
  {
    GMTrace.i(2788373299200L, 20775);
    ap.vd().b(132, this);
    ap.vd().b(145, this);
    this.mContext = null;
    this.hte = true;
    if (this.uYm != null) {
      this.uYm.dismiss();
    }
    GMTrace.o(2788373299200L, 20775);
  }
  
  public static abstract interface a
  {
    public abstract void zx(int paramInt);
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(2804747862016L, 20897);
      wfW = 1;
      wfX = 2;
      wfY = 3;
      wfZ = new int[] { wfW, wfX, wfY };
      GMTrace.o(2804747862016L, 20897);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */