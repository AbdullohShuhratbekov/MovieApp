package com.example.movieApp.presantation.home_screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieApp.data.utils.Constants.EMPTY_STRING
import com.example.movieApp.presantation.component.LoadingScreeen
import com.example.movieApp.presantation.component.MainScreenItem
import com.example.movieApp.presantation.component.MainScreenItemSacond
import com.example.weatherapptest.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    uiStateFlow: StateFlow<MainScreenUiState>,
    onBackPressedCallback: () -> Unit
) {
    when (val mainUiStateFlow = uiStateFlow.collectAsState().value) {
        is MainScreenUiState.Loading -> {
            LoadingScreeen()
        }

        is MainScreenUiState.Success -> {
            LoadedScreen(
                mainUiStateFlow,
                onBackPressedCallback = onBackPressedCallback,
                onNavigaiteToInfo = {}
            )
        }
        is MainScreenUiState.Error -> {
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoadedScreen(
    uiState: MainScreenUiState.Success,
    onBackPressedCallback: () -> Unit,
    onNavigaiteToInfo: (Int) -> Unit,

    modifier: Modifier = Modifier
) {

    var textSearch by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp, start = 18.dp),
            text = stringResource(id = R.string.text_first_tt),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            value = textSearch,
            onValueChange = {
                textSearch = it
            },
            trailingIcon = {
                Image(
                    modifier = modifier,
                    painter = painterResource(id = R.drawable.search__1_),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = stringResource(id = R.string.text_search),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        )
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = uiState.moviePopularModel,
                key = { it.movieId }
            ) {
                MainScreenItem(
                    model = it.moviePoster,
                    image = painterResource(id = R.drawable.movie)
                )
            }
        }
        Column(
            modifier = modifier.fillMaxSize(),

        ) {

            val movieList = listOf(
                uiState.moviePopularModel,
                uiState.movieNowPopularModel,
                uiState.movieTopRatedModel,
                uiState.movieUpCamingModel,

                )
            val cleanTitleState1 by remember {
                mutableStateOf(EMPTY_STRING)
            }
            val pageState = rememberPagerState { movieList.size }
            val coroutineScope = rememberCoroutineScope()
            ScrollableTabRow(
                selectedTabIndex = pageState.currentPage,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(),
                indicator = { tabPosition ->
                    Box(
                        modifier = modifier
                            .tabIndicatorOffset(tabPosition[pageState.currentPage])
                            .height(3.dp)
                            .background(
                                color = Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                },
                divider = { Spacer(modifier = modifier.height(4.dp)) },
                edgePadding = 0.dp
            ) {
                movieList.forEachIndexed { index, _ ->
                    val header = getPagerHeaderByPosition(position = index)
                    Tab(
                        selected = pageState.currentPage == index,
                        text = {
                            Text(text = header)
                        },
                        onClick = {
                            coroutineScope.launch {
                                pageState.scrollToPage(index)
                            }
                        },
                    )
                }
            }
            Spacer(modifier = modifier.padding(top = 15.dp))
            HorizontalPager(
                state = pageState,
                userScrollEnabled = true
            ) { page ->
                val movie = movieList[page]
                LazyVerticalGrid(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(12.dp)
                ) {
                    items(items = movie, key = { it.movieId }) {
                        MainScreenItemSacond(
                            imageUrl = it.moviePoster,
                            image = painterResource(id = R.drawable.movie),
                            movieID = it.movieId,
                            onNavigaiteToInfo = onNavigaiteToInfo
                        )
                    }
                }
            }
            val systemUiController = rememberSystemUiController()
            val color = MaterialTheme.colorScheme.background
            SideEffect {
                systemUiController.setSystemBarsColor(color)
                systemUiController.setNavigationBarColor(color)
            }
        }
    }
}



@Composable
fun getPagerHeaderByPosition(position: Int): String = when (position) {
    0 -> "Now playing"
    1 -> "Upcoming"
    2 -> "Top rated"
    else -> "Popular"
}





