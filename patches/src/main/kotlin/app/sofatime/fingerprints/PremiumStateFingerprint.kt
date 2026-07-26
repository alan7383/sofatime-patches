package app.sofatime.fingerprints

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string

val premiumStateClassFingerprint = Fingerprint(
    filters = listOf(
        string("PremiumState(purchased=")
    )
)
