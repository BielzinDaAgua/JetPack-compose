package com.example.elementos_telas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen4()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen4() {
    val itemsList = List(5) { "List item - $it" }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Configure", modifier = Modifier.padding(16.dp))
                Text(text = "account", modifier = Modifier.padding(16.dp))
                Text(text = "about", modifier = Modifier.padding(16.dp))
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                MediumTopAppBar({},
                    modifier = Modifier.height(60.dp),
                    colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black),
                    navigationIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White, modifier = Modifier.size(28.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Jetpack Compose", color = Color.White, fontSize = 16.sp)
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Search action */ }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White, modifier = Modifier.size(28.dp))
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Black
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White) },
                        label = { Text("Home", color = Color.White) },
                        selected = false,
                        onClick = {}
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.AddCircle, contentDescription = "Create", tint = Color.White) },
                        label = { Text("Create", color = Color.White) },
                        selected = false,
                        onClick = {}
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.White) },
                        label = { Text("Settings", color = Color.White) },
                        selected = false,
                        onClick = {}
                    )
                }
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 8.dp)
                ) {
                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color(0xFF03DAC5),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(Icons.Filled.MyLocation, contentDescription = "My location")
                    }
                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color(0xFF03DAC5)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Icon(Icons.Filled.NearMe, contentDescription = "Navigate")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Navigate")
                        }
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            content = { paddingValues ->
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    modifier = Modifier.padding(paddingValues)
                ) {
                    items(itemsList) { item ->
                        Card(
                            elevation = CardDefaults.cardElevation(4.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Text(
                                text = item,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        )
    }
}
