package com.example.statehw

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.Language


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {

            var city = remember { mutableStateOf("") }
            val cityList = remember { mutableStateListOf<String>() }

            Column(modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 70.dp))

            {
                Box(Modifier.background(color = Color.DarkGray)) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, color = Color.Black)
                    ) {

                        Text(text = "Динамический список",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold, color = Color.White,
                            modifier =  Modifier.background(color = Color.DarkGray).padding(8.dp))
                    }
                }


                LazyColumn(

                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    modifier = Modifier
                        .background(Color.Gray)
                        .fillMaxWidth()
                        .size(150.dp)
                        .border(1.dp, color = Color.Black)

                ) {
                    itemsIndexed(cityList) {
                        index, city ->

                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .background(Color.White, shape = CircleShape)
                                .clip(shape = CircleShape)) {

                            Text(text = city,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                modifier = Modifier.clickable( onClick = {
                                    cityList.removeAt(index)
                                }))

                        }

                        Spacer(modifier = Modifier.padding(2.dp))
                    }

                }

                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth())

                {
                    TextField( value = city.value, textStyle = TextStyle(fontSize = 24.sp),
                        onValueChange = { newText -> city.value = newText},
                        modifier = Modifier.padding(top = 16.dp))
                }

                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth())

                {
                    Text(text = "Добавить", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .clickable(onClick = {
                                cityList.add(city.value)
                            } ))
                }
            }

        }
    }
}






