package app.sofatime.fingerprints

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string

val premiumEntitlementClassFingerprint = Fingerprint(
    filters = listOf(
        string("PremiumEntitlement(premiumState=")
    )
)
