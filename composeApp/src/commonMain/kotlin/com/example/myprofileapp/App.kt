package com.example.myprofileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import myprofileapp.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {

    var showDialog by remember { mutableStateOf(false) }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F2)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            // FOTO PROFILE
            Image(
                painter = painterResource(Res.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Zahwa Natasya Hamzah",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Mahasiswa Informatika ITERA",
                color = Color.Gray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    InfoRow(Icons.Default.Email, "zahwa.123140069@student.itera.ac.id")

                    Divider(modifier = Modifier.padding(vertical = 10.dp))

                    InfoRow(Icons.Default.Phone, "085229804644")

                    Divider(modifier = Modifier.padding(vertical = 10.dp))

                    InfoRow(Icons.Default.LocationOn, "Bandar Lampung")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { showDialog = true },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6C4AB6)
                )
            ) {
                Text(
                    text = "Info",
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("OK")
                        }
                    },
                    title = {
                        Text("Informasi")
                    },
                    text = {
                        Text("Halo! Ini adalah aplikasi MyProfileApp yang dibuat menggunakan Kotlin Multiplatform.")
                    }
                )
            }

        }
    }
}

@Composable
fun InfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF4F5D95)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}