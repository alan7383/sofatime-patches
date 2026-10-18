package app.sofatime.patches

import app.morphe.patcher.Fingerprint

val premiumEntitlementClassFingerprint = Fingerprint(
    strings = listOf("PremiumEntitlement(premiumState=")
)

val crashlyticsRegistrarGetComponents = Fingerprint(
    definingClass = "Lcom/google/firebase/crashlytics/CrashlyticsRegistrar;",
    name = "getComponents",
    returnType = "Ljava/util/List;"
)

val sessionsRegistrarGetComponents = Fingerprint(
    definingClass = "Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;",
    name = "getComponents",
    returnType = "Ljava/util/List;"
)

val googleSignInMethodFingerprint = Fingerprint(
    returnType = "Ljava/io/Serializable;",
    strings = listOf(
        "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL"
    )
)

