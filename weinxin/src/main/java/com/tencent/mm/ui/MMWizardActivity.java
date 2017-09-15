package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class MMWizardActivity
  extends MMActivity
{
  public static final Map<String, Intent> uTt;
  
  static
  {
    GMTrace.i(2535372881920L, 18890);
    uTt = new HashMap();
    GMTrace.o(2535372881920L, 18890);
  }
  
  public MMWizardActivity()
  {
    GMTrace.i(2534299140096L, 18882);
    GMTrace.o(2534299140096L, 18882);
  }
  
  public static void b(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    GMTrace.i(2534701793280L, 18885);
    try
    {
      String str = "trans." + bf.NB() + "." + paramIntent2.hashCode();
      uTt.put(str, paramIntent2);
      paramIntent1.putExtra("WizardTransactionId", str);
      paramIntent2 = ((Activity)paramContext).getIntent();
      if (paramIntent2 != null) {
        paramIntent2.putExtra("WizardTransactionId", str);
      }
      w(paramContext, paramIntent1);
      GMTrace.o(2534701793280L, 18885);
      return;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.MMWizardActivity", "%s", new Object[] { bf.g(paramContext) });
      GMTrace.o(2534701793280L, 18885);
    }
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    String str1 = null;
    GMTrace.i(2534567575552L, 18884);
    v.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
    Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + paramContext.toString(), paramContext instanceof Activity);
    Object localObject = ((Activity)paramContext).getIntent();
    if (localObject != null) {
      str1 = ((Intent)localObject).getStringExtra("WizardRootClass");
    }
    for (localObject = ((Intent)localObject).getStringExtra("WizardTransactionId");; localObject = null)
    {
      String str2 = str1;
      if (bf.mA(str1)) {}
      try
      {
        str2 = paramIntent.getComponent().getClassName();
        Assert.assertFalse("startWizardActivity: ERROR in Get Root Class :[" + paramIntent + "][ " + paramIntent.getComponent() + " ]", bf.mA(str2));
        paramIntent.putExtra("WizardRootClass", str2);
        if (localObject != null) {
          paramIntent.putExtra("WizardTransactionId", (String)localObject);
        }
        paramContext.startActivity(paramIntent);
        GMTrace.o(2534567575552L, 18884);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.MMWizardActivity", localException, "", new Object[0]);
          String str3 = str1;
        }
      }
    }
  }
  
  public final void cancel()
  {
    GMTrace.i(2534970228736L, 18887);
    v.i("MicroMsg.MMWizardActivity", "cancel()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)uTt.get(str);
    uTt.remove(str);
    if (localIntent != null) {
      v.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + str + ", intent=" + localIntent);
    }
    GMTrace.o(2534970228736L, 18887);
  }
  
  public final void exit(int paramInt)
  {
    GMTrace.i(2534836011008L, 18886);
    v.i("MicroMsg.MMWizardActivity", "exit()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)uTt.get(str);
    uTt.remove(str);
    if (localIntent != null)
    {
      v.d("MicroMsg.MMWizardActivity", "doing post exit for transaction=" + str + ", intent=" + localIntent);
      localIntent.putExtra("wizard_activity_result_code", paramInt);
      startActivity(localIntent);
    }
    GMTrace.o(2534836011008L, 18886);
  }
  
  public void finish()
  {
    GMTrace.i(2535238664192L, 18889);
    v.i("MicroMsg.MMWizardActivity", "finish()");
    String str = getIntent().getStringExtra("WizardRootClass");
    if (getComponentName().getClassName().equals(str))
    {
      v.d("MicroMsg.MMWizardActivity", "root wizard activity");
      exit(-1);
    }
    super.finish();
    GMTrace.o(2535238664192L, 18889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2534433357824L, 18883);
    super.onCreate(paramBundle);
    v.i("MicroMsg.MMWizardActivity", "onCreate()");
    Assert.assertFalse("MMWizardActivity Should Start By startWizardActivity or startWizardNextStep", bf.mA(getIntent().getExtras().getString("WizardRootClass")));
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      super.finish();
      v.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
      exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
    }
    GMTrace.o(2534433357824L, 18883);
  }
  
  public final void zp(int paramInt)
  {
    GMTrace.i(15687099613184L, 116878);
    v.i("MicroMsg.MMWizardActivity", "finishWizard()");
    Object localObject = getIntent().getExtras().getString("WizardRootClass");
    Assert.assertFalse("finishWizard: ERROR in Get Root Class :[" + (String)localObject + "]", bf.mA((String)localObject));
    localObject = new Intent().setClassName(this, (String)localObject);
    ((Intent)localObject).putExtra("WizardRootClass", getIntent().getStringExtra("WizardRootClass"));
    ((Intent)localObject).putExtra("WizardTransactionId", getIntent().getStringExtra("WizardTransactionId"));
    ((Intent)localObject).putExtra("WizardRootKillSelf", true);
    ((Intent)localObject).putExtra("wizard_activity_result_code", paramInt);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    GMTrace.o(15687099613184L, 116878);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/MMWizardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */