package com.asteam.itaghvim.core.ads

/**
 * Coordinates rewarded advertisement flow.
 *
 * UI layers should react to this state instead of communicating directly
 * with the advertising SDK.
 */
class RewardFlow {

    fun onCompleted(): AdResult {
        return AdResult.Success
    }

    fun onFailed(): AdResult {
        return AdResult.Failed
    }
}
