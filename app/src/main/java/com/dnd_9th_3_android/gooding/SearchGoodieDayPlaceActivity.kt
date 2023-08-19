package com.dnd_9th_3_android.gooding

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.data.model.KakaoMapData
import com.dnd_9th_3_android.gooding.databinding.ActivitySearchGoodieDayPlaceBinding
import com.dnd_9th_3_android.gooding.databinding.ItemKakaoMapPlaceBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class SearchGoodieDayPlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchGoodieDayPlaceBinding
    private lateinit var goodieDayPlaceListAdapter: GoodieDayPlaceListAdapter
    private val viewModel by viewModels<SearchGoodieDayPlaceViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchGoodieDayPlaceBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initView()
        initViewModel()
        initListeners()
    }

    private fun initView() {
        initRecyclerView(binding.rvPlaceList)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        goodieDayPlaceListAdapter = GoodieDayPlaceListAdapter(
            onClick = ::onClickPlaceItem
        )

        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = goodieDayPlaceListAdapter
        }
    }

    private fun onClickPlaceItem(kakaoMapData: KakaoMapData) {
        // TODO: 주소 아이템 클릭하면 Record01Activity에 해당 주소가 반영되도록 하기
    }

    private fun initViewModel() {
        with(viewModel) {
            lifecycleScope.launch {
                uiState.collect { state ->
                    when (state) {
                        is SearchGoodieDayPlaceViewModel.UiState.SearchPlaceSuccess -> {
                            goodieDayPlaceListAdapter.submitList(state.mapAddressList)
                        }

                        is SearchGoodieDayPlaceViewModel.UiState.SearchPlaceFailed -> {
                            Toast.makeText(
                                this@SearchGoodieDayPlaceActivity,
                                "주소 검색에 실패했습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        is SearchGoodieDayPlaceViewModel.UiState.Idle -> {}
                    }
                }
            }
        }
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.layoutSearchPlace.setOnClickListener {
            closeKeyboard(binding.root)

            if (binding.textEditSearchPlace.hasFocus()) {
                binding.textEditSearchPlace.clearFocus()
            }
        }

        binding.textEditSearchPlace.setOnEditorActionListener { textView, actionId, keyEvent ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    val query = textView?.text.toString()
                    binding.rvPlaceList.isGone = true
                    viewModel.searchPlace(query)
                    Log.d("query", "SearchGoodieDayPlaceActivity - initListeners: query - $query")

                    closeKeyboard(binding.root)
                    binding.textEditSearchPlace.clearFocus()
                }
            }

            true
        }
    }

    private fun closeKeyboard(view: View) {
        val imm = view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, SearchGoodieDayPlaceActivity::class.java)
    }
}

class GoodieDayPlaceListAdapter(
    private val onClick: (KakaoMapData) -> Unit,
) : ListAdapter<KakaoMapData, GoodieDayPlaceListAdapter.GoodieDayPlaceViewHolder>(DiffCallback()) {
    private val addressList = mutableListOf<KakaoMapData>()

    class GoodieDayPlaceViewHolder(
        val binding: ItemKakaoMapPlaceBinding,
        private val onClick: (KakaoMapData) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mapData: KakaoMapData) {
            binding.tvPlaceName.text = mapData.documents[0].placeName
            binding.tvPlaceDetail.text = mapData.documents[0].addressName

            binding.root.setOnClickListener {
                onClick(mapData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodieDayPlaceViewHolder {
        val binding =
            ItemKakaoMapPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GoodieDayPlaceViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: GoodieDayPlaceViewHolder, position: Int) {
        val mapItem = currentList[position]

        holder.bind(mapItem)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    private class DiffCallback : DiffUtil.ItemCallback<KakaoMapData>() {
        override fun areItemsTheSame(oldItem: KakaoMapData, newItem: KakaoMapData): Boolean {
            return oldItem.documents[0].id == newItem.documents[0].id
        }

        override fun areContentsTheSame(oldItem: KakaoMapData, newItem: KakaoMapData): Boolean {
            return oldItem == newItem
        }
    }
}











// 카카오맵 api
object KakaoMapApiClient {
    private var instance: Retrofit? = null
    private const val CONNECT_TIMEOUT_SEC = 20000L
    private const val BASE_URL = "https://dapi.kakao.com/"

    fun getInstance(): Retrofit {
        if (instance == null) {

            // 로깅인터셉터 세팅
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            // OKHttpClient에 로깅인터셉터 등록
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
                .build()

            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return instance!!
    }
}

// api 통신을 위한 retrofit
private val retrofit: Retrofit = KakaoMapApiClient.getInstance()

// kakao map API Key
private const val API_KEY = "66e15e5cd7fdce2de67e28ec53aad52a"

//suspend fun getKakaoMapAddress(
//    keyword: String,
//    addPlaceList: (item: SelectPlaceItem) -> Unit
//) {
//    retrofit.create(KakaoMapService::class.java)
//        .getKakaoMapAddress(keyword)
//        .enqueue(object : Callback<KakaoMapData> {
//            override fun onResponse(call: Call<KakaoMapData>, response: Response<KakaoMapData>) {
//                Log.d(ContentValues.TAG, "카카오 주소 조회 결과 -------------------------------------------")
//                Log.d(ContentValues.TAG, "onResponse: ${response.body().toString()}")
//
//                val body: KakaoMapData = response.body()!!
//                val placeList = body.documents
//                for(i in 0 until placeList.size) {
//                    var selected = false
//                    // 첫 번째 주소 선택
//                    if(i == 0) selected = true
//
//                    // 주소 선택지 추가
//                    addPlaceList(
//                        SelectPlaceItem(
//                            placeList[i].placeName,
//                            placeList[i].roadAddressName,
//                            placeList[i].addressName,
//                            selected
//                        )
//                    )
//                }
//            }
//
//            override fun onFailure(call: Call<KakaoMapData>, t: Throwable) {
//                Log.d(ContentValues.TAG, "카카오 주소 조회 결과 fail -------------------------------------------")
//                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
//            }
//        })
//}