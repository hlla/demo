package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.f.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private DialogInterface.OnDismissListener FV;
  private PackageManager aJt;
  private String mimeType;
  a sSW;
  private Intent sSX;
  private int sSY;
  private String sSZ;
  private Bundle sTa;
  private com.tencent.mm.pluginsdk.model.t sTb;
  private ArrayList<String> sTc;
  private c sTd;
  private c sTe;
  private List<c> sTf;
  private String sTg;
  private int sTh;
  private int sTi;
  private boolean sTj;
  private boolean sTk;
  private boolean sTl;
  private long sTm;
  private e sTn;
  private AdapterView.OnItemClickListener sTo;
  private DialogInterface.OnClickListener sTp;
  private DialogInterface.OnClickListener sTq;
  private View.OnClickListener sTr;
  private m sTs;
  private int scene;
  
  public AppChooserUI()
  {
    GMTrace.i(1142058647552L, 8509);
    this.sSX = null;
    this.sSZ = null;
    this.sTa = null;
    this.sTb = null;
    this.sTc = null;
    this.scene = 0;
    this.sTd = null;
    this.sTe = new c();
    this.mimeType = null;
    this.sTj = false;
    this.sTk = false;
    this.sTl = false;
    this.sTo = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1125684084736L, 8387);
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).xM(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).ivb.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).sTA) || ((AppChooserUI.c(AppChooserUI.this).mKh) && ((AppChooserUI.c(AppChooserUI.this).raA) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label270;
            }
            AppChooserUI.b(AppChooserUI.this).jF(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).sTx != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).sTx.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.g.oSF.i(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).sTx.activityInfo.packageName });
          }
          GMTrace.o(1125684084736L, 8387);
          return;
          label270:
          AppChooserUI.b(AppChooserUI.this).jF(true);
        }
      }
    };
    this.sTp = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(16681652977664L, 124288);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).sTx != null))
        {
          ap.yY();
          c.vr().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).sTx.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).sTx.activityInfo.packageName, true);
        }
        GMTrace.o(16681652977664L, 124288);
      }
    };
    this.sTq = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(16681787195392L, 124289);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).sTx != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).sTx.activityInfo.packageName, false);
        }
        GMTrace.o(16681787195392L, 124289);
      }
    };
    this.sTr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1132931842048L, 8441);
        v.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          int i = AppChooserUI.a(AppChooserUI.this).sTu;
          if (i == AppChooserUI.f.sTF)
          {
            if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).ivb.isShowing()))
            {
              AppChooserUI.a(AppChooserUI.this).sTu = AppChooserUI.f.sTG;
              AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
            }
            paramAnonymousView = new f.a();
            if (AppChooserUI.f(AppChooserUI.this) == 1)
            {
              paramAnonymousView.tH("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
              paramAnonymousView.tJ(AppChooserUI.h(AppChooserUI.this).bCs());
              paramAnonymousView.kW(1);
              paramAnonymousView.dl(true);
              com.tencent.mm.plugin.downloader.model.e.akG().a(paramAnonymousView.kFl);
              u.bCB();
              u.wV(AppChooserUI.g(AppChooserUI.this));
              if (AppChooserUI.g(AppChooserUI.this) == 0)
              {
                if (!AppChooserUI.i(AppChooserUI.this)) {
                  break label283;
                }
                com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
              }
            }
            for (;;)
            {
              if (AppChooserUI.g(AppChooserUI.this) == 1) {
                com.tencent.mm.plugin.report.service.g.oSF.i(12809, new Object[] { Integer.valueOf(5), "" });
              }
              GMTrace.o(1132931842048L, 8441);
              return;
              paramAnonymousView.tH(AppChooserUI.h(AppChooserUI.this).No());
              break;
              label283:
              com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
            }
          }
          if (i == AppChooserUI.f.sTH)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            v.i("MicroMsg.AppChooserUI", "installRecommendApp");
            Object localObject = com.tencent.mm.plugin.downloader.model.e.akG().aU(l).path;
            v.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { localObject });
            localObject = new File((String)localObject);
            if (!q.e(paramAnonymousView.uRf.uRz, Uri.fromFile((File)localObject)))
            {
              ap.yY();
              c.vr().set(paramAnonymousView.xL(274560), Long.valueOf(0L));
              if (paramAnonymousView.sSW != null)
              {
                paramAnonymousView.sSW.sTu = AppChooserUI.f.sTF;
                paramAnonymousView.sSW.notifyDataSetChanged();
                GMTrace.o(1132931842048L, 8441);
              }
            }
            else if (paramAnonymousView.sSW != null)
            {
              paramAnonymousView.sSW.sTu = AppChooserUI.f.sTH;
              paramAnonymousView.sSW.notifyDataSetChanged();
            }
          }
        }
        GMTrace.o(1132931842048L, 8441);
      }
    };
    this.FV = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(1147830009856L, 8552);
        AppChooserUI.this.finish();
        GMTrace.o(1147830009856L, 8552);
      }
    };
    this.sTs = new m()
    {
      public final void bg(long paramAnonymousLong)
      {
        GMTrace.i(1115751972864L, 8313);
        GMTrace.o(1115751972864L, 8313);
      }
      
      public final void c(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1115349319680L, 8310);
        v.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!bf.mA(paramAnonymousString)) && (com.tencent.mm.a.e.aO(paramAnonymousString)))
        {
          ap.yY();
          c.vr().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).sTu = AppChooserUI.f.sTH;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        GMTrace.o(1115349319680L, 8310);
      }
      
      public final void d(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1115483537408L, 8311);
        v.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        ap.yY();
        c.vr().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).sTu = AppChooserUI.f.sTF;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        GMTrace.o(1115483537408L, 8311);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        GMTrace.i(14301838442496L, 106557);
        GMTrace.o(14301838442496L, 106557);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        GMTrace.i(1115617755136L, 8312);
        v.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        ap.yY();
        c.vr().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).sTu = AppChooserUI.f.sTF;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        GMTrace.o(1115617755136L, 8312);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        GMTrace.i(1115215101952L, 8309);
        v.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        GMTrace.o(1115215101952L, 8309);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        GMTrace.i(1115080884224L, 8308);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        ap.yY();
        c.vr().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        v.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        GMTrace.o(1115080884224L, 8308);
      }
    };
    GMTrace.o(1142058647552L, 8509);
  }
  
  private static Drawable a(Resources paramResources, int paramInt)
  {
    GMTrace.i(1143535042560L, 8520);
    try
    {
      paramResources = com.tencent.mm.bh.a.b(paramResources, paramInt);
      GMTrace.o(1143535042560L, 8520);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;)
      {
        paramResources = null;
      }
    }
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    GMTrace.i(1143400824832L, 8519);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.aJt.queryIntentActivities(paramIntent, 65536);
    Object localObject = this.sTb.bCt();
    label112:
    int j;
    int i;
    int k;
    if (!bf.mA(((u.a)localObject).sBj))
    {
      this.sSZ = ((u.a)localObject).sBj;
      if (((u.a)localObject).sBh > 0) {
        this.sTe.sTz = getResources().getDrawable(((u.a)localObject).sBh);
      }
      if (((u.a)localObject).sBk <= 0) {
        break label396;
      }
      this.sTe.sTy = getResources().getString(((u.a)localObject).sBk);
      this.sTe.sTA = true;
      this.sTe.raA = this.sTj;
      if (this.sTj) {
        this.sTe.mKh = true;
      }
      if (this.sTk) {
        this.sTe.sTB = true;
      }
      j = 0;
      i = 0;
      k = j;
      if (paramIntent == null) {
        break label448;
      }
      k = j;
      if (paramIntent.size() <= 0) {
        break label448;
      }
      int m = paramIntent.size();
      j = 0;
      label199:
      k = i;
      if (j >= m) {
        break label448;
      }
      v.d("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
      localObject = (ResolveInfo)paramIntent.get(j);
      if (localObject == null) {
        break label445;
      }
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (!paramArrayList.contains(str))) {
        break label445;
      }
      if (!this.sTb.LM(str)) {
        break label411;
      }
      this.sTe.sTx = ((ResolveInfo)localObject);
      this.sTe.mKh = true;
      if (((paramBoolean) || (!this.sTj)) && ((paramBoolean) || (!this.sTe.mKh))) {
        break label445;
      }
      localArrayList.add(0, this.sTe);
      i = 1;
    }
    label396:
    label411:
    label445:
    for (;;)
    {
      j += 1;
      break label199;
      if (((u.a)localObject).sBi <= 0) {
        break;
      }
      this.sSZ = getResources().getString(((u.a)localObject).sBi);
      break;
      this.sTe.sTy = ((u.a)localObject).sBl;
      break label112;
      localArrayList.add(new c((ResolveInfo)localObject, this.sTb.a(this.uRf.uRz, (ResolveInfo)localObject)));
    }
    label448:
    if ((paramBoolean) && (k == 0))
    {
      if ((this.sSY != 0) || (this.mimeType == null)) {
        break label642;
      }
      localArrayList.add(0, this.sTe);
      if (!this.sTk) {
        break label609;
      }
      com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.sTx != null)
        {
          paramArrayList = paramArrayList.sTx.activityInfo.packageName;
          if ((!bf.mA(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label609:
      com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label642:
      localArrayList.add(0, this.sTe);
    }
    GMTrace.o(1143400824832L, 8519);
    return localArrayList;
  }
  
  private int bGo()
  {
    GMTrace.i(1142998171648L, 8516);
    int i = this.sSY;
    GMTrace.o(1142998171648L, 8516);
    return 274496 + i;
  }
  
  private boolean bGp()
  {
    GMTrace.i(1143266607104L, 8518);
    v.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.sTl), Integer.valueOf(this.sTh), Integer.valueOf(this.sTi), Boolean.valueOf(bf.Hq()) });
    if ((this.sTl) && (this.sTh < this.sTi) && (!bf.Hq()) && (f.fuN != 1))
    {
      GMTrace.o(1143266607104L, 8518);
      return true;
    }
    GMTrace.o(1143266607104L, 8518);
    return false;
  }
  
  private Drawable c(ResolveInfo paramResolveInfo)
  {
    GMTrace.i(1143669260288L, 8521);
    try
    {
      Drawable localDrawable;
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        localDrawable = a(this.aJt.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          GMTrace.o(1143669260288L, 8521);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = a(this.aJt.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          GMTrace.o(1143669260288L, 8521);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      v.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.aJt);
      GMTrace.o(1143669260288L, 8521);
    }
    return paramResolveInfo;
  }
  
  private void i(int paramInt, String paramString, boolean paramBoolean)
  {
    GMTrace.i(1143132389376L, 8517);
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.sTa);
    setResult(paramInt, localIntent);
    finish();
    GMTrace.o(1143132389376L, 8517);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1142595518464L, 8513);
    GMTrace.o(1142595518464L, 8513);
    return -1;
  }
  
  public void onBackPressed()
  {
    GMTrace.i(1142729736192L, 8514);
    super.onBackPressed();
    i(0, null, false);
    GMTrace.o(1142729736192L, 8514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1142192865280L, 8510);
    super.onCreate(paramBundle);
    u.bCB();
    u.wS(this.sSY);
    x.a(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      v.w("ChooseActivity", "Target is not an intent: " + paramBundle);
      i(0, null, false);
      GMTrace.o(1142192865280L, 8510);
      return;
    }
    this.sSX = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.sSY = ((Intent)localObject).getIntExtra("type", 0);
    this.sTa = ((Intent)localObject).getBundleExtra("transferback");
    this.sTc = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.sTk = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    int i;
    if (ap.zb())
    {
      ap.yY();
      this.sTg = ((String)c.vr().get(xL(274528), ""));
      if ((TextUtils.isEmpty(this.sTg)) || (!p.n(this.uRf.uRz, this.sTg)) || ((this.sTc != null) && (!this.sTc.isEmpty()) && (!this.sTc.contains(this.sTg)))) {
        break label1220;
      }
      Intent localIntent = new Intent(this.sSX);
      localIntent.setPackage(this.sTg);
      if (!bf.j(this, localIntent)) {
        break label372;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (this.scene != 6))
      {
        i(-1, this.sTg, true);
        GMTrace.o(1142192865280L, 8510);
        return;
        v.e("MicroMsg.AppChooserUI", "acc not ready");
        i(4097, null, false);
        GMTrace.o(1142192865280L, 8510);
        return;
        label372:
        i = 0;
      }
      else
      {
        this.aJt = getPackageManager();
        this.sSW = new a();
        u.bCB();
        this.sTb = u.t(this.sSY, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.sTj = this.sTb.dt(this.uRf.uRz);
        ap.yY();
        this.sTh = ((Integer)c.vr().get(bGo(), Integer.valueOf(0))).intValue();
        u.bCB();
        this.sTi = u.wR(this.sSY);
        v.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.sTj), Integer.valueOf(this.sTh) });
        boolean bool;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.sTl = bool;
          if (this.sTh < this.sTi) {
            break label708;
          }
          i = 1;
          label546:
          this.sTf = a(this.sSX, bGp(), this.sTc);
          if ((i == 0) && (!this.sTj))
          {
            ap.yY();
            c.vr().set(bGo(), Integer.valueOf(this.sTh + 1));
          }
          if (!this.sTj) {
            break label713;
          }
          u.bCB();
          u.wU(this.sSY);
        }
        for (;;)
        {
          if ((this.sTf != null) && (this.sTf.size() == 1) && ((!bGp()) || (this.sTj)))
          {
            paramBundle = (c)this.sTf.get(0);
            if (paramBundle != null)
            {
              if (paramBundle.sTx != null)
              {
                i(-1, paramBundle.sTx.activityInfo.packageName, false);
                GMTrace.o(1142192865280L, 8510);
                return;
                bool = false;
                break;
                label708:
                i = 0;
                break label546;
                label713:
                if (i != 0) {
                  continue;
                }
                u.bCB();
                u.wT(this.sSY);
                continue;
              }
              i(4098, null, false);
              GMTrace.o(1142192865280L, 8510);
              return;
            }
            i(4097, null, false);
            GMTrace.o(1142192865280L, 8510);
            return;
          }
        }
        zb(8);
        if ((this.sTf != null) && (!this.sTf.isEmpty()))
        {
          this.sSW.kGq = this.sTf;
          ap.yY();
          this.sTm = ((Long)c.vr().get(xL(274560), Long.valueOf(0L))).longValue();
          localObject = com.tencent.mm.plugin.downloader.model.e.akG().aU(this.sTm);
          v.d("MicroMsg.AppChooserUI", "downloadId:" + this.sTm + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (com.tencent.mm.a.e.aO(((FileDownloadTaskInfo)localObject).path)) && (this.sSW != null))
          {
            this.sSW.sTu = f.sTH;
            this.sSW.notifyDataSetChanged();
          }
          this.sTn = new e(this.uRf.uRz);
          localObject = this.sTn;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.sTn.sTD = this.sTo;
            this.sTn.sTq = this.sTq;
            this.sTn.sTE = this.sTp;
            this.sTn.khv = this.sSW;
            this.sTn.FV = this.FV;
            paramBundle = this.sTn;
            if (paramBundle.sTD != null) {
              paramBundle.sTC.setOnItemClickListener(paramBundle.sTD);
            }
            if (paramBundle.khv != null) {
              paramBundle.sTC.setAdapter(paramBundle.khv);
            }
            paramBundle.ivb = com.tencent.mm.ui.base.g.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.sTC, paramBundle.mContext.getString(R.l.dIO), paramBundle.mContext.getString(R.l.dIN), paramBundle.sTq, paramBundle.sTE, R.e.aUd);
            paramBundle.ivb.setOnDismissListener(paramBundle.FV);
            paramBundle.ivb.show();
            if ((!this.sTk) && (this.sTj) && (i == 0))
            {
              this.sTd = this.sTe;
              this.sTn.jF(true);
            }
            com.tencent.mm.plugin.downloader.model.e.akG();
            b.a(this.sTs);
            GMTrace.o(1142192865280L, 8510);
            return;
          }
        }
        i(4097, null, false);
        GMTrace.o(1142192865280L, 8510);
        return;
        label1220:
        i = 0;
      }
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1142461300736L, 8512);
    super.onDestroy();
    com.tencent.mm.plugin.downloader.model.e.akG();
    b.b(this.sTs);
    if (this.sTn != null) {
      this.sTn.ivb.dismiss();
    }
    GMTrace.o(1142461300736L, 8512);
  }
  
  protected void onResume()
  {
    GMTrace.i(1142327083008L, 8511);
    super.onResume();
    if ((this.sTk) && (this.sSX != null) && (this.sTb.s(this, this.sSX)))
    {
      v.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.sTk = false;
      this.sTe.sTB = false;
    }
    this.sTj = this.sTb.dt(this.uRf.uRz);
    this.sTf = a(this.sSX, bGp(), this.sTc);
    if ((this.sTj) && (this.sTd == null))
    {
      this.sTd = this.sTe;
      this.sTn.jF(true);
    }
    if (this.sSW != null)
    {
      this.sSW.kGq = this.sTf;
      this.sSW.notifyDataSetChanged();
    }
    GMTrace.o(1142327083008L, 8511);
  }
  
  final int xL(int paramInt)
  {
    GMTrace.i(1142863953920L, 8515);
    if (this.mimeType != null)
    {
      i = this.sSY;
      int j = this.mimeType.hashCode();
      GMTrace.o(1142863953920L, 8515);
      return i + paramInt + j;
    }
    int i = this.sSY;
    GMTrace.o(1142863953920L, 8515);
    return i + paramInt;
  }
  
  final class a
    extends BaseAdapter
  {
    List<AppChooserUI.c> kGq;
    int sTu;
    
    public a()
    {
      GMTrace.i(1106625167360L, 8245);
      this.kGq = new ArrayList();
      this.sTu = AppChooserUI.f.sTF;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      GMTrace.o(1106625167360L, 8245);
    }
    
    public final int getCount()
    {
      GMTrace.i(1107162038272L, 8249);
      if (this.kGq == null)
      {
        GMTrace.o(1107162038272L, 8249);
        return 0;
      }
      int i = this.kGq.size();
      GMTrace.o(1107162038272L, 8249);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1106893602816L, 8247);
      long l = paramInt;
      GMTrace.o(1106893602816L, 8247);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(16682055630848L, 124291);
      if (xM(paramInt).sTA)
      {
        GMTrace.o(16682055630848L, 124291);
        return 1;
      }
      GMTrace.o(16682055630848L, 124291);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      GMTrace.i(1106759385088L, 8246);
      AppChooserUI.c localc1 = xM(paramInt);
      label81:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.uRf.uRz);
        if (localc1.sTA)
        {
          paramInt = R.i.cUu;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc1.sTz == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc1 });
          }
          paramViewGroup.mCX.setImageDrawable(localc1.sTz);
          paramViewGroup.mCY.setText(localc1.sTy);
          if ((localc1 == null) || ((localc1.sTA) && (!localc1.raA) && ((!localc1.sTA) || (!localc1.mKh) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc1.sTB)) {
            break label456;
          }
          paramViewGroup.sTv.setVisibility(8);
          paramViewGroup.sTw.setVisibility(0);
          Object localObject = paramViewGroup.sTw;
          AppChooserUI.c localc2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localc2 instanceof AppChooserUI.c)) {
            break label450;
          }
          localc2 = (AppChooserUI.c)localc2;
          if (((localc2.sTx == null) || (localc1.sTx == null) || (!localc2.sTx.activityInfo.packageName.equals(localc1.sTx.activityInfo.packageName))) && ((!localc2.sTA) || (!localc1.sTA))) {
            break label450;
          }
          bool = true;
          label309:
          ((RadioButton)localObject).setChecked(bool);
          label316:
          if (!localc1.sTA) {
            break label642;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label622;
          }
          paramViewGroup.mDa.setText(R.l.eGW);
          label345:
          localObject = paramViewGroup.mDa;
          paramInt = i;
          if (bf.mA(AppChooserUI.l(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc1))) {
          paramViewGroup.sTw.setChecked(true);
        }
        GMTrace.o(1106759385088L, 8246);
        return paramView;
        paramInt = R.i.cUt;
        break;
        paramViewGroup = (AppChooserUI.b)paramView.getTag();
        break label81;
        label450:
        bool = false;
        break label309;
        label456:
        paramViewGroup.sTv.setVisibility(0);
        paramViewGroup.sTw.setVisibility(8);
        paramViewGroup.sTv.setOnClickListener(AppChooserUI.k(AppChooserUI.this));
        if (this.sTu == AppChooserUI.f.sTF)
        {
          if (localc1.sTB) {
            paramViewGroup.sTv.setText(R.l.dHF);
          }
          for (;;)
          {
            paramViewGroup.sTv.setEnabled(true);
            break;
            paramViewGroup.sTv.setText(R.l.dGw);
          }
        }
        if (this.sTu == AppChooserUI.f.sTG)
        {
          paramViewGroup.sTv.setText(R.l.dGB);
          paramViewGroup.sTv.setEnabled(false);
          break label316;
        }
        if (this.sTu != AppChooserUI.f.sTH) {
          break label316;
        }
        if (localc1.sTB) {
          paramViewGroup.sTv.setText(R.l.dII);
        }
        for (;;)
        {
          paramViewGroup.sTv.setEnabled(true);
          break;
          paramViewGroup.sTv.setText(R.l.dIH);
        }
        label622:
        paramViewGroup.mDa.setText(bf.mz(AppChooserUI.l(AppChooserUI.this)));
        break label345;
        label642:
        paramViewGroup.mDa.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(16681921413120L, 124290);
      GMTrace.o(16681921413120L, 124290);
      return 2;
    }
    
    public final AppChooserUI.c xM(int paramInt)
    {
      GMTrace.i(1107027820544L, 8248);
      if (this.kGq == null)
      {
        GMTrace.o(1107027820544L, 8248);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.kGq.get(paramInt);
      GMTrace.o(1107027820544L, 8248);
      return localc;
    }
  }
  
  final class b
  {
    ImageView mCX;
    TextView mCY;
    TextView mDa;
    TextView sTv;
    RadioButton sTw;
    
    public b(View paramView)
    {
      GMTrace.i(1119912722432L, 8344);
      this.mCX = ((ImageView)paramView.findViewById(R.h.bpw));
      this.mCY = ((TextView)paramView.findViewById(R.h.bpC));
      this.mDa = ((TextView)paramView.findViewById(R.h.bpq));
      this.sTv = ((TextView)paramView.findViewById(R.h.bpJ));
      this.sTw = ((RadioButton)paramView.findViewById(R.h.bpH));
      GMTrace.o(1119912722432L, 8344);
    }
  }
  
  final class c
  {
    boolean mKh;
    boolean raA;
    boolean sTA;
    boolean sTB;
    ResolveInfo sTx;
    CharSequence sTy;
    Drawable sTz;
    
    public c()
    {
      GMTrace.i(1095216660480L, 8160);
      GMTrace.o(1095216660480L, 8160);
    }
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      GMTrace.i(1095350878208L, 8161);
      this.sTx = paramResolveInfo;
      this.sTy = paramCharSequence;
      this.sTA = false;
      this.raA = true;
      this.sTB = false;
      GMTrace.o(1095350878208L, 8161);
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d()
    {
      GMTrace.i(1059514744832L, 7894);
      GMTrace.o(1059514744832L, 7894);
    }
  }
  
  final class e
  {
    DialogInterface.OnDismissListener FV;
    public h ivb;
    BaseAdapter khv;
    Context mContext;
    String mTitle;
    ListView sTC;
    AdapterView.OnItemClickListener sTD;
    DialogInterface.OnClickListener sTE;
    DialogInterface.OnClickListener sTq;
    
    public e(Context paramContext)
    {
      GMTrace.i(1118704762880L, 8335);
      this.mContext = paramContext;
      this.sTC = ((ListView)View.inflate(this.mContext, R.i.cUs, null));
      GMTrace.o(1118704762880L, 8335);
    }
    
    public final void jF(boolean paramBoolean)
    {
      GMTrace.i(1119107416064L, 8338);
      if (this.ivb != null)
      {
        if (!paramBoolean)
        {
          this.ivb.a(R.l.dIO, null);
          this.ivb.b(R.l.dIN, null);
          GMTrace.o(1119107416064L, 8338);
          return;
        }
        this.ivb.a(R.l.dIO, this.sTq);
        this.ivb.b(R.l.dIN, this.sTE);
      }
      GMTrace.o(1119107416064L, 8338);
    }
  }
  
  public static enum f
  {
    static
    {
      GMTrace.i(1095753531392L, 8164);
      sTF = 1;
      sTG = 2;
      sTH = 3;
      sTI = new int[] { sTF, sTG, sTH };
      GMTrace.o(1095753531392L, 8164);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/AppChooserUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */