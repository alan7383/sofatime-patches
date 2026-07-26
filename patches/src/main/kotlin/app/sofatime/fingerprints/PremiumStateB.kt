package app.sofatime.fingerprints

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.literal
import com.android.tools.smali.dexlib2.AccessFlags

val premiumStateBFingerprint = Fingerprint(
    classFingerprint = premiumStateClassFingerprint,
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    filters = listOf(
        literal(1)
    )
)
