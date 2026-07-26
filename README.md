# 🍿 Morphe Patches for SofaTime

Official repository containing custom Morphe patches for **SofaTime** (Android).

## ❓ About

This repository provides modular patches for the SofaTime Android application. The patches unlock all premium features and bypass license checks seamlessly across supported app versions.

### ✨ Features
- **SofaTime Premium**: Unlocks all premium features, custom themes, and advanced tracking tools.
- **SofaTime License Check Bypass**: Bypasses PairIP / Google Play Store license verification, allowing side-loading and installation from custom APK sources.

> [!IMPORTANT]
> **🔑 Authentication & Login Notice**
> 
> Due to Google Play Services signature verification (SHA-1 fingerprint mismatch on repackaged APKs), **Google Sign-In will not work**.
> 
> **How to log in:**
> - Please use **Email & Password** login instead.
> - **If your account is linked to Google**: Simply use the **"Forgot Password"** link on the login screen to set a password for your account email. You will then be able to log in using Email & Password without needing Google Sign-In!

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.0.1](https://github.com/alan7383/sofatime-patches/releases/tag/v1.0.1)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;2 patches total
<details open>
<summary>📦 SofaTime&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 1.1.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [SofaTime License Check Bypass](#sofatime-license-check-bypass) | Bypasses PairIP license verification. | *None* |
| [SofaTime Premium](#sofatime-premium) | Unlocks all premium features. | *None* |

</details>

<!-- PATCHES_END -->

## 🧩 Patch Details

### SofaTime License Check Bypass
- **Description**: Bypasses PairIP and Google Play Store verification checks.
- **Implementation**: Short-circuits license verification by injecting `return-void` into `LicenseClient.checkLicense()` and `initializeLicenseCheck()`, and forcing `LicenseContentProvider.onCreate()` to return `true` (`const/4 v0, 0x1`).

### SofaTime Premium
- **Description**: Unlocks all premium capabilities.
- **Implementation**: Overrides the entitlement state checks by injecting `return true` (`const/4 v0, 0x1`) directly into the Smali getters matching `isPremium`, `isPremiumPurchased`, and `isPurchased` (`PremiumEntitlement` & `PremiumState`), forcing all feature gates to evaluate as active.

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
