package com.google.android.finsky.dn.c;

import com.google.android.finsky.dn.a;
import com.google.android.finsky.dn.k;
import java.util.concurrent.TimeUnit;

public final class e
  extends k
{
  private static final long c = TimeUnit.DAYS.toMillis(3L);
  
  protected final void a()
  {
    Boolean localBoolean = Boolean.valueOf(true);
    a("NetworkOptimizations", "enable_dns_cache_warmup", localBoolean);
    a("NetworkOptimizations", "enable_dns_cache_warmup_logging", localBoolean);
    localBoolean = Boolean.valueOf(false);
    a("NetworkOptimizations", "enable_quic_server_configs_to_store", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_quic_server_configs_to_store", localBoolean);
    a("NetworkOptimizations", "enable_quic_idle_connection_timeout", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_quic_idle_connection_timeout", localBoolean);
    a("NetworkOptimizations", "migrate_quic_sessions_on_network_change", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_migrate_quic_sessions_on_network_change", localBoolean);
    a("NetworkOptimizations", "enable_quic_connection_options", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_quic_connection_options", localBoolean);
    a("NetworkOptimizations", "race_cert_verification", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_race_cert_verification", localBoolean);
    a("NetworkOptimizations", "enable_stale_dns", localBoolean);
    a("NetworkOptimizations", "kill_switch_to_disable_stale_dns", localBoolean);
    a("NetworkOptimizations", "stale_dns_delay_ms", Integer.valueOf(1500));
    a("NetworkOptimizations", "max_stale_dns_expired_time_ms", Long.valueOf(c));
    a("NetworkOptimizations", "kill_switch_to_disable_brotli", localBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */