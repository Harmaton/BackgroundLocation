package com.njagi.kuri.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.njagi.kuri.R
import com.njagi.kuri.ui.theme.KuriTheme

@Composable
fun SearchInputBox( modifier: Modifier, text: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                text = text, modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )
        },
        leadingIcon = { Icon(imageVector = Icons.Default.LocationOn, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Refresh , contentDescription = "")
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .background(androidx.compose.ui.graphics.Color.White), shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Gray,
            trailingIconColor = Color.Red
        )
    )

}

@Preview(showBackground = true)
@Composable
fun searchBoxPreview() {
    KuriTheme(){
        SearchInputBox(modifier = Modifier.background(color = Color.Transparent), text = "Parcel Location ..." )
    }
}