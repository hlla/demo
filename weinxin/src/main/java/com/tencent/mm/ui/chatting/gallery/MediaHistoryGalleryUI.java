package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.a.b;
import com.tencent.mm.ui.l;

public class MediaHistoryGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.b
{
  private RecyclerView aak;
  private String kuX;
  private TextView kuZ;
  private ProgressDialog vNT;
  private long vNv;
  private boolean vOY;
  private View vPb;
  private View vPd;
  private View vPe;
  private View vPf;
  private View vPg;
  private a.a vRI;
  private TextView vRJ;
  private boolean vRK;
  private boolean vRL;
  private int vRM;
  private boolean vRN;
  
  public MediaHistoryGalleryUI()
  {
    GMTrace.i(14959236874240L, 111455);
    this.vOY = false;
    this.vRM = -1;
    GMTrace.o(14959236874240L, 111455);
  }
  
  private void BE(int paramInt)
  {
    GMTrace.i(14961115922432L, 111469);
    if ((this.vRI.bWm()) && (paramInt > 0))
    {
      this.vPd.setEnabled(true);
      this.vPe.setEnabled(true);
      this.vPf.setEnabled(true);
      this.vPg.setEnabled(true);
      GMTrace.o(14961115922432L, 111469);
      return;
    }
    this.vPd.setEnabled(false);
    this.vPe.setEnabled(false);
    this.vPf.setEnabled(false);
    this.vPg.setEnabled(false);
    GMTrace.o(14961115922432L, 111469);
  }
  
  private void j(boolean paramBoolean, String paramString)
  {
    GMTrace.i(18823499481088L, 140246);
    v.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = getString(R.l.cbL);
      }
      this.vNT = p.b(this, str, true, 0, null);
      GMTrace.o(18823499481088L, 140246);
      return;
    }
    if ((this.vNT != null) && (this.vNT.isShowing()))
    {
      this.vNT.dismiss();
      this.vNT = null;
    }
    GMTrace.o(18823499481088L, 140246);
  }
  
  public final void Bd(int paramInt)
  {
    GMTrace.i(14960579051520L, 111465);
    qL(getString(R.l.enU, new Object[] { Integer.valueOf(paramInt) }));
    BE(paramInt);
    GMTrace.o(14960579051520L, 111465);
  }
  
  public final void Be(int paramInt)
  {
    GMTrace.i(18823231045632L, 140244);
    bWl();
    j(false, "");
    int i = paramInt;
    if (paramInt == 0) {
      i = R.l.enS;
    }
    if (this.vRN) {
      g.a(this, i, R.l.dIG, true, null);
    }
    this.vRN = false;
    GMTrace.o(18823231045632L, 140244);
  }
  
  protected final void KD()
  {
    GMTrace.i(14959773745152L, 111459);
    super.KD();
    this.vPb = findViewById(R.h.ckZ);
    this.vPe = findViewById(R.h.cJu);
    this.vPg = findViewById(R.h.beu);
    this.vPf = findViewById(R.h.czs);
    this.vPd = findViewById(R.h.bNS);
    this.vPd.setTag(Integer.valueOf(1));
    this.vPe.setTag(Integer.valueOf(0));
    this.vPf.setTag(Integer.valueOf(3));
    this.vPg.setTag(Integer.valueOf(2));
    this.vPd.setOnClickListener(this);
    this.vPe.setOnClickListener(this);
    this.vPf.setOnClickListener(this);
    this.vPg.setOnClickListener(this);
    this.vRJ = ((TextView)findViewById(R.h.bok));
    this.kuZ = ((TextView)findViewById(R.h.cAK));
    this.aak = ((RecyclerView)findViewById(R.h.bWg));
    this.aak.setBackgroundColor(getResources().getColor(R.e.aSI));
    findViewById(R.h.bGr).setBackgroundColor(getResources().getColor(R.e.aSI));
    this.aak.a(this.vRI.eW(this));
    this.aak.a(this.vRI.eX(this));
    this.aak.a(this.vRI.ak(this.kuX, this.vNv));
    this.aak.Zl = true;
    this.aak.ZM = new RecyclerView.k()
    {
      public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(14964471365632L, 111494);
        super.c(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        GMTrace.o(14964471365632L, 111494);
      }
    };
    this.aak.a(new RecyclerView.k()
    {
      private Runnable meG;
      
      private void er(boolean paramAnonymousBoolean)
      {
        GMTrace.i(14962323881984L, 111478);
        if (paramAnonymousBoolean)
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.meG);
          if (MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).getVisibility() != 0)
          {
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.uRf.uRz, R.a.aQX);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setVisibility(0);
            MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).startAnimation(localAnimation);
            GMTrace.o(14962323881984L, 111478);
          }
        }
        else
        {
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).removeCallbacks(this.meG);
          MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).postDelayed(this.meG, 256L);
        }
        GMTrace.o(14962323881984L, 111478);
      }
      
      public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(14962458099712L, 111479);
        super.c(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        Object localObject = (LinearLayoutManager)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).eW(MediaHistoryGalleryUI.this);
        paramAnonymousRecyclerView = (com.tencent.mm.ui.chatting.a.a)MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).bWi();
        localObject = paramAnonymousRecyclerView.Ba(((LinearLayoutManager)localObject).fa());
        if (localObject == null)
        {
          GMTrace.o(14962458099712L, 111479);
          return;
        }
        paramAnonymousRecyclerView = paramAnonymousRecyclerView.eO(((com.tencent.mm.ui.chatting.a.a.c)localObject).hTb);
        MediaHistoryGalleryUI.a(MediaHistoryGalleryUI.this).setText(bf.ap(paramAnonymousRecyclerView, ""));
        GMTrace.o(14962458099712L, 111479);
      }
      
      public final void e(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        GMTrace.i(14962592317440L, 111480);
        if (1 == paramAnonymousInt) {
          er(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.Zf instanceof LinearLayoutManager))
          {
            if (((LinearLayoutManager)paramAnonymousRecyclerView.Zf).fa() == 0) {
              MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.this).r(false, -1);
            }
            n.GX().bi(paramAnonymousInt);
          }
          GMTrace.o(14962592317440L, 111480);
          return;
          if (paramAnonymousInt == 0) {
            er(false);
          }
        }
      }
    });
    qL(this.vRI.Oi());
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(14965276672000L, 111500);
        MediaHistoryGalleryUI.this.finish();
        GMTrace.o(14965276672000L, 111500);
        return true;
      }
    });
    GMTrace.o(14959773745152L, 111459);
  }
  
  public final void bWk()
  {
    GMTrace.i(14960847486976L, 111467);
    this.vRI.bWk();
    qL(getString(R.l.enU, new Object[] { Integer.valueOf(this.vRI.bWj()) }));
    this.vPb.setVisibility(0);
    this.vPb.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRq));
    BE(this.vRI.bWj());
    zi(0);
    a(0, getString(R.l.enp), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(14958565785600L, 111450);
        MediaHistoryGalleryUI.this.bWl();
        GMTrace.o(14958565785600L, 111450);
        return true;
      }
    });
    GMTrace.o(14960847486976L, 111467);
  }
  
  public final void bWl()
  {
    GMTrace.i(14960981704704L, 111468);
    this.vRI.bWl();
    qL(this.vRI.Oi());
    this.vPb.setVisibility(8);
    this.vPb.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRo));
    zi(0);
    a(0, getString(R.l.enq), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(14964202930176L, 111492);
        MediaHistoryGalleryUI.this.bWk();
        GMTrace.o(14964202930176L, 111492);
        return true;
      }
    });
    GMTrace.o(14960981704704L, 111468);
  }
  
  public final void bWn()
  {
    GMTrace.i(18822962610176L, 140242);
    bWl();
    this.vRN = false;
    j(false, "");
    GMTrace.o(18822962610176L, 140242);
  }
  
  public final void bWo()
  {
    GMTrace.i(18822828392448L, 140241);
    this.vRN = true;
    j(true, getString(R.l.esj));
    GMTrace.o(18822828392448L, 140241);
  }
  
  public final void bWp()
  {
    GMTrace.i(18823096827904L, 140243);
    bWl();
    this.vRN = false;
    j(false, "");
    String str = com.tencent.mm.compatible.util.e.gSp.substring(com.tencent.mm.compatible.util.e.gSp.indexOf("tencent/MicroMsg"));
    Toast.makeText(this, getString(R.l.dVb, new Object[] { str }), 1).show();
    GMTrace.o(18823096827904L, 140243);
  }
  
  public final boolean bWq()
  {
    GMTrace.i(18823365263360L, 140245);
    boolean bool = this.vRN;
    GMTrace.o(18823365263360L, 140245);
    return bool;
  }
  
  public final View getChildAt(int paramInt)
  {
    GMTrace.i(14960444833792L, 111464);
    View localView = this.aak.getChildAt(paramInt);
    GMTrace.o(14960444833792L, 111464);
    return localView;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(14960042180608L, 111461);
    int i = R.i.dig;
    GMTrace.o(14960042180608L, 111461);
    return i;
  }
  
  public final void ln(boolean paramBoolean)
  {
    GMTrace.i(14960176398336L, 111462);
    if (paramBoolean)
    {
      j(true, null);
      GMTrace.o(14960176398336L, 111462);
      return;
    }
    this.aak.fn().bc(0);
    GMTrace.o(14960176398336L, 111462);
  }
  
  public void onBackPressed()
  {
    GMTrace.i(18822694174720L, 140240);
    super.onBackPressed();
    v.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
    if (this.vRN)
    {
      this.vRI.bWn();
      GMTrace.o(18822694174720L, 140240);
      return;
    }
    finish();
    GMTrace.o(18822694174720L, 140240);
  }
  
  public void onClick(View paramView)
  {
    GMTrace.i(14960713269248L, 111466);
    this.vRI.Bc(((Integer)paramView.getTag()).intValue());
    GMTrace.o(14960713269248L, 111466);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(14959371091968L, 111456);
    super.onCreate(paramBundle);
    this.vOY = true;
    paramBundle = getIntent();
    boolean bool;
    if (paramBundle.getIntExtra("kintent_intent_source", 0) == 1)
    {
      bool = true;
      this.vRK = bool;
      this.kuX = paramBundle.getStringExtra("kintent_talker");
      this.vRM = paramBundle.getIntExtra("kintent_image_index", -1);
      this.vRL = paramBundle.getBooleanExtra("key_is_biz_chat", false);
      this.vNv = getIntent().getLongExtra("key_biz_chat_id", -1L);
      switch (getIntent().getIntExtra("key_media_type", -1))
      {
      }
    }
    for (paramBundle = a.ae(this, com.tencent.mm.ui.chatting.b.a.c.vNQ);; paramBundle = a.ae(this, com.tencent.mm.ui.chatting.b.a.c.vNQ))
    {
      paramBundle.a(this);
      KD();
      this.vRI.r(true, this.vRM);
      GMTrace.o(14959371091968L, 111456);
      return;
      bool = false;
      break;
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(14959639527424L, 111458);
    super.onDestroy();
    this.vRI.onDetach();
    GMTrace.o(14959639527424L, 111458);
  }
  
  protected void onResume()
  {
    GMTrace.i(14959505309696L, 111457);
    super.onResume();
    this.vRI.onResume();
    if (this.vOY)
    {
      if (!this.vRI.bWm()) {
        break label60;
      }
      bWk();
    }
    for (;;)
    {
      this.vOY = false;
      GMTrace.o(14959505309696L, 111457);
      return;
      label60:
      bWl();
    }
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    GMTrace.i(14960310616064L, 111463);
    v.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.vRM) });
    if (paramBoolean)
    {
      j(false, null);
      this.aak.fn().aab.notifyChanged();
      if (this.vRM != -1) {
        this.aak.Zf.aX(this.vRM);
      }
      while (paramInt <= 0)
      {
        this.kuZ.setVisibility(0);
        this.aak.setVisibility(8);
        this.kuZ.setText(getString(R.l.dVa));
        GMTrace.o(14960310616064L, 111463);
        return;
        int i = this.aak.fn().getItemCount();
        this.aak.Zf.aX(i - 1);
      }
      this.kuZ.setVisibility(8);
      this.aak.setVisibility(0);
      GMTrace.o(14960310616064L, 111463);
      return;
    }
    if (paramInt > 0)
    {
      this.aak.fn().bc(0);
      this.aak.fn().R(0, paramInt);
      GMTrace.o(14960310616064L, 111463);
      return;
    }
    this.aak.fn().bc(0);
    GMTrace.o(14960310616064L, 111463);
  }
  
  private static final class a
  {
    public static a.a ae(Context paramContext, int paramInt)
    {
      GMTrace.i(14964605583360L, 111495);
      Object localObject = null;
      switch (MediaHistoryGalleryUI.6.vRQ[(paramInt - 1)])
      {
      }
      for (paramContext = (Context)localObject;; paramContext = new com.tencent.mm.ui.chatting.c.e(paramContext))
      {
        GMTrace.o(14964605583360L, 111495);
        return paramContext;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */