package com.dudegenuine.whatsapp.ui.compose.screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dudegenuine.whatsapp.R
import com.dudegenuine.whatsapp.ui.theme.WhatsAppThemeColor
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * Wed, 29 Jun 2022
 * Whatsapp by utifmd
 **/
@Composable
fun EditText(modifier: Modifier = Modifier, onMessageSend: (String) -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Box {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            TextField(
                value = textState.value,
                leadingIcon = { Icon(Icons.Default.Face, contentDescription = null) },
                placeholder = { Text(text = "Type a message") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onPrimary,
                ),
                modifier = Modifier.weight(8.5f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.requiredSize(12.dp))

            IconButton(modifier = Modifier.weight(1.5f, true), content = {
                Icon(Icons.Default.Send, tint = MaterialTheme.colors.onPrimary, contentDescription = null)
            }, onClick = {
                onMessageSend(textState.value.text)
                scope.launch{ scrollState.animateScrollTo(0) }
            })
        }
    }
}


@Composable
fun BottomDesign() {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(0.85f)
                .wrapContentSize()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(10.dp, 0.dp, 10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                contentDescription = "Emoji",
                tint = Color.Gray,
                modifier = Modifier.weight(0.1f)
            )
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = {
                    Text(
                        text = "Message",
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier
                    .weight(0.66f)
                    .wrapContentHeight(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Text,
                    autoCorrect = true,
                    imeAction = ImeAction.Done
                ),
                textStyle = TextStyle(color = Color.Black,
                    fontSize = 15.sp),
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_attach_file_24),
                contentDescription = "Attach",
                tint = Color.Gray,
                modifier = Modifier.weight(0.14f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24),
                contentDescription = "Attach",
                tint = Color.Gray,
                modifier = Modifier.weight(0.1f)
            )
        }
        Row(
            modifier = Modifier.weight(0.15f),
            horizontalArrangement = Arrangement.Center
        ) {
            FloatingActionButton(
                onClick = {
                    /*if (textState.value.text.isNotEmpty()) {
                        val sampleData = SampleData(
                            "Name",
                            textState.value.text,
                            "Sample Url",
                            strDate
                        )
                        viewModel.addChat(sampleData)
                    }*/
                },
                backgroundColor = WhatsAppThemeColor
            ) {
                Icon(
                    painter = painterResource(
                        if (textState.value.text.isEmpty()) {
                            R.drawable.ic_baseline_keyboard_voice_24
                        } else {
                            R.drawable.ic_baseline_send_24
                        }
                    ),
                    contentDescription = "Text Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}