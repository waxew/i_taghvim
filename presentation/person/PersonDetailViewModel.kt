package com.asteam.itaghvim.presentation.person

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel صفحه جزئیات شخص
 *
 * این کلاس مسئول مدیریت وضعیت صفحه جزئیات است.
 * ارتباط با UseCase ها در مراحل بعدی تکمیل می‌شود.
 */
@HiltViewModel
class PersonDetailViewModel @Inject constructor() : ViewModel() {

    // TODO: اتصال به GetPersonDetailUseCase
    // TODO: دریافت مناسبت‌های مرتبط با شخص
    // TODO: مدیریت حذف و ویرایش شخص
}
