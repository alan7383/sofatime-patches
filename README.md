# 🍿 Morphe Patches for SofaTime

Official repository containing custom Morphe patches for **SofaTime** (Android).

## ❓ About

This repository provides modular patches for the SofaTime Android application. The patches unlock all premium features, bypass license checks, and restore Google Sign-In capabilities seamlessly across supported app versions.

### ✨ Features
- **SofaTime Premium**: Unlocks all premium features, custom themes, and advanced tracking tools.
- **SofaTime License Check Bypass**: Bypasses PairIP / Google Play Store license verification, allowing side-loading and installation from custom APK sources.
- **SofaTime Google Sign-In Bypass**: Restores functional Google Sign-In on repackaged APKs by using an in-app WebView OAuth flow to bypass Google Play Services SHA-1 signature checks.

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.1.0](https://github.com/alan7383/sofatime-patches/releases/tag/v1.1.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;3 patches total
<details open>
<summary>📦 SofaTime&nbsp;&nbsp;•&nbsp;&nbsp;3 patches</summary>
<br>

**🎯 Supported versions:**

| 1.1.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [SofaTime Google Sign-In Bypass](#sofatime-google-sign-in-bypass) | Restores Google Sign-In on repackaged APKs via embedded OAuth. |  |
| [SofaTime License Check Bypass](#sofatime-license-check-bypass) | Bypasses PairIP license verification. |  |
| [SofaTime Premium](#sofatime-premium) | Unlocks all premium features. |  |

</details>

<!-- PATCHES_END -->

## 🧩 Patch Details

### SofaTime Google Sign-In Bypass
- **Description**: Restores Google Sign-In on repackaged APKs where Google Play Services SHA-1 verification fails.
- **Implementation**: Hooks method `mp8.w` to delegate authentication to a precompiled Kotlin extension (`GoogleSignInHelper.kt`). Displays an in-app WebView OAuth flow against `https://accounts.google.com/o/oauth2/v2/auth`, captures the direct Google ID Token / Auth Code upon redirect to `https://tvsofa-3.firebaseapp.com/__/auth/handler`, and asynchronously resumes the Kotlin coroutine (`uk5` wrapper).

### SofaTime License Check Bypass
- **Description**: Bypasses PairIP and Google Play Store verification checks.
- **Implementation**: Short-circuits license verification by injecting `return-void` into `LicenseClient.checkLicense()` and `initializeLicenseCheck()`, and forcing `LicenseContentProvider.onCreate()` to return `true` (`const/4 v0, 0x1`).

### SofaTime Premium
- **Description**: Unlocks all premium features.
- **Implementation**: Overrides the entitlement state checks by injecting `return true` (`const/4 v0, 0x1`) into the `PremiumEntitlement` Smali methods — `isPremium` (combined premium/trial check with `Instant.now()`) and `isPremiumPurchased` (purchase-only check) — forcing all premium feature gates to evaluate as active.

#### How to use these patches

Click here to add these patches to Morphe: https://morphe.software/add-source?github=alan7383/sofatime-patches

Or manually add this repository url as a patch source in Morphe: https://github.com/alan7383/sofatime-patches

### 🛠️ Building

To build SofaTime Patches locally, you can follow the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation).

```bash
./gradlew build
```

## 📜 License

SofaTime Patches are licensed under the [GNU General Public License v3.0](LICENSE).
