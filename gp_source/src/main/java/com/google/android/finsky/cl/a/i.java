package com.google.android.finsky.cl.a;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.finsky.activities.AccessRestrictedActivity;
import com.google.android.finsky.activities.AppsPermissionsActivity;
import com.google.android.finsky.activities.MultiInstallActivity;
import com.google.android.finsky.activities.RetailDemoModeActivity;
import com.google.android.finsky.activities.ReviewsActivity;
import com.google.android.finsky.billing.addresschallenge.AddressChallengeActivity;
import com.google.android.finsky.billing.changesubscriptionprice.ChangeSubscriptionPriceActivity;
import com.google.android.finsky.billing.common.PurchaseFlowConfig;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.billing.gifting.GiftingActivity;
import com.google.android.finsky.billing.lightpurchase.AgeVerificationActivity;
import com.google.android.finsky.billing.lightpurchase.AuthenticatedWebViewActivity;
import com.google.android.finsky.billing.lightpurchase.LightPurchaseFlowActivity;
import com.google.android.finsky.billing.lightpurchase.PurchaseActivity;
import com.google.android.finsky.billing.myaccount.CancelSubscriptionActivity;
import com.google.android.finsky.billing.myaccount.ReactivateSubscriptionActivity;
import com.google.android.finsky.billing.myaccount.SubscriptionCancelSurveyActivity;
import com.google.android.finsky.billing.profile.CatchAbandonmentActivity;
import com.google.android.finsky.billing.redeem.RedeemCodeActivity;
import com.google.android.finsky.billing.updatesubscriptioninstrument.UpdateSubscriptionInstrumentActivity;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.cl.b;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.t;
import com.google.android.finsky.ds.a.aw;
import com.google.android.finsky.ds.a.ax;
import com.google.android.finsky.ds.a.bb;
import com.google.android.finsky.ds.a.bp;
import com.google.android.finsky.ds.a.by;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.ig;
import com.google.android.finsky.ds.a.iz;
import com.google.android.finsky.ds.a.kr;
import com.google.android.finsky.e.af;
import com.google.android.finsky.family.management.FamilyMemberSettingsActivity;
import com.google.android.finsky.family.setup.FamilySetupActivity;
import com.google.android.finsky.library.c;
import com.google.android.finsky.library.g;
import com.google.android.finsky.library.q;
import com.google.android.finsky.marketingoptin.MarketingOptInActivity;
import com.google.android.finsky.notification.m;
import com.google.android.finsky.notification.n;
import com.google.android.finsky.notification.o;
import com.google.android.finsky.screenshotsactivity.ScreenshotsActivityV2;
import com.google.android.finsky.settings.SettingsActivity;
import com.google.android.finsky.setupui.SetupWizardFinalHoldActivity;
import com.google.android.finsky.tos.TosActivity;
import com.google.android.finsky.unauthenticated.UnauthenticatedMainActivity;
import com.google.android.finsky.uninstallmanager.v2.UninstallManagerActivityV2;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.ParcelableProto;
import com.google.android.finsky.wear.WearSupportService;
import com.google.wireless.android.finsky.dfe.e.a.fm;
import com.google.wireless.android.finsky.dfe.nano.ex;
import com.google.wireless.android.finsky.dfe.nano.gi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class i
  implements b
{
  private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "com.google.android.finsky.UNINSTALL_WIZARD_FOR_DETAILS", "com.google.android.finsky.UNINSTALL_WIZARD_FOR_MY_DOWNLOADS", "com.google.android.finsky.PAYMENT_METHODS" })));
  private final com.google.android.finsky.ba.a b;
  private final c c;
  
  public i(com.google.android.finsky.ba.a parama, c paramc)
  {
    this.b = parama;
    this.c = paramc;
  }
  
  private final Intent a(Account paramAccount, Context paramContext, f paramf, af paramaf, Document paramDocument, PurchaseParams paramPurchaseParams, fm paramfm, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (this.b.b)
    {
      paramf = "com.google.android.finsky.tv.ACQUIRE";
      paramf = new Intent(paramf);
      paramf.setPackage(paramContext.getPackageName());
      paramf.putExtra("AcquireActivity.account", paramAccount);
      if (paramDocument != null) {
        paramf.putExtra("AcquireActivity.doc", paramDocument);
      }
      if (paramaf != null) {
        paramaf.a(paramf);
      }
      if (paramPurchaseParams != null) {
        paramf.putExtra("AcquireActivity.purchaseParams", paramPurchaseParams);
      }
      if (paramfm != null) {
        paramf.putExtra("AcquireActivity.redeemParam", ParcelableProto.a(paramfm));
      }
      paramf.putExtra("AcquireActivity.topupRequest", paramBoolean1);
      paramf.putExtra("AcquireActivity.logPair", paramBoolean2);
      return paramf;
    }
    if (paramInt == 1) {}
    label121:
    while (paramInt == 2)
    {
      if (this.b.c)
      {
        paramf = "com.google.android.finsky.wear.ACQUIRE";
        break;
      }
      paramf = "com.google.android.finsky.ACQUIRE";
      break;
    }
    label171:
    Object localObject;
    if (paramPurchaseParams != null)
    {
      paramInt = paramPurchaseParams.i;
      if (paramInt != 0) {}
    }
    else if (!paramBoolean1)
    {
      if (paramPurchaseParams != null)
      {
        localObject = paramPurchaseParams.p;
        if (localObject != null)
        {
          paramInt = ((ex)localObject).h;
          if ((paramInt != 3) || (paramPurchaseParams.u == null)) {}
        }
      }
    }
    for (;;)
    {
      label209:
      paramf = "com.google.android.finsky.phoenix.ACQUIRE";
      break;
      if (paramInt != 1)
      {
        if (!paramf.a(12659348L)) {
          break label121;
        }
        continue;
      }
      if (!paramf.a(12642294L))
      {
        break label121;
        if (paramPurchaseParams == null) {
          break label121;
        }
        localObject = paramPurchaseParams.k;
        if (localObject == null) {
          break label121;
        }
        paramInt = ((bp)localObject).a;
        if (((paramInt == 6) && (paramf.a(12660156L))) || ((paramInt == 2) && (paramf.a(12660157L))) || ((paramInt == 1) && (paramf.a(12660158L))) || ((paramInt == 4) && (paramf.a(12660159L)))) {
          break label121;
        }
        label353:
        long l;
        if (paramDocument == null) {
          if (paramPurchaseParams.k.c == 1)
          {
            l = 12658567L;
            label370:
            paramBoolean3 = paramf.a(l);
            if ((paramPurchaseParams.n) || (paramPurchaseParams.o)) {}
          }
        }
        for (;;)
        {
          if (!paramBoolean3) {
            break label528;
          }
          break label209;
          if ((!paramBoolean3) || (!paramf.a(12659349L))) {
            break;
          }
          break label209;
          l = 12658568L;
          break label370;
          if (paramPurchaseParams.k.c != 1) {
            break label353;
          }
          localObject = paramDocument.a(paramPurchaseParams.s, paramPurchaseParams.t);
          if (localObject != null) {}
          for (paramBoolean3 = ((by)localObject).b;; paramBoolean3 = true)
          {
            if (!paramBoolean3) {}
            for (l = 12660247L;; l = 12660260L)
            {
              if (!paramf.a(l)) {
                break label503;
              }
              break;
            }
            label503:
            break label353;
          }
          if (!paramBoolean3) {
            break label171;
          }
          paramBoolean3 = paramf.a(12656071L);
        }
        label528:
        break label121;
        if (paramInt != 2) {
          break label121;
        }
      }
    }
  }
  
  private static Intent a(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, AccessRestrictedActivity.class);
    paramContext.putExtra("AccessRestrictedActivity.messageId", paramInt);
    return paramContext;
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, DfeToc paramDfeToc, Class paramClass)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramClass = new Bundle();
    paramClass.putString(paramString2, paramString1);
    paramClass.putParcelable(paramString3, paramDfeToc);
    paramContext.putExtras(paramClass);
    return paramContext;
  }
  
  private static Intent a(m paramm, Context paramContext, af paramaf)
  {
    String str = paramm.d;
    if ("com.google.android.finsky.DEFAULT_CLICK".equals(str))
    {
      paramm = o.a(paramm, paramContext, j.a(paramContext.getApplicationContext()), paramaf);
      paramm.setAction(null);
      return paramm;
    }
    if (!"com.google.android.finsky.VIEW_MY_DOWNLOADS".equals(str))
    {
      if ("com.google.android.finsky.DETAILS".equals(str)) {
        return o.a(paramm, paramContext, j.a(paramContext.getApplicationContext()), paramaf);
      }
      if (a.contains(str)) {
        return o.a(paramm, paramContext, j.a(paramContext.getApplicationContext()), paramaf);
      }
      return null;
    }
    return o.a(paramm, paramContext, j.a(paramContext.getApplicationContext()), null);
  }
  
  private static n a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    n localn = m.b("com.google.android.finsky.DETAILS");
    localn.a = Uri.parse(paramString1);
    if (paramString2 != null) {
      localn.a("continue_url", paramString2);
    }
    if (paramString3 != null) {
      localn.a("override_account", paramString3);
    }
    if (paramString4 != null) {
      localn.a("original_url", paramString4);
    }
    if (paramBoolean) {
      localn.a("clear_back_stack", paramBoolean);
    }
    return localn;
  }
  
  private static m b()
  {
    return m.b("com.google.android.finsky.VIEW_MY_DOWNLOADS").a();
  }
  
  private static n b(String paramString)
  {
    return a(paramString, null, null, null, false);
  }
  
  public final PendingIntent a(m paramm, Context paramContext, int paramInt, af paramaf)
  {
    paramm = a(paramm, paramContext, paramaf);
    if (paramm != null) {
      return o.a(paramm, paramContext, paramInt);
    }
    return null;
  }
  
  public final Intent a(int paramInt, com.google.wireless.android.finsky.a.b.e parame, Bundle paramBundle, af paramaf)
  {
    return AddressChallengeActivity.a(paramInt, parame, paramBundle, paramaf);
  }
  
  public final Intent a(Account paramAccount, Context paramContext, PurchaseParams paramPurchaseParams, f paramf)
  {
    if (paramf.a(12638277L)) {
      return a(paramAccount, paramContext, paramf, null, null, paramPurchaseParams, null, true, 4);
    }
    paramContext = new Bundle();
    paramContext.putParcelable("TvIntentConstants.account", paramAccount);
    paramContext.putParcelable("TvIntentConstants.purchaseParams", paramPurchaseParams);
    paramContext.putString("TvIntentConstants.breadcrumb", paramPurchaseParams.p.a);
    paramAccount = new Intent("com.google.android.finsky.tv.IABV3_PURCHASE");
    paramAccount.putExtras(paramContext);
    return paramAccount;
  }
  
  public final Intent a(Account paramAccount, Context paramContext, PurchaseParams paramPurchaseParams, t paramt, String paramString, f paramf)
  {
    if (paramf.a(12638277L)) {
      return a(paramAccount, paramContext, paramf, null, null, paramPurchaseParams, null, true, 4);
    }
    paramContext = new Bundle();
    paramContext.putParcelable("TvIntentConstants.account", paramAccount);
    paramContext.putParcelable("TvIntentConstants.purchaseParams", paramPurchaseParams);
    if (paramt != null) {
      paramContext.putString("TvIntentConstants.offerFilter", paramt.name());
    }
    paramContext.putString("TvIntentConstants.breadcrumb", paramString);
    paramAccount = new Intent("com.google.android.finsky.tv.PURCHASE");
    paramAccount.putExtras(paramContext);
    return paramAccount;
  }
  
  public final Intent a(Account paramAccount, Context paramContext, f paramf, af paramaf, Document paramDocument, PurchaseParams paramPurchaseParams, fm paramfm, boolean paramBoolean, int paramInt)
  {
    return a(paramAccount, paramContext, paramf, paramaf, paramDocument, paramPurchaseParams, paramfm, false, paramBoolean, false, paramInt);
  }
  
  public final Intent a(Account paramAccount, Context paramContext, f paramf, af paramaf, boolean paramBoolean)
  {
    return a(paramAccount, paramContext, paramf, paramaf, null, null, null, true, false, paramBoolean, 0);
  }
  
  public final Intent a(Account paramAccount, Context paramContext, Document paramDocument, aw paramaw, af paramaf)
  {
    if (paramAccount == null) {
      throw new IllegalArgumentException("account is required");
    }
    if (paramaw != null)
    {
      paramContext = new Intent(paramContext, CancelSubscriptionActivity.class);
      paramContext.putExtra("document", paramDocument);
      paramContext.putExtra("account", paramAccount);
      paramContext.putExtra("cancel_subscription_dialog", ParcelableProto.a(paramaw));
      paramaf.a(paramAccount).a(paramContext);
      com.google.android.finsky.billing.common.j.a(paramContext, paramAccount.name);
      return paramContext;
    }
    throw new IllegalArgumentException("cancellation dialog is required");
  }
  
  public final Intent a(Account paramAccount, Context paramContext, Document paramDocument, iz paramiz, af paramaf)
  {
    if (paramAccount == null) {
      throw new IllegalArgumentException("Account is required.");
    }
    if (paramiz != null)
    {
      paramContext = new Intent(paramContext, ReactivateSubscriptionActivity.class);
      paramContext.putExtra("document", paramDocument);
      paramContext.putExtra("account", paramAccount);
      paramContext.putExtra("reactivate_subscription_dialog", ParcelableProto.a(paramiz));
      paramaf.a(paramAccount).a(paramContext);
      com.google.android.finsky.billing.common.j.a(paramContext, paramAccount.name);
      return paramContext;
    }
    throw new IllegalArgumentException("Reactivation dialog is required.");
  }
  
  public final Intent a(Account paramAccount, PurchaseParams paramPurchaseParams)
  {
    Intent localIntent = new Intent("com.google.android.finsky.wear.IABV3_PURCHASE");
    localIntent.putExtra("PurchaseActivity.account", paramAccount);
    localIntent.putExtra("PurchaseActivity.params", paramPurchaseParams);
    return localIntent;
  }
  
  public final Intent a(Account paramAccount, PurchaseParams paramPurchaseParams, af paramaf)
  {
    return PurchaseActivity.a(paramAccount, paramPurchaseParams, null, null, paramaf);
  }
  
  public final Intent a(Account paramAccount, Document paramDocument, String paramString, int paramInt1, int paramInt2, af paramaf)
  {
    return LightPurchaseFlowActivity.a(paramAccount, paramDocument, paramString, paramInt1, null, paramDocument.a.D, null, 1, null, false, 0, paramInt2, paramaf);
  }
  
  public final Intent a(Account paramAccount, Document paramDocument, String paramString1, int paramInt1, t paramt, String paramString2, String paramString3, boolean paramBoolean, int paramInt2, int paramInt3, af paramaf)
  {
    return LightPurchaseFlowActivity.a(paramAccount, paramDocument, paramString1, paramInt1, paramt, paramDocument.a.D, paramString3, 0, paramString2, paramBoolean, paramInt2, paramInt3, paramaf);
  }
  
  public final Intent a(Account paramAccount, String paramString1, String paramString2, af paramaf)
  {
    return AuthenticatedWebViewActivity.a(paramAccount, paramString1, paramString2, paramaf);
  }
  
  public final Intent a(Activity paramActivity, Account paramAccount)
  {
    Object localObject2 = null;
    Object localObject1 = paramActivity.getIntent();
    if (localObject1 != null) {}
    for (localObject1 = ((Intent)localObject1).getStringExtra("family_app_id");; localObject1 = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = this.c.a(paramAccount).c().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((q)((Iterator)localObject1).next()).g.startsWith((String)com.google.android.finsky.ag.d.dg.b())) {
            localObject1 = "pfm";
          }
        }
      }
      for (;;)
      {
        paramAccount = paramAccount.name;
        Intent localIntent = new Intent(paramActivity, FamilyMemberSettingsActivity.class).putExtra("accountName", paramAccount).putExtra("memberSettingTheme", 2132017472);
        localIntent = new Intent("com.google.android.gms.family.v2.MANAGE").setPackage((String)com.google.android.finsky.ag.d.df.b()).putExtra("accountName", paramAccount).putExtra("appId", (String)localObject1).putExtra("manageMemberIntent", localIntent).putExtra("manageKIntent", localIntent);
        localIntent.putExtra("predefinedTheme", "play");
        paramAccount = (Account)localObject2;
        if (paramActivity.getPackageManager().resolveActivity(localIntent, 0) != null)
        {
          paramAccount = (Account)localObject2;
          if (com.google.android.gms.common.d.d(paramActivity) >= ((Integer)com.google.android.finsky.ag.d.fv.b()).intValue())
          {
            FinskyLog.a("Using Unicorn family management v2 API [appId=%s].", new Object[] { localObject1 });
            paramAccount = localIntent;
          }
        }
        return paramAccount;
        localObject1 = "pfl";
      }
    }
  }
  
  public final Intent a(Context paramContext)
  {
    return a(b(), paramContext, null);
  }
  
  public final Intent a(Context paramContext, int paramInt, DfeToc paramDfeToc)
  {
    paramDfeToc = paramDfeToc.a(paramInt);
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext()));
    paramContext.setData(Uri.parse(paramDfeToc.b));
    paramContext.setAction("com.google.android.finsky.CORPUS_HOME");
    paramContext.putExtra("title", paramDfeToc.d);
    paramContext.putExtra("backend_id", paramInt);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, int paramInt, af paramaf)
  {
    paramContext = a(paramContext, paramaf);
    paramContext.putExtra("setting-key-to-open", paramInt);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, Document paramDocument, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    com.android.ex.photo.e locale1 = new com.android.ex.photo.e(paramContext, ScreenshotsActivityV2.class);
    Integer localInteger = Integer.valueOf(paramInt1);
    locale1.e = localInteger;
    locale1.f = com.android.ex.photo.d.a.b;
    locale1.a = true;
    com.android.ex.photo.e locale2 = locale1.a(10.0F);
    locale2.d = true;
    locale2.b = paramContext.getString(2131951954, new Object[] { paramDocument.a.I });
    paramContext = (Rect)paramHashMap.get(localInteger);
    if (paramContext != null)
    {
      paramInt1 = paramContext.left;
      int i = paramContext.top;
      int j = paramContext.right;
      int k = paramContext.left;
      int m = paramContext.bottom;
      int n = paramContext.top;
      locale1.h = true;
      locale1.k = paramInt1;
      locale1.l = i;
      locale1.j = (j - k);
      locale1.i = (m - n);
      locale1.c = true;
    }
    paramContext = locale1.a();
    paramContext.putExtra("document", paramDocument);
    paramContext.putExtra("imageType", paramInt2);
    paramContext.putExtra("indexToLocation", paramHashMap);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, Document paramDocument, ig paramig, String paramString, af paramaf)
  {
    paramContext = new Intent(paramContext, ChangeSubscriptionPriceActivity.class);
    paramContext.putExtra("document", paramDocument);
    paramContext.putExtra("subscription_price_change_dialog", ParcelableProto.a(paramig));
    paramaf.b(paramString).a(paramContext);
    com.google.android.finsky.billing.common.j.a(paramContext, paramString);
    com.google.android.finsky.billing.common.j.a(paramContext, paramDocument.a.D);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, Document paramDocument, af paramaf)
  {
    return a(paramContext, paramDocument.a.q, paramaf);
  }
  
  public final Intent a(Context paramContext, Document paramDocument, String paramString, boolean paramBoolean, af paramaf)
  {
    paramContext = new Intent(paramContext, ReviewsActivity.class);
    paramContext.putExtra("finsky.ReviewsActivity.document", paramDocument);
    paramContext.putExtra("finsky.ReviewsActivity.reviewsUrl", paramString);
    paramContext.putExtra("finsky.ReviewsActivity.isRottenTomatoesReviews", paramBoolean);
    paramContext.setFlags(536870912);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, bb parambb, String paramString, PurchaseFlowConfig paramPurchaseFlowConfig, af paramaf)
  {
    return CatchAbandonmentActivity.a(paramContext, parambb, 0, paramString, paramPurchaseFlowConfig, paramaf);
  }
  
  public final Intent a(Context paramContext, kr paramkr, int paramInt1, int paramInt2, String paramString, af paramaf)
  {
    paramContext = new Intent(paramContext, GiftingActivity.class);
    GiftingActivity.a(paramContext, paramString);
    paramContext.putExtra("GiftingActivity.action", ParcelableProto.a(paramkr));
    paramContext.putExtra("GiftingActivity.backend", paramInt1);
    paramContext.putExtra("GiftingActivity.documentType", paramInt2);
    paramaf.b(paramString).a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, af paramaf)
  {
    paramContext = new Intent(paramContext, SettingsActivity.class);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, af paramaf, String paramString, DfeToc paramDfeToc)
  {
    paramContext = a(paramContext, paramString, "finsky.OptInActivity.account", "finsky.OptInActivity.toc", paramDfeToc, MarketingOptInActivity.class);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString)
  {
    return new Intent("android.intent.action.VIEW").setClass(paramContext, j.a(paramContext.getApplicationContext())).setData(Uri.parse(paramString));
  }
  
  public final Intent a(Context paramContext, String paramString1, int paramInt, String paramString2, af paramaf)
  {
    paramContext = new Intent(paramContext, AgeVerificationActivity.class);
    paramContext.putExtra("authAccount", paramString1);
    paramContext.putExtra("AgeVerificationActivity.backend", paramInt);
    paramContext.putExtra("AgeVerificationActivity.docid_str", paramString2);
    paramaf.b(paramString1).a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString, DfeToc paramDfeToc)
  {
    if (com.google.android.finsky.ba.a.b(paramContext)) {}
    for (Class localClass1 = j.a();; localClass1 = null)
    {
      Class localClass2 = localClass1;
      if (localClass1 == null) {
        localClass2 = TosActivity.class;
      }
      return a(paramContext, paramString, "finsky.TosActivity.account", "finsky.TosActivity.toc", paramDfeToc, localClass2);
    }
  }
  
  public final Intent a(Context paramContext, String paramString, bp parambp, int paramInt, af paramaf)
  {
    paramContext = new Intent(paramContext, UpdateSubscriptionInstrumentActivity.class);
    paramContext.setAction("com.google.android.finsky.UPDATE_SUBSCRIPTION_INSTRUMENT");
    paramContext.putExtra("backend_docid", parambp.b);
    paramContext.putExtra("backend", parambp.a);
    paramContext.putExtra("document_type", parambp.c);
    paramContext.putExtra("instrument_id", 0L);
    paramContext.putExtra("instrument_rank", paramInt);
    paramContext.putExtra("payment_client_token", null);
    paramaf.b(paramString).a(paramContext);
    com.google.android.finsky.billing.common.j.a(paramContext, paramString);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString, bp parambp, long paramLong, byte[] paramArrayOfByte, af paramaf)
  {
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext()));
    paramContext.setAction("com.google.android.finsky.UPDATE_SUBSCRIPTION_INSTRUMENT");
    paramContext.putExtra("account_name", paramString);
    paramContext.putExtra("document", ParcelableProto.a(parambp));
    paramContext.putExtra("instrument_id", paramLong);
    paramContext.putExtra("payment_client_token", paramArrayOfByte);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString, af paramaf)
  {
    return a(b(paramString).a(), paramContext, paramaf);
  }
  
  public final Intent a(Context paramContext, String paramString1, String paramString2, int paramInt, af paramaf)
  {
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext()));
    paramContext.setData(Uri.parse(paramString1));
    paramContext.setAction("com.google.android.finsky.VIEW_BROWSE");
    paramContext.putExtra("title", paramString2);
    paramContext.putExtra("backend_id", paramInt);
    paramContext.putExtra("clear_back_stack", false);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString1, String paramString2, Document paramDocument, boolean paramBoolean, af paramaf)
  {
    return a(paramContext, paramString1, paramString2, paramDocument, paramBoolean, paramaf, false, null);
  }
  
  public final Intent a(Context paramContext, String paramString1, String paramString2, Document paramDocument, boolean paramBoolean1, af paramaf, boolean paramBoolean2, String paramString3)
  {
    paramContext = new Intent(paramContext, AppsPermissionsActivity.class);
    paramContext.putExtra("AppsPermissionsActivity.accountName", paramString1);
    paramContext.putExtra("AppsPermissionsActivity.docidStr", paramString2);
    paramContext.putExtra("AppsPermissionsActivity.doc", paramDocument);
    paramContext.putExtra("AppsPermissionsActivity.showDetailedPermissions", paramBoolean1);
    paramContext.putExtra("AppsPermissionsActivity.alwaysShowBucketedPermissions", paramBoolean2);
    paramContext.putExtra("AppsPermissionsActivity.buttonText", paramString3);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent a(Context paramContext, String paramString1, String paramString2, af paramaf)
  {
    return a(a(paramString1, null, null, paramString2), paramContext, paramaf);
  }
  
  public final Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, af paramaf)
  {
    return a(a(paramString1, paramString2, paramString3, paramString4, paramBoolean).a(), paramContext, paramaf);
  }
  
  public final Intent a(Context paramContext, Collection paramCollection, af paramaf)
  {
    return MultiInstallActivity.a(paramContext, paramCollection, paramaf, 1);
  }
  
  public final Intent a(String paramString1, String paramString2, String paramString3, af paramaf)
  {
    return RedeemCodeActivity.a(paramString1, 3, paramString2, paramString3, paramaf);
  }
  
  public final Intent a(ArrayList paramArrayList, af paramaf, Context paramContext)
  {
    return UninstallManagerActivityV2.a(paramArrayList, paramaf, false, paramContext.getApplicationContext());
  }
  
  public final m a()
  {
    return m.b("com.google.android.finsky.UNINSTALL_WIZARD_FOR_MY_DOWNLOADS").a();
  }
  
  public final m a(String paramString)
  {
    n localn = m.b("com.google.android.finsky.UNINSTALL_WIZARD_FOR_DETAILS");
    localn.a = Uri.parse(paramString);
    return localn.a();
  }
  
  public final m a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!"com.google.android.instantapps.supervisor".equals(paramString1))
    {
      if (!"com.google.android.gms".equals(paramString1))
      {
        n localn = m.b("com.google.android.finsky.DEFAULT_CLICK");
        if (!TextUtils.isEmpty(paramString1)) {
          localn = b(paramString4).a("error_doc_id", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localn.a("error_title", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localn.a("error_html_message", paramString3);
        }
        return localn.a();
      }
      return b();
    }
    return b();
  }
  
  public final Intent b(Account paramAccount, Context paramContext, Document paramDocument, aw paramaw, af paramaf)
  {
    if (paramAccount == null) {
      throw new IllegalArgumentException("account is required");
    }
    if (paramaw == null) {
      throw new IllegalArgumentException("cancellation dialog is required");
    }
    ax localax = paramaw.b;
    if ((localax == null) || (localax.d == null)) {
      throw new IllegalArgumentException("cancellation survey dialog and cancellation survey options are required");
    }
    paramContext = new Intent(paramContext, SubscriptionCancelSurveyActivity.class);
    paramContext.putExtra("document", paramDocument);
    paramContext.putExtra("account", paramAccount);
    paramContext.putExtra("cancel_subscription_dialog", ParcelableProto.a(paramaw));
    paramaf.a(paramAccount).a(paramContext);
    com.google.android.finsky.billing.common.j.a(paramContext, paramAccount.name);
    return paramContext;
  }
  
  public final Intent b(Context paramContext)
  {
    return new Intent("com.google.android.finsky.VIEW_MY_DOWNLOADS").setClass(paramContext, j.a(paramContext.getApplicationContext())).putExtra("trigger_update_all", true);
  }
  
  public final Intent b(Context paramContext, af paramaf)
  {
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext()));
    if (paramaf != null) {
      paramaf.a(paramContext);
    }
    return paramContext;
  }
  
  public final Intent b(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext()));
    paramContext.putExtra("error_html_message", paramString);
    return paramContext;
  }
  
  public final Intent b(Context paramContext, String paramString, af paramaf)
  {
    paramContext = new Intent(paramContext, FamilySetupActivity.class);
    paramContext.putExtra("accountName", paramString);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent b(Context paramContext, Collection paramCollection, af paramaf)
  {
    return MultiInstallActivity.a(paramContext, paramCollection, paramaf, 0);
  }
  
  public final Intent c(Context paramContext)
  {
    return new Intent(paramContext, WearSupportService.class);
  }
  
  public final Intent c(Context paramContext, af paramaf)
  {
    paramContext = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getApplicationContext().getPackageName());
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent c(Context paramContext, String paramString, af paramaf)
  {
    paramContext = new Intent(paramContext, j.a(paramContext.getApplicationContext())).setAction("com.google.android.gms.actions.VIEW_REMOTE_ESCALATIONS").putExtra("authAccount", paramString);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent d(Context paramContext)
  {
    return a(paramContext, 2131952556);
  }
  
  public final Intent d(Context paramContext, af paramaf)
  {
    paramContext = new Intent(paramContext, RetailDemoModeActivity.class);
    paramaf.a(paramContext);
    return paramContext;
  }
  
  public final Intent e(Context paramContext)
  {
    return a(paramContext, 2131952555);
  }
  
  public final Intent f(Context paramContext)
  {
    return a(paramContext, 2131952515);
  }
  
  public final Intent g(Context paramContext)
  {
    if (this.b.b)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.google.android.finsky.setupui.tvimpl.TvSetupWizardFinalHoldActivity");
      return localIntent;
    }
    return new Intent(paramContext, SetupWizardFinalHoldActivity.class);
  }
  
  public final Intent h(Context paramContext)
  {
    return new Intent(paramContext, j.a(paramContext.getApplicationContext()));
  }
  
  public final Intent i(Context paramContext)
  {
    return new Intent(paramContext, UnauthenticatedMainActivity.class);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */