package ir.androidcoder.pagingrecyclerview

import androidx.paging.Pager
import androidx.paging.PagingConfig

class ViewModel {

    private val data = listOf(
        TestModel(0 , "zero"),
        TestModel(1 , "one"),
        TestModel(2 , "two"),
        TestModel(3 , "three"),
        TestModel(4 , "four"),
        TestModel(5 , "five"),
        TestModel(6 , "six"),
        TestModel(7 , "seven"),
        TestModel(8 , "eight"),
        TestModel(9 , "nine"),
        TestModel(10 , "ten"),
        TestModel(11 , "eleven"),
        TestModel(12 , "twelve"),
        TestModel(13 , "thirteen"),
        TestModel(14 , "fourteen"),
        TestModel(15 , "fifteen"),
        TestModel(16 , "sixteen"),
        TestModel(17 , "seventeen"),
        TestModel(18 , "eighteen"),
        TestModel(19 , "nineteen"),
        TestModel(20 , "twenty"),
        TestModel(21 , "twenty one"),
        TestModel(22 , "twenty two"),
        TestModel(23 , "twenty three"),
        TestModel(24 , "twenty four"),
        TestModel(25 , "twenty five"),
        TestModel(26 , "twenty six"),
        TestModel(27 , "twenty seven"),
        TestModel(28 , "twenty eight"),
        TestModel(29 , "twenty nine"),
        TestModel(30 , "thirty"),
    )


    fun searchMovies() : Pager<Int, TestModel> = Pager(
        config = PagingConfig(pageSize = 17 , enablePlaceholders = false),
        pagingSourceFactory = { TestPagingSource(data) }
    )

}