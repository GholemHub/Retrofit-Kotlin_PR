package com.example.getpost_retrofit_pr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getpost_retrofit_pr.adapter.MyAdapter
import com.example.getpost_retrofit_pr.model.Post
import com.example.getpost_retrofit_pr.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel: MainViewModel
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var recyclerview: RecyclerView


    private val myAdapter by lazy{ MyAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fun to init resources
        initialize()
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //getPost get the result from "MainViewModel.kt"




        //funGetCustomPosts()
        funPushPost()
        funPushPost2()


        buttonListener()


    }


    /** *  funPushPost2 push the data in form of urlencoded
     * */
    private fun funPushPost() {
        val myPost = Post(2,2, "ALEX", "SEGEDA")

        viewModel.pushPost(myPost)
        viewModel.myResponse.observe(this, Observer{response ->
            if(response.isSuccessful) {
                d("Main", response.body().toString())
                d("Main", response.code().toString())
                d("Main", response.message().toString())
            }else{
                Toast.makeText(this,response.code(), Toast.LENGTH_SHORT).show()
            }

        })


    }
/** *  funPushPost2 push the data in form of urlencoded
 * */
    private fun funPushPost2() {
        viewModel.pushPost2(2,2, "ALEX", "SEGEDA")
        viewModel.myResponse.observe(this, Observer{response ->
            if(response.isSuccessful) {
                d("Main", response.body().toString())
                d("Main", response.code().toString())
                d("Main", response.message().toString())
            }else{
                Toast.makeText(this,response.code(), Toast.LENGTH_SHORT).show()
            }

        })


    }

    private fun funGetCustomPosts(){
        viewModel.getCustomPosts(2,"id", "desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this,response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun buttonListener() {

        //to use getCustomPost we make the options
        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        button.setOnClickListener {
            val myNumber = editText.text.toString()

            viewModel.getCustomPosts2(Integer.parseInt(myNumber), options)

            viewModel.myCustomPosts2.observe(this, Observer{ response ->
                if(response.isSuccessful){
                    //textView.text = response.body().toString()

                    response.body()?.forEach{
                        d("Response", it.userId.toString())
                        d("Response", it.id.toString())
                        d("Response", it.title)
                        d("Response", it.body)
                        d("Response", "-----------------------------")
                    }

                }else{
                    d("Response", response.errorBody().toString())
                    // textView.text = response.code().toString()
                }
            })
        }
    }

    private fun setupRecyclerview(){
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun initialize() {
        recyclerview = findViewById(R.id.recyclerView)
        //textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editTextNumber)
    }
}