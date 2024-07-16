package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        BusinessCardApp1(
            fullName = stringResource(R.string.hamzat_akolade),
            title = stringResource(R.string.software_engineer),
            modifier = Modifier.padding()
        )
        BusinessCardApp2(phoneNumber = stringResource(R.string._234_908_085_5200),
            socialMedia = stringResource(R.string.ex_plicit),
            email = stringResource(R.string.hamzatakolade_gmail_com))
    }
}


@Composable
fun BusinessCardApp1(fullName: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageLogo = painterResource(R.drawable.android_logo)
            Image(
                painter = imageLogo,
                contentDescription = null,
                modifier = Modifier.size(100.dp),
            )
            Text(
                text = fullName,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                fontSize = 19.sp,
                modifier = Modifier.padding(top = 5.dp),
                fontWeight = FontWeight.Bold
            )
    }
}

@Composable
fun BusinessCardApp2(phoneNumber: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val iconLogo = painterResource(R.drawable.phone_24dp_e8eaed)
        val iconLogo2 = painterResource(R.drawable.chat_24dp_e8eaed)
        val iconLogo3 = painterResource(R.drawable.email_24dp_e8eaed)
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Icon(
                painter = iconLogo,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = phoneNumber,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Icon(
                painter = iconLogo2,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = socialMedia,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Icon(
                painter = iconLogo3,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = email,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp1(stringResource(R.string.hamzat_akolade), stringResource(R.string.software_engineer))
        BusinessCardApp2(stringResource(R.string._234_908_085_5200), stringResource(R.string.ex_plicit), stringResource(R.string.hamzatakolade_gmail_com) )
    }
}