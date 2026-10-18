package app.sofatime.patches

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.patch.bytecodePatch

import app.sofatime.shared.Constants.SOFATIME_COMPATIBILITY

@Suppress("unused")
val premiumPatch = bytecodePatch(
    name = "Unlock premium features",
    description = "Unlocks all premium capabilities.",
    default = true,
) {
    compatibleWith(SOFATIME_COMPATIBILITY)

    execute {
        val entitlementClass = premiumEntitlementClassFingerprint.classDef
        val targetMethods = entitlementClass.methods.filter {
            it.returnType == "Z" && it.parameters.isEmpty()
        }

        if (targetMethods.isEmpty()) {
            throw PatchException("No entitlement boolean methods found in ${entitlementClass.type}")
        }

        targetMethods.forEach { method ->
            method.addInstructions(
                0,
                """
                    const/4 v0, 0x1
                    return v0
                """
            )
        }
    }
}
