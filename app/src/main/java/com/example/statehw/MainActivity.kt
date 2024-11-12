package com.example.statehw

import android.os.Bundle
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.Language


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val productList = mutableListOf<Products>(Products.APPLE, Products.CUCUMBER, Products.PINEAPPLE,
            Products.CORN, Products.TOMATO, Products.BREAD, Products.BUTTER, Products.WATER,
            Products.MEAT, Products.MILK, Products.EGGS)


        setContent {

            var count = 3
            var titleProducts by rememberSaveable() { mutableStateOf("Список продуктов") }
            var changeLanguageText by rememberSaveable() { mutableStateOf("Switch language") }
            var rusLanguage by rememberSaveable() { mutableStateOf(true) }

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

                        Text(text = titleProducts,
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
                    items(productList) {
                        product ->
                        ProductRow(product,rusLanguage)
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                }

                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth())

                {
                    Text(text = changeLanguageText, fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .clickable(onClick = {

                                count += 1
                                if (count % 2 != 0) {
                                    titleProducts = "List of products"
                                    changeLanguageText = "Изменить язык"
                                    rusLanguage = false
                                } else {
                                    titleProducts = "Список продуктов"
                                    changeLanguageText = "Switch language"
                                    rusLanguage = true
                                }} ))
                }
            }

        }
    }
}

@Composable
fun ProductRow(products: Products, rusLanguage: Boolean) {

    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.White, shape = CircleShape)
            .clip(shape = CircleShape)) {

        if (rusLanguage == true) {
            Text(text = products.rusName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        } else {
            Text(text = products.engName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }
}



enum class Products(val rusName: String, val engName: String) {
    APPLE("Яблоко","Apple"),
    PINEAPPLE("Ананас","Pineapple"),
    TOMATO("Помидор","Tomato"),
    CUCUMBER("Огурец","Cucumber"),
    CORN("Кукуруза","Corn"),
    WATER("Вода","Water"),
    BREAD("Хлеб","Bread"),
    BUTTER("Масло","Butter"),
    MEAT("Мясо","Meat"),
    MILK("Молоко","Milk"),
    EGGS("Яйца","Eggs");



}

