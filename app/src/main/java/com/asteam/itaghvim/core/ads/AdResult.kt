package com.asteam.itaghvim.core.ads

/**
 * Result state returned from advertising operations.
 * Keeps UI independent from the ad SDK implementation.
 */
sealed interface AdResult {
    data object Success : AdResult
    data object Failed : AdResult
    data object NotAvailable : AdResult
}
