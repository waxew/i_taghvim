package com.asteam.itaghvim.presentation.person

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asteam.itaghvim.domain.model.Person

/**
 * صفحه مدیریت اشخاص با اتصال مستقیم به Room
 */
@Composable
fun PeopleScreen(viewModel: PersonViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var showAddDialog by rememberSaveable { mutableStateOf(false) }
    var name by rememberSaveable { mutableStateOf("") }
    var birthday by rememberSaveable { mutableStateOf("") }
    var marriageDate by rememberSaveable { mutableStateOf("") }
    var notes by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.loadPersons()
    }

    val visiblePersons = state.persons.filter { person ->
        searchQuery.isBlank() || person.name.contains(searchQuery.trim(), ignoreCase = true)
    }

    androidx.compose.runtime.CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { showAddDialog = true }) {
                    Text("+", style = MaterialTheme.typography.titleLarge)
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("اشخاص", style = MaterialTheme.typography.headlineSmall)
                Text(
                    "مناسبت‌های تولد و ازدواج اشخاص را ذخیره کنید.",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    label = { Text("جستجوی نام") },
                    placeholder = { Text("مثلاً علی") }
                )

                when {
                    state.isLoading -> {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    state.errorMessage != null -> {
                        Text(
                            "خطا در بارگذاری: ${state.errorMessage}",
                            color = MaterialTheme.colorScheme.error
                        )
                        OutlinedButton(onClick = { viewModel.loadPersons() }) {
                            Text("تلاش دوباره")
                        }
                    }
                    visiblePersons.isEmpty() -> {
                        Text(
                            if (searchQuery.isBlank()) {
                                "هنوز شخصی ثبت نشده است. با دکمه + اولین شخص را اضافه کنید."
                            } else {
                                "شخصی با این نام پیدا نشد."
                            },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    else -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(visiblePersons, key = { it.id }) { person ->
                                Card(modifier = Modifier.fillMaxWidth()) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                person.name,
                                                style = MaterialTheme.typography.titleMedium
                                            )
                                            person.birthday?.takeIf { it.isNotBlank() }?.let {
                                                Text("تولد: $it")
                                            }
                                            person.marriageDate?.takeIf { it.isNotBlank() }?.let {
                                                Text("ازدواج: $it")
                                            }
                                            person.notes?.takeIf { it.isNotBlank() }?.let {
                                                Text(it, style = MaterialTheme.typography.bodySmall)
                                            }
                                        }
                                        Spacer(Modifier.width(8.dp))
                                        IconButton(onClick = { viewModel.deletePerson(person.id) }) {
                                            Text("حذف", color = MaterialTheme.colorScheme.error)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (showAddDialog) {
            AlertDialog(
                onDismissRequest = { showAddDialog = false },
                title = { Text("افزودن شخص جدید") },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            singleLine = true,
                            label = { Text("نام *") }
                        )
                        OutlinedTextField(
                            value = birthday,
                            onValueChange = { birthday = it },
                            singleLine = true,
                            label = { Text("تاریخ تولد") },
                            placeholder = { Text("۱۴۰۰/۱۱/۲۲") }
                        )
                        OutlinedTextField(
                            value = marriageDate,
                            onValueChange = { marriageDate = it },
                            singleLine = true,
                            label = { Text("تاریخ ازدواج") }
                        )
                        OutlinedTextField(
                            value = notes,
                            onValueChange = { notes = it },
                            label = { Text("یادداشت") }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        enabled = name.isNotBlank(),
                        onClick = {
                            viewModel.addPerson(
                                Person(
                                    name = name.trim(),
                                    birthday = birthday.trim().ifBlank { null },
                                    marriageDate = marriageDate.trim().ifBlank { null },
                                    notes = notes.trim().ifBlank { null }
                                )
                            )
                            name = ""
                            birthday = ""
                            marriageDate = ""
                            notes = ""
                            showAddDialog = false
                        }
                    ) {
                        Text("ذخیره")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showAddDialog = false }) {
                        Text("انصراف")
                    }
                }
            )
        }
    }
}
