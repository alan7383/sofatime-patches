package app.sofatime.patches

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.sofatime.fingerprints.premiumEntitlementBFingerprint
import app.sofatime.fingerprints.premiumEntitlementCFingerprint
import app.sofatime.fingerprints.premiumStateBFingerprint
import app.sofatime.shared.Constants.SOFATIME_COMPATIBILITY

@Suppress("unused")
val premiumPatch = bytecodePatch(
    name = "SofaTime Premium",
    description = "Unlocks all premium features.",
    default = true,
) {
    compatibleWith(SOFATIME_COMPATIBILITY)

    execute {
        premiumEntitlementBFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )

        premiumEntitlementCFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )

        premiumStateBFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}
