package com.dnd_9th_3_android.gooding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.databinding.FragmentDayFeedBinding
import com.dnd_9th_3_android.gooding.feed.FeedScreen
import com.dnd_9th_3_android.gooding.feed.ui.theme.GoodingTheme

class DayFeedFragment : Fragment() {
    private var _binding : FragmentDayFeedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDayFeedBinding.inflate(layoutInflater,container,false)
        binding.feedComposeView.apply {
            // follow fragment Lifecycle
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose
                GoodingTheme {
                    FeedScreen()
                }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = DayFeedFragment()
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFeed(){
    FeedScreen()
}
