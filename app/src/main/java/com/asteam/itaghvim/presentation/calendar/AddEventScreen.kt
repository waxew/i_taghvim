package com.asteam.itaghvim.presentation.calendar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.asteam.itaghvim.domain.model.CalendarEvent

/** فرم افزودن مناسبت؛ ذخیره واقعی در Room و نمایش پیام موفقیت. */
@Composable
fun AddEventScreen(selectedSolarDate:String="",onSaved:()->Unit={},viewModel:EventViewModel=hiltViewModel()){
 var title by remember{mutableStateOf("")}; var saved by remember{mutableStateOf(false)}
 val date=selectedSolarDate.ifBlank{"1405/01/01"}
 Column(Modifier.fillMaxSize(),horizontalAlignment=Alignment.CenterHorizontally,verticalArrangement=Arrangement.Center){
  Text("افزودن مناسبت جدید")
  OutlinedTextField(value=title,onValueChange={title=it},label={Text("عنوان مناسبت")})
  Button(enabled=title.isNotBlank(),onClick={viewModel.saveEvent(CalendarEvent(0,title.trim(),null,date,null,null,null)){saved=true;onSaved()}}){Text("ذخیره")}
  if(saved)Text("رویداد با موفقیت ذخیره شد")
 }
}