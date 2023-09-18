package com.myapp.artspaceapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    artWork("Set Sail into the future with Jesus", "St.Jonas")
                }
            }
        }
    }
}

@Composable
fun artWork(text: String, artist: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ArtWorkWall(
            image = painterResource(R.drawable.sailing_boat),
            modifier = Modifier.align(Alignment.CenterHorizontally),

            )

        ArtWorkDescriptor(
            text = text,
            text2 = artist,
            modifier = Modifier
        )
        DisplayController(
            text=text,
            text2= artist,
            modifier = modifier.align(Alignment.CenterHorizontally  )

        )

    }
}

@Composable
fun ArtWorkWall(image: Painter, modifier: Modifier) {

    Column(
        modifier = modifier
            .padding(16.dp)
            .background(Color.White)
            .shadow(16.dp)
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtWorkDescriptor(text: String, text2: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.Gray)
    ) {
        Text(
            text = text, fontSize = 30.sp, modifier = Modifier.padding(16.dp)
        )
        Text(
            text = text2, fontSize = 30.sp, modifier = Modifier.padding(10.dp)


        )


    }
}

@Composable
fun DisplayController(text: String,text2:String,modifier: Modifier) {
    Column {
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.text))
            }
            Spacer(modifier =modifier.width(50.dp) )
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.text2))
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ArtWorkPreview() {
    ArtSpaceAppTheme {
        artWork("Set Sail into the future with Jesus", "By St.Jonas")
    }
}