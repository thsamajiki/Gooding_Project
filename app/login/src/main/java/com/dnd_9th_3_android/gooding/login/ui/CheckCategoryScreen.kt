package com.dnd_9th_3_android.gooding.login.ui
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import com.dnd_9th_3_android.gooding.core.data.R
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.painterResource
//import androidx.hilt.navigation.compose.hiltViewModel
//import com.dnd_9th_3_android.gooding.login.component.CategoryBox
////import com.dnd_9th_3_android.gooding.login.type.CategoryListType
//import com.dnd_9th_3_android.gooding.login.viewModel.LoginViewModel

//@Composable
//fun CheckCategoryScreen(
//    navController: NavHostController,
//    loginViewModel: LoginViewModel = hiltViewModel()
//) {
//    Image(
//        painter = painterResource(id = R.drawable.category_ment),
//        contentDescription = null,
//        modifier = Modifier
//            .height(dimensionResource(id = R.dimen.size_54))
//            .width(dimensionResource(id = R.dimen.size_215))
//            .padding(
//                top = dimensionResource(id = R.dimen.padding_36),
//                start = dimensionResource(id = R.dimen.padding_18)
//            )
//    )
//
//    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.top_size)))
//
////    val size = loginViewModel.categoryList.size
////    LazyVerticalGrid(
////        contentPadding = PaddingValues(
////            horizontal = dimensionResource(id = R.dimen.padding_6),
////            vertical = dimensionResource(id = R.dimen.padding_6)
////        ),
////        columns = GridCells.Fixed(size/3),
////        content = {
////            items(size){ index->
////                CategoryBox(loginViewModel.categoryList[index], clickData = {
////                    loginViewModel.categoryList[index].selected = !loginViewModel.categoryList[index].selected
////                })
////            }
////        }
////    )
//
//}