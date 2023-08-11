package com.dnd_9th_3_android.gooding.my

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dnd_9th_3_android.gooding.my.navi.NavigationGraph

// just nav controller view
@Composable
fun MyAccountScreen() {
    val navController = rememberNavController()
    NavigationGraph(navController)
}