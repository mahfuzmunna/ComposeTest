package me.mahfuzmunna.android_jetpack_compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mahfuzmunna.android_jetpack_compose.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface {
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }

    @Composable
    private fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message -> MessageCard(msg = message) }
        }

    }

    @Composable
    private fun MessageCard(msg: Message) {
        Row(Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "description",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = msg.author, style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                    Text(
                        text = msg.message,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }


    @Preview(name = "Light mode")
    @Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
    @Composable
    fun MessageCardPreview() {
        ComposeTestTheme {
            Surface {
                MessageCard(msg = Message("Lexi", "Hey take a look at this Jetpack compose!"))
            }
        }
    }

    @Preview
    @Composable
    fun CoversationPreview() {
        ComposeTestTheme {
            Conversation(messages = SampleData.conversationSample)
        }
    }
}