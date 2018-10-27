package com.google.android.play.utils.b;

public final class j
{
  public static final a A;
  public static final a B;
  public static final a C;
  public static final a D = a.a("playcommon.play_drawer_recyclerview_cache", Integer.valueOf(10));
  public static final a E;
  public static final a F;
  public static final a G;
  public static final a H;
  public static final a I;
  public static final a J;
  public static final a K;
  public static final a L;
  public static final a M;
  public static final a N;
  public static final a O;
  public static final a P;
  public static final String[] a = { "playcommon" };
  public static final a b;
  public static final a c;
  public static final a d;
  public static a e;
  public static a f;
  public static final a g;
  public static a h;
  public static final a i;
  public static final a j;
  public static final a k;
  public static a l;
  public static final a m;
  public static final a n;
  public static final a o = a.a("playcommon.mcc_mnc_override", null);
  public static final a p;
  public static a q;
  public static a r;
  public static a s;
  public static a t;
  public static a u;
  public static final a v;
  public static final a w;
  public static final a x;
  public static final a y;
  public static final a z;
  
  static
  {
    I = a.a("playcommon.proto_log_url_regexp", ".*");
    k = a.a("playcommon.dfe_request_timeout_ms", Integer.valueOf(2500));
    Integer localInteger = Integer.valueOf(1);
    j = a.a("playcommon.dfe_max_retries", localInteger);
    Float localFloat = Float.valueOf(1.0F);
    i = a.a("playcommon.dfe_backoff_multiplier", localFloat);
    Object localObject1 = Integer.valueOf(8000);
    G = a.a("playcommon.plus_profile_bg_timeout_ms", (Integer)localObject1);
    Object localObject2 = Integer.valueOf(0);
    F = a.a("playcommon.plus_profile_bg_max_retries", (Integer)localObject2);
    E = a.a("playcommon.plus_profile_bg_backoff_mult", localFloat);
    O = a.a("playcommon.user_profile_bg_timeout_ms", (Integer)localObject1);
    N = a.a("playcommon.user_profile_bg_max_retries", (Integer)localObject2);
    M = a.a("playcommon.user_profile_bg_backoff_mult", localFloat);
    m = a.a("playcommon.ip_country_override", null);
    b = a.a("android_id", Long.valueOf(0L));
    c = a.a("playcommon.auth_token_type", "androidmarket");
    d = a.a("playcommon.auth_token_type_oauth2", "oauth2:https://www.googleapis.com/auth/googleplay");
    n = a.b("logging_id2", "");
    g = a.b("market_client_id", "am-google");
    localObject1 = Boolean.valueOf(false);
    K = a.a("playcommon.skip_all_caches", (Boolean)localObject1);
    J = a.a("playcommon.show_staging_data", (Boolean)localObject1);
    H = a.a("playcommon.prex_disabled", (Boolean)localObject1);
    localObject2 = Boolean.valueOf(true);
    L = a.a("playcommon.tentative_gc_runner_enabled", (Boolean)localObject2);
    e = a.a("playcommon.bitmap_loader_cache_size_mb", Integer.valueOf(-1));
    f = a.a("playcommon.bitmap_loader_cache_size_ratio_to_screen", Float.valueOf(1.5F));
    p = a.a("playcommon.min_image_size_limit_in_lru_cache_bytes", Integer.valueOf(524288));
    h = a.a("playcommon.debug_display_image_sizes", (Boolean)localObject1);
    l = a.a("playcommon.debug_enable_force_network_type", (Boolean)localObject1);
    q = a.a("playcommon.debug_overridden_network_type", localInteger);
    r = a.a("playcommon.overridden_predicted_latency_2g", Integer.valueOf(1729477));
    s = a.a("playcommon.overridden_predicted_latency_3g", Integer.valueOf(591604));
    t = a.a("playcommon.overridden_predicted_latency_4g", Integer.valueOf(330427));
    u = a.a("playcommon.overridden_predicted_latency_wifi", Integer.valueOf(38818));
    P = a.a("playcommon.webp_fife_images_enabled", (Boolean)localObject2);
    y = a.a("playcommon.percent_of_image_size_wifi", localFloat);
    x = a.a("playcommon.percent_of_image_size_4g", Float.valueOf(0.9F));
    w = a.a("playcommon.percent_of_image_size_3g", Float.valueOf(0.75F));
    v = a.a("playcommon.percent_of_image_size_2g", Float.valueOf(0.45F));
    a.a("playcommon.main_cache_size_mb", localInteger);
    a.a("playcommon.image_cache_size_mb", Integer.valueOf(4));
    a.a("playcommon.volley_buffer_pool_size_kb", Integer.valueOf(256));
    a.a("playcommon.force_enabled_experiment_ids", null);
    a.a("playcommon.force_disabled_experiment_ids", null);
    z = a.a("playcommon.play_log_server_url_format_key", "format");
    A = a.a("playcommon.play_log_server_url_format_value", "raw");
    B = a.a("playcommon.play_log_server_url_proto_v2_key", "proto_v2");
    C = a.a("playcommon.play_log_server_url_proto_v2_value", (Boolean)localObject2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/utils/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */