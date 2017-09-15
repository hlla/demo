package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bg.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.x.n;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View kFL;
  private Context mContext;
  private View vUp;
  private TextView vUq;
  private boolean vUr;
  private boolean vUs;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1838246002688L, 13696);
    this.kFL = null;
    this.vUr = true;
    this.mContext = paramContext;
    init();
    bXD();
    GMTrace.o(1838246002688L, 13696);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1838111784960L, 13695);
    this.kFL = null;
    this.vUr = true;
    this.mContext = paramContext;
    init();
    bXD();
    GMTrace.o(1838111784960L, 13695);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1837977567232L, 13694);
    this.kFL = null;
    this.vUr = true;
    this.mContext = paramContext;
    init();
    bXD();
    GMTrace.o(1837977567232L, 13694);
  }
  
  private void init()
  {
    GMTrace.i(1838380220416L, 13697);
    this.vUs = false;
    View.inflate(getContext(), R.i.cVD, this);
    this.kFL = findViewById(R.h.bGk);
    this.vUp = this.kFL.findViewById(R.h.btC);
    Object localObject = this.vUp.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.U(getContext(), R.f.aWL) * a.dL(getContext())));
    this.vUp.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.kFL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1780398161920L, 13265);
        Intent localIntent = new Intent();
        localIntent.putExtra("intent_service_type", 251658241);
        com.tencent.mm.bb.d.b(paramAnonymousView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", localIntent);
        GMTrace.o(1780398161920L, 13265);
      }
    });
    this.vUp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1729932296192L, 12889);
        if ((BizContactEntranceView.a(BizContactEntranceView.this) instanceof MMActivity)) {
          ((MMActivity)BizContactEntranceView.a(BizContactEntranceView.this)).aGY();
        }
        GMTrace.o(1729932296192L, 12889);
        return false;
      }
    });
    localObject = (MaskLayout)this.vUp.findViewById(R.h.btB);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).view;
    n.Bl();
    localImageView.setImageBitmap(com.tencent.mm.x.d.hm("service_officialaccounts"));
    this.vUq = ((TextView)((MaskLayout)localObject).findViewById(R.h.cIC));
    GMTrace.o(1838380220416L, 13697);
  }
  
  final void bXD()
  {
    GMTrace.i(1838514438144L, 13698);
    long l = System.currentTimeMillis();
    ap.yY();
    int j = c.wR().bLl();
    View localView;
    if (j > 0)
    {
      this.vUr = true;
      localView = this.vUp;
      if (!this.vUr) {
        break label135;
      }
    }
    label135:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.vUr) {
        ap.vL().D(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            GMTrace.i(1807375925248L, 13466);
            Object localObject1 = w.DH();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo").append(" where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1").append(" ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            v.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((com.tencent.mm.modelbiz.d)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              ap.yY();
              long l2 = bf.bx(c.vr().get(233473, null));
              v.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(1793283063808L, 13361);
                  TextView localTextView = BizContactEntranceView.c(BizContactEntranceView.this);
                  if ((BizContactEntranceView.b(BizContactEntranceView.this)) && (l1 > this.vUv)) {}
                  for (int i = 0;; i = 4)
                  {
                    localTextView.setVisibility(i);
                    GMTrace.o(1793283063808L, 13361);
                    return;
                  }
                }
              });
              GMTrace.o(1807375925248L, 13466);
              return;
              if (!((Cursor)localObject1).moveToFirst())
              {
                ((Cursor)localObject1).close();
              }
              else
              {
                l1 = ((Cursor)localObject1).getLong(0);
                ((Cursor)localObject1).close();
              }
            }
          }
        });
      }
      v.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.vUr), Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(1838514438144L, 13698);
      return;
      this.vUr = false;
      break;
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    int i = 0;
    GMTrace.i(1838648655872L, 13699);
    v.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.vUr) });
    View localView = this.kFL;
    if (this.vUr) {}
    for (;;)
    {
      localView.setVisibility(i);
      GMTrace.o(1838648655872L, 13699);
      return;
      i = 8;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/BizContactEntranceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */