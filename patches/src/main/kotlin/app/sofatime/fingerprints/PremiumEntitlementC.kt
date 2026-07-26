package app.sofatime.fingerprints

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.fieldAccess
import app.morphe.patcher.opcode
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

val premiumEntitlementCFingerprint = Fingerprint(
    classFingerprint = premiumEntitlementClassFingerprint,
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    parameters = emptyList(),
    name = "c",
    filters = listOf(
        fieldAccess(
            opcode = Opcode.IGET_BOOLEAN,
            name = "a",
            type = "Z"
        )
    )
)
