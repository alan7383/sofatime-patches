package app.sofatime.fingerprints

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import com.android.tools.smali.dexlib2.AccessFlags

val premiumEntitlementBFingerprint = Fingerprint(
    classFingerprint = premiumEntitlementClassFingerprint,
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    parameters = emptyList(),
    name = "b",
    filters = listOf(
        methodCall(
            name = "b",
            returnType = "Z"
        )
    )
)
